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
 */

/**
 * Licensee: vr(Universidade do Minho)
 * License Type: Academic
 */
package roomie.model.avatar;

import org.hibernate.Query;
import org.orm.PersistentException;
import org.orm.PersistentSession;
import roomie.model.RoomiePersistentManager;
import roomie.repository.avatar.AvatarCriteria;

import java.util.List;

public class AvatarDAO {
	public static Avatar loadAvatarByORMID(int ID) throws PersistentException {
		try {
			PersistentSession session = RoomiePersistentManager.instance().getSession();
			return loadAvatarByORMID(session, ID);
		} catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Avatar getAvatarByORMID(int ID) throws PersistentException {
		try {
			PersistentSession session = RoomiePersistentManager.instance().getSession();
			return getAvatarByORMID(session, ID);
		} catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Avatar loadAvatarByORMID(int ID, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = RoomiePersistentManager.instance().getSession();
			return loadAvatarByORMID(session, ID, lockMode);
		} catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Avatar getAvatarByORMID(int ID, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = RoomiePersistentManager.instance().getSession();
			return getAvatarByORMID(session, ID, lockMode);
		} catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Avatar loadAvatarByORMID(PersistentSession session, int ID) throws PersistentException {
		try {
			return (Avatar) session.load(Avatar.class, new Integer(ID));
		} catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Avatar getAvatarByORMID(PersistentSession session, int ID) throws PersistentException {
		try {
			return (Avatar) session.get(Avatar.class, new Integer(ID));
		} catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Avatar loadAvatarByORMID(PersistentSession session, int ID, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			return (Avatar) session.load(Avatar.class, new Integer(ID), lockMode);
		} catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Avatar getAvatarByORMID(PersistentSession session, int ID, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			return (Avatar) session.get(Avatar.class, new Integer(ID), lockMode);
		} catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static List queryAvatar(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = RoomiePersistentManager.instance().getSession();
			return queryAvatar(session, condition, orderBy);
		} catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static List queryAvatar(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = RoomiePersistentManager.instance().getSession();
			return queryAvatar(session, condition, orderBy, lockMode);
		} catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Avatar[] listAvatarByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = RoomiePersistentManager.instance().getSession();
			return listAvatarByQuery(session, condition, orderBy);
		} catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Avatar[] listAvatarByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = RoomiePersistentManager.instance().getSession();
			return listAvatarByQuery(session, condition, orderBy, lockMode);
		} catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static List queryAvatar(PersistentSession session, String condition, String orderBy) throws PersistentException {
		StringBuffer sb = new StringBuffer("From roomie.model.avatar.Avatar as Avatar");
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
	
	public static List queryAvatar(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		StringBuffer sb = new StringBuffer("From roomie.model.avatar.Avatar as Avatar");
		if (condition != null) sb.append(" Where ").append(condition);
		if (orderBy != null) sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			query.setLockMode("Avatar", lockMode);
			return query.list();
		} catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Avatar[] listAvatarByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		try {
			List list = queryAvatar(session, condition, orderBy);
			return (Avatar[]) list.toArray(new Avatar[list.size()]);
		} catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Avatar[] listAvatarByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			List list = queryAvatar(session, condition, orderBy, lockMode);
			return (Avatar[]) list.toArray(new Avatar[list.size()]);
		} catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Avatar loadAvatarByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = RoomiePersistentManager.instance().getSession();
			return loadAvatarByQuery(session, condition, orderBy);
		} catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Avatar loadAvatarByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = RoomiePersistentManager.instance().getSession();
			return loadAvatarByQuery(session, condition, orderBy, lockMode);
		} catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Avatar loadAvatarByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		Avatar[] avatars = listAvatarByQuery(session, condition, orderBy);
		if (avatars != null && avatars.length > 0) return avatars[0];
		else return null;
	}
	
	public static Avatar loadAvatarByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		Avatar[] avatars = listAvatarByQuery(session, condition, orderBy, lockMode);
		if (avatars != null && avatars.length > 0) return avatars[0];
		else return null;
	}
	
	public static java.util.Iterator iterateAvatarByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = RoomiePersistentManager.instance().getSession();
			return iterateAvatarByQuery(session, condition, orderBy);
		} catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static java.util.Iterator iterateAvatarByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = RoomiePersistentManager.instance().getSession();
			return iterateAvatarByQuery(session, condition, orderBy, lockMode);
		} catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static java.util.Iterator iterateAvatarByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		StringBuffer sb = new StringBuffer("From roomie.model.avatar.Avatar as Avatar");
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
	
	public static java.util.Iterator iterateAvatarByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		StringBuffer sb = new StringBuffer("From roomie.model.avatar.Avatar as Avatar");
		if (condition != null) sb.append(" Where ").append(condition);
		if (orderBy != null) sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			query.setLockMode("Avatar", lockMode);
			return query.iterate();
		} catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Avatar createAvatar() {
		return new Avatar();
	}
	
	public static boolean save(Avatar avatar) throws PersistentException {
		try {
			RoomiePersistentManager.instance().saveObject(avatar);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static boolean delete(Avatar avatar) throws PersistentException {
		try {
			RoomiePersistentManager.instance().deleteObject(avatar);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static boolean refresh(Avatar avatar) throws PersistentException {
		try {
			RoomiePersistentManager.instance().getSession().refresh(avatar);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static boolean evict(Avatar avatar) throws PersistentException {
		try {
			RoomiePersistentManager.instance().getSession().evict(avatar);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Avatar loadAvatarByCriteria(AvatarCriteria avatarCriteria) {
		Avatar[] avatars = listAvatarByCriteria(avatarCriteria);
		if (avatars == null || avatars.length == 0) {
			return null;
		}
		return avatars[0];
	}
	
	public static Avatar[] listAvatarByCriteria(AvatarCriteria avatarCriteria) {
		return avatarCriteria.listAvatar();
	}
}
