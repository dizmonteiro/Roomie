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

import java.util.Date;

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
}
