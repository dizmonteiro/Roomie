/**
 * "Visual Paradigm: DO NOT MODIFY THIS FILE!"
 * <p>
 * This is an automatic generated file. It will be regenerated every time
 * you generate persistence class.
 * <p>
 * Modifying its content may cause the program not work, or your work may lost.
 * <p>
 * Licensee: vr(Universidade do Minho)
 * License Type: Academic
 * <p>
 * Licensee: vr(Universidade do Minho)
 * License Type: Academic
 * <p>
 * Licensee: vr(Universidade do Minho)
 * License Type: Academic
 * <p>
 * Licensee: vr(Universidade do Minho)
 * License Type: Academic
 * <p>
 * Licensee: vr(Universidade do Minho)
 * License Type: Academic
 */

/**
 * Licensee: vr(Universidade do Minho)
 * License Type: Academic
 */
package roomie.models.evaluation;

import org.hibernate.Query;
import org.orm.PersistentException;
import org.orm.PersistentSession;
import roomie.models.RoomiePersistentManager;
import roomie.models.landlord.Landlord;
import roomie.models.tenant.Tenant;
import roomie.repositories.evaluation.LandlordEvaluationCriteria;

import java.util.List;

public class LandlordEvaluationDAO {
	public static LandlordEvaluation loadLandlordEvaluationByORMID(Landlord landlord, Tenant tenant) throws PersistentException {
		try {
			PersistentSession session = RoomiePersistentManager.instance().getSession();
			return loadLandlordEvaluationByORMID(session, landlord, tenant);
		} catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static LandlordEvaluation getLandlordEvaluationByORMID(Landlord landlord, Tenant tenant) throws PersistentException {
		try {
			PersistentSession session = RoomiePersistentManager.instance().getSession();
			return getLandlordEvaluationByORMID(session, landlord, tenant);
		} catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static LandlordEvaluation loadLandlordEvaluationByORMID(Landlord landlord, Tenant tenant, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = RoomiePersistentManager.instance().getSession();
			return loadLandlordEvaluationByORMID(session, landlord, tenant, lockMode);
		} catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static LandlordEvaluation getLandlordEvaluationByORMID(Landlord landlord, Tenant tenant, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = RoomiePersistentManager.instance().getSession();
			return getLandlordEvaluationByORMID(session, landlord, tenant, lockMode);
		} catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static LandlordEvaluation loadLandlordEvaluationByORMID(PersistentSession session, Landlord landlord, Tenant tenant) throws PersistentException {
		try {
			LandlordEvaluation landlordevaluation = new LandlordEvaluation();
			landlordevaluation.setLandlord(landlord);
			landlordevaluation.setTenant(tenant);
			
			return (LandlordEvaluation) session.load(LandlordEvaluation.class, landlordevaluation);
		} catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static LandlordEvaluation getLandlordEvaluationByORMID(PersistentSession session, Landlord landlord, Tenant tenant) throws PersistentException {
		try {
			LandlordEvaluation landlordevaluation = new LandlordEvaluation();
			landlordevaluation.setLandlord(landlord);
			landlordevaluation.setTenant(tenant);
			
			return (LandlordEvaluation) session.get(LandlordEvaluation.class, landlordevaluation);
		} catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static LandlordEvaluation loadLandlordEvaluationByORMID(PersistentSession session, Landlord landlord, Tenant tenant, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			LandlordEvaluation landlordevaluation = new LandlordEvaluation();
			landlordevaluation.setLandlord(landlord);
			landlordevaluation.setTenant(tenant);
			
			return (LandlordEvaluation) session.load(LandlordEvaluation.class, landlordevaluation, lockMode);
		} catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static LandlordEvaluation getLandlordEvaluationByORMID(PersistentSession session, Landlord landlord, Tenant tenant, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			LandlordEvaluation landlordevaluation = new LandlordEvaluation();
			landlordevaluation.setLandlord(landlord);
			landlordevaluation.setTenant(tenant);
			
			return (LandlordEvaluation) session.get(LandlordEvaluation.class, landlordevaluation, lockMode);
		} catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static List queryLandlordEvaluation(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = RoomiePersistentManager.instance().getSession();
			return queryLandlordEvaluation(session, condition, orderBy);
		} catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static List queryLandlordEvaluation(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = RoomiePersistentManager.instance().getSession();
			return queryLandlordEvaluation(session, condition, orderBy, lockMode);
		} catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static LandlordEvaluation[] listLandlordEvaluationByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = RoomiePersistentManager.instance().getSession();
			return listLandlordEvaluationByQuery(session, condition, orderBy);
		} catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static LandlordEvaluation[] listLandlordEvaluationByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = RoomiePersistentManager.instance().getSession();
			return listLandlordEvaluationByQuery(session, condition, orderBy, lockMode);
		} catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static List queryLandlordEvaluation(PersistentSession session, String condition, String orderBy) throws PersistentException {
		StringBuffer sb = new StringBuffer("From roomie.models.evaluation.LandlordEvaluation as LandlordEvaluation");
		if (condition != null) sb.append(" Where ").append(condition);
		if (orderBy != null) sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			return query.list();
		} catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static List queryLandlordEvaluation(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		StringBuffer sb = new StringBuffer("From roomie.models.evaluation.LandlordEvaluation as LandlordEvaluation");
		if (condition != null) sb.append(" Where ").append(condition);
		if (orderBy != null) sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			query.setLockMode("LandlordEvaluation", lockMode);
			return query.list();
		} catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static LandlordEvaluation[] listLandlordEvaluationByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		try {
			List list = queryLandlordEvaluation(session, condition, orderBy);
			return (LandlordEvaluation[]) list.toArray(new LandlordEvaluation[list.size()]);
		} catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static LandlordEvaluation[] listLandlordEvaluationByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			List list = queryLandlordEvaluation(session, condition, orderBy, lockMode);
			return (LandlordEvaluation[]) list.toArray(new LandlordEvaluation[list.size()]);
		} catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static LandlordEvaluation loadLandlordEvaluationByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = RoomiePersistentManager.instance().getSession();
			return loadLandlordEvaluationByQuery(session, condition, orderBy);
		} catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static LandlordEvaluation loadLandlordEvaluationByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = RoomiePersistentManager.instance().getSession();
			return loadLandlordEvaluationByQuery(session, condition, orderBy, lockMode);
		} catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static LandlordEvaluation loadLandlordEvaluationByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		LandlordEvaluation[] landlordEvaluations = listLandlordEvaluationByQuery(session, condition, orderBy);
		if (landlordEvaluations != null && landlordEvaluations.length > 0) return landlordEvaluations[0];
		else return null;
	}
	
	public static LandlordEvaluation loadLandlordEvaluationByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		LandlordEvaluation[] landlordEvaluations = listLandlordEvaluationByQuery(session, condition, orderBy, lockMode);
		if (landlordEvaluations != null && landlordEvaluations.length > 0) return landlordEvaluations[0];
		else return null;
	}
	
	public static java.util.Iterator iterateLandlordEvaluationByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = RoomiePersistentManager.instance().getSession();
			return iterateLandlordEvaluationByQuery(session, condition, orderBy);
		} catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static java.util.Iterator iterateLandlordEvaluationByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = RoomiePersistentManager.instance().getSession();
			return iterateLandlordEvaluationByQuery(session, condition, orderBy, lockMode);
		} catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static java.util.Iterator iterateLandlordEvaluationByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		StringBuffer sb = new StringBuffer("From roomie.models.evaluation.LandlordEvaluation as LandlordEvaluation");
		if (condition != null) sb.append(" Where ").append(condition);
		if (orderBy != null) sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			return query.iterate();
		} catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static java.util.Iterator iterateLandlordEvaluationByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		StringBuffer sb = new StringBuffer("From roomie.models.evaluation.LandlordEvaluation as LandlordEvaluation");
		if (condition != null) sb.append(" Where ").append(condition);
		if (orderBy != null) sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			query.setLockMode("LandlordEvaluation", lockMode);
			return query.iterate();
		} catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static LandlordEvaluation createLandlordEvaluation() {
		return new LandlordEvaluation();
	}
	
	public static boolean save(LandlordEvaluation landlordEvaluation) throws PersistentException {
		try {
			RoomiePersistentManager.instance().saveObject(landlordEvaluation);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static boolean delete(LandlordEvaluation landlordEvaluation) throws PersistentException {
		try {
			RoomiePersistentManager.instance().deleteObject(landlordEvaluation);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static boolean refresh(LandlordEvaluation landlordEvaluation) throws PersistentException {
		try {
			RoomiePersistentManager.instance().getSession().refresh(landlordEvaluation);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static boolean evict(LandlordEvaluation landlordEvaluation) throws PersistentException {
		try {
			RoomiePersistentManager.instance().getSession().evict(landlordEvaluation);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static LandlordEvaluation loadLandlordEvaluationByCriteria(LandlordEvaluationCriteria landlordEvaluationCriteria) {
		LandlordEvaluation[] landlordEvaluations = listLandlordEvaluationByCriteria(landlordEvaluationCriteria);
		if (landlordEvaluations == null || landlordEvaluations.length == 0) {
			return null;
		}
		return landlordEvaluations[0];
	}
	
	public static LandlordEvaluation[] listLandlordEvaluationByCriteria(LandlordEvaluationCriteria landlordEvaluationCriteria) {
		return landlordEvaluationCriteria.listLandlordEvaluation();
	}
}
