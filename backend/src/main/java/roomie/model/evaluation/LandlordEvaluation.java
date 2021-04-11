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
package roomie.model.evaluation;

import roomie.model.landlord.Landlord;
import roomie.model.tenant.Tenant;

import java.io.Serializable;
public class LandlordEvaluation implements Serializable {
	public LandlordEvaluation() {
	}
	
	public boolean equals(Object aObj) {
		if (aObj == this)
			return true;
		if (!(aObj instanceof LandlordEvaluation))
			return false;
		LandlordEvaluation landlordevaluation = (LandlordEvaluation)aObj;
		if (getLandlord() == null) {
			if (landlordevaluation.getLandlord() != null)
				return false;
		}
		else if (!getLandlord().equals(landlordevaluation.getLandlord()))
			return false;
		if (getTenant() == null) {
			if (landlordevaluation.getTenant() != null)
				return false;
		}
		else if (!getTenant().equals(landlordevaluation.getTenant()))
			return false;
		return true;
	}
	
	public int hashCode() {
		int hashcode = 0;
		if (getLandlord() != null) {
			hashcode = hashcode + (int) getLandlord().getORMID();
		}
		if (getTenant() != null) {
			hashcode = hashcode + (int) getTenant().getORMID();
		}
		return hashcode;
	}
	
	private Landlord landlord;
	
	private int landlordId;
	
	private void setLandlordId(int value) {
		this.landlordId = value;
	}
	
	public int getLandlordId() {
		return landlordId;
	}
	
	private Tenant tenant;
	
	private int tenantId;
	
	private void setTenantId(int value) {
		this.tenantId = value;
	}
	
	public int getTenantId() {
		return tenantId;
	}
	
	private double cleanliness;
	
	private double payment;
	
	private double care;
	
	public void setCleanliness(double value) {
		this.cleanliness = value;
	}
	
	public double getCleanliness() {
		return cleanliness;
	}
	
	public void setPayment(double value) {
		this.payment = value;
	}
	
	public double getPayment() {
		return payment;
	}
	
	public void setCare(double value) {
		this.care = value;
	}
	
	public double getCare() {
		return care;
	}
	
	public void setLandlord(Landlord value) {
		this.landlord = value;
	}
	
	public Landlord getLandlord() {
		return landlord;
	}
	
	public void setTenant(Tenant value) {
		this.tenant = value;
	}
	
	public Tenant getTenant() {
		return tenant;
	}
	
	public String toString() {
		return String.valueOf(((getLandlord() == null) ? "" : String.valueOf(getLandlord().getORMID())) + " " + ((getTenant() == null) ? "" : String.valueOf(getTenant().getORMID())));
	}
	
}
