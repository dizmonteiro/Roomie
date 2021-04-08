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
package roomie;

import org.hibernate.Criteria;
import org.orm.PersistentException;
import org.orm.PersistentSession;
import org.orm.criteria.*;

public class AvatarCriteria extends AbstractORMCriteria {
	public final IntegerExpression ID;
	public final StringExpression path;
	
	public AvatarCriteria(Criteria criteria) {
		super(criteria);
		ID = new IntegerExpression("ID", this);
		path = new StringExpression("path", this);
	}
	
	public AvatarCriteria(PersistentSession session) {
		this(session.createCriteria(Avatar.class));
	}
	
	public AvatarCriteria() throws PersistentException {
		this(RoomiePersistentManager.instance().getSession());
	}
	
	public Avatar uniqueAvatar() {
		return (Avatar) super.uniqueResult();
	}
	
	public Avatar[] listAvatar() {
		java.util.List list = super.list();
		return (Avatar[]) list.toArray(new Avatar[list.size()]);
	}
}

