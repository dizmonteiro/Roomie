/**
 * "Visual Paradigm: DO NOT MODIFY THIS FILE!"
 * 
 * This is an automatic generated file. It will be regenerated every time 
 * you generate persistence class.
 * 
 * Modifying its content may cause the program not work, or your work may lost.
 */

/**
 * Licensee: vr(Universidade do Minho)
 * License Type: Academic
 */
package roomie.entities;

import java.io.Serializable;
public class TenantEvaluation implements Serializable {
	public TenantEvaluation() {
	}
	
	public boolean equals(Object aObj) {
		if (aObj == this)
			return true;
		if (!(aObj instanceof TenantEvaluation))
			return false;
		TenantEvaluation tenantevaluation = (TenantEvaluation)aObj;
		if (getEvaluatorTenant() == null) {
			if (tenantevaluation.getEvaluatorTenant() != null)
				return false;
		}
		else if (!getEvaluatorTenant().equals(tenantevaluation.getEvaluatorTenant()))
			return false;
		if (getEvaluatedTenant() == null) {
			if (tenantevaluation.getEvaluatedTenant() != null)
				return false;
		}
		else if (!getEvaluatedTenant().equals(tenantevaluation.getEvaluatedTenant()))
			return false;
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
	
	private roomie.entities.Tenant evaluatorTenant;
	
	private int evaluatorTenantId;
	
	private void setEvaluatorTenantId(int value) {
		this.evaluatorTenantId = value;
	}
	
	public int getEvaluatorTenantId() {
		return evaluatorTenantId;
	}
	
	private roomie.entities.Tenant evaluatedTenant;
	
	private int evaluatedTenantId;
	
	private void setEvaluatedTenantId(int value) {
		this.evaluatedTenantId = value;
	}
	
	public int getEvaluatedTenantId() {
		return evaluatedTenantId;
	}
	
	private double tidiness;
	
	private double cleanliness;
	
	private double privacy;
	
	private double friendliness;
	
	public void setTidiness(double value) {
		this.tidiness = value;
	}
	
	public double getTidiness() {
		return tidiness;
	}
	
	public void setCleanliness(double value) {
		this.cleanliness = value;
	}
	
	public double getCleanliness() {
		return cleanliness;
	}
	
	public void setPrivacy(double value) {
		this.privacy = value;
	}
	
	public double getPrivacy() {
		return privacy;
	}
	
	public void setFriendliness(double value) {
		this.friendliness = value;
	}
	
	public double getFriendliness() {
		return friendliness;
	}
	
	public void setEvaluatedTenant(roomie.entities.Tenant value) {
		this.evaluatedTenant = value;
	}
	
	public roomie.entities.Tenant getEvaluatedTenant() {
		return evaluatedTenant;
	}
	
	public void setEvaluatorTenant(roomie.entities.Tenant value) {
		this.evaluatorTenant = value;
	}
	
	public roomie.entities.Tenant getEvaluatorTenant() {
		return evaluatorTenant;
	}
	
	public String toString() {
		return String.valueOf(((getEvaluatorTenant() == null) ? "" : String.valueOf(getEvaluatorTenant().getORMID())) + " " + ((getEvaluatedTenant() == null) ? "" : String.valueOf(getEvaluatedTenant().getORMID())));
	}
	
}
