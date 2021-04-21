package roomie.controllers;

import org.orm.ORMDatabaseInitiator;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import roomie.models.RoomiePersistentManager;

/**
 * @author: Vasco Ramos
 * @created: 11/04/2021 - 10:08
 */

@RestController
@RequestMapping("/admin")
public class AdminController {
	
	@GetMapping("/create-db")
	public String createDB() {
		try {
			ORMDatabaseInitiator.createSchema(RoomiePersistentManager.instance());
			RoomiePersistentManager.instance().disposePersistentManager();
			return "Success!";
		} catch (Exception e) {
			return e.toString();
		}
	}
	
	@GetMapping("/drop-db")
	public String dropDB() {
		try {
			ORMDatabaseInitiator.dropSchema(RoomiePersistentManager.instance());
			RoomiePersistentManager.instance().disposePersistentManager();
			return "Success!";
		} catch (Exception e) {
			return e.toString();
		}
	}
	
	/*
	@GetMapping("/populate")
	public String populateDB() throws PersistentException {
		PersistentTransaction t = RoomiePersistentManager.instance().getSession().beginTransaction();
		try {
			BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
			
			Avatar avatar = AvatarDAO.createAvatar();
			AvatarDAO.save(avatar);
			
			Tenant tenant = TenantDAO.createTenant();
			tenant.setEmail("tt@roomie.com");
			tenant.setPassword(passwordEncoder.encode("tt"));
			tenant.setUsername("tt");
			tenant.setName("Vasco Ramos");
			tenant.setAvatar(avatar);
			TenantDAO.save(tenant);
			
			Landlord landlord = LandlordDAO.createLandlord();
			landlord.setEmail("ld@roomie.com");
			landlord.setPassword(passwordEncoder.encode("ld"));
			landlord.setUsername("ld");
			landlord.setName("Vasco Ramos");
			landlord.setAvatar(avatar);
			LandlordDAO.save(landlord);
			t.commit();
			return "Success!";
		} catch (Exception e) {
			t.rollback();
			return e.toString();
		}
	}
	*/
}
