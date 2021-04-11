package roomie.controller;

import org.orm.ORMDatabaseInitiator;
import org.orm.PersistentException;
import org.orm.PersistentTransaction;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import roomie.model.RoomiePersistentManager;
import roomie.model.avatar.Avatar;
import roomie.model.avatar.AvatarDAO;

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
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "Done";
	}
	
	@GetMapping("/drop-db")
	public String dropDB() {
		try {
			ORMDatabaseInitiator.dropSchema(RoomiePersistentManager.instance());
			RoomiePersistentManager.instance().disposePersistentManager();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "Done";
	}
	
	@GetMapping("/populate")
	public String populateDB() {
		try {
			try {
				createTestData();
			} finally {
				RoomiePersistentManager.instance().disposePersistentManager();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "Done";
	}
	
	private void createTestData() throws PersistentException {
		PersistentTransaction t = RoomiePersistentManager.instance().getSession().beginTransaction();
		try {
			Avatar lroomieAvatar = AvatarDAO.createAvatar();
			// Initialize the properties of the persistent object here
			AvatarDAO.save(lroomieAvatar);
			t.commit();
		}
		catch (Exception e) {
			t.rollback();
		}
		
	}
	
}
