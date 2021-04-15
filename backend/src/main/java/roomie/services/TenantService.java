package roomie.services;

/**
 * @author: Vasco Ramos
 * @created: 13/04/2021 - 11:02
 */

import org.orm.PersistentException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import roomie.exception.ErrorDetails;
import roomie.exception.ResourceNotFoundException;
import roomie.helpers.UserUtils;
import roomie.models.avatar.Avatar;
import roomie.models.avatar.AvatarDAO;
import roomie.models.tenant.Tenant;
import roomie.models.tenant.TenantDAO;

@Service
public class TenantService {
	@Autowired
	private UserUtils userUtils;
	
	private BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
	
	public void exists(Tenant tenant) throws PersistentException {
		if (userUtils.existsByEmail(tenant.getEmail())) {
			throw new ErrorDetails("There is already a user with that email");
		}
	}
	
	public Tenant register(Tenant tenant, Avatar avatar) throws PersistentException {
		if (avatar == null) {
			avatar = AvatarDAO.createAvatar();
			AvatarDAO.save(avatar);
		}
		
		tenant.setPassword(passwordEncoder.encode(tenant.getPassword()));
		tenant.setAvatar(avatar);
		
		TenantDAO.save(tenant);
		return tenant;
	}
	
	public Tenant getById(int id) throws ResourceNotFoundException, PersistentException {
		Tenant tenant = TenantDAO.getTenantByORMID(id);
		if (tenant == null) {
			throw new ResourceNotFoundException("Tenant not found: id=" + id);
		}
		return tenant;
	}
	
	public boolean delete(Tenant tenant) throws PersistentException, ResourceNotFoundException {
		TenantDAO.evict(tenant);
		return TenantDAO.delete(tenant);
	}
	
	public Tenant update(Tenant tenant, Tenant tenantInfo) throws PersistentException {
		if (tenantInfo.getName() != null) {
			tenant.setName(tenantInfo.getName());
		}
		
		if (tenantInfo.getUsername() != null) {
			tenant.setUsername(tenantInfo.getUsername());
		}
		
		if (tenantInfo.getPhone() != null) {
			tenant.setPhone(tenantInfo.getPhone());
		}
		
		if (tenantInfo.getSex() != null) {
			tenant.setSex(tenantInfo.getSex());
		}
		
		if (tenantInfo.getNationality() != null) {
			tenant.setNationality(tenantInfo.getNationality());
		}
		
		if (tenantInfo.getOccupation() != null) {
			tenant.setOccupation(tenantInfo.getOccupation());
		}
		
		TenantDAO.save(tenant);
		TenantDAO.refresh(tenant);
		return tenant;
	}
}
