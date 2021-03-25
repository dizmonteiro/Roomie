/**
 * Licensee: vr(Universidade do Minho)
 * License Type: Academic
 */
package ormsamples;

import org.orm.PersistentException;
import org.orm.PersistentTransaction;

public class CreateRoomieData {
	public static void main(String[] args) {
		try {
			CreateRoomieData createRoomieData = new CreateRoomieData();
			try {
				createRoomieData.createTestData();
			} finally {
				roomie.RoomiePersistentManager.instance().disposePersistentManager();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void createTestData() throws PersistentException {
		PersistentTransaction t = roomie.RoomiePersistentManager.instance().getSession().beginTransaction();
		try {
			roomie.Tenant lroomieTenant = roomie.TenantDAO.createTenant();
			// TODO Initialize the properties of the persistent object here, the following properties must be initialized before saving : avatar
			roomie.TenantDAO.save(lroomieTenant);
			roomie.House lroomieHouse = roomie.HouseDAO.createHouse();
			// TODO Initialize the properties of the persistent object here, the following properties must be initialized before saving : photos, price, bathRooms, availableRooms, rooms
			roomie.HouseDAO.save(lroomieHouse);
			roomie.Photo lroomiePhoto = roomie.PhotoDAO.createPhoto();
			// Initialize the properties of the persistent object here
			roomie.PhotoDAO.save(lroomiePhoto);
			roomie.Landlord lroomieLandlord = roomie.LandlordDAO.createLandlord();
			// TODO Initialize the properties of the persistent object here, the following properties must be initialized before saving : houses, avatar
			roomie.LandlordDAO.save(lroomieLandlord);
			roomie.RentHistory lroomieRentHistory = roomie.RentHistoryDAO.createRentHistory();
			// TODO Initialize the properties of the persistent object here, the following properties must be initialized before saving : eDate, bDate
			roomie.RentHistoryDAO.save(lroomieRentHistory);
			roomie.Application lroomieApplication = roomie.ApplicationDAO.createApplication();
			// TODO Initialize the properties of the persistent object here, the following properties must be initialized before saving : accepted, toBeAssessed
			roomie.ApplicationDAO.save(lroomieApplication);
			roomie.LandlordEvaluation lroomieLandlordEvaluation = roomie.LandlordEvaluationDAO.createLandlordEvaluation();
			// Initialize the properties of the persistent object here
			roomie.LandlordEvaluationDAO.save(lroomieLandlordEvaluation);
			roomie.TenantEvaluation lroomieTenantEvaluation = roomie.TenantEvaluationDAO.createTenantEvaluation();
			// Initialize the properties of the persistent object here
			roomie.TenantEvaluationDAO.save(lroomieTenantEvaluation);
			roomie.Avatar lroomieAvatar = roomie.AvatarDAO.createAvatar();
			// Initialize the properties of the persistent object here
			roomie.AvatarDAO.save(lroomieAvatar);
			t.commit();
		} catch (Exception e) {
			t.rollback();
		}
		
	}
}
