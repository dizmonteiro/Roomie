package roomie.helpers;

import org.orm.PersistentException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import roomie.models.landlord.Landlord;
import roomie.models.landlord.LandlordDAO;
import roomie.models.tenant.Tenant;
import roomie.models.tenant.TenantDAO;

/**
 * @author: Vasco Ramos
 * @created: 14/04/2021 - 17:06
 */

@Component("userSecurity")
public class UserSecurity {
	public boolean isSelf(Authentication authentication, int userId) throws PersistentException {
		String email = ((UserDetails) authentication.getPrincipal()).getUsername();
		
		Tenant[] tenants = TenantDAO.listTenantByQuery("Email='" + email + "'", null);
		if (tenants.length > 0) {
			return tenants[0].getId() == userId;
		}
		
		Landlord[] landlords = LandlordDAO.listLandlordByQuery("Email='" + email + "'", null);
		if (landlords.length > 0) {
			return landlords[0].getId() == userId;
		}
		
		return false;
	}
}