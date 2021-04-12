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
 */

/**
 * Licensee: vr(Universidade do Minho)
 * License Type: Academic
 */
package roomie.models.rentHistory;

import roomie.models.house.House;
import roomie.models.tenant.Tenant;

import java.io.Serializable;

public class RentHistory implements Serializable {
	private House house;
	private int houseId;
	private Tenant tenant;
	private int tenantId;
	private java.util.Date bDate;
	private java.util.Date eDate;
	
	public RentHistory() {
	}
	
	public boolean equals(Object aObj) {
		if (aObj == this) return true;
		if (!(aObj instanceof RentHistory)) return false;
		RentHistory renthistory = (RentHistory) aObj;
		if (getHouse() == null) {
			if (renthistory.getHouse() != null) return false;
		} else if (!getHouse().equals(renthistory.getHouse())) return false;
		if (getTenant() == null) {
			if (renthistory.getTenant() != null) return false;
		} else if (!getTenant().equals(renthistory.getTenant())) return false;
		return true;
	}
	
	public int hashCode() {
		int hashcode = 0;
		if (getHouse() != null) {
			hashcode = hashcode + (int) getHouse().getORMID();
		}
		if (getTenant() != null) {
			hashcode = hashcode + (int) getTenant().getORMID();
		}
		return hashcode;
	}
	
	public int getHouseId() {
		return houseId;
	}
	
	private void setHouseId(int value) {
		this.houseId = value;
	}
	
	public int getTenantId() {
		return tenantId;
	}
	
	private void setTenantId(int value) {
		this.tenantId = value;
	}
	
	public java.util.Date getbDate() {
		return bDate;
	}
	
	public void setbDate(java.util.Date value) {
		this.bDate = value;
	}
	
	public java.util.Date geteDate() {
		return eDate;
	}
	
	public void seteDate(java.util.Date value) {
		this.eDate = value;
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
	
	public void setEDate(java.util.Date eDate) {
		//TODO: Implement Method
		throw new UnsupportedOperationException();
	}
	
	public String toString() {
		return String.valueOf(((getHouse() == null) ? "" : String.valueOf(getHouse().getORMID())) + " " + ((getTenant() == null) ? "" : String.valueOf(getTenant().getORMID())));
	}
	
}
