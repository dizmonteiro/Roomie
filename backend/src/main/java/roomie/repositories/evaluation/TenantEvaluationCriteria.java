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
package roomie.repositories.evaluation;

import org.hibernate.Criteria;
import org.orm.PersistentException;
import org.orm.PersistentSession;
import org.orm.criteria.AbstractORMCriteria;
import org.orm.criteria.AssociationExpression;
import org.orm.criteria.DoubleExpression;
import org.orm.criteria.IntegerExpression;
import roomie.models.evaluation.TenantEvaluation;
import roomie.repositories.RoomiePersistentManager;
import roomie.repositories.tenant.TenantCriteria;

public class TenantEvaluationCriteria extends AbstractORMCriteria {
	public final IntegerExpression evaluatorTenantId;
	public final AssociationExpression evaluatorTenant;
	public final IntegerExpression evaluatedTenantId;
	public final AssociationExpression evaluatedTenant;
	public final DoubleExpression tidiness;
	public final DoubleExpression cleanliness;
	public final DoubleExpression privacy;
	public final DoubleExpression friendliness;
	
	public TenantEvaluationCriteria(Criteria criteria) {
		super(criteria);
		evaluatorTenantId = new IntegerExpression("evaluatorTenant.id", this);
		evaluatorTenant = new AssociationExpression("evaluatorTenant", this);
		evaluatedTenantId = new IntegerExpression("evaluatedTenant.id", this);
		evaluatedTenant = new AssociationExpression("evaluatedTenant", this);
		tidiness = new DoubleExpression("tidiness", this);
		cleanliness = new DoubleExpression("cleanliness", this);
		privacy = new DoubleExpression("privacy", this);
		friendliness = new DoubleExpression("friendliness", this);
	}
	
	public TenantEvaluationCriteria(PersistentSession session) {
		this(session.createCriteria(TenantEvaluation.class));
	}
	
	public TenantEvaluationCriteria() throws PersistentException {
		this(RoomiePersistentManager.instance().getSession());
	}
	
	public TenantCriteria createEvaluatorTenantCriteria() {
		return new TenantCriteria(createCriteria("evaluatorTenant"));
	}
	
	public TenantCriteria createEvaluatedTenantCriteria() {
		return new TenantCriteria(createCriteria("evaluatedTenant"));
	}
	
	public TenantEvaluation uniqueTenantEvaluation() {
		return (TenantEvaluation) super.uniqueResult();
	}
	
	public TenantEvaluation[] listTenantEvaluation() {
		java.util.List list = super.list();
		return (TenantEvaluation[]) list.toArray(new TenantEvaluation[list.size()]);
	}
}

