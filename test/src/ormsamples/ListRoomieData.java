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
		roomie.Tenant[] roomieTenants = roomie.TenantDAO.listTenantByQuery(null, null);
		int length = Math.min(roomieTenants.length, ROW_COUNT);
		for (int i = 0; i < length; i++) {
			System.out.println(roomieTenants[i]);
		}
		System.out.println(length + " record(s) retrieved.");
		
		System.out.println("Listing House...");
		roomie.House[] roomieHouses = roomie.HouseDAO.listHouseByQuery(null, null);
		length = Math.min(roomieHouses.length, ROW_COUNT);
		for (int i = 0; i < length; i++) {
			System.out.println(roomieHouses[i]);
		}
		System.out.println(length + " record(s) retrieved.");
		
		System.out.println("Listing Photo...");
		roomie.Photo[] roomiePhotos = roomie.PhotoDAO.listPhotoByQuery(null, null);
		length = Math.min(roomiePhotos.length, ROW_COUNT);
		for (int i = 0; i < length; i++) {
			System.out.println(roomiePhotos[i]);
		}
		System.out.println(length + " record(s) retrieved.");
		
		System.out.println("Listing Landlord...");
		roomie.Landlord[] roomieLandlords = roomie.LandlordDAO.listLandlordByQuery(null, null);
		length = Math.min(roomieLandlords.length, ROW_COUNT);
		for (int i = 0; i < length; i++) {
			System.out.println(roomieLandlords[i]);
		}
		System.out.println(length + " record(s) retrieved.");
		
		System.out.println("Listing RentHistory...");
		roomie.RentHistory[] roomieRentHistorys = roomie.RentHistoryDAO.listRentHistoryByQuery(null, null);
		length = Math.min(roomieRentHistorys.length, ROW_COUNT);
		for (int i = 0; i < length; i++) {
			System.out.println(roomieRentHistorys[i]);
		}
		System.out.println(length + " record(s) retrieved.");
		
		System.out.println("Listing Application...");
		roomie.Application[] roomieApplications = roomie.ApplicationDAO.listApplicationByQuery(null, null);
		length = Math.min(roomieApplications.length, ROW_COUNT);
		for (int i = 0; i < length; i++) {
			System.out.println(roomieApplications[i]);
		}
		System.out.println(length + " record(s) retrieved.");
		
		System.out.println("Listing LandlordEvaluation...");
		roomie.LandlordEvaluation[] roomieLandlordEvaluations = roomie.LandlordEvaluationDAO.listLandlordEvaluationByQuery(null, null);
		length = Math.min(roomieLandlordEvaluations.length, ROW_COUNT);
		for (int i = 0; i < length; i++) {
			System.out.println(roomieLandlordEvaluations[i]);
		}
		System.out.println(length + " record(s) retrieved.");
		
		System.out.println("Listing TenantEvaluation...");
		roomie.TenantEvaluation[] roomieTenantEvaluations = roomie.TenantEvaluationDAO.listTenantEvaluationByQuery(null, null);
		length = Math.min(roomieTenantEvaluations.length, ROW_COUNT);
		for (int i = 0; i < length; i++) {
			System.out.println(roomieTenantEvaluations[i]);
		}
		System.out.println(length + " record(s) retrieved.");
		
		System.out.println("Listing Avatar...");
		roomie.Avatar[] roomieAvatars = roomie.AvatarDAO.listAvatarByQuery(null, null);
		length = Math.min(roomieAvatars.length, ROW_COUNT);
		for (int i = 0; i < length; i++) {
			System.out.println(roomieAvatars[i]);
		}
		System.out.println(length + " record(s) retrieved.");
		
	}
	
	public void listByCriteria() throws PersistentException {
		System.out.println("Listing Tenant by Criteria...");
		roomie.TenantCriteria lroomieTenantCriteria = new roomie.TenantCriteria();
		// Please uncomment the follow line and fill in parameter(s) 
		//lroomieTenantCriteria.id.eq();
		lroomieTenantCriteria.setMaxResults(ROW_COUNT);
		roomie.Tenant[] roomieTenants = lroomieTenantCriteria.listTenant();
		int length =roomieTenants== null ? 0 : Math.min(roomieTenants.length, ROW_COUNT); 
		for (int i = 0; i < length; i++) {
			 System.out.println(roomieTenants[i]);
		}
		System.out.println(length + " Tenant record(s) retrieved."); 
		
		System.out.println("Listing House by Criteria...");
		roomie.HouseCriteria lroomieHouseCriteria = new roomie.HouseCriteria();
		// Please uncomment the follow line and fill in parameter(s) 
		//lroomieHouseCriteria.id.eq();
		lroomieHouseCriteria.setMaxResults(ROW_COUNT);
		roomie.House[] roomieHouses = lroomieHouseCriteria.listHouse();
		length =roomieHouses== null ? 0 : Math.min(roomieHouses.length, ROW_COUNT); 
		for (int i = 0; i < length; i++) {
			 System.out.println(roomieHouses[i]);
		}
		System.out.println(length + " House record(s) retrieved."); 
		
		System.out.println("Listing Photo by Criteria...");
		roomie.PhotoCriteria lroomiePhotoCriteria = new roomie.PhotoCriteria();
		// Please uncomment the follow line and fill in parameter(s) 
		//lroomiePhotoCriteria.ID.eq();
		lroomiePhotoCriteria.setMaxResults(ROW_COUNT);
		roomie.Photo[] roomiePhotos = lroomiePhotoCriteria.listPhoto();
		length =roomiePhotos== null ? 0 : Math.min(roomiePhotos.length, ROW_COUNT); 
		for (int i = 0; i < length; i++) {
			 System.out.println(roomiePhotos[i]);
		}
		System.out.println(length + " Photo record(s) retrieved."); 
		
		System.out.println("Listing Landlord by Criteria...");
		roomie.LandlordCriteria lroomieLandlordCriteria = new roomie.LandlordCriteria();
		// Please uncomment the follow line and fill in parameter(s) 
		//lroomieLandlordCriteria.id.eq();
		lroomieLandlordCriteria.setMaxResults(ROW_COUNT);
		roomie.Landlord[] roomieLandlords = lroomieLandlordCriteria.listLandlord();
		length =roomieLandlords== null ? 0 : Math.min(roomieLandlords.length, ROW_COUNT); 
		for (int i = 0; i < length; i++) {
			 System.out.println(roomieLandlords[i]);
		}
		System.out.println(length + " Landlord record(s) retrieved."); 
		
		System.out.println("Listing RentHistory by Criteria...");
		roomie.RentHistoryCriteria lroomieRentHistoryCriteria = new roomie.RentHistoryCriteria();
		// Please uncomment the follow line and fill in parameter(s) 
		//roomie.HouseCriteria lroomieRentHistoryCriteria_House = lroomieRentHistoryCriteria.createHouseCriteria();
		//lroomieRentHistoryCriteria_House.id.eq();
		//roomie.TenantCriteria lroomieRentHistoryCriteria_Tenant = lroomieRentHistoryCriteria.createTenantCriteria();
		//lroomieRentHistoryCriteria_Tenant.id.eq();
		lroomieRentHistoryCriteria.setMaxResults(ROW_COUNT);
		roomie.RentHistory[] roomieRentHistorys = lroomieRentHistoryCriteria.listRentHistory();
		length =roomieRentHistorys== null ? 0 : Math.min(roomieRentHistorys.length, ROW_COUNT); 
		for (int i = 0; i < length; i++) {
			 System.out.println(roomieRentHistorys[i]);
		}
		System.out.println(length + " RentHistory record(s) retrieved."); 
		
		System.out.println("Listing Application by Criteria...");
		roomie.ApplicationCriteria lroomieApplicationCriteria = new roomie.ApplicationCriteria();
		// Please uncomment the follow line and fill in parameter(s) 
		//roomie.TenantCriteria lroomieApplicationCriteria_Tenant = lroomieApplicationCriteria.createTenantCriteria();
		//lroomieApplicationCriteria_Tenant.id.eq();
		//roomie.HouseCriteria lroomieApplicationCriteria_House = lroomieApplicationCriteria.createHouseCriteria();
		//lroomieApplicationCriteria_House.id.eq();
		lroomieApplicationCriteria.setMaxResults(ROW_COUNT);
		roomie.Application[] roomieApplications = lroomieApplicationCriteria.listApplication();
		length =roomieApplications== null ? 0 : Math.min(roomieApplications.length, ROW_COUNT); 
		for (int i = 0; i < length; i++) {
			 System.out.println(roomieApplications[i]);
		}
		System.out.println(length + " Application record(s) retrieved."); 
		
		System.out.println("Listing LandlordEvaluation by Criteria...");
		roomie.LandlordEvaluationCriteria lroomieLandlordEvaluationCriteria = new roomie.LandlordEvaluationCriteria();
		// Please uncomment the follow line and fill in parameter(s) 
		//roomie.LandlordCriteria lroomieLandlordEvaluationCriteria_Landlord = lroomieLandlordEvaluationCriteria.createLandlordCriteria();
		//lroomieLandlordEvaluationCriteria_Landlord.id.eq();
		//roomie.TenantCriteria lroomieLandlordEvaluationCriteria_Tenant = lroomieLandlordEvaluationCriteria.createTenantCriteria();
		//lroomieLandlordEvaluationCriteria_Tenant.id.eq();
		lroomieLandlordEvaluationCriteria.setMaxResults(ROW_COUNT);
		roomie.LandlordEvaluation[] roomieLandlordEvaluations = lroomieLandlordEvaluationCriteria.listLandlordEvaluation();
		length =roomieLandlordEvaluations== null ? 0 : Math.min(roomieLandlordEvaluations.length, ROW_COUNT); 
		for (int i = 0; i < length; i++) {
			 System.out.println(roomieLandlordEvaluations[i]);
		}
		System.out.println(length + " LandlordEvaluation record(s) retrieved."); 
		
		System.out.println("Listing TenantEvaluation by Criteria...");
		roomie.TenantEvaluationCriteria lroomieTenantEvaluationCriteria = new roomie.TenantEvaluationCriteria();
		// Please uncomment the follow line and fill in parameter(s) 
		//roomie.TenantCriteria lroomieTenantEvaluationCriteria_Tenant = lroomieTenantEvaluationCriteria.createEvaluatorTenantCriteria();
		//lroomieTenantEvaluationCriteria_Tenant.id.eq();
		//roomie.TenantCriteria lroomieTenantEvaluationCriteria_Tenant = lroomieTenantEvaluationCriteria.createEvaluatedTenantCriteria();
		//lroomieTenantEvaluationCriteria_Tenant.id.eq();
		lroomieTenantEvaluationCriteria.setMaxResults(ROW_COUNT);
		roomie.TenantEvaluation[] roomieTenantEvaluations = lroomieTenantEvaluationCriteria.listTenantEvaluation();
		length =roomieTenantEvaluations== null ? 0 : Math.min(roomieTenantEvaluations.length, ROW_COUNT); 
		for (int i = 0; i < length; i++) {
			 System.out.println(roomieTenantEvaluations[i]);
		}
		System.out.println(length + " TenantEvaluation record(s) retrieved."); 
		
		System.out.println("Listing Avatar by Criteria...");
		roomie.AvatarCriteria lroomieAvatarCriteria = new roomie.AvatarCriteria();
		// Please uncomment the follow line and fill in parameter(s) 
		//lroomieAvatarCriteria.ID.eq();
		lroomieAvatarCriteria.setMaxResults(ROW_COUNT);
		roomie.Avatar[] roomieAvatars = lroomieAvatarCriteria.listAvatar();
		length =roomieAvatars== null ? 0 : Math.min(roomieAvatars.length, ROW_COUNT); 
		for (int i = 0; i < length; i++) {
			 System.out.println(roomieAvatars[i]);
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
				roomie.RoomiePersistentManager.instance().disposePersistentManager();
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
}
