package roomie.controllers;

import org.orm.ORMDatabaseInitiator;
import org.orm.PersistentException;
import org.orm.PersistentTransaction;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import roomie.models.RoomiePersistentManager;
import roomie.models.avatar.Avatar;
import roomie.models.avatar.AvatarDAO;
import roomie.models.tenant.Tenant;
import roomie.models.tenant.TenantDAO;

/**
 * @author: Vasco Ramos
 * @created: 11/04/2021 - 10:08
 */

@RestController
@RequestMapping("/admin")
public class Admin {
	
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
	
	@GetMapping("/populate")
	public String populateDB() throws PersistentException {
		PersistentTransaction t = RoomiePersistentManager.instance().getSession().beginTransaction();
		try {
			Avatar avatar = AvatarDAO.createAvatar();
			AvatarDAO.save(avatar);
			Tenant tenant = TenantDAO.createTenant();
			tenant.setEmail("vr@roomie.com");
			BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
			tenant.setPassword(passwordEncoder.encode("vr"));
			tenant.setUsername("vr");
			tenant.setName("Vasco Ramos");
			tenant.setAvatar(avatar);
			TenantDAO.save(tenant);
			t.commit();
			return "Success!";
		} catch (Exception e) {
			t.rollback();
			return e.toString();
		}
	}
}
