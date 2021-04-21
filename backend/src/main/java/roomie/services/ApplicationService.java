package roomie.services;

/**
 * @author: Vasco Ramos
 * @created: 13/04/2021 - 11:02
 */

import org.hibernate.criterion.Restrictions;
import org.orm.PersistentException;
import org.springframework.stereotype.Service;
import roomie.exception.ErrorDetails;
import roomie.models.application.Application;
import roomie.models.application.ApplicationDAO;
import roomie.models.house.House;
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

    /*
    public boolean delete(Application application) throws PersistentException, ResourceNotFoundException {
        ApplicationDAO.evict(application);
        return ApplicationDAO.delete(application);
    }

    public Application update(Application application, Application applicationInfo) throws PersistentException {
        if (applicationInfo.getName() != null) {
            application.setName(applicationInfo.getName());
        }

        if (applicationInfo.getUsername() != null) {
            application.setUsername(applicationInfo.getUsername());
        }

        if (applicationInfo.getPhone() != null) {
            application.setPhone(applicationInfo.getPhone());
        }

        if (applicationInfo.getSex() != null) {
            application.setSex(applicationInfo.getSex());
        }

        if (applicationInfo.getAddress() != null) {
            application.setAddress(applicationInfo.getAddress());
        }

        ApplicationDAO.save(application);
        ApplicationDAO.refresh(application);
        return application;
    }

    public boolean updatePassword(Application application, UpdatePasswordRequest body) throws PersistentException {
        if (!passwordEncoder.matches(body.getOldPassword(), application.getPassword())) {
            throw new ErrorDetails("Current password is not correct");
        }

        if (body.getOldPassword().equals(body.getNewPassword())) {
            throw new ErrorDetails("Current and new passwords can't be the same");
        }

        application.setPassword(passwordEncoder.encode(body.getNewPassword()));

        ApplicationDAO.save(application);
        ApplicationDAO.refresh(application);
        return true;
    }

    public boolean save(Application application) throws PersistentException {
        ApplicationDAO.save(application);
        ApplicationDAO.refresh(application);
        return true;
    }
	*/
}
