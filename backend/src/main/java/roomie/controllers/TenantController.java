package roomie.controllers;

import org.orm.PersistentException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import roomie.exception.ResourceNotFoundException;
import roomie.models.avatar.Avatar;
import roomie.models.tenant.Tenant;
import roomie.services.AvatarService;
import roomie.services.TenantService;

import javax.validation.Valid;
import java.io.IOException;

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
	
	@PostMapping(consumes = {"multipart/form-data"})
	public Tenant register(@Valid @ModelAttribute Tenant tenant, @RequestPart("file") MultipartFile file) throws PersistentException {
		Avatar avatar = avatarService.store(file);
		return tenantService.register(tenant, avatar);
	}
	
	@GetMapping(value = "/{id}")
	public Tenant getTenant(@PathVariable int id) throws PersistentException, ResourceNotFoundException {
		return tenantService.getById(id);
	}
	
	@GetMapping(value = "/{id}/avatar", produces = "image/*")
	@ResponseBody
	public byte[] getAvatar(@PathVariable int id) throws PersistentException, ResourceNotFoundException, IOException {
		return avatarService.load(tenantService.getById(id).getAvatar());
	}
	
}
