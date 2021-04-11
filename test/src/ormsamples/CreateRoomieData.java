/**
 * Licensee: vr(Universidade do Minho)
 * License Type: Academic
 */
package ormsamples;

import org.orm.*;
public class CreateRoomieData {
	public void createTestData() throws PersistentException {
		PersistentTransaction t = roomie.entities.RoomiePersistentManager.instance().getSession().beginTransaction();
		try {
			roomie.entities.Tenant lroomieentitiesTenant = roomie.entities.TenantDAO.createTenant();
			// TODO Initialize the properties of the persistent object here, the following properties must be initialized before saving : avatar
			roomie.entities.TenantDAO.save(lroomieentitiesTenant);
			roomie.entities.House lroomieentitiesHouse = roomie.entities.HouseDAO.createHouse();
			// TODO Initialize the properties of the persistent object here, the following properties must be initialized before saving : photos, maxPrice, minPrice, bathRooms, availableRooms, rooms
			roomie.entities.HouseDAO.save(lroomieentitiesHouse);
			roomie.entities.Photo lroomieentitiesPhoto = roomie.entities.PhotoDAO.createPhoto();
			// Initialize the properties of the persistent object here
			roomie.entities.PhotoDAO.save(lroomieentitiesPhoto);
			roomie.entities.Landlord lroomieentitiesLandlord = roomie.entities.LandlordDAO.createLandlord();
			// TODO Initialize the properties of the persistent object here, the following properties must be initialized before saving : houses, avatar
			roomie.entities.LandlordDAO.save(lroomieentitiesLandlord);
			roomie.entities.RentHistory lroomieentitiesRentHistory = roomie.entities.RentHistoryDAO.createRentHistory();
			// TODO Initialize the properties of the persistent object here, the following properties must be initialized before saving : eDate, bDate
			roomie.entities.RentHistoryDAO.save(lroomieentitiesRentHistory);
			roomie.entities.Application lroomieentitiesApplication = roomie.entities.ApplicationDAO.createApplication();
			// TODO Initialize the properties of the persistent object here, the following properties must be initialized before saving : accepted, toBeAssessed
			roomie.entities.ApplicationDAO.save(lroomieentitiesApplication);
			roomie.entities.LandlordEvaluation lroomieentitiesLandlordEvaluation = roomie.entities.LandlordEvaluationDAO.createLandlordEvaluation();
			// TODO Initialize the properties of the persistent object here, the following properties must be initialized before saving : care, payment, cleanliness
			roomie.entities.LandlordEvaluationDAO.save(lroomieentitiesLandlordEvaluation);
			roomie.entities.TenantEvaluation lroomieentitiesTenantEvaluation = roomie.entities.TenantEvaluationDAO.createTenantEvaluation();
			// TODO Initialize the properties of the persistent object here, the following properties must be initialized before saving : friendliness, privacy, cleanliness, tidiness
			roomie.entities.TenantEvaluationDAO.save(lroomieentitiesTenantEvaluation);
			roomie.entities.Avatar lroomieentitiesAvatar = roomie.entities.AvatarDAO.createAvatar();
			// Initialize the properties of the persistent object here
			roomie.entities.AvatarDAO.save(lroomieentitiesAvatar);
			t.commit();
		}
		catch (Exception e) {
			t.rollback();
		}
		
	}
	
	public static void main(String[] args) {
		try {
			CreateRoomieData createRoomieData = new CreateRoomieData();
			try {
				createRoomieData.createTestData();
			}
			finally {
				roomie.entities.RoomiePersistentManager.instance().disposePersistentManager();
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
}
