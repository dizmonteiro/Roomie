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

import java.util.List;
import org.hibernate.criterion.DetachedCriteria;
import org.orm.PersistentSession;
import org.orm.criteria.*;

public class AvatarDetachedCriteria extends AbstractORMDetachedCriteria {
	public final IntegerExpression ID;
	public final StringExpression path;
	
	public AvatarDetachedCriteria() {
		super(roomie.entities.Avatar.class, roomie.entities.AvatarCriteria.class);
		ID = new IntegerExpression("ID", this.getDetachedCriteria());
		path = new StringExpression("path", this.getDetachedCriteria());
	}
	
	public AvatarDetachedCriteria(DetachedCriteria aDetachedCriteria) {
		super(aDetachedCriteria, roomie.entities.AvatarCriteria.class);
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

