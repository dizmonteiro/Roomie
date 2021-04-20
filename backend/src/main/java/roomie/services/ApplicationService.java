package roomie.services;

/**
 * @author: Vasco Ramos
 * @created: 13/04/2021 - 11:02
 */

import org.orm.PersistentException;
import org.springframework.stereotype.Service;
import roomie.exception.ErrorDetails;
import roomie.models.application.Application;
import roomie.models.application.ApplicationDAO;
import roomie.models.house.House;
import roomie.models.tenant.Tenant;

@Service
public class ApplicationService {

    public Application create(Tenant tenant, House house) throws PersistentException {
        if(ApplicationDAO.getApplicationByORMID(tenant,house) != null){
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

    /*public Application register(Application application, Avatar avatar) throws PersistentException {
        if (avatar == null) {
            avatar = AvatarDAO.createAvatar();
            AvatarDAO.save(avatar);
        }

        application.setPassword(passwordEncoder.encode(application.getPassword()));
        application.setAvatar(avatar);

        ApplicationDAO.save(application);
        return application;
    }

    public Application getById(int id) throws ResourceNotFoundException, PersistentException {
        Application application = ApplicationDAO.getApplicationByORMID(id);
        if (application == null) {
            throw new ResourceNotFoundException("Application not found: id=" + id);
        }
        return application;
    }

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
