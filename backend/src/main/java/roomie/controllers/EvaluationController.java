package roomie.controllers;

import org.orm.PersistentException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;
import roomie.exception.ErrorDetails;
import roomie.exception.ResourceNotFoundException;
import roomie.models.auth.AcceptRejectApplication;
import roomie.models.auth.MyUser;
import roomie.models.auth.TenantEvaluationRequest;
import roomie.models.evaluation.TenantEvaluation;
import roomie.models.house.House;
import roomie.models.tenant.Tenant;
import roomie.services.EvaluationService;
import roomie.services.HouseService;
import roomie.services.TenantService;

import javax.validation.Valid;

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
	
	@PreAuthorize("hasRole('TENANT')")
	@PostMapping(value = "/tenant/{id}")
	public TenantEvaluation evaluateTenant(@PathVariable int id, Authentication auth, @Valid @RequestBody TenantEvaluationRequest body) throws PersistentException, ResourceNotFoundException {
		Tenant evaluator = tenantService.getById(((MyUser) auth.getPrincipal()).getId());
		Tenant evaluated = tenantService.getById(id);
		House house = houseService.getById(body.getHouseId());
		if(!evaluationService.wereRoommates(evaluator,evaluated,house)){
			throw new ErrorDetails("Tenants were not roommates on that house or they were but they never met!");
		}
		
		double tidiness = body.getTidiness();
		double cleanliness = body.getCleanliness();
		double privacy = body.getPrivacy();
		double friendliness = body.getFriendliness();
		return evaluationService.create(evaluator,evaluated,tidiness,cleanliness,privacy,friendliness);
	}
	
	@PreAuthorize("hasRole('LANDLORD') and @userSecurity.isOwner(authentication, #id)")
	@PostMapping(value = "/landlord/{id}")
	public String evaluateLandlord(@PathVariable int id, @Valid @RequestBody AcceptRejectApplication body) throws PersistentException, ResourceNotFoundException {
		/*Tenant tenant = tenantService.getById(body.getTenantId());
		House house = houseService.getById(id);
		house.setAvailableRooms(house.getAvailableRooms() + 1);
		HouseDAO.save(house);
		HouseDAO.refresh(house);
		RentHistory r = RentHistoryDAO.getRentHistoryByORMID(house, tenant);
		rentHistoryService.finish(r);
		return "Success!";*/
		return null;
	}
}
