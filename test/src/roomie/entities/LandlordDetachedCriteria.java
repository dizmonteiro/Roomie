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

public class LandlordDetachedCriteria extends AbstractORMDetachedCriteria {
	public final IntegerExpression id;
	public final IntegerExpression avatarId;
	public final AssociationExpression avatar;
	public final StringExpression name;
	public final StringExpression email;
	public final StringExpression username;
	public final DateExpression birthDate;
	public final StringExpression sex;
	public final StringExpression nif;
	public final StringExpression address;
	public final StringExpression password;
	public final StringExpression phone;
	public final CollectionExpression houses;
	
	public LandlordDetachedCriteria() {
		super(roomie.entities.Landlord.class, roomie.entities.LandlordCriteria.class);
		id = new IntegerExpression("id", this.getDetachedCriteria());
		avatarId = new IntegerExpression("avatar.ID", this.getDetachedCriteria());
		avatar = new AssociationExpression("avatar", this.getDetachedCriteria());
		name = new StringExpression("name", this.getDetachedCriteria());
		email = new StringExpression("email", this.getDetachedCriteria());
		username = new StringExpression("username", this.getDetachedCriteria());
		birthDate = new DateExpression("birthDate", this.getDetachedCriteria());
		sex = new StringExpression("sex", this.getDetachedCriteria());
		nif = new StringExpression("nif", this.getDetachedCriteria());
		address = new StringExpression("address", this.getDetachedCriteria());
		password = new StringExpression("password", this.getDetachedCriteria());
		phone = new StringExpression("phone", this.getDetachedCriteria());
		houses = new CollectionExpression("ORM_Houses", this.getDetachedCriteria());
	}
	
	public LandlordDetachedCriteria(DetachedCriteria aDetachedCriteria) {
		super(aDetachedCriteria, roomie.entities.LandlordCriteria.class);
		id = new IntegerExpression("id", this.getDetachedCriteria());
		avatarId = new IntegerExpression("avatar.ID", this.getDetachedCriteria());
		avatar = new AssociationExpression("avatar", this.getDetachedCriteria());
		name = new StringExpression("name", this.getDetachedCriteria());
		email = new StringExpression("email", this.getDetachedCriteria());
		username = new StringExpression("username", this.getDetachedCriteria());
		birthDate = new DateExpression("birthDate", this.getDetachedCriteria());
		sex = new StringExpression("sex", this.getDetachedCriteria());
		nif = new StringExpression("nif", this.getDetachedCriteria());
		address = new StringExpression("address", this.getDetachedCriteria());
		password = new StringExpression("password", this.getDetachedCriteria());
		phone = new StringExpression("phone", this.getDetachedCriteria());
		houses = new CollectionExpression("ORM_Houses", this.getDetachedCriteria());
	}
	
	public AvatarDetachedCriteria createAvatarCriteria() {
		return new AvatarDetachedCriteria(createCriteria("avatar"));
	}
	
	public HouseDetachedCriteria createHousesCriteria() {
		return new HouseDetachedCriteria(createCriteria("ORM_Houses"));
	}
	
	public Landlord uniqueLandlord(PersistentSession session) {
		return (Landlord) super.createExecutableCriteria(session).uniqueResult();
	}
	
	public Landlord[] listLandlord(PersistentSession session) {
		List list = super.createExecutableCriteria(session).list();
		return (Landlord[]) list.toArray(new Landlord[list.size()]);
	}
}
