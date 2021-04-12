package roomie.services;

import org.orm.PersistentException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import roomie.models.landlord.Landlord;
import roomie.models.landlord.LandlordDAO;
import roomie.models.tenant.Tenant;
import roomie.models.tenant.TenantDAO;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

/**
 * @author: Vasco Ramos
 * @created: 12/04/2021 - 11:38
 */

@Service
public class MyUserDetailsService implements UserDetailsService {
	
	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		try {
			Set<GrantedAuthority> authorities = new HashSet<>();
			Tenant[] tenants = TenantDAO.listTenantByQuery(null, null);
			if (tenants.length > 0) {
				authorities.add(new SimpleGrantedAuthority("ROLE_TENANT"));
				return new User(tenants[0].getEmail(), tenants[0].getPassword(), authorities);
			}
			
			Landlord[] landlords = LandlordDAO.listLandlordByQuery("Email='" + email + "'", null);
			if (landlords.length > 0) {
				authorities.add(new SimpleGrantedAuthority("ROLE_LANDLORD"));
				return new User(landlords[0].getEmail(), landlords[0].getPassword(), authorities);
			}
		} catch (PersistentException e) {
			e.printStackTrace();
		}
		return new User(null, null, new ArrayList<>());
	}
}
