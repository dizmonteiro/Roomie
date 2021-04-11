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
package roomie.repository.rentHistory;

import org.hibernate.criterion.DetachedCriteria;
import org.orm.PersistentSession;
import org.orm.criteria.AbstractORMDetachedCriteria;
import org.orm.criteria.AssociationExpression;
import org.orm.criteria.DateExpression;
import org.orm.criteria.IntegerExpression;
import roomie.model.rentHistory.RentHistory;
import roomie.repository.house.HouseDetachedCriteria;
import roomie.repository.tenant.TenantDetachedCriteria;

import java.util.List;

public class RentHistoryDetachedCriteria extends AbstractORMDetachedCriteria {
	public final IntegerExpression houseId;
	public final AssociationExpression house;
	public final IntegerExpression tenantId;
	public final AssociationExpression tenant;
	public final DateExpression bDate;
	public final DateExpression eDate;
	
	public RentHistoryDetachedCriteria() {
		super(RentHistory.class, RentHistoryCriteria.class);
		houseId = new IntegerExpression("house.id", this.getDetachedCriteria());
		house = new AssociationExpression("house", this.getDetachedCriteria());
		tenantId = new IntegerExpression("tenant.id", this.getDetachedCriteria());
		tenant = new AssociationExpression("tenant", this.getDetachedCriteria());
		bDate = new DateExpression("bDate", this.getDetachedCriteria());
		eDate = new DateExpression("eDate", this.getDetachedCriteria());
	}
	
	public RentHistoryDetachedCriteria(DetachedCriteria aDetachedCriteria) {
		super(aDetachedCriteria, RentHistoryCriteria.class);
		houseId = new IntegerExpression("house.id", this.getDetachedCriteria());
		house = new AssociationExpression("house", this.getDetachedCriteria());
		tenantId = new IntegerExpression("tenant.id", this.getDetachedCriteria());
		tenant = new AssociationExpression("tenant", this.getDetachedCriteria());
		bDate = new DateExpression("bDate", this.getDetachedCriteria());
		eDate = new DateExpression("eDate", this.getDetachedCriteria());
	}
	
	public HouseDetachedCriteria createHouseCriteria() {
		return new HouseDetachedCriteria(createCriteria("house"));
	}
	
	public TenantDetachedCriteria createTenantCriteria() {
		return new TenantDetachedCriteria(createCriteria("tenant"));
	}
	
	public RentHistory uniqueRentHistory(PersistentSession session) {
		return (RentHistory) super.createExecutableCriteria(session).uniqueResult();
	}
	
	public RentHistory[] listRentHistory(PersistentSession session) {
		List list = super.createExecutableCriteria(session).list();
		return (RentHistory[]) list.toArray(new RentHistory[list.size()]);
	}
}
