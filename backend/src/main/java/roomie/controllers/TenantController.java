package roomie.controllers;

import org.orm.PersistentException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import roomie.exception.ResourceNotFoundException;
import roomie.models.application.Application;
import roomie.models.auth.UpdatePasswordRequest;
import roomie.models.avatar.Avatar;
import roomie.models.evaluation.LandlordEvaluation;
import roomie.models.evaluation.LandlordEvaluationDAO;
import roomie.models.evaluation.TenantEvaluation;
import roomie.models.evaluation.TenantEvaluationDAO;
import roomie.models.rentHistory.RentHistory;
import roomie.models.tenant.Tenant;
import roomie.models.tenant.TenantRating;
import roomie.services.ApplicationService;
import roomie.services.AvatarService;
import roomie.services.RentHistoryService;
import roomie.services.TenantService;

import javax.validation.Valid;
import java.io.IOException;
import java.util.List;

/**
 * @author: Vasco Ramos
 * @created: 13/04/2021 - 10:00
 */

@RestController
@RequestMapping("/tenants")
public class TenantController {
	@Autowired
	private TenantService tenantService;
	
	@Autowired
	private AvatarService avatarService;
	
	@Autowired
	private ApplicationService applicationService;
	
	@Autowired
	private RentHistoryService rentHistoryService;
	
	@PostMapping(consumes = {"multipart/form-data"})
	public Tenant register(@Valid Tenant tenant, @RequestPart(value = "file", required = false) MultipartFile file) throws PersistentException {
		tenantService.exists(tenant);
		Avatar avatar = avatarService.store(file);
		return tenantService.register(tenant, avatar);
	}
	
	@GetMapping(value = "/{id}")
	public Tenant getTenant(@PathVariable int id) throws PersistentException, ResourceNotFoundException {
		return tenantService.getById(id);
	}
	
	@PreAuthorize("hasRole('TENANT') and @userSecurity.isSelf(authentication,#id)")
	@PutMapping("/{id}/password")
	public ResponseEntity<String> updatePassword(@PathVariable int id, @Valid @RequestBody UpdatePasswordRequest body) throws PersistentException, ResourceNotFoundException {
		Tenant tenant = tenantService.getById(id);
		boolean res = tenantService.updatePassword(tenant, body);
		if (res) {
			return ResponseEntity.ok("Password updated successfully");
		} else {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}
	
	@PreAuthorize("hasRole('TENANT') and @userSecurity.isSelf(authentication, #id)")
	@PutMapping(value = "/{id}")
	public Tenant editTenant(@PathVariable int id, Tenant tenantInfo, @RequestPart(value = "file", required = false) MultipartFile file) throws PersistentException, ResourceNotFoundException {
		Tenant tenant = tenantService.getById(id);
		tenant = tenantService.update(tenant, tenantInfo);
		avatarService.update(tenant.getAvatar(), file);
		return tenant;
	}
	
	@PreAuthorize("hasRole('TENANT') and @userSecurity.isSelf(authentication, #id)")
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> deleteTenant(@PathVariable int id) throws PersistentException, ResourceNotFoundException {
		Tenant tenant = tenantService.getById(id);
		avatarService.delete(tenant.getAvatar());
		boolean res = tenantService.delete(tenant);
		if (res) {
			return ResponseEntity.noContent().build();
		} else {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}
	
	@GetMapping(value = "/{id}/avatar", produces = "image/*")
	@ResponseBody
	public byte[] getAvatar(@PathVariable int id) throws PersistentException, ResourceNotFoundException, IOException {
		return avatarService.load(tenantService.getById(id).getAvatar());
	}
	
	@PreAuthorize("hasRole('TENANT') and @userSecurity.isSelf(authentication, #id)")
	@GetMapping(value = "/{id}/applications")
	public List<Application> getApplications(@PathVariable int id) throws PersistentException, ResourceNotFoundException {
		return applicationService.getByTenantId(id);
	}
	
	@GetMapping(value = "/{id}/rating")
	public TenantRating getRating(@PathVariable int id) throws PersistentException, ResourceNotFoundException {
		Tenant tenant = tenantService.getById(id);
		
		TenantRating rating = new TenantRating();
		List<LandlordEvaluation> landEvals = LandlordEvaluationDAO.queryLandlordEvaluation("tenant =" + tenant, null);
		double cleanliness = 0;
		double payment = 0;
		double care = 0;
		
		if (landEvals.size() != 0) {
			for (LandlordEvaluation eval : landEvals) {
				cleanliness = cleanliness + eval.getCleanliness();
				payment = payment + eval.getPayment();
				care = care + eval.getCare();
			}
			
			rating.setPayment(payment / landEvals.size());
			rating.setCare(care / landEvals.size());
		}
		
		List<TenantEvaluation> tenantEvals = TenantEvaluationDAO
				.queryTenantEvaluation("evaluatedTenant =" + tenant, null);
		double tidiness = 0;
		double privacy = 0;
		double friendliness = 0;
		
		if (tenantEvals.size() != 0) {
			for (TenantEvaluation eval : tenantEvals) {
				tidiness = tidiness + eval.getTidiness();
				privacy = privacy + eval.getPrivacy();
				friendliness = friendliness + eval.getFriendliness();
				cleanliness = cleanliness + eval.getCleanliness();
				
			}
			
			rating.setTidiness(tidiness / tenantEvals.size());
			rating.setPrivacy(privacy / tenantEvals.size());
			rating.setFriendliness(friendliness / tenantEvals.size());
		}
		
		if (landEvals.size() != 0 || tenantEvals.size() != 0) {
			rating.setCleanliness(cleanliness / (landEvals.size() + tenantEvals.size()));
		}
		
		return rating;
	}
	
	@GetMapping(value = "/{id}/rentHistory")
	public List<RentHistory> getRentHistory(@PathVariable int id) throws PersistentException, ResourceNotFoundException {
		Tenant tenant = tenantService.getById(id);
		return rentHistoryService.getTenantsRentHistory(tenant);
	}
	
	
}
