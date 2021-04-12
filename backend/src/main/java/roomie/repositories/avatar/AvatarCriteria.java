package roomie.repositories.avatar;

/**
 * Licensee: vr(Universidade do Minho)
 * License Type: Academic
 */

import org.hibernate.Criteria;
import org.orm.PersistentException;
import org.orm.PersistentSession;
import org.orm.criteria.AbstractORMCriteria;
import org.orm.criteria.IntegerExpression;
import org.orm.criteria.StringExpression;
import roomie.models.avatar.Avatar;
import roomie.repositories.RoomiePersistentManager;

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

