/**
 * Licensee: vr(Universidade do Minho)
 * License Type: Academic
 */
package ormsamples;

import org.orm.ORMDatabaseInitiator;

public class CreateRoomieDatabaseSchema {
	public static void main(String[] args) {
		try {
			ORMDatabaseInitiator.createSchema(roomie.RoomiePersistentManager.instance());
			roomie.RoomiePersistentManager.instance().disposePersistentManager();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
