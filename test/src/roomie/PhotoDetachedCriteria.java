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

import java.util.List;
import org.hibernate.criterion.DetachedCriteria;
import org.orm.PersistentSession;
import org.orm.criteria.*;

public class PhotoDetachedCriteria extends AbstractORMDetachedCriteria {
	public final IntegerExpression ID;
	public final StringExpression path;
	
	public PhotoDetachedCriteria() {
		super(roomie.Photo.class, roomie.PhotoCriteria.class);
		ID = new IntegerExpression("ID", this.getDetachedCriteria());
		path = new StringExpression("path", this.getDetachedCriteria());
	}
	
	public PhotoDetachedCriteria(DetachedCriteria aDetachedCriteria) {
		super(aDetachedCriteria, roomie.PhotoCriteria.class);
		ID = new IntegerExpression("ID", this.getDetachedCriteria());
		path = new StringExpression("path", this.getDetachedCriteria());
	}
	
	public Photo uniquePhoto(PersistentSession session) {
		return (Photo) super.createExecutableCriteria(session).uniqueResult();
	}
	
	public Photo[] listPhoto(PersistentSession session) {
		List list = super.createExecutableCriteria(session).list();
		return (Photo[]) list.toArray(new Photo[list.size()]);
	}
}

