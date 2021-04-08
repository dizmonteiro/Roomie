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
package roomie;

import java.io.Serializable;
public class Application implements Serializable {
	public Application() {
	}
	
	public boolean equals(Object aObj) {
		if (aObj == this)
			return true;
		if (!(aObj instanceof Application))
			return false;
		Application application = (Application)aObj;
		if (getTenant() == null) {
			if (application.getTenant() != null)
				return false;
		}
		else if (!getTenant().equals(application.getTenant()))
			return false;
		if (getHouse() == null) {
			if (application.getHouse() != null)
				return false;
		}
		else if (!getHouse().equals(application.getHouse()))
			return false;
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
	
	private roomie.Tenant tenant;
	
	private int tenantId;
	
	private void setTenantId(int value) {
		this.tenantId = value;
	}
	
	public int getTenantId() {
		return tenantId;
	}
	
	private roomie.House house;
	
	private int houseId;
	
	private void setHouseId(int value) {
		this.houseId = value;
	}
	
	public int getHouseId() {
		return houseId;
	}
	
	private boolean toBeAssessed;
	
	private boolean accepted;
	
	public void setToBeAssessed(boolean value) {
		this.toBeAssessed = value;
	}
	
	public boolean getToBeAssessed() {
		return toBeAssessed;
	}
	
	public void setAccepted(boolean value) {
		this.accepted = value;
	}
	
	public boolean getAccepted() {
		return accepted;
	}
	
	public void setHouse(roomie.House value) {
		this.house = value;
	}
	
	public roomie.House getHouse() {
		return house;
	}
	
	public void setTenant(roomie.Tenant value) {
		this.tenant = value;
	}
	
	public roomie.Tenant getTenant() {
		return tenant;
	}
	
	public boolean hasBeenAssessed() {
		//TODO: Implement Method
		throw new UnsupportedOperationException();
	}
	
	public boolean isAccepted() {
		//TODO: Implement Method
		throw new UnsupportedOperationException();
	}
	
	public String toString() {
		return String.valueOf(((getTenant() == null) ? "" : String.valueOf(getTenant().getORMID())) + " " + ((getHouse() == null) ? "" : String.valueOf(getHouse().getORMID())));
	}
	
}
