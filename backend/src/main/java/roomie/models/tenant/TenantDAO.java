package roomie.models.tenant;

/**
 * Licensee: vr(Universidade do Minho)
 * License Type: Academic
 */

import org.hibernate.Query;
import org.orm.PersistentException;
import org.orm.PersistentSession;
import roomie.models.RoomiePersistentManager;
import roomie.repositories.tenant.TenantCriteria;

import java.util.List;

public class TenantDAO {
	public static Tenant loadTenantByORMID(int id) throws PersistentException {
		try {
			PersistentSession session = RoomiePersistentManager.instance().getSession();
			return loadTenantByORMID(session, id);
		} catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Tenant getTenantByORMID(int id) throws PersistentException {
		try {
			PersistentSession session = RoomiePersistentManager.instance().getSession();
			return getTenantByORMID(session, id);
		} catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Tenant loadTenantByORMID(int id, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = RoomiePersistentManager.instance().getSession();
			return loadTenantByORMID(session, id, lockMode);
		} catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Tenant getTenantByORMID(int id, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = RoomiePersistentManager.instance().getSession();
			return getTenantByORMID(session, id, lockMode);
		} catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Tenant loadTenantByORMID(PersistentSession session, int id) throws PersistentException {
		try {
			return (Tenant) session.load(Tenant.class, id);
		} catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Tenant getTenantByORMID(PersistentSession session, int id) throws PersistentException {
		try {
			return (Tenant) session.get(Tenant.class, id);
		} catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Tenant loadTenantByORMID(PersistentSession session, int id, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			return (Tenant) session.load(Tenant.class, id, lockMode);
		} catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Tenant getTenantByORMID(PersistentSession session, int id, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			return (Tenant) session.get(Tenant.class, id, lockMode);
		} catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static List queryTenant(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = RoomiePersistentManager.instance().getSession();
			return queryTenant(session, condition, orderBy);
		} catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static List queryTenant(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = RoomiePersistentManager.instance().getSession();
			return queryTenant(session, condition, orderBy, lockMode);
		} catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Tenant[] listTenantByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = RoomiePersistentManager.instance().getSession();
			return listTenantByQuery(session, condition, orderBy);
		} catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Tenant[] listTenantByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = RoomiePersistentManager.instance().getSession();
			return listTenantByQuery(session, condition, orderBy, lockMode);
		} catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static List queryTenant(PersistentSession session, String condition, String orderBy) throws PersistentException {
		StringBuffer sb = new StringBuffer("From roomie.models.tenant.Tenant as Tenant");
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
	
	public static List queryTenant(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		StringBuffer sb = new StringBuffer("From roomie.models.tenant.Tenant as Tenant");
		if (condition != null) sb.append(" Where ").append(condition);
		if (orderBy != null) sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			query.setLockMode("Tenant", lockMode);
			return query.list();
		} catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Tenant[] listTenantByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		try {
			List list = queryTenant(session, condition, orderBy);
			return (Tenant[]) list.toArray(new Tenant[list.size()]);
		} catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Tenant[] listTenantByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			List list = queryTenant(session, condition, orderBy, lockMode);
			return (Tenant[]) list.toArray(new Tenant[list.size()]);
		} catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Tenant loadTenantByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = RoomiePersistentManager.instance().getSession();
			return loadTenantByQuery(session, condition, orderBy);
		} catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Tenant loadTenantByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = RoomiePersistentManager.instance().getSession();
			return loadTenantByQuery(session, condition, orderBy, lockMode);
		} catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Tenant loadTenantByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		Tenant[] tenants = listTenantByQuery(session, condition, orderBy);
		if (tenants != null && tenants.length > 0) return tenants[0];
		else return null;
	}
	
	public static Tenant loadTenantByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		Tenant[] tenants = listTenantByQuery(session, condition, orderBy, lockMode);
		if (tenants != null && tenants.length > 0) return tenants[0];
		else return null;
	}
	
	public static java.util.Iterator iterateTenantByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = RoomiePersistentManager.instance().getSession();
			return iterateTenantByQuery(session, condition, orderBy);
		} catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static java.util.Iterator iterateTenantByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = RoomiePersistentManager.instance().getSession();
			return iterateTenantByQuery(session, condition, orderBy, lockMode);
		} catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static java.util.Iterator iterateTenantByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		StringBuffer sb = new StringBuffer("From roomie.models.tenant.Tenant as Tenant");
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
	
	public static java.util.Iterator iterateTenantByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		StringBuffer sb = new StringBuffer("From roomie.models.tenant.Tenant as Tenant");
		if (condition != null) sb.append(" Where ").append(condition);
		if (orderBy != null) sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			query.setLockMode("Tenant", lockMode);
			return query.iterate();
		} catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Tenant createTenant() {
		return new Tenant();
	}
	
	public static boolean save(Tenant tenant) throws PersistentException {
		try {
			RoomiePersistentManager.instance().saveObject(tenant);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static boolean delete(Tenant tenant) throws PersistentException {
		try {
			RoomiePersistentManager.instance().deleteObject(tenant);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static boolean refresh(Tenant tenant) throws PersistentException {
		try {
			RoomiePersistentManager.instance().getSession().refresh(tenant);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static boolean evict(Tenant tenant) throws PersistentException {
		try {
			RoomiePersistentManager.instance().getSession().evict(tenant);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Tenant loadTenantByCriteria(TenantCriteria tenantCriteria) {
		Tenant[] tenants = listTenantByCriteria(tenantCriteria);
		if (tenants == null || tenants.length == 0) {
			return null;
		}
		return tenants[0];
	}
	
	public static Tenant[] listTenantByCriteria(TenantCriteria tenantCriteria) {
		return tenantCriteria.listTenant();
	}
}
