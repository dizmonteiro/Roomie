package roomie.models.tenant;

/**
 * @author: Vasco Ramos
 * @created: 05/05/2021 - 10:32
 */

public class TenantRating {
	
	private double cleanliness;
	private double payment;
	private double care;
	private double tidiness;
	private double privacy;
	private double friendliness;
	
	public TenantRating() {
	}
	
	public double getCleanliness() {
		return cleanliness;
	}
	
	public void setCleanliness(double cleanliness) {
		this.cleanliness = cleanliness;
	}
	
	public double getPayment() {
		return payment;
	}
	
	public void setPayment(double payment) {
		this.payment = payment;
	}
	
	public double getCare() {
		return care;
	}
	
	public void setCare(double care) {
		this.care = care;
	}
	
	public double getTidiness() {
		return tidiness;
	}
	
	public void setTidiness(double tidiness) {
		this.tidiness = tidiness;
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
