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
package roomie.repository.evaluation;

import org.hibernate.criterion.DetachedCriteria;
import org.orm.PersistentSession;
import org.orm.criteria.AbstractORMDetachedCriteria;
import org.orm.criteria.AssociationExpression;
import org.orm.criteria.DoubleExpression;
import org.orm.criteria.IntegerExpression;
import roomie.model.evaluation.LandlordEvaluation;
import roomie.repository.landlord.LandlordDetachedCriteria;
import roomie.repository.tenant.TenantDetachedCriteria;

import java.util.List;

public class LandlordEvaluationDetachedCriteria extends AbstractORMDetachedCriteria {
	public final IntegerExpression landlordId;
	public final AssociationExpression landlord;
	public final IntegerExpression tenantId;
	public final AssociationExpression tenant;
	public final DoubleExpression cleanliness;
	public final DoubleExpression payment;
	public final DoubleExpression care;
	
	public LandlordEvaluationDetachedCriteria() {
		super(LandlordEvaluation.class, LandlordEvaluationCriteria.class);
		landlordId = new IntegerExpression("landlord.id", this.getDetachedCriteria());
		landlord = new AssociationExpression("landlord", this.getDetachedCriteria());
		tenantId = new IntegerExpression("tenant.id", this.getDetachedCriteria());
		tenant = new AssociationExpression("tenant", this.getDetachedCriteria());
		cleanliness = new DoubleExpression("cleanliness", this.getDetachedCriteria());
		payment = new DoubleExpression("payment", this.getDetachedCriteria());
		care = new DoubleExpression("care", this.getDetachedCriteria());
	}
	
	public LandlordEvaluationDetachedCriteria(DetachedCriteria aDetachedCriteria) {
		super(aDetachedCriteria, LandlordEvaluationCriteria.class);
		landlordId = new IntegerExpression("landlord.id", this.getDetachedCriteria());
		landlord = new AssociationExpression("landlord", this.getDetachedCriteria());
		tenantId = new IntegerExpression("tenant.id", this.getDetachedCriteria());
		tenant = new AssociationExpression("tenant", this.getDetachedCriteria());
		cleanliness = new DoubleExpression("cleanliness", this.getDetachedCriteria());
		payment = new DoubleExpression("payment", this.getDetachedCriteria());
		care = new DoubleExpression("care", this.getDetachedCriteria());
	}
	
	public LandlordDetachedCriteria createLandlordCriteria() {
		return new LandlordDetachedCriteria(createCriteria("landlord"));
	}
	
	public TenantDetachedCriteria createTenantCriteria() {
		return new TenantDetachedCriteria(createCriteria("tenant"));
	}
	
	public LandlordEvaluation uniqueLandlordEvaluation(PersistentSession session) {
		return (LandlordEvaluation) super.createExecutableCriteria(session).uniqueResult();
	}
	
	public LandlordEvaluation[] listLandlordEvaluation(PersistentSession session) {
		List list = super.createExecutableCriteria(session).list();
		return (LandlordEvaluation[]) list.toArray(new LandlordEvaluation[list.size()]);
	}
}

