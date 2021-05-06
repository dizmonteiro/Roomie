package roomie.models.evaluation;

/**
 * Licensee: vr(Universidade do Minho)
 * License Type: Academic
 */

import roomie.models.tenant.Tenant;

import java.io.Serializable;

public class TenantEvaluation implements Serializable {
	private Tenant evaluatorTenant;
	private int evaluatorTenantId;
	private Tenant evaluatedTenant;
	private int evaluatedTenantId;
	private double tidiness;
	private double cleanliness;
	private double privacy;
	private double friendliness;
	
	public TenantEvaluation() {
	}
	
	public boolean equals(Object aObj) {
		if (aObj == this) return true;
		if (!(aObj instanceof TenantEvaluation)) return false;
		TenantEvaluation tenantevaluation = (TenantEvaluation) aObj;
		if (getEvaluatorTenant() == null) {
			if (tenantevaluation.getEvaluatorTenant() != null) return false;
		} else if (!getEvaluatorTenant().equals(tenantevaluation.getEvaluatorTenant())) return false;
		if (getEvaluatedTenant() == null) {
			if (tenantevaluation.getEvaluatedTenant() != null) return false;
		} else if (!getEvaluatedTenant().equals(tenantevaluation.getEvaluatedTenant())) return false;
		return true;
	}
	
	public int hashCode() {
		int hashcode = 0;
		if (getEvaluatorTenant() != null) {
			hashcode = hashcode + (int) getEvaluatorTenant().getORMID();
		}
		if (getEvaluatedTenant() != null) {
			hashcode = hashcode + (int) getEvaluatedTenant().getORMID();
		}
		return hashcode;
	}
	
	public int getEvaluatorTenantId() {
		return evaluatorTenantId;
	}
	
	private void setEvaluatorTenantId(int value) {
		this.evaluatorTenantId = value;
	}
	
	public int getEvaluatedTenantId() {
		return evaluatedTenantId;
	}
	
	private void setEvaluatedTenantId(int value) {
		this.evaluatedTenantId = value;
	}
	
	public double getTidiness() {
		return tidiness;
	}
	
	public void setTidiness(double value) {
		this.tidiness = value;
	}
	
	public double getCleanliness() {
		return cleanliness;
	}
	
	public void setCleanliness(double value) {
		this.cleanliness = value;
	}
	
	public double getPrivacy() {
		return privacy;
	}
	
	public void setPrivacy(double value) {
		this.privacy = value;
	}
	
	public double getFriendliness() {
		return friendliness;
	}
	
	public void setFriendliness(double value) {
		this.friendliness = value;
	}
	
	public Tenant getEvaluatedTenant() {
		return evaluatedTenant;
	}
	
	public void setEvaluatedTenant(Tenant value) {
		this.evaluatedTenant = value;
	}
	
	public Tenant getEvaluatorTenant() {
		return evaluatorTenant;
	}
	
	public void setEvaluatorTenant(Tenant value) {
		this.evaluatorTenant = value;
	}
	
	public String toString() {
		return String.valueOf(((getEvaluatorTenant() == null) ? "" : String
				.valueOf(getEvaluatorTenant().getORMID())) + " " + ((getEvaluatedTenant() == null) ? "" : String
				.valueOf(getEvaluatedTenant().getORMID())));
	}
	
}
