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
 */

/**
 * Licensee: vr(Universidade do Minho)
 * License Type: Academic
 */
package roomie.model.evaluation;

import org.hibernate.Query;
import org.orm.PersistentException;
import org.orm.PersistentSession;
import roomie.model.RoomiePersistentManager;
import roomie.model.tenant.Tenant;
import roomie.repository.evaluation.TenantEvaluationCriteria;

import java.util.List;

public class TenantEvaluationDAO {
	public static TenantEvaluation loadTenantEvaluationByORMID(Tenant evaluatorTenant, Tenant evaluatedTenant) throws PersistentException {
		try {
			PersistentSession session = RoomiePersistentManager.instance().getSession();
			return loadTenantEvaluationByORMID(session, evaluatorTenant, evaluatedTenant);
		} catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static TenantEvaluation getTenantEvaluationByORMID(Tenant evaluatorTenant, Tenant evaluatedTenant) throws PersistentException {
		try {
			PersistentSession session = RoomiePersistentManager.instance().getSession();
			return getTenantEvaluationByORMID(session, evaluatorTenant, evaluatedTenant);
		} catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static TenantEvaluation loadTenantEvaluationByORMID(Tenant evaluatorTenant, Tenant evaluatedTenant, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = RoomiePersistentManager.instance().getSession();
			return loadTenantEvaluationByORMID(session, evaluatorTenant, evaluatedTenant, lockMode);
		} catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static TenantEvaluation getTenantEvaluationByORMID(Tenant evaluatorTenant, Tenant evaluatedTenant, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = RoomiePersistentManager.instance().getSession();
			return getTenantEvaluationByORMID(session, evaluatorTenant, evaluatedTenant, lockMode);
		} catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static TenantEvaluation loadTenantEvaluationByORMID(PersistentSession session, Tenant evaluatorTenant, Tenant evaluatedTenant) throws PersistentException {
		try {
			TenantEvaluation tenantevaluation = new TenantEvaluation();
			tenantevaluation.setEvaluatorTenant(evaluatorTenant);
			tenantevaluation.setEvaluatedTenant(evaluatedTenant);
			
			return (TenantEvaluation) session.load(TenantEvaluation.class, tenantevaluation);
		} catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static TenantEvaluation getTenantEvaluationByORMID(PersistentSession session, Tenant evaluatorTenant, Tenant evaluatedTenant) throws PersistentException {
		try {
			TenantEvaluation tenantevaluation = new TenantEvaluation();
			tenantevaluation.setEvaluatorTenant(evaluatorTenant);
			tenantevaluation.setEvaluatedTenant(evaluatedTenant);
			
			return (TenantEvaluation) session.get(TenantEvaluation.class, tenantevaluation);
		} catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static TenantEvaluation loadTenantEvaluationByORMID(PersistentSession session, Tenant evaluatorTenant, Tenant evaluatedTenant, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			TenantEvaluation tenantevaluation = new TenantEvaluation();
			tenantevaluation.setEvaluatorTenant(evaluatorTenant);
			tenantevaluation.setEvaluatedTenant(evaluatedTenant);
			
			return (TenantEvaluation) session.load(TenantEvaluation.class, tenantevaluation, lockMode);
		} catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static TenantEvaluation getTenantEvaluationByORMID(PersistentSession session, Tenant evaluatorTenant, Tenant evaluatedTenant, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			TenantEvaluation tenantevaluation = new TenantEvaluation();
			tenantevaluation.setEvaluatorTenant(evaluatorTenant);
			tenantevaluation.setEvaluatedTenant(evaluatedTenant);
			
			return (TenantEvaluation) session.get(TenantEvaluation.class, tenantevaluation, lockMode);
		} catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static List queryTenantEvaluation(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = RoomiePersistentManager.instance().getSession();
			return queryTenantEvaluation(session, condition, orderBy);
		} catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static List queryTenantEvaluation(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = RoomiePersistentManager.instance().getSession();
			return queryTenantEvaluation(session, condition, orderBy, lockMode);
		} catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static TenantEvaluation[] listTenantEvaluationByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = RoomiePersistentManager.instance().getSession();
			return listTenantEvaluationByQuery(session, condition, orderBy);
		} catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static TenantEvaluation[] listTenantEvaluationByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = RoomiePersistentManager.instance().getSession();
			return listTenantEvaluationByQuery(session, condition, orderBy, lockMode);
		} catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static List queryTenantEvaluation(PersistentSession session, String condition, String orderBy) throws PersistentException {
		StringBuffer sb = new StringBuffer("From roomie.model.evaluation.TenantEvaluation as TenantEvaluation");
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
	
	public static List queryTenantEvaluation(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		StringBuffer sb = new StringBuffer("From roomie.model.evaluation.TenantEvaluation as TenantEvaluation");
		if (condition != null) sb.append(" Where ").append(condition);
		if (orderBy != null) sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			query.setLockMode("TenantEvaluation", lockMode);
			return query.list();
		} catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static TenantEvaluation[] listTenantEvaluationByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		try {
			List list = queryTenantEvaluation(session, condition, orderBy);
			return (TenantEvaluation[]) list.toArray(new TenantEvaluation[list.size()]);
		} catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static TenantEvaluation[] listTenantEvaluationByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			List list = queryTenantEvaluation(session, condition, orderBy, lockMode);
			return (TenantEvaluation[]) list.toArray(new TenantEvaluation[list.size()]);
		} catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static TenantEvaluation loadTenantEvaluationByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = RoomiePersistentManager.instance().getSession();
			return loadTenantEvaluationByQuery(session, condition, orderBy);
		} catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static TenantEvaluation loadTenantEvaluationByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = RoomiePersistentManager.instance().getSession();
			return loadTenantEvaluationByQuery(session, condition, orderBy, lockMode);
		} catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static TenantEvaluation loadTenantEvaluationByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		TenantEvaluation[] tenantEvaluations = listTenantEvaluationByQuery(session, condition, orderBy);
		if (tenantEvaluations != null && tenantEvaluations.length > 0) return tenantEvaluations[0];
		else return null;
	}
	
	public static TenantEvaluation loadTenantEvaluationByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		TenantEvaluation[] tenantEvaluations = listTenantEvaluationByQuery(session, condition, orderBy, lockMode);
		if (tenantEvaluations != null && tenantEvaluations.length > 0) return tenantEvaluations[0];
		else return null;
	}
	
	public static java.util.Iterator iterateTenantEvaluationByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = RoomiePersistentManager.instance().getSession();
			return iterateTenantEvaluationByQuery(session, condition, orderBy);
		} catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static java.util.Iterator iterateTenantEvaluationByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = RoomiePersistentManager.instance().getSession();
			return iterateTenantEvaluationByQuery(session, condition, orderBy, lockMode);
		} catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static java.util.Iterator iterateTenantEvaluationByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		StringBuffer sb = new StringBuffer("From roomie.model.evaluation.TenantEvaluation as TenantEvaluation");
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
	
	public static java.util.Iterator iterateTenantEvaluationByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		StringBuffer sb = new StringBuffer("From roomie.model.evaluation.TenantEvaluation as TenantEvaluation");
		if (condition != null) sb.append(" Where ").append(condition);
		if (orderBy != null) sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			query.setLockMode("TenantEvaluation", lockMode);
			return query.iterate();
		} catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static TenantEvaluation createTenantEvaluation() {
		return new TenantEvaluation();
	}
	
	public static boolean save(TenantEvaluation tenantEvaluation) throws PersistentException {
		try {
			RoomiePersistentManager.instance().saveObject(tenantEvaluation);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static boolean delete(TenantEvaluation tenantEvaluation) throws PersistentException {
		try {
			RoomiePersistentManager.instance().deleteObject(tenantEvaluation);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static boolean refresh(TenantEvaluation tenantEvaluation) throws PersistentException {
		try {
			RoomiePersistentManager.instance().getSession().refresh(tenantEvaluation);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static boolean evict(TenantEvaluation tenantEvaluation) throws PersistentException {
		try {
			RoomiePersistentManager.instance().getSession().evict(tenantEvaluation);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static TenantEvaluation loadTenantEvaluationByCriteria(TenantEvaluationCriteria tenantEvaluationCriteria) {
		TenantEvaluation[] tenantEvaluations = listTenantEvaluationByCriteria(tenantEvaluationCriteria);
		if (tenantEvaluations == null || tenantEvaluations.length == 0) {
			return null;
		}
		return tenantEvaluations[0];
	}
	
	public static TenantEvaluation[] listTenantEvaluationByCriteria(TenantEvaluationCriteria tenantEvaluationCriteria) {
		return tenantEvaluationCriteria.listTenantEvaluation();
	}
}
