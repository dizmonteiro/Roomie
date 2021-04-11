package roomie.controller;

import org.orm.ORMDatabaseInitiator;
import org.orm.PersistentException;
import org.orm.PersistentTransaction;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import roomie.model.RoomiePersistentManager;
import roomie.model.avatar.Avatar;
import roomie.model.avatar.AvatarDAO;

/**
 * @author: Vasco Ramos
 * @created: 11/04/2021 - 10:08
 */

@RestController()
@RequestMapping("/admin")
public class Admin {
	
	@GetMapping("/create-db")
	public String createDB() {
		try {
			ORMDatabaseInitiator.createSchema(RoomiePersistentManager.instance());
			RoomiePersistentManager.instance().disposePersistentManager();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "Done";
	}
	
	@GetMapping("/drop-db")
	public String dropDB() {
		try {
			ORMDatabaseInitiator.dropSchema(RoomiePersistentManager.instance());
			RoomiePersistentManager.instance().disposePersistentManager();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "Done";
	}
	
	@GetMapping("/populate")
	public String populateDB() {
		try {
			try {
				createTestData();
			} finally {
				RoomiePersistentManager.instance().disposePersistentManager();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "Done";
	}
	
	private void createTestData() throws PersistentException {
		PersistentTransaction t = RoomiePersistentManager.instance().getSession().beginTransaction();
		try {
			// roomie.Tenant lroomieTenant = roomie.TenantDAO.createTenant();
			// TODO Initialize the properties of the persistent object here, the following properties must be initialized before saving : avatar
			// roomie.TenantDAO.save(lroomieTenant);
			// roomie.House lroomieHouse = roomie.HouseDAO.createHouse();
			// TODO Initialize the properties of the persistent object here, the following properties must be initialized before saving : photos, maxPrice, minPrice, bathRooms, availableRooms, rooms
			// roomie.HouseDAO.save(lroomieHouse);
			//roomie.Photo lroomiePhoto = roomie.PhotoDAO.createPhoto();
			// Initialize the properties of the persistent object here
			//roomie.PhotoDAO.save(lroomiePhoto);
			//roomie.Landlord lroomieLandlord = roomie.LandlordDAO.createLandlord();
			// TODO Initialize the properties of the persistent object here, the following properties must be initialized before saving : houses, avatar
			//roomie.LandlordDAO.save(lroomieLandlord);
			//roomie.RentHistory lroomieRentHistory = roomie.RentHistoryDAO.createRentHistory();
			// TODO Initialize the properties of the persistent object here, the following properties must be initialized before saving : eDate, bDate
			//roomie.RentHistoryDAO.save(lroomieRentHistory);
			//roomie.Application lroomieApplication = roomie.ApplicationDAO.createApplication();
			// TODO Initialize the properties of the persistent object here, the following properties must be initialized before saving : accepted, toBeAssessed
			//roomie.ApplicationDAO.save(lroomieApplication);
			//roomie.LandlordEvaluation lroomieLandlordEvaluation = roomie.LandlordEvaluationDAO.createLandlordEvaluation();
			// TODO Initialize the properties of the persistent object here, the following properties must be initialized before saving : care, payment, cleanliness
			//roomie.LandlordEvaluationDAO.save(lroomieLandlordEvaluation);
			//roomie.TenantEvaluation lroomieTenantEvaluation = roomie.TenantEvaluationDAO.createTenantEvaluation();
			// TODO Initialize the properties of the persistent object here, the following properties must be initialized before saving : friendliness, privacy, cleanliness, tidiness
			// roomie.TenantEvaluationDAO.save(lroomieTenantEvaluation);
			Avatar lroomieAvatar = AvatarDAO.createAvatar();
			// Initialize the properties of the persistent object here
			AvatarDAO.save(lroomieAvatar);
			t.commit();
		}
		catch (Exception e) {
			t.rollback();
		}
		
	}
	
}
