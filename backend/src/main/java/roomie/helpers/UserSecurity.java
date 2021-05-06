package roomie.helpers;

import org.orm.PersistentException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import roomie.exception.ResourceNotFoundException;
import roomie.models.application.ApplicationDAO;
import roomie.models.auth.MyUser;
import roomie.models.house.House;
import roomie.models.landlord.Landlord;
import roomie.models.landlord.LandlordDAO;
import roomie.models.rentHistory.RentHistory;
import roomie.models.rentHistory.RentHistoryDAO;
import roomie.models.tenant.Tenant;
import roomie.models.tenant.TenantDAO;
import roomie.services.HouseService;
import roomie.services.LandlordService;
import roomie.services.RentHistoryService;
import roomie.services.TenantService;

import java.util.Date;

/**
 * @author: Vasco Ramos
 * @created: 14/04/2021 - 17:06
 */

@Component("userSecurity")
public class UserSecurity {
	@Autowired
	private HouseService houseService;
	
	@Autowired
	private LandlordService landlordService;
	
	@Autowired
	private TenantService tenantService;
	
	@Autowired
	private RentHistoryService rentHistoryService;
	
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
	
	public boolean isOwner(Authentication authentication, int houseId) {
		try {
			Landlord landlord = landlordService.getById(((MyUser) authentication.getPrincipal()).getId());
			House house = houseService.getById(houseId);
			return landlord.houses.contains(house);
		} catch (ResourceNotFoundException | PersistentException e) {
			return false;
		}
	}
	
	public boolean hasApplied(Authentication authentication, int houseId) throws PersistentException, ResourceNotFoundException {
		Tenant tenant = tenantService.getById(((MyUser) authentication.getPrincipal()).getId());
		House house;
		try {
			house = houseService.getById(houseId);
		} catch (ResourceNotFoundException e) {
			return false;
		}
		return ApplicationDAO.getApplicationByORMID(tenant, house) != null;
	}
	
	public boolean wereRoommates(Authentication authentication, int idHouse, int idEvaluated) {
		try {
			Tenant evaluator = tenantService.getById(((MyUser) authentication.getPrincipal()).getId());
			Tenant evaluated = tenantService.getById(idEvaluated);
			House house = houseService.getById(idHouse);
			
			RentHistory evaluatorRH = RentHistoryDAO.getRentHistoryByORMID(house, evaluator);
			RentHistory evaluatedRH = RentHistoryDAO.getRentHistoryByORMID(house, evaluated);
			return evaluatorRH != null && evaluatedRH != null && evaluatorRH.getTenantId() != evaluatedRH.getTenantId() && evaluatorRH.getHouseId() == evaluatedRH.getHouseId()
					&& this.intersect(evaluatorRH.getbDate(), evaluatorRH.geteDate(), evaluatedRH.getbDate(), evaluatedRH.geteDate());
			
		} catch (PersistentException | ResourceNotFoundException e) {
			return false;
		}
	}
	
	private boolean intersect(Date bdateA, Date edateA, Date bdateB, Date edateB) {
		if (edateA == null) edateA = new Date();
		if (edateB == null) edateB = new Date();
		return (bdateA.getTime() <= edateB.getTime()) && (edateA.getTime() >= bdateB.getTime());
	}
}