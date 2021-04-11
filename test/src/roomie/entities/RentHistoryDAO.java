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

public class RentHistoryDAO {
	public static RentHistory loadRentHistoryByORMID(roomie.entities.House house, roomie.entities.Tenant tenant) throws PersistentException {
		try {
			PersistentSession session = RoomiePersistentManager.instance().getSession();
			return loadRentHistoryByORMID(session, house, tenant);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static RentHistory getRentHistoryByORMID(roomie.entities.House house, roomie.entities.Tenant tenant) throws PersistentException {
		try {
			PersistentSession session = RoomiePersistentManager.instance().getSession();
			return getRentHistoryByORMID(session, house, tenant);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static RentHistory loadRentHistoryByORMID(roomie.entities.House house, roomie.entities.Tenant tenant, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = RoomiePersistentManager.instance().getSession();
			return loadRentHistoryByORMID(session, house, tenant, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static RentHistory getRentHistoryByORMID(roomie.entities.House house, roomie.entities.Tenant tenant, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = RoomiePersistentManager.instance().getSession();
			return getRentHistoryByORMID(session, house, tenant, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static RentHistory loadRentHistoryByORMID(PersistentSession session, roomie.entities.House house, roomie.entities.Tenant tenant) throws PersistentException {
		try {
			RentHistory renthistory = new roomie.entities.RentHistory();
			renthistory.setHouse(house);
			renthistory.setTenant(tenant);
			
			return (RentHistory) session.load(roomie.entities.RentHistory.class, renthistory);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static RentHistory getRentHistoryByORMID(PersistentSession session, roomie.entities.House house, roomie.entities.Tenant tenant) throws PersistentException {
		try {
			RentHistory renthistory = new roomie.entities.RentHistory();
			renthistory.setHouse(house);
			renthistory.setTenant(tenant);
			
			return (RentHistory) session.get(roomie.entities.RentHistory.class, renthistory);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static RentHistory loadRentHistoryByORMID(PersistentSession session, roomie.entities.House house, roomie.entities.Tenant tenant, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			RentHistory renthistory = new roomie.entities.RentHistory();
			renthistory.setHouse(house);
			renthistory.setTenant(tenant);
			
			return (RentHistory) session.load(roomie.entities.RentHistory.class, renthistory, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static RentHistory getRentHistoryByORMID(PersistentSession session, roomie.entities.House house, roomie.entities.Tenant tenant, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			RentHistory renthistory = new roomie.entities.RentHistory();
			renthistory.setHouse(house);
			renthistory.setTenant(tenant);
			
			return (RentHistory) session.get(roomie.entities.RentHistory.class, renthistory, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static List queryRentHistory(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = RoomiePersistentManager.instance().getSession();
			return queryRentHistory(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static List queryRentHistory(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = RoomiePersistentManager.instance().getSession();
			return queryRentHistory(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static RentHistory[] listRentHistoryByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = RoomiePersistentManager.instance().getSession();
			return listRentHistoryByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static RentHistory[] listRentHistoryByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = RoomiePersistentManager.instance().getSession();
			return listRentHistoryByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static List queryRentHistory(PersistentSession session, String condition, String orderBy) throws PersistentException {
		StringBuffer sb = new StringBuffer("From roomie.entities.RentHistory as RentHistory");
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
	
	public static List queryRentHistory(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		StringBuffer sb = new StringBuffer("From roomie.entities.RentHistory as RentHistory");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			query.setLockMode("RentHistory", lockMode);
			return query.list();
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static RentHistory[] listRentHistoryByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		try {
			List list = queryRentHistory(session, condition, orderBy);
			return (RentHistory[]) list.toArray(new RentHistory[list.size()]);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static RentHistory[] listRentHistoryByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			List list = queryRentHistory(session, condition, orderBy, lockMode);
			return (RentHistory[]) list.toArray(new RentHistory[list.size()]);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static RentHistory loadRentHistoryByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = RoomiePersistentManager.instance().getSession();
			return loadRentHistoryByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static RentHistory loadRentHistoryByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = RoomiePersistentManager.instance().getSession();
			return loadRentHistoryByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static RentHistory loadRentHistoryByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		RentHistory[] rentHistorys = listRentHistoryByQuery(session, condition, orderBy);
		if (rentHistorys != null && rentHistorys.length > 0)
			return rentHistorys[0];
		else
			return null;
	}
	
	public static RentHistory loadRentHistoryByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		RentHistory[] rentHistorys = listRentHistoryByQuery(session, condition, orderBy, lockMode);
		if (rentHistorys != null && rentHistorys.length > 0)
			return rentHistorys[0];
		else
			return null;
	}
	
	public static java.util.Iterator iterateRentHistoryByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = RoomiePersistentManager.instance().getSession();
			return iterateRentHistoryByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static java.util.Iterator iterateRentHistoryByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = RoomiePersistentManager.instance().getSession();
			return iterateRentHistoryByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static java.util.Iterator iterateRentHistoryByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		StringBuffer sb = new StringBuffer("From roomie.entities.RentHistory as RentHistory");
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
	
	public static java.util.Iterator iterateRentHistoryByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		StringBuffer sb = new StringBuffer("From roomie.entities.RentHistory as RentHistory");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			query.setLockMode("RentHistory", lockMode);
			return query.iterate();
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static RentHistory createRentHistory() {
		return new roomie.entities.RentHistory();
	}
	
	public static boolean save(roomie.entities.RentHistory rentHistory) throws PersistentException {
		try {
			RoomiePersistentManager.instance().saveObject(rentHistory);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static boolean delete(roomie.entities.RentHistory rentHistory) throws PersistentException {
		try {
			RoomiePersistentManager.instance().deleteObject(rentHistory);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static boolean refresh(roomie.entities.RentHistory rentHistory) throws PersistentException {
		try {
			RoomiePersistentManager.instance().getSession().refresh(rentHistory);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static boolean evict(roomie.entities.RentHistory rentHistory) throws PersistentException {
		try {
			RoomiePersistentManager.instance().getSession().evict(rentHistory);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static RentHistory loadRentHistoryByCriteria(RentHistoryCriteria rentHistoryCriteria) {
		RentHistory[] rentHistorys = listRentHistoryByCriteria(rentHistoryCriteria);
		if(rentHistorys == null || rentHistorys.length == 0) {
			return null;
		}
		return rentHistorys[0];
	}
	
	public static RentHistory[] listRentHistoryByCriteria(RentHistoryCriteria rentHistoryCriteria) {
		return rentHistoryCriteria.listRentHistory();
	}
}
