package roomie.controllers;

import org.orm.PersistentException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;
import roomie.exception.ResourceNotFoundException;
import roomie.models.application.Application;
import roomie.models.auth.MyUser;
import roomie.models.house.House;
import roomie.models.tenant.Tenant;
import roomie.services.ApplicationService;
import roomie.services.HouseService;
import roomie.services.TenantService;

import javax.validation.Valid;

/**
 * @author: Vasco Ramos
 * @created: 13/04/2021 - 10:00
 */

@RestController
@RequestMapping("/applications")
public class ApplicationController {
	@Autowired
	private ApplicationService applicationService;
	
	@Autowired
	private TenantService tenantService;
	
	@Autowired
	private HouseService houseService;
	
	@PreAuthorize("hasRole('TENANT')")
	@PostMapping
	public Application register(@Valid @RequestBody Application application, Authentication auth) throws PersistentException, ResourceNotFoundException {
		Tenant tenant = tenantService.getById(((MyUser) auth.getPrincipal()).getId());
		House house = houseService.getById(application.getHouseId());
		return applicationService.create(tenant, house);
	}
	
	@PreAuthorize("hasRole('TENANT') and @userSecurity.hasApplied(authentication,#id)")
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> deleteApplication(@PathVariable int id, Authentication auth) throws PersistentException, ResourceNotFoundException {
		Tenant tenant = tenantService.getById(((MyUser) auth.getPrincipal()).getId());
		House house = houseService.getById(id);
		Application application = applicationService.getById(tenant, house);
		boolean res = applicationService.delete(application);
		if (res) {
			return ResponseEntity.noContent().build();
		} else {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}
}
