package roomie.repositories.photo;

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
import roomie.models.RoomiePersistentManager;
import roomie.models.photo.Photo;

public class PhotoCriteria extends AbstractORMCriteria {
	public final IntegerExpression ID;
	public final StringExpression path;
	
	public PhotoCriteria(Criteria criteria) {
		super(criteria);
		ID = new IntegerExpression("ID", this);
		path = new StringExpression("path", this);
	}
	
	public PhotoCriteria(PersistentSession session) {
		this(session.createCriteria(Photo.class));
	}
	
	public PhotoCriteria() throws PersistentException {
		this(RoomiePersistentManager.instance().getSession());
	}
	
	public Photo uniquePhoto() {
		return (Photo) super.uniqueResult();
	}
	
	public Photo[] listPhoto() {
		java.util.List list = super.list();
		return (Photo[]) list.toArray(new Photo[list.size()]);
	}
}

