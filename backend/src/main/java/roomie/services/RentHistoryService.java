package roomie.services;

/**
 * @author: João Abreu
 * @created: 17/04/2021 - 15:24
 */

import org.orm.PersistentException;
import org.springframework.stereotype.Service;
import roomie.models.house.House;
import roomie.models.rentHistory.RentHistory;
import roomie.models.rentHistory.RentHistoryDAO;
import roomie.models.tenant.Tenant;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class RentHistoryService {
	public void create(Tenant tenant, House house) throws PersistentException {
		RentHistory rentHistory = RentHistoryDAO.createRentHistory();
		rentHistory.setTenant(tenant);
		rentHistory.setHouse(house);
		rentHistory.setbDate(new Date());
		RentHistoryDAO.save(rentHistory);
	}
	
	public void finish(RentHistory r) throws PersistentException {
		r.seteDate(new Date());
		RentHistoryDAO.save(r);
		RentHistoryDAO.refresh(r);
	}
	
	public List<Tenant> getHouseTenants(House house, String bDate, String eDate) throws PersistentException, ParseException {
		List<RentHistory> rentHistories = new ArrayList<>();
		if (bDate == null && eDate == null) {
			rentHistories = RentHistoryDAO.queryRentHistory("house=" + house + " and edate is null", null);
		} else if (bDate != null && eDate != null) {
			rentHistories = RentHistoryDAO
					.queryRentHistory("house=" + house + " and bdate >= '" + bDate + "' and edate <= '" + eDate + "'", null);
		}
		
		List<Tenant> tenants = new ArrayList<>();
		for (RentHistory entry : rentHistories) {
			tenants.add(entry.getTenant());
		}
		return tenants;
	}
	
	public List<RentHistory> getTenantsRentHistory(Tenant tenant) throws PersistentException {
		return RentHistoryDAO.queryRentHistory("tenant=" + tenant, null);
	}
}
