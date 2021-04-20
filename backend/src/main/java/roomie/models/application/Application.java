package roomie.models.application;

/**
 * Licensee: vr(Universidade do Minho)
 * License Type: Academic
 */

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.sun.istack.NotNull;
import io.swagger.v3.oas.annotations.Hidden;
import io.swagger.v3.oas.annotations.media.Schema;
import roomie.models.house.House;
import roomie.models.tenant.Tenant;

import java.io.Serializable;

public class Application implements Serializable {
	@JsonProperty(access = JsonProperty.Access.READ_ONLY)
	private Tenant tenant;
	@JsonIgnore
	private int tenantId;
	@JsonProperty(access = JsonProperty.Access.READ_ONLY)
	private House house;
	@NotNull
	@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
	private int houseId;
	@Schema(example = "false")
	private boolean toBeAssessed;
	@Schema(example = "false")
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
	
	public void setAccepted(boolean value) {
		this.accepted = value;
	}
	
	public String toString() {
		return String.valueOf(((getTenant() == null) ? "" : String
				.valueOf(getTenant().getORMID())) + " " + ((getHouse() == null) ? "" : String
				.valueOf(getHouse().getORMID())));
	}
	
}
