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
	
	@PreAuthorize("hasRole('TENANT') and @userSecurity.wereRoommates(authentication,#idHouse,#idEvaluated)")
	@PostMapping(value = "/tenant/{idHouse}/{idEvaluated}")
	public TenantEvaluation evaluateTenant(@PathVariable int idHouse, @PathVariable int idEvaluated, Authentication auth, @Valid @RequestBody TenantEvaluation body) throws PersistentException, ResourceNotFoundException {
		Tenant evaluator = tenantService.getById(((MyUser) auth.getPrincipal()).getId());
		Tenant evaluated = tenantService.getById(idEvaluated);
		
		double tidiness = body.getTidiness();
		double cleanliness = body.getCleanliness();
		double privacy = body.getPrivacy();
		double friendliness = body.getFriendliness();
		return evaluationService.create(evaluator,evaluated,tidiness,cleanliness,privacy,friendliness);
	}
	
	@PreAuthorize("hasRole('LANDLORD') and @userSecurity.isOwner(authentication, #id)")
	@PostMapping(value = "/landlord/{idHouse}/{idTenant}")
	public String evaluateLandlord(@PathVariable int id, @Valid @RequestBody AcceptRejectApplication body) throws PersistentException, ResourceNotFoundException {
		return null;
	}
}
