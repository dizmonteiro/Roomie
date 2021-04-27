package roomie.controllers;

import org.orm.PersistentException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import roomie.exception.ResourceNotFoundException;
import roomie.models.auth.AcceptRejectApplication;
import roomie.models.house.House;
import roomie.models.rentHistory.RentHistory;
import roomie.models.rentHistory.RentHistoryDAO;
import roomie.models.tenant.Tenant;
import roomie.services.HouseService;
import roomie.services.RentHistoryService;
import roomie.services.TenantService;

import javax.validation.Valid;

/**
 * @author: Vasco Ramos
 * @created: 13/04/2021 - 10:00
 */

@RestController
@RequestMapping("/rentHistory")
public class RentHistoryController {
	
	@Autowired
	private TenantService tenantService;
	
	@Autowired
	private HouseService houseService;
	
	@Autowired
	private RentHistoryService rentHistoryService;
	
	@PreAuthorize("hasRole('LANDLORD') and @userSecurity.isOwner(authentication, #id)")
	@PutMapping(value = "/{id}")
	public String finishRentHistory(@PathVariable int id, @Valid @RequestBody AcceptRejectApplication body) throws PersistentException, ResourceNotFoundException {
		Tenant tenant = tenantService.getById(body.getTenantId());
		House house = houseService.getById(id);
		RentHistory r = RentHistoryDAO.getRentHistoryByORMID(house, tenant);
		rentHistoryService.finish(r);
		return "Success!";
	}
}
