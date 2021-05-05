package roomie.services;

import org.orm.PersistentException;
import org.springframework.stereotype.Service;
import roomie.exception.ResourceNotFoundException;
import roomie.models.evaluation.TenantEvaluation;
import roomie.models.evaluation.TenantEvaluationDAO;
import roomie.models.house.House;
import roomie.models.rentHistory.RentHistory;
import roomie.models.rentHistory.RentHistoryDAO;
import roomie.models.tenant.Tenant;

import java.util.Date;


/**
 * @author: Vasco Ramos
 * @created: 14/04/2021 - 11:35
 */

@Service
public class EvaluationService {
	
	public TenantEvaluation create(Tenant evaluator, Tenant evaluated, double tidiness, double cleanliness, double privacy, double friendliness) throws PersistentException {
		TenantEvaluation tenantEvaluation = TenantEvaluationDAO.createTenantEvaluation();
		tenantEvaluation.setEvaluatorTenant(evaluator);
		tenantEvaluation.setEvaluatedTenant(evaluated);
		tenantEvaluation.setTidiness(tidiness);
		tenantEvaluation.setCleanliness(cleanliness);
		tenantEvaluation.setPrivacy(privacy);
		tenantEvaluation.setFriendliness(friendliness);
		TenantEvaluationDAO.save(tenantEvaluation);
		return tenantEvaluation;
	}
	
	public boolean wereRoommates(Tenant evaluator, Tenant evaluated, House house){
		try {
			RentHistory evaluatorRH = RentHistoryDAO.getRentHistoryByORMID(house, evaluator);
			RentHistory evaluatedRH = RentHistoryDAO.getRentHistoryByORMID(house, evaluated);
			return evaluatorRH != null &&
				   evaluatedRH != null &&
				   evaluatorRH.getHouseId() == evaluatedRH.getHouseId() &&
				   this.intersect(evaluatorRH.getbDate(),evaluatorRH.geteDate(),evaluatedRH.getbDate(),evaluatedRH.geteDate());
			
		} catch (PersistentException e) {
			return false;
		}
	}
	
	private boolean intersect(Date bdateA,Date edateA,Date bdateB,Date edateB){
		if(edateA == null) edateA = new Date();
		if(edateB == null) edateB = new Date();
		return (bdateA.getTime() <= edateB.getTime()) && (edateA.getTime() >= bdateB.getTime());
	}
}
