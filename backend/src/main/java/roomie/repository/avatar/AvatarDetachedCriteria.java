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
package roomie.repository.avatar;

import org.hibernate.criterion.DetachedCriteria;
import org.orm.PersistentSession;
import org.orm.criteria.AbstractORMDetachedCriteria;
import org.orm.criteria.IntegerExpression;
import org.orm.criteria.StringExpression;
import roomie.model.avatar.Avatar;

import java.util.List;

public class AvatarDetachedCriteria extends AbstractORMDetachedCriteria {
	public final IntegerExpression ID;
	public final StringExpression path;
	
	public AvatarDetachedCriteria() {
		super(Avatar.class, AvatarCriteria.class);
		ID = new IntegerExpression("ID", this.getDetachedCriteria());
		path = new StringExpression("path", this.getDetachedCriteria());
	}
	
	public AvatarDetachedCriteria(DetachedCriteria aDetachedCriteria) {
		super(aDetachedCriteria, AvatarCriteria.class);
		ID = new IntegerExpression("ID", this.getDetachedCriteria());
		path = new StringExpression("path", this.getDetachedCriteria());
	}
	
	public Avatar uniqueAvatar(PersistentSession session) {
		return (Avatar) super.createExecutableCriteria(session).uniqueResult();
	}
	
	public Avatar[] listAvatar(PersistentSession session) {
		List list = super.createExecutableCriteria(session).list();
		return (Avatar[]) list.toArray(new Avatar[list.size()]);
	}
}

