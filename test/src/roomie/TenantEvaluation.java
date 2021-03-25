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

import java.io.Serializable;

public class TenantEvaluation implements Serializable {
	private String comment;
	private roomie.Tenant evaluatorTenant;
	private int evaluatorTenantId;
	private roomie.Tenant evaluatedTenant;
	private int evaluatedTenantId;
	private double rating;
	
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
	
	public String getComment() {
		return comment;
	}
	
	public void setComment(String value) {
		this.comment = value;
	}
	
	public double getRating() {
		return rating;
	}
	
	public void setRating(double value) {
		this.rating = value;
	}
	
	public roomie.Tenant getEvaluatedTenant() {
		return evaluatedTenant;
	}
	
	public void setEvaluatedTenant(roomie.Tenant value) {
		this.evaluatedTenant = value;
	}
	
	public roomie.Tenant getEvaluatorTenant() {
		return evaluatorTenant;
	}
	
	public void setEvaluatorTenant(roomie.Tenant value) {
		this.evaluatorTenant = value;
	}
	
	public String toString() {
		return String.valueOf(((getEvaluatorTenant() == null) ? "" : String.valueOf(getEvaluatorTenant().getORMID())) + " " + ((getEvaluatedTenant() == null) ? "" : String.valueOf(getEvaluatedTenant().getORMID())));
	}
	
}
