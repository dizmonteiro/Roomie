package roomie.services;

import org.orm.PersistentException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import roomie.models.auth.MyUser;
import roomie.models.landlord.Landlord;
import roomie.models.landlord.LandlordDAO;
import roomie.models.tenant.Tenant;
import roomie.models.tenant.TenantDAO;

import java.util.HashSet;
import java.util.Set;

/**
 * @author: Vasco Ramos
 * @created: 12/04/2021 - 11:38
 */

@Service
public class MyUserDetailsService implements UserDetailsService {
	
	@Override
	public MyUser loadUserByUsername(String email) throws UsernameNotFoundException {
		try {
			Set<GrantedAuthority> authorities = new HashSet<>();
			Tenant[] tenants = TenantDAO.listTenantByQuery("Email='" + email + "'", null);
			if (tenants.length > 0) {
				authorities.add(new SimpleGrantedAuthority("ROLE_TENANT"));
				return new MyUser(tenants[0].getEmail(), tenants[0].getPassword(), tenants[0].getName(), tenants[0]
						.getId(), authorities);
			}
			
			Landlord[] landlords = LandlordDAO.listLandlordByQuery("Email='" + email + "'", null);
			if (landlords.length > 0) {
				authorities.add(new SimpleGrantedAuthority("ROLE_LANDLORD"));
				return new MyUser(landlords[0].getEmail(), landlords[0].getPassword(), landlords[0]
						.getName(), landlords[0].getId(), authorities);
			}
		} catch (PersistentException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public MyUser loadUserByUsernameAndType(String email, String type) throws UsernameNotFoundException {
		try {
			Set<GrantedAuthority> authorities = new HashSet<>();
			if (type.equals("tenant")) {
				Tenant[] tenants = TenantDAO.listTenantByQuery("Email='" + email + "'", null);
				if (tenants.length > 0) {
					authorities.add(new SimpleGrantedAuthority("ROLE_TENANT"));
					return new MyUser(tenants[0].getEmail(), tenants[0].getPassword(), tenants[0].getName(), tenants[0]
							.getId(), authorities);
				}
			}
			
			if (type.equals("landlord")) {
				Landlord[] landlords = LandlordDAO.listLandlordByQuery("Email='" + email + "'", null);
				if (landlords.length > 0) {
					authorities.add(new SimpleGrantedAuthority("ROLE_LANDLORD"));
					return new MyUser(landlords[0].getEmail(), landlords[0].getPassword(), landlords[0]
							.getName(), landlords[0].getId(), authorities);
				}
			}
			
		} catch (PersistentException e) {
			e.printStackTrace();
		}
		return null;
	}
}
