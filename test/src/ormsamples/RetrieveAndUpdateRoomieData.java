/**
 * Licensee: vr(Universidade do Minho)
 * License Type: Academic
 */
package ormsamples;

import org.orm.*;
public class RetrieveAndUpdateRoomieData {
	public void retrieveAndUpdateTestData() throws PersistentException {
		PersistentTransaction t = roomie.entities.RoomiePersistentManager.instance().getSession().beginTransaction();
		try {
			roomie.entities.Tenant lroomieentitiesTenant = roomie.entities.TenantDAO.loadTenantByQuery(null, null);
			// Update the properties of the persistent object
			roomie.entities.TenantDAO.save(lroomieentitiesTenant);
			roomie.entities.House lroomieentitiesHouse = roomie.entities.HouseDAO.loadHouseByQuery(null, null);
			// Update the properties of the persistent object
			roomie.entities.HouseDAO.save(lroomieentitiesHouse);
			roomie.entities.Photo lroomieentitiesPhoto = roomie.entities.PhotoDAO.loadPhotoByQuery(null, null);
			// Update the properties of the persistent object
			roomie.entities.PhotoDAO.save(lroomieentitiesPhoto);
			roomie.entities.Landlord lroomieentitiesLandlord = roomie.entities.LandlordDAO.loadLandlordByQuery(null, null);
			// Update the properties of the persistent object
			roomie.entities.LandlordDAO.save(lroomieentitiesLandlord);
			roomie.entities.RentHistory lroomieentitiesRentHistory = roomie.entities.RentHistoryDAO.loadRentHistoryByQuery(null, null);
			// Update the properties of the persistent object
			roomie.entities.RentHistoryDAO.save(lroomieentitiesRentHistory);
			roomie.entities.Application lroomieentitiesApplication = roomie.entities.ApplicationDAO.loadApplicationByQuery(null, null);
			// Update the properties of the persistent object
			roomie.entities.ApplicationDAO.save(lroomieentitiesApplication);
			roomie.entities.LandlordEvaluation lroomieentitiesLandlordEvaluation = roomie.entities.LandlordEvaluationDAO.loadLandlordEvaluationByQuery(null, null);
			// Update the properties of the persistent object
			roomie.entities.LandlordEvaluationDAO.save(lroomieentitiesLandlordEvaluation);
			roomie.entities.TenantEvaluation lroomieentitiesTenantEvaluation = roomie.entities.TenantEvaluationDAO.loadTenantEvaluationByQuery(null, null);
			// Update the properties of the persistent object
			roomie.entities.TenantEvaluationDAO.save(lroomieentitiesTenantEvaluation);
			roomie.entities.Avatar lroomieentitiesAvatar = roomie.entities.AvatarDAO.loadAvatarByQuery(null, null);
			// Update the properties of the persistent object
			roomie.entities.AvatarDAO.save(lroomieentitiesAvatar);
			t.commit();
		}
		catch (Exception e) {
			t.rollback();
		}
		
	}
	
	public void retrieveByCriteria() throws PersistentException {
		System.out.println("Retrieving Tenant by TenantCriteria");
		roomie.entities.TenantCriteria lroomieentitiesTenantCriteria = new roomie.entities.TenantCriteria();
		// Please uncomment the follow line and fill in parameter(s)
		//lroomieentitiesTenantCriteria.id.eq();
		System.out.println(lroomieentitiesTenantCriteria.uniqueTenant());
		
		System.out.println("Retrieving House by HouseCriteria");
		roomie.entities.HouseCriteria lroomieentitiesHouseCriteria = new roomie.entities.HouseCriteria();
		// Please uncomment the follow line and fill in parameter(s)
		//lroomieentitiesHouseCriteria.id.eq();
		System.out.println(lroomieentitiesHouseCriteria.uniqueHouse());
		
		System.out.println("Retrieving Photo by PhotoCriteria");
		roomie.entities.PhotoCriteria lroomieentitiesPhotoCriteria = new roomie.entities.PhotoCriteria();
		// Please uncomment the follow line and fill in parameter(s)
		//lroomieentitiesPhotoCriteria.ID.eq();
		System.out.println(lroomieentitiesPhotoCriteria.uniquePhoto());
		
		System.out.println("Retrieving Landlord by LandlordCriteria");
		roomie.entities.LandlordCriteria lroomieentitiesLandlordCriteria = new roomie.entities.LandlordCriteria();
		// Please uncomment the follow line and fill in parameter(s)
		//lroomieentitiesLandlordCriteria.id.eq();
		System.out.println(lroomieentitiesLandlordCriteria.uniqueLandlord());
		
		System.out.println("Retrieving RentHistory by RentHistoryCriteria");
		roomie.entities.RentHistoryCriteria lroomieentitiesRentHistoryCriteria = new roomie.entities.RentHistoryCriteria();
		// Please uncomment the follow line and fill in parameter(s)
		//lroomieentitiesRentHistoryCriteria.house.eq();
		//lroomieentitiesRentHistoryCriteria.tenant.eq();
		System.out.println(lroomieentitiesRentHistoryCriteria.uniqueRentHistory());
		
		System.out.println("Retrieving Application by ApplicationCriteria");
		roomie.entities.ApplicationCriteria lroomieentitiesApplicationCriteria = new roomie.entities.ApplicationCriteria();
		// Please uncomment the follow line and fill in parameter(s)
		//lroomieentitiesApplicationCriteria.tenant.eq();
		//lroomieentitiesApplicationCriteria.house.eq();
		System.out.println(lroomieentitiesApplicationCriteria.uniqueApplication());
		
		System.out.println("Retrieving LandlordEvaluation by LandlordEvaluationCriteria");
		roomie.entities.LandlordEvaluationCriteria lroomieentitiesLandlordEvaluationCriteria = new roomie.entities.LandlordEvaluationCriteria();
		// Please uncomment the follow line and fill in parameter(s)
		//lroomieentitiesLandlordEvaluationCriteria.landlord.eq();
		//lroomieentitiesLandlordEvaluationCriteria.tenant.eq();
		System.out.println(lroomieentitiesLandlordEvaluationCriteria.uniqueLandlordEvaluation());
		
		System.out.println("Retrieving TenantEvaluation by TenantEvaluationCriteria");
		roomie.entities.TenantEvaluationCriteria lroomieentitiesTenantEvaluationCriteria = new roomie.entities.TenantEvaluationCriteria();
		// Please uncomment the follow line and fill in parameter(s)
		//lroomieentitiesTenantEvaluationCriteria.evaluatorTenant.eq();
		//lroomieentitiesTenantEvaluationCriteria.evaluatedTenant.eq();
		System.out.println(lroomieentitiesTenantEvaluationCriteria.uniqueTenantEvaluation());
		
		System.out.println("Retrieving Avatar by AvatarCriteria");
		roomie.entities.AvatarCriteria lroomieentitiesAvatarCriteria = new roomie.entities.AvatarCriteria();
		// Please uncomment the follow line and fill in parameter(s)
		//lroomieentitiesAvatarCriteria.ID.eq();
		System.out.println(lroomieentitiesAvatarCriteria.uniqueAvatar());
		
	}
	
	
	public static void main(String[] args) {
		try {
			RetrieveAndUpdateRoomieData retrieveAndUpdateRoomieData = new RetrieveAndUpdateRoomieData();
			try {
				retrieveAndUpdateRoomieData.retrieveAndUpdateTestData();
				//retrieveAndUpdateRoomieData.retrieveByCriteria();
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
