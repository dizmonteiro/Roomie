/**
 * Licensee: vr(Universidade do Minho)
 * License Type: Academic
 */
package ormsamples;

import org.orm.*;
public class RetrieveAndUpdateRoomieData {
	public void retrieveAndUpdateTestData() throws PersistentException {
		PersistentTransaction t = roomie.RoomiePersistentManager.instance().getSession().beginTransaction();
		try {
			roomie.Tenant lroomieTenant = roomie.TenantDAO.loadTenantByQuery(null, null);
			// Update the properties of the persistent object
			roomie.TenantDAO.save(lroomieTenant);
			roomie.House lroomieHouse = roomie.HouseDAO.loadHouseByQuery(null, null);
			// Update the properties of the persistent object
			roomie.HouseDAO.save(lroomieHouse);
			roomie.Photo lroomiePhoto = roomie.PhotoDAO.loadPhotoByQuery(null, null);
			// Update the properties of the persistent object
			roomie.PhotoDAO.save(lroomiePhoto);
			roomie.Landlord lroomieLandlord = roomie.LandlordDAO.loadLandlordByQuery(null, null);
			// Update the properties of the persistent object
			roomie.LandlordDAO.save(lroomieLandlord);
			roomie.RentHistory lroomieRentHistory = roomie.RentHistoryDAO.loadRentHistoryByQuery(null, null);
			// Update the properties of the persistent object
			roomie.RentHistoryDAO.save(lroomieRentHistory);
			roomie.Application lroomieApplication = roomie.ApplicationDAO.loadApplicationByQuery(null, null);
			// Update the properties of the persistent object
			roomie.ApplicationDAO.save(lroomieApplication);
			roomie.LandlordEvaluation lroomieLandlordEvaluation = roomie.LandlordEvaluationDAO.loadLandlordEvaluationByQuery(null, null);
			// Update the properties of the persistent object
			roomie.LandlordEvaluationDAO.save(lroomieLandlordEvaluation);
			roomie.TenantEvaluation lroomieTenantEvaluation = roomie.TenantEvaluationDAO.loadTenantEvaluationByQuery(null, null);
			// Update the properties of the persistent object
			roomie.TenantEvaluationDAO.save(lroomieTenantEvaluation);
			roomie.Avatar lroomieAvatar = roomie.AvatarDAO.loadAvatarByQuery(null, null);
			// Update the properties of the persistent object
			roomie.AvatarDAO.save(lroomieAvatar);
			t.commit();
		}
		catch (Exception e) {
			t.rollback();
		}
		
	}
	
	public void retrieveByCriteria() throws PersistentException {
		System.out.println("Retrieving Tenant by TenantCriteria");
		roomie.TenantCriteria lroomieTenantCriteria = new roomie.TenantCriteria();
		// Please uncomment the follow line and fill in parameter(s)
		//lroomieTenantCriteria.id.eq();
		System.out.println(lroomieTenantCriteria.uniqueTenant());
		
		System.out.println("Retrieving House by HouseCriteria");
		roomie.HouseCriteria lroomieHouseCriteria = new roomie.HouseCriteria();
		// Please uncomment the follow line and fill in parameter(s)
		//lroomieHouseCriteria.id.eq();
		System.out.println(lroomieHouseCriteria.uniqueHouse());
		
		System.out.println("Retrieving Photo by PhotoCriteria");
		roomie.PhotoCriteria lroomiePhotoCriteria = new roomie.PhotoCriteria();
		// Please uncomment the follow line and fill in parameter(s)
		//lroomiePhotoCriteria.ID.eq();
		System.out.println(lroomiePhotoCriteria.uniquePhoto());
		
		System.out.println("Retrieving Landlord by LandlordCriteria");
		roomie.LandlordCriteria lroomieLandlordCriteria = new roomie.LandlordCriteria();
		// Please uncomment the follow line and fill in parameter(s)
		//lroomieLandlordCriteria.id.eq();
		System.out.println(lroomieLandlordCriteria.uniqueLandlord());
		
		System.out.println("Retrieving RentHistory by RentHistoryCriteria");
		roomie.RentHistoryCriteria lroomieRentHistoryCriteria = new roomie.RentHistoryCriteria();
		// Please uncomment the follow line and fill in parameter(s)
		//lroomieRentHistoryCriteria.house.eq();
		//lroomieRentHistoryCriteria.tenant.eq();
		System.out.println(lroomieRentHistoryCriteria.uniqueRentHistory());
		
		System.out.println("Retrieving Application by ApplicationCriteria");
		roomie.ApplicationCriteria lroomieApplicationCriteria = new roomie.ApplicationCriteria();
		// Please uncomment the follow line and fill in parameter(s)
		//lroomieApplicationCriteria.tenant.eq();
		//lroomieApplicationCriteria.house.eq();
		System.out.println(lroomieApplicationCriteria.uniqueApplication());
		
		System.out.println("Retrieving LandlordEvaluation by LandlordEvaluationCriteria");
		roomie.LandlordEvaluationCriteria lroomieLandlordEvaluationCriteria = new roomie.LandlordEvaluationCriteria();
		// Please uncomment the follow line and fill in parameter(s)
		//lroomieLandlordEvaluationCriteria.landlord.eq();
		//lroomieLandlordEvaluationCriteria.tenant.eq();
		System.out.println(lroomieLandlordEvaluationCriteria.uniqueLandlordEvaluation());
		
		System.out.println("Retrieving TenantEvaluation by TenantEvaluationCriteria");
		roomie.TenantEvaluationCriteria lroomieTenantEvaluationCriteria = new roomie.TenantEvaluationCriteria();
		// Please uncomment the follow line and fill in parameter(s)
		//lroomieTenantEvaluationCriteria.evaluatorTenant.eq();
		//lroomieTenantEvaluationCriteria.evaluatedTenant.eq();
		System.out.println(lroomieTenantEvaluationCriteria.uniqueTenantEvaluation());
		
		System.out.println("Retrieving Avatar by AvatarCriteria");
		roomie.AvatarCriteria lroomieAvatarCriteria = new roomie.AvatarCriteria();
		// Please uncomment the follow line and fill in parameter(s)
		//lroomieAvatarCriteria.ID.eq();
		System.out.println(lroomieAvatarCriteria.uniqueAvatar());
		
	}
	
	
	public static void main(String[] args) {
		try {
			RetrieveAndUpdateRoomieData retrieveAndUpdateRoomieData = new RetrieveAndUpdateRoomieData();
			try {
				retrieveAndUpdateRoomieData.retrieveAndUpdateTestData();
				//retrieveAndUpdateRoomieData.retrieveByCriteria();
			}
			finally {
				roomie.RoomiePersistentManager.instance().disposePersistentManager();
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
}
