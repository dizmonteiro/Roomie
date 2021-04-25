package roomie.services;

/**
 * @author: Vasco Ramos
 * @created: 13/04/2021 - 11:02
 */

import org.hibernate.criterion.Restrictions;
import org.orm.PersistentException;
import org.springframework.stereotype.Service;
import roomie.exception.ErrorDetails;
import roomie.exception.ResourceNotFoundException;
import roomie.models.application.Application;
import roomie.models.application.ApplicationDAO;
import roomie.models.house.House;
import roomie.models.house.HouseDAO;
import roomie.models.tenant.Tenant;
import roomie.repositories.application.ApplicationCriteria;
import roomie.repositories.house.HouseCriteria;

import java.util.List;

@Service
public class ApplicationService {
	
	public Application create(Tenant tenant, House house) throws PersistentException {
		if (ApplicationDAO.getApplicationByORMID(tenant, house) != null) {
			throw new ErrorDetails("Tenant already applied to this house.");
		}
		Application application = new Application();
		application.setHouse(house);
		application.setTenant(tenant);
		application.setAccepted(false);
		application.setToBeAssessed(false);
		
		ApplicationDAO.save(application);
		return application;
	}
	
	public List<Application> getByTenantId(int id) throws PersistentException {
		return getByEntityId("tenant", id);
	}
	
	public List<Application> getByLandlordId(int id) throws PersistentException {
		return getByEntityId("landlord", id);
	}
	
	public List<Application> getByEntityId(String entity, int id) throws PersistentException {
		ApplicationCriteria criteria = new ApplicationCriteria();
		if (entity.equals("landlord")) {
			HouseCriteria houseCriteria = criteria.createHouseCriteria();
			houseCriteria.add(Restrictions.eq(entity + ".id", id));
		} else {
			criteria.add(Restrictions.eq(entity + ".id", id));
		}
		return criteria.list();
	}
	
	public boolean delete(Application application) throws PersistentException {
		ApplicationDAO.evict(application);
		return ApplicationDAO.delete(application);
	}
	
	public Application getById(Tenant tenant, House house) throws ResourceNotFoundException, PersistentException {
		Application application = ApplicationDAO.getApplicationByORMID(tenant, house);
		if (application == null) {
			throw new ResourceNotFoundException("Application not found: tenant = " + tenant
					.toString() + ", house = " + house.toString());
		}
		return application;
	}
	
	public Application update(Application application, boolean accept) throws PersistentException {
		application.setToBeAssessed(true);
		application.setAccepted(accept);
		ApplicationDAO.save(application);
		ApplicationDAO.refresh(application);
		return application;
	}
}
