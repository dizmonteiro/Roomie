/**
 * Licensee: vr(Universidade do Minho)
 * License Type: Academic
 */
package ormsamples;

import org.orm.*;
public class DeleteRoomieData {
	public void deleteTestData() throws PersistentException {
		PersistentTransaction t = roomie.entities.RoomiePersistentManager.instance().getSession().beginTransaction();
		try {
			roomie.entities.Tenant lroomieentitiesTenant = roomie.entities.TenantDAO.loadTenantByQuery(null, null);
			// Delete the persistent object
			roomie.entities.TenantDAO.delete(lroomieentitiesTenant);
			roomie.entities.House lroomieentitiesHouse = roomie.entities.HouseDAO.loadHouseByQuery(null, null);
			// Delete the persistent object
			roomie.entities.HouseDAO.delete(lroomieentitiesHouse);
			roomie.entities.Photo lroomieentitiesPhoto = roomie.entities.PhotoDAO.loadPhotoByQuery(null, null);
			// Delete the persistent object
			roomie.entities.PhotoDAO.delete(lroomieentitiesPhoto);
			roomie.entities.Landlord lroomieentitiesLandlord = roomie.entities.LandlordDAO.loadLandlordByQuery(null, null);
			// Delete the persistent object
			roomie.entities.LandlordDAO.delete(lroomieentitiesLandlord);
			roomie.entities.RentHistory lroomieentitiesRentHistory = roomie.entities.RentHistoryDAO.loadRentHistoryByQuery(null, null);
			// Delete the persistent object
			roomie.entities.RentHistoryDAO.delete(lroomieentitiesRentHistory);
			roomie.entities.Application lroomieentitiesApplication = roomie.entities.ApplicationDAO.loadApplicationByQuery(null, null);
			// Delete the persistent object
			roomie.entities.ApplicationDAO.delete(lroomieentitiesApplication);
			roomie.entities.LandlordEvaluation lroomieentitiesLandlordEvaluation = roomie.entities.LandlordEvaluationDAO.loadLandlordEvaluationByQuery(null, null);
			// Delete the persistent object
			roomie.entities.LandlordEvaluationDAO.delete(lroomieentitiesLandlordEvaluation);
			roomie.entities.TenantEvaluation lroomieentitiesTenantEvaluation = roomie.entities.TenantEvaluationDAO.loadTenantEvaluationByQuery(null, null);
			// Delete the persistent object
			roomie.entities.TenantEvaluationDAO.delete(lroomieentitiesTenantEvaluation);
			roomie.entities.Avatar lroomieentitiesAvatar = roomie.entities.AvatarDAO.loadAvatarByQuery(null, null);
			// Delete the persistent object
			roomie.entities.AvatarDAO.delete(lroomieentitiesAvatar);
			t.commit();
		}
		catch (Exception e) {
			t.rollback();
		}
		
	}
	
	public static void main(String[] args) {
		try {
			DeleteRoomieData deleteRoomieData = new DeleteRoomieData();
			try {
				deleteRoomieData.deleteTestData();
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
