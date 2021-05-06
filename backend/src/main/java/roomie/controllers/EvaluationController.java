package roomie.controllers;

import org.orm.PersistentException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;
import roomie.exception.ErrorDetails;
import roomie.exception.ResourceNotFoundException;
import roomie.helpers.UserSecurity;
import roomie.models.auth.LandlordEvaluationRequest;
import roomie.models.auth.MyUser;
import roomie.models.auth.TenantEvaluationRequest;
import roomie.models.evaluation.LandlordEvaluation;
import roomie.models.evaluation.TenantEvaluation;
import roomie.models.house.House;
import roomie.models.landlord.Landlord;
import roomie.models.rentHistory.RentHistory;
import roomie.models.rentHistory.RentHistoryDAO;
import roomie.models.tenant.Tenant;
import roomie.services.EvaluationService;
import roomie.services.HouseService;
import roomie.services.LandlordService;
import roomie.services.TenantService;

import javax.validation.Valid;
import java.util.Date;

/**
 * @author: Vasco Ramos
 * @created: 13/04/2021 - 10:00
 */

@RestController
@RequestMapping("/evaluation")
public class EvaluationController {
	
	@Autowired
	private TenantService tenantService;
	
	@Autowired
	private EvaluationService evaluationService;
	
	@Autowired
	private HouseService houseService;
	
	@Autowired
	private LandlordService landlordService;
	
	@Autowired
	private UserSecurity userSecurity;
	
	@PreAuthorize("hasRole('TENANT')")
	@PostMapping(value = "/tenant/{evaluatedTenantId}")
	public TenantEvaluation evaluateTenant(@PathVariable int evaluatedTenantId, Authentication auth, @Valid @RequestBody TenantEvaluationRequest body) throws PersistentException, ResourceNotFoundException {
		
		if (!userSecurity.wereRoommates(auth, body.getHouseId(), evaluatedTenantId))
			throw new AccessDeniedException("Tenants were not roommates on that house. If they were, they never met!");
		
		Tenant evaluator = tenantService.getById(((MyUser) auth.getPrincipal()).getId());
		Tenant evaluated = tenantService.getById(evaluatedTenantId);
		
		double tidiness = body.getTidiness();
		double cleanliness = body.getCleanliness();
		double privacy = body.getPrivacy();
		double friendliness = body.getFriendliness();
		return evaluationService
				.createTenantEvaluation(evaluator, evaluated, tidiness, cleanliness, privacy, friendliness);
	}
	
	@PreAuthorize("hasRole('LANDLORD')")
	@PostMapping(value = "/landlord/{tenantId}")
	public LandlordEvaluation evaluateLandlord(@PathVariable int tenantId, Authentication auth, @Valid @RequestBody LandlordEvaluationRequest body) throws PersistentException, ResourceNotFoundException {
		
		int houseId = body.getHouseId();
		
		if (!userSecurity.isOwner(auth, houseId))
			throw new AccessDeniedException("Landlord isn't the owner of this house!");
		
		Landlord landlord = landlordService.getById(((MyUser) auth.getPrincipal()).getId());
		Tenant tenant = tenantService.getById(tenantId);
		
		double cleanliness = body.getCleanliness();
		double payment = body.getPayment();
		double care = body.getCare();
		
		House house = houseService.getById(houseId);
		RentHistory rh = RentHistoryDAO.getRentHistoryByORMID(house, tenant);
		
		if (rh.getbDate().getTime() > new Date().getTime())
			throw new ErrorDetails("Tenant doesn't live in this house yet!");
		
		return evaluationService.createTenantEvaluation(landlord, tenant, cleanliness, payment, care);
	}
}
