package roomie.helpers;

import org.orm.PersistentException;
import org.springframework.stereotype.Component;
import roomie.models.landlord.LandlordDAO;
import roomie.models.tenant.TenantDAO;

/**
 * @author: Vasco Ramos
 * @created: 14/04/2021 - 11:10
 */

@Component
public class UserUtils {
	public boolean existsByEmail(String email) throws PersistentException {
		return LandlordDAO.listLandlordByQuery("Email='" + email + "'", null).length > 0 || TenantDAO
				.listTenantByQuery("Email='" + email + "'", null).length > 0;
	}
}
