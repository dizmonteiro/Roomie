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

public class LandlordEvaluation implements Serializable {
	private roomie.Landlord landlord;
	private int landlordId;
	private roomie.Tenant tenant;
	private int tenantId;
	private String comment;
	private double rating;
	
	public LandlordEvaluation() {
	}
	
	public boolean equals(Object aObj) {
		if (aObj == this) return true;
		if (!(aObj instanceof LandlordEvaluation)) return false;
		LandlordEvaluation landlordevaluation = (LandlordEvaluation) aObj;
		if (getLandlord() == null) {
			if (landlordevaluation.getLandlord() != null) return false;
		} else if (!getLandlord().equals(landlordevaluation.getLandlord())) return false;
		if (getTenant() == null) {
			if (landlordevaluation.getTenant() != null) return false;
		} else if (!getTenant().equals(landlordevaluation.getTenant())) return false;
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
	
	public int getLandlordId() {
		return landlordId;
	}
	
	private void setLandlordId(int value) {
		this.landlordId = value;
	}
	
	public int getTenantId() {
		return tenantId;
	}
	
	private void setTenantId(int value) {
		this.tenantId = value;
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
	
	public roomie.Landlord getLandlord() {
		return landlord;
	}
	
	public void setLandlord(roomie.Landlord value) {
		this.landlord = value;
	}
	
	public roomie.Tenant getTenant() {
		return tenant;
	}
	
	public void setTenant(roomie.Tenant value) {
		this.tenant = value;
	}
	
	public String toString() {
		return String.valueOf(((getLandlord() == null) ? "" : String.valueOf(getLandlord().getORMID())) + " " + ((getTenant() == null) ? "" : String.valueOf(getTenant().getORMID())));
	}
	
}
