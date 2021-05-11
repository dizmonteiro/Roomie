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
}
