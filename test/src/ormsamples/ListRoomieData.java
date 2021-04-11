/**
 * Licensee: vr(Universidade do Minho)
 * License Type: Academic
 */
package ormsamples;

import org.orm.*;
public class ListRoomieData {
	private static final int ROW_COUNT = 100;
	
	public void listTestData() throws PersistentException {
		System.out.println("Listing Tenant...");
		roomie.entities.Tenant[] roomieentitiesTenants = roomie.entities.TenantDAO.listTenantByQuery(null, null);
		int length = Math.min(roomieentitiesTenants.length, ROW_COUNT);
		for (int i = 0; i < length; i++) {
			System.out.println(roomieentitiesTenants[i]);
		}
		System.out.println(length + " record(s) retrieved.");
		
		System.out.println("Listing House...");
		roomie.entities.House[] roomieentitiesHouses = roomie.entities.HouseDAO.listHouseByQuery(null, null);
		length = Math.min(roomieentitiesHouses.length, ROW_COUNT);
		for (int i = 0; i < length; i++) {
			System.out.println(roomieentitiesHouses[i]);
		}
		System.out.println(length + " record(s) retrieved.");
		
		System.out.println("Listing Photo...");
		roomie.entities.Photo[] roomieentitiesPhotos = roomie.entities.PhotoDAO.listPhotoByQuery(null, null);
		length = Math.min(roomieentitiesPhotos.length, ROW_COUNT);
		for (int i = 0; i < length; i++) {
			System.out.println(roomieentitiesPhotos[i]);
		}
		System.out.println(length + " record(s) retrieved.");
		
		System.out.println("Listing Landlord...");
		roomie.entities.Landlord[] roomieentitiesLandlords = roomie.entities.LandlordDAO.listLandlordByQuery(null, null);
		length = Math.min(roomieentitiesLandlords.length, ROW_COUNT);
		for (int i = 0; i < length; i++) {
			System.out.println(roomieentitiesLandlords[i]);
		}
		System.out.println(length + " record(s) retrieved.");
		
		System.out.println("Listing RentHistory...");
		roomie.entities.RentHistory[] roomieentitiesRentHistorys = roomie.entities.RentHistoryDAO.listRentHistoryByQuery(null, null);
		length = Math.min(roomieentitiesRentHistorys.length, ROW_COUNT);
		for (int i = 0; i < length; i++) {
			System.out.println(roomieentitiesRentHistorys[i]);
		}
		System.out.println(length + " record(s) retrieved.");
		
		System.out.println("Listing Application...");
		roomie.entities.Application[] roomieentitiesApplications = roomie.entities.ApplicationDAO.listApplicationByQuery(null, null);
		length = Math.min(roomieentitiesApplications.length, ROW_COUNT);
		for (int i = 0; i < length; i++) {
			System.out.println(roomieentitiesApplications[i]);
		}
		System.out.println(length + " record(s) retrieved.");
		
		System.out.println("Listing LandlordEvaluation...");
		roomie.entities.LandlordEvaluation[] roomieentitiesLandlordEvaluations = roomie.entities.LandlordEvaluationDAO.listLandlordEvaluationByQuery(null, null);
		length = Math.min(roomieentitiesLandlordEvaluations.length, ROW_COUNT);
		for (int i = 0; i < length; i++) {
			System.out.println(roomieentitiesLandlordEvaluations[i]);
		}
		System.out.println(length + " record(s) retrieved.");
		
		System.out.println("Listing TenantEvaluation...");
		roomie.entities.TenantEvaluation[] roomieentitiesTenantEvaluations = roomie.entities.TenantEvaluationDAO.listTenantEvaluationByQuery(null, null);
		length = Math.min(roomieentitiesTenantEvaluations.length, ROW_COUNT);
		for (int i = 0; i < length; i++) {
			System.out.println(roomieentitiesTenantEvaluations[i]);
		}
		System.out.println(length + " record(s) retrieved.");
		
		System.out.println("Listing Avatar...");
		roomie.entities.Avatar[] roomieentitiesAvatars = roomie.entities.AvatarDAO.listAvatarByQuery(null, null);
		length = Math.min(roomieentitiesAvatars.length, ROW_COUNT);
		for (int i = 0; i < length; i++) {
			System.out.println(roomieentitiesAvatars[i]);
		}
		System.out.println(length + " record(s) retrieved.");
		
	}
	
