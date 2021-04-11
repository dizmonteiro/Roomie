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
package roomie.repository.house;

import org.hibernate.criterion.DetachedCriteria;
import org.orm.PersistentSession;
import org.orm.criteria.*;
import roomie.model.house.House;
import roomie.repository.photo.PhotoDetachedCriteria;

import java.util.List;

public class HouseDetachedCriteria extends AbstractORMDetachedCriteria {
	public final IntegerExpression id;
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
	
	public HouseDetachedCriteria() {
		super(House.class, HouseCriteria.class);
		id = new IntegerExpression("id", this.getDetachedCriteria());
		address = new StringExpression("address", this.getDetachedCriteria());
		title = new StringExpression("title", this.getDetachedCriteria());
		rooms = new IntegerExpression("rooms", this.getDetachedCriteria());
		availableRooms = new IntegerExpression("availableRooms", this.getDetachedCriteria());
		bathRooms = new IntegerExpression("bathRooms", this.getDetachedCriteria());
		minPrice = new DoubleExpression("minPrice", this.getDetachedCriteria());
		maxPrice = new DoubleExpression("maxPrice", this.getDetachedCriteria());
		description = new StringExpression("description", this.getDetachedCriteria());
		features = new StringExpression("features", this.getDetachedCriteria());
		photos = new CollectionExpression("ORM_Photos", this.getDetachedCriteria());
	}
	
	public HouseDetachedCriteria(DetachedCriteria aDetachedCriteria) {
		super(aDetachedCriteria, HouseCriteria.class);
		id = new IntegerExpression("id", this.getDetachedCriteria());
		address = new StringExpression("address", this.getDetachedCriteria());
		title = new StringExpression("title", this.getDetachedCriteria());
		rooms = new IntegerExpression("rooms", this.getDetachedCriteria());
		availableRooms = new IntegerExpression("availableRooms", this.getDetachedCriteria());
		bathRooms = new IntegerExpression("bathRooms", this.getDetachedCriteria());
		minPrice = new DoubleExpression("minPrice", this.getDetachedCriteria());
		maxPrice = new DoubleExpression("maxPrice", this.getDetachedCriteria());
		description = new StringExpression("description", this.getDetachedCriteria());
		features = new StringExpression("features", this.getDetachedCriteria());
		photos = new CollectionExpression("ORM_Photos", this.getDetachedCriteria());
	}
	
	public PhotoDetachedCriteria createPhotosCriteria() {
		return new PhotoDetachedCriteria(createCriteria("ORM_Photos"));
	}
	
	public House uniqueHouse(PersistentSession session) {
		return (House) super.createExecutableCriteria(session).uniqueResult();
	}
	
	public House[] listHouse(PersistentSession session) {
		List list = super.createExecutableCriteria(session).list();
		return (House[]) list.toArray(new House[list.size()]);
	}
}

