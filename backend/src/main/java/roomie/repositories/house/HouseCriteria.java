/**
 * Licensee: vr(Universidade do Minho)
 * License Type: Academic
 */
package roomie.repositories.house;

import org.hibernate.Criteria;
import org.orm.PersistentException;
import org.orm.PersistentSession;
import org.orm.criteria.*;
import roomie.models.RoomiePersistentManager;
import roomie.models.house.House;
import roomie.repositories.landlord.LandlordCriteria;
import roomie.repositories.photo.PhotoCriteria;

public class HouseCriteria extends AbstractORMCriteria {
	public final IntegerExpression id;
	public final IntegerExpression landlordId;
	public final AssociationExpression landlord;
	public final StringExpression address;
	public final StringExpression title;
	public final IntegerExpression rooms;
	public final IntegerExpression availableRooms;
	public final IntegerExpression bathRooms;
	public final DoubleExpression minPrice;
	public final DoubleExpression maxPrice;
	public final StringExpression description;
	public final StringExpression features;
	public final CollectionExpression photos;
	
	public HouseCriteria(Criteria criteria) {
		super(criteria);
		id = new IntegerExpression("id", this);
		landlordId = new IntegerExpression("landlord.id", this);
		landlord = new AssociationExpression("landlord", this);
		address = new StringExpression("address", this);
		title = new StringExpression("title", this);
		rooms = new IntegerExpression("rooms", this);
		availableRooms = new IntegerExpression("availableRooms", this);
		bathRooms = new IntegerExpression("bathRooms", this);
		minPrice = new DoubleExpression("minPrice", this);
		maxPrice = new DoubleExpression("maxPrice", this);
		description = new StringExpression("description", this);
		features = new StringExpression("features", this);
		photos = new CollectionExpression("ORM_Photos", this);
	}
	
	public HouseCriteria(PersistentSession session) {
		this(session.createCriteria(House.class));
	}
	
	public HouseCriteria() throws PersistentException {
		this(RoomiePersistentManager.instance().getSession());
	}
	
	public LandlordCriteria createLandlordCriteria() {
		return new LandlordCriteria(createCriteria("landlord"));
	}
	
	public PhotoCriteria createPhotosCriteria() {
		return new PhotoCriteria(createCriteria("ORM_Photos"));
	}
	
	public House uniqueHouse() {
		return (House) super.uniqueResult();
	}
	
	public House[] listHouse() {
		java.util.List list = super.list();
		return (House[]) list.toArray(new House[list.size()]);
	}
}

