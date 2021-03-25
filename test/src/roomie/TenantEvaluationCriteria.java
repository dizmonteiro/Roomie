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

import org.hibernate.Criteria;
import org.orm.PersistentException;
import org.orm.PersistentSession;
import org.orm.criteria.*;

public class TenantEvaluationCriteria extends AbstractORMCriteria {
	public final StringExpression comment;
	public final IntegerExpression evaluatorTenantId;
	public final AssociationExpression evaluatorTenant;
	public final IntegerExpression evaluatedTenantId;
	public final AssociationExpression evaluatedTenant;
	public final DoubleExpression rating;
	
	public TenantEvaluationCriteria(Criteria criteria) {
		super(criteria);
		comment = new StringExpression("comment", this);
		evaluatorTenantId = new IntegerExpression("evaluatorTenant.id", this);
		evaluatorTenant = new AssociationExpression("evaluatorTenant", this);
		evaluatedTenantId = new IntegerExpression("evaluatedTenant.id", this);
		evaluatedTenant = new AssociationExpression("evaluatedTenant", this);
		rating = new DoubleExpression("rating", this);
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

