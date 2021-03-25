/**
 * Licensee: vr(Universidade do Minho)
 * License Type: Academic
 */
package ormsamples;

import org.orm.PersistentException;
import org.orm.PersistentTransaction;

public class DeleteRoomieData {
	public static void main(String[] args) {
		try {
			DeleteRoomieData deleteRoomieData = new DeleteRoomieData();
			try {
				deleteRoomieData.deleteTestData();
			} finally {
				roomie.RoomiePersistentManager.instance().disposePersistentManager();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void deleteTestData() throws PersistentException {
		PersistentTransaction t = roomie.RoomiePersistentManager.instance().getSession().beginTransaction();
		try {
			roomie.Tenant lroomieTenant = roomie.TenantDAO.loadTenantByQuery(null, null);
			// Delete the persistent object
			roomie.TenantDAO.delete(lroomieTenant);
			roomie.House lroomieHouse = roomie.HouseDAO.loadHouseByQuery(null, null);
			// Delete the persistent object
			roomie.HouseDAO.delete(lroomieHouse);
			roomie.Photo lroomiePhoto = roomie.PhotoDAO.loadPhotoByQuery(null, null);
			// Delete the persistent object
			roomie.PhotoDAO.delete(lroomiePhoto);
			roomie.Landlord lroomieLandlord = roomie.LandlordDAO.loadLandlordByQuery(null, null);
			// Delete the persistent object
			roomie.LandlordDAO.delete(lroomieLandlord);
			roomie.RentHistory lroomieRentHistory = roomie.RentHistoryDAO.loadRentHistoryByQuery(null, null);
			// Delete the persistent object
			roomie.RentHistoryDAO.delete(lroomieRentHistory);
			roomie.Application lroomieApplication = roomie.ApplicationDAO.loadApplicationByQuery(null, null);
			// Delete the persistent object
			roomie.ApplicationDAO.delete(lroomieApplication);
			roomie.LandlordEvaluation lroomieLandlordEvaluation = roomie.LandlordEvaluationDAO.loadLandlordEvaluationByQuery(null, null);
			// Delete the persistent object
			roomie.LandlordEvaluationDAO.delete(lroomieLandlordEvaluation);
			roomie.TenantEvaluation lroomieTenantEvaluation = roomie.TenantEvaluationDAO.loadTenantEvaluationByQuery(null, null);
			// Delete the persistent object
			roomie.TenantEvaluationDAO.delete(lroomieTenantEvaluation);
			roomie.Avatar lroomieAvatar = roomie.AvatarDAO.loadAvatarByQuery(null, null);
			// Delete the persistent object
			roomie.AvatarDAO.delete(lroomieAvatar);
			t.commit();
		} catch (Exception e) {
			t.rollback();
		}
		
	}
}
