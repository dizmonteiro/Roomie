package roomie.controllers;

import org.orm.ORMDatabaseInitiator;
import org.orm.PersistentException;
import org.orm.PersistentTransaction;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import roomie.models.RoomiePersistentManager;
import roomie.models.avatar.Avatar;
import roomie.models.avatar.AvatarDAO;

/**
 * @author: Vasco Ramos
 * @created: 11/04/2021 - 10:08
 */

@RestController()
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
			t.commit();
			return "Success!";
		}
		catch (Exception e) {
			t.rollback();
			return e.toString();
		}
	}
	
	@PostMapping("/populate")
	public String populateDB2() throws PersistentException {
		PersistentTransaction t = RoomiePersistentManager.instance().getSession().beginTransaction();
		try {
			Avatar avatar = AvatarDAO.createAvatar();
			AvatarDAO.save(avatar);
			t.commit();
			return "Success!";
		}
		catch (Exception e) {
			t.rollback();
			return e.toString();
		}
	}
}
