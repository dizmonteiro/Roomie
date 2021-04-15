package roomie.controllers;

import org.orm.PersistentException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import roomie.exception.ResourceNotFoundException;
import roomie.models.auth.UpdatePasswordRequest;
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
	
	@PreAuthorize("hasRole('TENANT') and @userSecurity.isSelf(authentication,#id)")
	@PutMapping(value = "/{id}")
	public Tenant editTenant(@PathVariable int id, Tenant tenantInfo, @RequestPart(value = "file", required = false) MultipartFile file) throws PersistentException, ResourceNotFoundException {
		Tenant tenant = tenantService.getById(id);
		tenant = tenantService.update(tenant, tenantInfo);
		avatarService.update(tenant.getAvatar(), file);
		return tenant;
	}
	
	@PreAuthorize("hasRole('TENANT') and @userSecurity.isSelf(authentication,#id)")
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
	
}
