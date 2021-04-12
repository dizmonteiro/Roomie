package roomie.services;

import org.orm.PersistentException;
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

/**
 * @author: Vasco Ramos
 * @created: 12/04/2021 - 11:38
 */

@Service
public class MyUserDetailsService implements UserDetailsService {
	
	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		System.out.println(email);
		try {
			Tenant[] tenants = TenantDAO.listTenantByQuery(null, null);
			if (tenants.length > 0) {
				return new User(tenants[0].getEmail(), tenants[0].getPassword(), new ArrayList<>());
			}
			
			Landlord[] landlords = LandlordDAO.listLandlordByQuery("Email='"+email+"'", null);
			if (landlords.length > 0) {
				return new User(landlords[0].getEmail(), landlords[0].getPassword(), new ArrayList<>());
			}
		} catch (PersistentException e) {
			e.printStackTrace();
		}
		return new User(null, null, new ArrayList<>());
	}
}
