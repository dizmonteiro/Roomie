package roomie.models.auth;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * @author: Vasco Ramos
 * @created: 15/04/2021 - 13:54
 */

public class LandlordEvaluationRequest implements Serializable {
	
	@NotNull
	private int houseId;
	@NotNull
	private double cleanliness;
	@NotNull
	private double payment;
	@NotNull
	private double care;
	
	public LandlordEvaluationRequest() {
	
	}
	
	public int getHouseId() {
		return houseId;
	}
	
	public void setHouseId(int houseId) {
		this.houseId = houseId;
	}
	
	public void setCleanliness(double cleanliness) {
		this.cleanliness = cleanliness;
	}
	
	public void setPayment(double payment) {
		this.payment = payment;
	}
	
	public void setCare(double care) {
		this.care = care;
	}
	
	public double getCleanliness() {
		return cleanliness;
	}
	
	public double getPayment() {
		return payment;
	}
	
	public double getCare() {
		return care;
	}
}
