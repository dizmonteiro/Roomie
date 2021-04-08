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

public class TenantDetachedCriteria extends AbstractORMDetachedCriteria {
	public final IntegerExpression id;
	public final IntegerExpression avatarId;
	public final AssociationExpression avatar;
	public final StringExpression name;
	public final StringExpression email;
	public final StringExpression username;
	public final StringExpression phone;
	public final DateExpression birthDate;
	public final StringExpression sex;
	public final StringExpression nif;
	public final StringExpression nationality;
	public final StringExpression occupation;
	public final StringExpression password;
	
	public TenantDetachedCriteria() {
		super(roomie.Tenant.class, roomie.TenantCriteria.class);
		id = new IntegerExpression("id", this.getDetachedCriteria());
		avatarId = new IntegerExpression("avatar.ID", this.getDetachedCriteria());
		avatar = new AssociationExpression("avatar", this.getDetachedCriteria());
		name = new StringExpression("name", this.getDetachedCriteria());
		email = new StringExpression("email", this.getDetachedCriteria());
		username = new StringExpression("username", this.getDetachedCriteria());
		phone = new StringExpression("phone", this.getDetachedCriteria());
		birthDate = new DateExpression("birthDate", this.getDetachedCriteria());
		sex = new StringExpression("sex", this.getDetachedCriteria());
		nif = new StringExpression("nif", this.getDetachedCriteria());
		nationality = new StringExpression("nationality", this.getDetachedCriteria());
		occupation = new StringExpression("occupation", this.getDetachedCriteria());
		password = new StringExpression("password", this.getDetachedCriteria());
	}
	
	public TenantDetachedCriteria(DetachedCriteria aDetachedCriteria) {
		super(aDetachedCriteria, roomie.TenantCriteria.class);
		id = new IntegerExpression("id", this.getDetachedCriteria());
		avatarId = new IntegerExpression("avatar.ID", this.getDetachedCriteria());
		avatar = new AssociationExpression("avatar", this.getDetachedCriteria());
		name = new StringExpression("name", this.getDetachedCriteria());
		email = new StringExpression("email", this.getDetachedCriteria());
		username = new StringExpression("username", this.getDetachedCriteria());
		phone = new StringExpression("phone", this.getDetachedCriteria());
		birthDate = new DateExpression("birthDate", this.getDetachedCriteria());
		sex = new StringExpression("sex", this.getDetachedCriteria());
		nif = new StringExpression("nif", this.getDetachedCriteria());
		nationality = new StringExpression("nationality", this.getDetachedCriteria());
		occupation = new StringExpression("occupation", this.getDetachedCriteria());
		password = new StringExpression("password", this.getDetachedCriteria());
	}
	
	public AvatarDetachedCriteria createAvatarCriteria() {
		return new AvatarDetachedCriteria(createCriteria("avatar"));
	}
	
	public Tenant uniqueTenant(PersistentSession session) {
		return (Tenant) super.createExecutableCriteria(session).uniqueResult();
	}
	
	public Tenant[] listTenant(PersistentSession session) {
		List list = super.createExecutableCriteria(session).list();
		return (Tenant[]) list.toArray(new Tenant[list.size()]);
	}
}

