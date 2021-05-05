package roomie.services;

import org.orm.PersistentException;
import org.springframework.stereotype.Service;
import roomie.exception.ResourceNotFoundException;
import roomie.models.evaluation.LandlordEvaluation;
import roomie.models.evaluation.LandlordEvaluationDAO;
import roomie.models.evaluation.TenantEvaluation;
import roomie.models.evaluation.TenantEvaluationDAO;
import roomie.models.house.House;
import roomie.models.landlord.Landlord;
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
	
	public TenantEvaluation createTenantEvaluation(Tenant evaluator, Tenant evaluated, double tidiness, double cleanliness, double privacy, double friendliness) throws PersistentException {
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
	
	public LandlordEvaluation createTenantEvaluation(Landlord landlord, Tenant tenant, double cleanliness, double payment, double care) throws PersistentException {
		LandlordEvaluation landlordEvaluation = LandlordEvaluationDAO.createLandlordEvaluation();
		landlordEvaluation.setLandlord(landlord);
		landlordEvaluation.setTenant(tenant);
		landlordEvaluation.setCleanliness(cleanliness);
		landlordEvaluation.setPayment(payment);
		landlordEvaluation.setCare(care);
		LandlordEvaluationDAO.save(landlordEvaluation);
		return landlordEvaluation;
	}
}
