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
package roomie.repositories.rentHistory;

import org.hibernate.Criteria;
import org.orm.PersistentException;
import org.orm.PersistentSession;
import org.orm.criteria.AbstractORMCriteria;
import org.orm.criteria.AssociationExpression;
import org.orm.criteria.DateExpression;
import org.orm.criteria.IntegerExpression;
import roomie.models.rentHistory.RentHistory;
import roomie.repositories.RoomiePersistentManager;
import roomie.repositories.house.HouseCriteria;
import roomie.repositories.tenant.TenantCriteria;

public class RentHistoryCriteria extends AbstractORMCriteria {
	public final IntegerExpression houseId;
	public final AssociationExpression house;
	public final IntegerExpression tenantId;
	public final AssociationExpression tenant;
	public final DateExpression bDate;
	public final DateExpression eDate;
	
	public RentHistoryCriteria(Criteria criteria) {
		super(criteria);
		houseId = new IntegerExpression("house.id", this);
		house = new AssociationExpression("house", this);
		tenantId = new IntegerExpression("tenant.id", this);
		tenant = new AssociationExpression("tenant", this);
		bDate = new DateExpression("bDate", this);
		eDate = new DateExpression("eDate", this);
	}
	
	public RentHistoryCriteria(PersistentSession session) {
		this(session.createCriteria(RentHistory.class));
	}
	
	public RentHistoryCriteria() throws PersistentException {
		this(RoomiePersistentManager.instance().getSession());
	}
	
	public HouseCriteria createHouseCriteria() {
		return new HouseCriteria(createCriteria("house"));
	}
	
	public TenantCriteria createTenantCriteria() {
		return new TenantCriteria(createCriteria("tenant"));
	}
	
	public RentHistory uniqueRentHistory() {
		return (RentHistory) super.uniqueResult();
	}
	
	public RentHistory[] listRentHistory() {
		java.util.List list = super.list();
		return (RentHistory[]) list.toArray(new RentHistory[list.size()]);
	}
}

