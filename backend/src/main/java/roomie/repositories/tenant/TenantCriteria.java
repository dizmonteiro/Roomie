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
 * <p>
 * Licensee: vr(Universidade do Minho)
 * License Type: Academic
 */

/**
 * Licensee: vr(Universidade do Minho)
 * License Type: Academic
 */
package roomie.repositories.tenant;

import org.hibernate.Criteria;
import org.orm.PersistentException;
import org.orm.PersistentSession;
import org.orm.criteria.*;
import roomie.models.tenant.Tenant;
import roomie.repositories.RoomiePersistentManager;
import roomie.repositories.avatar.AvatarCriteria;

public class TenantCriteria extends AbstractORMCriteria {
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
	
	public TenantCriteria(Criteria criteria) {
		super(criteria);
		id = new IntegerExpression("id", this);
		avatarId = new IntegerExpression("avatar.ID", this);
		avatar = new AssociationExpression("avatar", this);
		name = new StringExpression("name", this);
		email = new StringExpression("email", this);
		username = new StringExpression("username", this);
		phone = new StringExpression("phone", this);
		birthDate = new DateExpression("birthDate", this);
		sex = new StringExpression("sex", this);
		nif = new StringExpression("nif", this);
		nationality = new StringExpression("nationality", this);
		occupation = new StringExpression("occupation", this);
		password = new StringExpression("password", this);
	}
	
	public TenantCriteria(PersistentSession session) {
		this(session.createCriteria(Tenant.class));
	}
	
	public TenantCriteria() throws PersistentException {
		this(RoomiePersistentManager.instance().getSession());
	}
	
	public AvatarCriteria createAvatarCriteria() {
		return new AvatarCriteria(createCriteria("avatar"));
	}
	
	public Tenant uniqueTenant() {
		return (Tenant) super.uniqueResult();
	}
	
	public Tenant[] listTenant() {
		java.util.List list = super.list();
		return (Tenant[]) list.toArray(new Tenant[list.size()]);
	}
}