	public void listByCriteria() throws PersistentException {
		System.out.println("Listing Tenant by Criteria...");
		roomie.entities.TenantCriteria lroomieentitiesTenantCriteria = new roomie.entities.TenantCriteria();
		// Please uncomment the follow line and fill in parameter(s) 
		//lroomieentitiesTenantCriteria.id.eq();
		lroomieentitiesTenantCriteria.setMaxResults(ROW_COUNT);
		roomie.entities.Tenant[] roomieentitiesTenants = lroomieentitiesTenantCriteria.listTenant();
		int length =roomieentitiesTenants== null ? 0 : Math.min(roomieentitiesTenants.length, ROW_COUNT); 
		for (int i = 0; i < length; i++) {
			 System.out.println(roomieentitiesTenants[i]);
		}
		System.out.println(length + " Tenant record(s) retrieved."); 
		
		System.out.println("Listing House by Criteria...");
		roomie.entities.HouseCriteria lroomieentitiesHouseCriteria = new roomie.entities.HouseCriteria();
		// Please uncomment the follow line and fill in parameter(s) 
		//lroomieentitiesHouseCriteria.id.eq();
		lroomieentitiesHouseCriteria.setMaxResults(ROW_COUNT);
		roomie.entities.House[] roomieentitiesHouses = lroomieentitiesHouseCriteria.listHouse();
		length =roomieentitiesHouses== null ? 0 : Math.min(roomieentitiesHouses.length, ROW_COUNT); 
		for (int i = 0; i < length; i++) {
			 System.out.println(roomieentitiesHouses[i]);
		}
		System.out.println(length + " House record(s) retrieved."); 
		
		System.out.println("Listing Photo by Criteria...");
		roomie.entities.PhotoCriteria lroomieentitiesPhotoCriteria = new roomie.entities.PhotoCriteria();
		// Please uncomment the follow line and fill in parameter(s) 
		//lroomieentitiesPhotoCriteria.ID.eq();
		lroomieentitiesPhotoCriteria.setMaxResults(ROW_COUNT);
		roomie.entities.Photo[] roomieentitiesPhotos = lroomieentitiesPhotoCriteria.listPhoto();
		length =roomieentitiesPhotos== null ? 0 : Math.min(roomieentitiesPhotos.length, ROW_COUNT); 
		for (int i = 0; i < length; i++) {
			 System.out.println(roomieentitiesPhotos[i]);
		}
		System.out.println(length + " Photo record(s) retrieved."); 
		
		System.out.println("Listing Landlord by Criteria...");
		roomie.entities.LandlordCriteria lroomieentitiesLandlordCriteria = new roomie.entities.LandlordCriteria();
		// Please uncomment the follow line and fill in parameter(s) 
		//lroomieentitiesLandlordCriteria.id.eq();
		lroomieentitiesLandlordCriteria.setMaxResults(ROW_COUNT);
		roomie.entities.Landlord[] roomieentitiesLandlords = lroomieentitiesLandlordCriteria.listLandlord();
		length =roomieentitiesLandlords== null ? 0 : Math.min(roomieentitiesLandlords.length, ROW_COUNT); 
		for (int i = 0; i < length; i++) {
			 System.out.println(roomieentitiesLandlords[i]);
		}
		System.out.println(length + " Landlord record(s) retrieved."); 
		
		System.out.println("Listing RentHistory by Criteria...");
		roomie.entities.RentHistoryCriteria lroomieentitiesRentHistoryCriteria = new roomie.entities.RentHistoryCriteria();
		// Please uncomment the follow line and fill in parameter(s) 
		//roomie.entities.HouseCriteria lroomieentitiesRentHistoryCriteria_House = lroomieentitiesRentHistoryCriteria.createHouseCriteria();
		//lroomieentitiesRentHistoryCriteria_House.id.eq();
		//roomie.entities.TenantCriteria lroomieentitiesRentHistoryCriteria_Tenant = lroomieentitiesRentHistoryCriteria.createTenantCriteria();
		//lroomieentitiesRentHistoryCriteria_Tenant.id.eq();
		lroomieentitiesRentHistoryCriteria.setMaxResults(ROW_COUNT);
		roomie.entities.RentHistory[] roomieentitiesRentHistorys = lroomieentitiesRentHistoryCriteria.listRentHistory();
		length =roomieentitiesRentHistorys== null ? 0 : Math.min(roomieentitiesRentHistorys.length, ROW_COUNT); 
		for (int i = 0; i < length; i++) {
			 System.out.println(roomieentitiesRentHistorys[i]);
		}
		System.out.println(length + " RentHistory record(s) retrieved."); 
		
		System.out.println("Listing Application by Criteria...");
		roomie.entities.ApplicationCriteria lroomieentitiesApplicationCriteria = new roomie.entities.ApplicationCriteria();
		// Please uncomment the follow line and fill in parameter(s) 
		//roomie.entities.TenantCriteria lroomieentitiesApplicationCriteria_Tenant = lroomieentitiesApplicationCriteria.createTenantCriteria();
		//lroomieentitiesApplicationCriteria_Tenant.id.eq();
		//roomie.entities.HouseCriteria lroomieentitiesApplicationCriteria_House = lroomieentitiesApplicationCriteria.createHouseCriteria();
		//lroomieentitiesApplicationCriteria_House.id.eq();
		lroomieentitiesApplicationCriteria.setMaxResults(ROW_COUNT);
		roomie.entities.Application[] roomieentitiesApplications = lroomieentitiesApplicationCriteria.listApplication();
		length =roomieentitiesApplications== null ? 0 : Math.min(roomieentitiesApplications.length, ROW_COUNT); 
		for (int i = 0; i < length; i++) {
			 System.out.println(roomieentitiesApplications[i]);
		}
		System.out.println(length + " Application record(s) retrieved."); 
		
		System.out.println("Listing LandlordEvaluation by Criteria...");
		roomie.entities.LandlordEvaluationCriteria lroomieentitiesLandlordEvaluationCriteria = new roomie.entities.LandlordEvaluationCriteria();
		// Please uncomment the follow line and fill in parameter(s) 
		//roomie.entities.LandlordCriteria lroomieentitiesLandlordEvaluationCriteria_Landlord = lroomieentitiesLandlordEvaluationCriteria.createLandlordCriteria();
		//lroomieentitiesLandlordEvaluationCriteria_Landlord.id.eq();
		//roomie.entities.TenantCriteria lroomieentitiesLandlordEvaluationCriteria_Tenant = lroomieentitiesLandlordEvaluationCriteria.createTenantCriteria();
		//lroomieentitiesLandlordEvaluationCriteria_Tenant.id.eq();
		lroomieentitiesLandlordEvaluationCriteria.setMaxResults(ROW_COUNT);
		roomie.entities.LandlordEvaluation[] roomieentitiesLandlordEvaluations = lroomieentitiesLandlordEvaluationCriteria.listLandlordEvaluation();
		length =roomieentitiesLandlordEvaluations== null ? 0 : Math.min(roomieentitiesLandlordEvaluations.length, ROW_COUNT); 
		for (int i = 0; i < length; i++) {
			 System.out.println(roomieentitiesLandlordEvaluations[i]);
		}
		System.out.println(length + " LandlordEvaluation record(s) retrieved."); 
		
		System.out.println("Listing TenantEvaluation by Criteria...");
		roomie.entities.TenantEvaluationCriteria lroomieentitiesTenantEvaluationCriteria = new roomie.entities.TenantEvaluationCriteria();
		// Please uncomment the follow line and fill in parameter(s) 
		//roomie.entities.TenantCriteria lroomieentitiesTenantEvaluationCriteria_Tenant = lroomieentitiesTenantEvaluationCriteria.createEvaluatorTenantCriteria();
		//lroomieentitiesTenantEvaluationCriteria_Tenant.id.eq();
		//roomie.entities.TenantCriteria lroomieentitiesTenantEvaluationCriteria_Tenant = lroomieentitiesTenantEvaluationCriteria.createEvaluatedTenantCriteria();
		//lroomieentitiesTenantEvaluationCriteria_Tenant.id.eq();
		lroomieentitiesTenantEvaluationCriteria.setMaxResults(ROW_COUNT);
		roomie.entities.TenantEvaluation[] roomieentitiesTenantEvaluations = lroomieentitiesTenantEvaluationCriteria.listTenantEvaluation();
		length =roomieentitiesTenantEvaluations== null ? 0 : Math.min(roomieentitiesTenantEvaluations.length, ROW_COUNT); 
		for (int i = 0; i < length; i++) {
			 System.out.println(roomieentitiesTenantEvaluations[i]);
		}
		System.out.println(length + " TenantEvaluation record(s) retrieved."); 
		
		System.out.println("Listing Avatar by Criteria...");
		roomie.entities.AvatarCriteria lroomieentitiesAvatarCriteria = new roomie.entities.AvatarCriteria();
		// Please uncomment the follow line and fill in parameter(s) 
		//lroomieentitiesAvatarCriteria.ID.eq();
		lroomieentitiesAvatarCriteria.setMaxResults(ROW_COUNT);
		roomie.entities.Avatar[] roomieentitiesAvatars = lroomieentitiesAvatarCriteria.listAvatar();
		length =roomieentitiesAvatars== null ? 0 : Math.min(roomieentitiesAvatars.length, ROW_COUNT); 
		for (int i = 0; i < length; i++) {
			 System.out.println(roomieentitiesAvatars[i]);
		}
		System.out.println(length + " Avatar record(s) retrieved."); 
		
	}
	
	public static void main(String[] args) {
		try {
			ListRoomieData listRoomieData = new ListRoomieData();
			try {
				listRoomieData.listTestData();
				//listRoomieData.listByCriteria();
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
