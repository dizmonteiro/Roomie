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
package roomie;

import org.hibernate.criterion.DetachedCriteria;
import org.orm.PersistentSession;
import org.orm.criteria.*;

import java.util.List;

public class TenantEvaluationDetachedCriteria extends AbstractORMDetachedCriteria {
	public final StringExpression comment;
	public final IntegerExpression evaluatorTenantId;
	public final AssociationExpression evaluatorTenant;
	public final IntegerExpression evaluatedTenantId;
	public final AssociationExpression evaluatedTenant;
	public final DoubleExpression rating;
	
	public TenantEvaluationDetachedCriteria() {
		super(roomie.TenantEvaluation.class, roomie.TenantEvaluationCriteria.class);
		comment = new StringExpression("comment", this.getDetachedCriteria());
		evaluatorTenantId = new IntegerExpression("evaluatorTenant.id", this.getDetachedCriteria());
		evaluatorTenant = new AssociationExpression("evaluatorTenant", this.getDetachedCriteria());
		evaluatedTenantId = new IntegerExpression("evaluatedTenant.id", this.getDetachedCriteria());
		evaluatedTenant = new AssociationExpression("evaluatedTenant", this.getDetachedCriteria());
		rating = new DoubleExpression("rating", this.getDetachedCriteria());
	}
	
	public TenantEvaluationDetachedCriteria(DetachedCriteria aDetachedCriteria) {
		super(aDetachedCriteria, roomie.TenantEvaluationCriteria.class);
		comment = new StringExpression("comment", this.getDetachedCriteria());
		evaluatorTenantId = new IntegerExpression("evaluatorTenant.id", this.getDetachedCriteria());
		evaluatorTenant = new AssociationExpression("evaluatorTenant", this.getDetachedCriteria());
		evaluatedTenantId = new IntegerExpression("evaluatedTenant.id", this.getDetachedCriteria());
		evaluatedTenant = new AssociationExpression("evaluatedTenant", this.getDetachedCriteria());
		rating = new DoubleExpression("rating", this.getDetachedCriteria());
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

