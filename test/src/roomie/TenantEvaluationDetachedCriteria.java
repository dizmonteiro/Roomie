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

public class TenantEvaluationDetachedCriteria extends AbstractORMDetachedCriteria {
	public final IntegerExpression evaluatorTenantId;
	public final AssociationExpression evaluatorTenant;
	public final IntegerExpression evaluatedTenantId;
	public final AssociationExpression evaluatedTenant;
	public final DoubleExpression tidiness;
	public final DoubleExpression cleanliness;
	public final DoubleExpression privacy;
	public final DoubleExpression friendliness;
	
	public TenantEvaluationDetachedCriteria() {
		super(roomie.TenantEvaluation.class, roomie.TenantEvaluationCriteria.class);
		evaluatorTenantId = new IntegerExpression("evaluatorTenant.id", this.getDetachedCriteria());
		evaluatorTenant = new AssociationExpression("evaluatorTenant", this.getDetachedCriteria());
		evaluatedTenantId = new IntegerExpression("evaluatedTenant.id", this.getDetachedCriteria());
		evaluatedTenant = new AssociationExpression("evaluatedTenant", this.getDetachedCriteria());
		tidiness = new DoubleExpression("tidiness", this.getDetachedCriteria());
		cleanliness = new DoubleExpression("cleanliness", this.getDetachedCriteria());
		privacy = new DoubleExpression("privacy", this.getDetachedCriteria());
		friendliness = new DoubleExpression("friendliness", this.getDetachedCriteria());
	}
	
	public TenantEvaluationDetachedCriteria(DetachedCriteria aDetachedCriteria) {
		super(aDetachedCriteria, roomie.TenantEvaluationCriteria.class);
		evaluatorTenantId = new IntegerExpression("evaluatorTenant.id", this.getDetachedCriteria());
		evaluatorTenant = new AssociationExpression("evaluatorTenant", this.getDetachedCriteria());
		evaluatedTenantId = new IntegerExpression("evaluatedTenant.id", this.getDetachedCriteria());
		evaluatedTenant = new AssociationExpression("evaluatedTenant", this.getDetachedCriteria());
		tidiness = new DoubleExpression("tidiness", this.getDetachedCriteria());
		cleanliness = new DoubleExpression("cleanliness", this.getDetachedCriteria());
		privacy = new DoubleExpression("privacy", this.getDetachedCriteria());
		friendliness = new DoubleExpression("friendliness", this.getDetachedCriteria());
	}
	
	public TenantDetachedCriteria createEvaluatorTenantCriteria() {
		return new TenantDetachedCriteria(createCriteria("evaluatorTenant"));
	}
	
	public TenantDetachedCriteria createEvaluatedTenantCriteria() {
		return new TenantDetachedCriteria(createCriteria("evaluatedTenant"));
	}
	
	public TenantEvaluation uniqueTenantEvaluation(PersistentSession session) {
		return (TenantEvaluation) super.createExecutableCriteria(session).uniqueResult();
	}
	
	public TenantEvaluation[] listTenantEvaluation(PersistentSession session) {
		List list = super.createExecutableCriteria(session).list();
		return (TenantEvaluation[]) list.toArray(new TenantEvaluation[list.size()]);
	}
}

