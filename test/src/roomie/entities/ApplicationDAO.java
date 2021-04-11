/**
 * "Visual Paradigm: DO NOT MODIFY THIS FILE!"
 * 
 * This is an automatic generated file. It will be regenerated every time 
 * you generate persistence class.
 * 
 * Modifying its content may cause the program not work, or your work may lost.
 */

/**
 * Licensee: vr(Universidade do Minho)
 * License Type: Academic
 */
package roomie.entities;

import org.orm.*;
import org.hibernate.Query;
import org.hibernate.LockMode;
import java.util.List;

public class ApplicationDAO {
	public static Application loadApplicationByORMID(roomie.entities.Tenant tenant, roomie.entities.House house) throws PersistentException {
		try {
			PersistentSession session = RoomiePersistentManager.instance().getSession();
			return loadApplicationByORMID(session, tenant, house);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Application getApplicationByORMID(roomie.entities.Tenant tenant, roomie.entities.House house) throws PersistentException {
		try {
			PersistentSession session = RoomiePersistentManager.instance().getSession();
			return getApplicationByORMID(session, tenant, house);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Application loadApplicationByORMID(roomie.entities.Tenant tenant, roomie.entities.House house, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = RoomiePersistentManager.instance().getSession();
			return loadApplicationByORMID(session, tenant, house, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Application getApplicationByORMID(roomie.entities.Tenant tenant, roomie.entities.House house, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = RoomiePersistentManager.instance().getSession();
			return getApplicationByORMID(session, tenant, house, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Application loadApplicationByORMID(PersistentSession session, roomie.entities.Tenant tenant, roomie.entities.House house) throws PersistentException {
		try {
			Application application = new roomie.entities.Application();
			application.setTenant(tenant);
			application.setHouse(house);
			
			return (Application) session.load(roomie.entities.Application.class, application);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Application getApplicationByORMID(PersistentSession session, roomie.entities.Tenant tenant, roomie.entities.House house) throws PersistentException {
		try {
			Application application = new roomie.entities.Application();
			application.setTenant(tenant);
			application.setHouse(house);
			
			return (Application) session.get(roomie.entities.Application.class, application);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Application loadApplicationByORMID(PersistentSession session, roomie.entities.Tenant tenant, roomie.entities.House house, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			Application application = new roomie.entities.Application();
			application.setTenant(tenant);
			application.setHouse(house);
			
			return (Application) session.load(roomie.entities.Application.class, application, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Application getApplicationByORMID(PersistentSession session, roomie.entities.Tenant tenant, roomie.entities.House house, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			Application application = new roomie.entities.Application();
			application.setTenant(tenant);
			application.setHouse(house);
			
			return (Application) session.get(roomie.entities.Application.class, application, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static List queryApplication(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = RoomiePersistentManager.instance().getSession();
			return queryApplication(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static List queryApplication(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = RoomiePersistentManager.instance().getSession();
			return queryApplication(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Application[] listApplicationByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = RoomiePersistentManager.instance().getSession();
			return listApplicationByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Application[] listApplicationByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = RoomiePersistentManager.instance().getSession();
			return listApplicationByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static List queryApplication(PersistentSession session, String condition, String orderBy) throws PersistentException {
		StringBuffer sb = new StringBuffer("From roomie.entities.Application as Application");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			return query.list();
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static List queryApplication(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		StringBuffer sb = new StringBuffer("From roomie.entities.Application as Application");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			query.setLockMode("Application", lockMode);
			return query.list();
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Application[] listApplicationByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		try {
			List list = queryApplication(session, condition, orderBy);
			return (Application[]) list.toArray(new Application[list.size()]);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Application[] listApplicationByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			List list = queryApplication(session, condition, orderBy, lockMode);
			return (Application[]) list.toArray(new Application[list.size()]);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Application loadApplicationByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = RoomiePersistentManager.instance().getSession();
			return loadApplicationByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Application loadApplicationByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = RoomiePersistentManager.instance().getSession();
			return loadApplicationByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Application loadApplicationByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		Application[] applications = listApplicationByQuery(session, condition, orderBy);
		if (applications != null && applications.length > 0)
			return applications[0];
		else
			return null;
	}
	
	public static Application loadApplicationByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		Application[] applications = listApplicationByQuery(session, condition, orderBy, lockMode);
		if (applications != null && applications.length > 0)
			return applications[0];
		else
			return null;
	}
	
	public static java.util.Iterator iterateApplicationByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = RoomiePersistentManager.instance().getSession();
			return iterateApplicationByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static java.util.Iterator iterateApplicationByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = RoomiePersistentManager.instance().getSession();
			return iterateApplicationByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static java.util.Iterator iterateApplicationByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		StringBuffer sb = new StringBuffer("From roomie.entities.Application as Application");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			return query.iterate();
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static java.util.Iterator iterateApplicationByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		StringBuffer sb = new StringBuffer("From roomie.entities.Application as Application");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			query.setLockMode("Application", lockMode);
			return query.iterate();
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Application createApplication() {
		return new roomie.entities.Application();
	}
	
	public static boolean save(roomie.entities.Application application) throws PersistentException {
		try {
			RoomiePersistentManager.instance().saveObject(application);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static boolean delete(roomie.entities.Application application) throws PersistentException {
		try {
			RoomiePersistentManager.instance().deleteObject(application);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static boolean refresh(roomie.entities.Application application) throws PersistentException {
		try {
			RoomiePersistentManager.instance().getSession().refresh(application);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static boolean evict(roomie.entities.Application application) throws PersistentException {
		try {
			RoomiePersistentManager.instance().getSession().evict(application);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Application loadApplicationByCriteria(ApplicationCriteria applicationCriteria) {
		Application[] applications = listApplicationByCriteria(applicationCriteria);
		if(applications == null || applications.length == 0) {
			return null;
		}
		return applications[0];
	}
	
	public static Application[] listApplicationByCriteria(ApplicationCriteria applicationCriteria) {
		return applicationCriteria.listApplication();
	}
}
