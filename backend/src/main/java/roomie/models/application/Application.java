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
 * <p>
 * Licensee: vr(Universidade do Minho)
 * License Type: Academic
 * <p>
 * Licensee: vr(Universidade do Minho)
 * License Type: Academic
 * <p>
 * Licensee: vr(Universidade do Minho)
 * License Type: Academic
 * <p>
 * Licensee: vr(Universidade do Minho)
 * License Type: Academic
 * <p>
 * Licensee: vr(Universidade do Minho)
 * License Type: Academic
 */

/**
 * Licensee: vr(Universidade do Minho)
 * License Type: Academic
 */
package roomie.models.application;

import roomie.models.house.House;
import roomie.models.tenant.Tenant;

import java.io.Serializable;

public class Application implements Serializable {
	private Tenant tenant;
	private int tenantId;
	private House house;
	private int houseId;
	private boolean toBeAssessed;
	private boolean accepted;
	
	public Application() {
	}
	
	public boolean equals(Object aObj) {
		if (aObj == this) return true;
		if (!(aObj instanceof Application)) return false;
		Application application = (Application) aObj;
		if (getTenant() == null) {
			if (application.getTenant() != null) return false;
		} else if (!getTenant().equals(application.getTenant())) return false;
		if (getHouse() == null) {
			if (application.getHouse() != null) return false;
		} else if (!getHouse().equals(application.getHouse())) return false;
		return true;
	}
	
	public int hashCode() {
		int hashcode = 0;
		if (getTenant() != null) {
			hashcode = hashcode + (int) getTenant().getORMID();
		}
		if (getHouse() != null) {
			hashcode = hashcode + (int) getHouse().getORMID();
		}
		return hashcode;
	}
	
	public int getTenantId() {
		return tenantId;
	}
	
	private void setTenantId(int value) {
		this.tenantId = value;
	}
	
	public int getHouseId() {
		return houseId;
	}
	
	private void setHouseId(int value) {
		this.houseId = value;
	}
	
	public boolean getToBeAssessed() {
		return toBeAssessed;
	}
	
	public void setToBeAssessed(boolean value) {
		this.toBeAssessed = value;
	}
	
	public boolean getAccepted() {
		return accepted;
	}
	
	public House getHouse() {
		return house;
	}
	
	public void setHouse(House value) {
		this.house = value;
	}
	
	public Tenant getTenant() {
		return tenant;
	}
	
	public void setTenant(Tenant value) {
		this.tenant = value;
	}
	
	public boolean hasBeenAssessed() {
		//TODO: Implement Method
		throw new UnsupportedOperationException();
	}
	
	public boolean isAccepted() {
		//TODO: Implement Method
		throw new UnsupportedOperationException();
	}
	
	public void setAccepted(boolean value) {
		this.accepted = value;
	}
	
	public String toString() {
		return String.valueOf(((getTenant() == null) ? "" : String
				.valueOf(getTenant().getORMID())) + " " + ((getHouse() == null) ? "" : String
				.valueOf(getHouse().getORMID())));
	}
	
}
