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
package roomie.model.rentHistory;

import roomie.model.house.House;
import roomie.model.tenant.Tenant;

import java.io.Serializable;
public class RentHistory implements Serializable {
	public RentHistory() {
	}
	
	public boolean equals(Object aObj) {
		if (aObj == this)
			return true;
		if (!(aObj instanceof RentHistory))
			return false;
		RentHistory renthistory = (RentHistory)aObj;
		if (getHouse() == null) {
			if (renthistory.getHouse() != null)
				return false;
		}
		else if (!getHouse().equals(renthistory.getHouse()))
			return false;
		if (getTenant() == null) {
			if (renthistory.getTenant() != null)
				return false;
		}
		else if (!getTenant().equals(renthistory.getTenant()))
			return false;
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
	
	private House house;
	
	private int houseId;
	
	private void setHouseId(int value) {
		this.houseId = value;
	}
	
	public int getHouseId() {
		return houseId;
	}
	
	private Tenant tenant;
	
	private int tenantId;
	
	private void setTenantId(int value) {
		this.tenantId = value;
	}
	
	public int getTenantId() {
		return tenantId;
	}
	
	private java.util.Date bDate;
	
	private java.util.Date eDate;
	
	public void setbDate(java.util.Date value) {
		this.bDate = value;
	}
	
	public java.util.Date getbDate() {
		return bDate;
	}
	
	public void seteDate(java.util.Date value) {
		this.eDate = value;
	}
	
	public java.util.Date geteDate() {
		return eDate;
	}
	
	public void setHouse(House value) {
		this.house = value;
	}
	
	public House getHouse() {
		return house;
	}
	
	public void setTenant(Tenant value) {
		this.tenant = value;
	}
	
	public Tenant getTenant() {
		return tenant;
	}
	
	public void setEDate(java.util.Date eDate) {
		//TODO: Implement Method
		throw new UnsupportedOperationException();
	}
	
	public String toString() {
		return String.valueOf(((getHouse() == null) ? "" : String.valueOf(getHouse().getORMID())) + " " + ((getTenant() == null) ? "" : String.valueOf(getTenant().getORMID())));
	}
	
}