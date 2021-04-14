package roomie.repositories.evaluation;

/**
 * Licensee: vr(Universidade do Minho)
 * License Type: Academic
 */

import org.hibernate.Criteria;
import org.orm.PersistentException;
import org.orm.PersistentSession;
import org.orm.criteria.AbstractORMCriteria;
import org.orm.criteria.AssociationExpression;
import org.orm.criteria.DoubleExpression;
import org.orm.criteria.IntegerExpression;
import roomie.models.RoomiePersistentManager;
import roomie.models.evaluation.LandlordEvaluation;
import roomie.repositories.landlord.LandlordCriteria;
import roomie.repositories.tenant.TenantCriteria;

public class LandlordEvaluationCriteria extends AbstractORMCriteria {
	public final IntegerExpression landlordId;
	public final AssociationExpression landlord;
	public final IntegerExpression tenantId;
	public final AssociationExpression tenant;
	public final DoubleExpression cleanliness;
	public final DoubleExpression payment;
	public final DoubleExpression care;
	
	public LandlordEvaluationCriteria(Criteria criteria) {
		super(criteria);
		landlordId = new IntegerExpression("landlord.id", this);
		landlord = new AssociationExpression("landlord", this);
		tenantId = new IntegerExpression("tenant.id", this);
		tenant = new AssociationExpression("tenant", this);
		cleanliness = new DoubleExpression("cleanliness", this);
		payment = new DoubleExpression("payment", this);
		care = new DoubleExpression("care", this);
	}
	
	public LandlordEvaluationCriteria(PersistentSession session) {
		this(session.createCriteria(LandlordEvaluation.class));
	}
	
	public LandlordEvaluationCriteria() throws PersistentException {
		this(RoomiePersistentManager.instance().getSession());
	}
	
	public LandlordCriteria createLandlordCriteria() {
		return new LandlordCriteria(createCriteria("landlord"));
	}
	
	public TenantCriteria createTenantCriteria() {
		return new TenantCriteria(createCriteria("tenant"));
	}
	
	public LandlordEvaluation uniqueLandlordEvaluation() {
		return (LandlordEvaluation) super.uniqueResult();
	}
	
	public LandlordEvaluation[] listLandlordEvaluation() {
		java.util.List list = super.list();
		return (LandlordEvaluation[]) list.toArray(new LandlordEvaluation[list.size()]);
	}
}

