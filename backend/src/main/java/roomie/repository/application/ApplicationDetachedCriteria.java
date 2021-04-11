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
package roomie.repository.application;

import org.hibernate.criterion.DetachedCriteria;
import org.orm.PersistentSession;
import org.orm.criteria.AbstractORMDetachedCriteria;
import org.orm.criteria.AssociationExpression;
import org.orm.criteria.BooleanExpression;
import org.orm.criteria.IntegerExpression;
import roomie.model.application.Application;
import roomie.repository.house.HouseDetachedCriteria;
import roomie.repository.tenant.TenantDetachedCriteria;

import java.util.List;

public class ApplicationDetachedCriteria extends AbstractORMDetachedCriteria {
	public final IntegerExpression tenantId;
	public final AssociationExpression tenant;
	public final IntegerExpression houseId;
	public final AssociationExpression house;
	public final BooleanExpression toBeAssessed;
	public final BooleanExpression accepted;
	
	public ApplicationDetachedCriteria() {
		super(Application.class, ApplicationCriteria.class);
		tenantId = new IntegerExpression("tenant.id", this.getDetachedCriteria());
		tenant = new AssociationExpression("tenant", this.getDetachedCriteria());
		houseId = new IntegerExpression("house.id", this.getDetachedCriteria());
		house = new AssociationExpression("house", this.getDetachedCriteria());
		toBeAssessed = new BooleanExpression("toBeAssessed", this.getDetachedCriteria());
		accepted = new BooleanExpression("accepted", this.getDetachedCriteria());
	}
	
	public ApplicationDetachedCriteria(DetachedCriteria aDetachedCriteria) {
		super(aDetachedCriteria, ApplicationCriteria.class);
		tenantId = new IntegerExpression("tenant.id", this.getDetachedCriteria());
		tenant = new AssociationExpression("tenant", this.getDetachedCriteria());
		houseId = new IntegerExpression("house.id", this.getDetachedCriteria());
		house = new AssociationExpression("house", this.getDetachedCriteria());
		toBeAssessed = new BooleanExpression("toBeAssessed", this.getDetachedCriteria());
		accepted = new BooleanExpression("accepted", this.getDetachedCriteria());
	}
	
	public TenantDetachedCriteria createTenantCriteria() {
		return new TenantDetachedCriteria(createCriteria("tenant"));
	}
	
	public HouseDetachedCriteria createHouseCriteria() {
		return new HouseDetachedCriteria(createCriteria("house"));
	}
	
	public Application uniqueApplication(PersistentSession session) {
		return (Application) super.createExecutableCriteria(session).uniqueResult();
	}
	
	public Application[] listApplication(PersistentSession session) {
		List list = super.createExecutableCriteria(session).list();
		return (Application[]) list.toArray(new Application[list.size()]);
	}
}

