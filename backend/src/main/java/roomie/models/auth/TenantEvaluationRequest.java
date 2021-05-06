package roomie.models.auth;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * @author: Vasco Ramos
 * @created: 15/04/2021 - 13:54
 */

public class TenantEvaluationRequest implements Serializable {
	
	@NotNull
	private int houseId;
	@NotNull
	private double tidiness;
	@NotNull
	private double cleanliness;
	@NotNull
	private double privacy;
	@NotNull
	private double friendliness;
	
	public TenantEvaluationRequest() {
	
	}
	
	public int getHouseId() {
		return houseId;
	}
	
	public void setHouseId(int houseId) {
		this.houseId = houseId;
	}
	
	public double getTidiness() {
		return tidiness;
	}
	
	public void setTidiness(double tidiness) {
		this.tidiness = tidiness;
	}
	
	public double getCleanliness() {
		return cleanliness;
	}
	
	public void setCleanliness(double cleanliness) {
		this.cleanliness = cleanliness;
	}
	
	public double getPrivacy() {
		return privacy;
	}
	
	public void setPrivacy(double privacy) {
		this.privacy = privacy;
	}
	
	public double getFriendliness() {
		return friendliness;
	}
	
	public void setFriendliness(double friendliness) {
		this.friendliness = friendliness;
	}
}
