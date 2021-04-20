package roomie.controllers;

import org.orm.PersistentException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
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

    /*@GetMapping(value = "/{id}")
    public Application getApplication(@PathVariable int id) throws PersistentException, ResourceNotFoundException {
        return applicationService.getById(id);
    }

    @PreAuthorize("hasRole('LANDLORD') and @userSecurity.isSelf(authentication,#id)")
    @PutMapping("/{id}/password")
    public ResponseEntity<String> updatePassword(@PathVariable int id, @Valid @RequestBody UpdatePasswordRequest body) throws PersistentException, ResourceNotFoundException {
        Application application = applicationService.getById(id);
        boolean res = applicationService.updatePassword(application, body);
        if (res) {
            return ResponseEntity.ok("Password updated successfully");
        } else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PreAuthorize("hasRole('LANDLORD') and @userSecurity.isSelf(authentication,#id)")
    @PutMapping(value = "/{id}")
    public Application editLandord(@PathVariable int id, Application applicationInfo, @RequestPart(value = "file", required = false) MultipartFile file) throws PersistentException, ResourceNotFoundException {
        Application application = applicationService.getById(id);
        application = applicationService.update(application, applicationInfo);
        avatarService.update(application.getAvatar(), file);
        return application;
    }

    @PreAuthorize("hasRole('LANDLORD') and @userSecurity.isSelf(authentication,#id)")
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> deleteApplication(@PathVariable int id) throws PersistentException, ResourceNotFoundException {
        Application application = applicationService.getById(id);
        avatarService.delete(application.getAvatar());
        boolean res = applicationService.delete(application);
        if (res) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping(value = "/{id}/avatar", produces = "image/*")
    @ResponseBody
    public byte[] getAvatar(@PathVariable int id) throws PersistentException, ResourceNotFoundException, IOException {
        return avatarService.load(applicationService.getById(id).getAvatar());
    }

    @GetMapping(value = "/{id}/houses")
    public List<House> getApplicationHouses(@PathVariable int id) throws PersistentException, ResourceNotFoundException {
        return applicationService.getById(id).houses.getCollection();
    }
*/
}
