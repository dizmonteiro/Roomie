package roomie.models.landlord;

/**
 * Licensee: vr(Universidade do Minho)
 * License Type: Academic
 */

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import org.springframework.format.annotation.DateTimeFormat;
import roomie.models.ORMConstants;
import roomie.models.avatar.Avatar;
import roomie.models.house.HouseListCollection;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

public class Landlord implements Serializable {
	@Schema(hidden = true)
	private int id;
	@JsonIgnore
	private Avatar avatar; // editable
	@NotNull
	private String name; // editable
	@NotNull
	private String email;
	@NotNull
	private String username; // editable
	@NotNull
	@JsonFormat(pattern = "yyyy-MM-dd")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private java.util.Date birthDate;
	@NotNull
	private String sex; // editable
	@NotNull
	private String nif;
	@NotNull
	private String address; // editable
	@NotNull
	@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
	private String password; // editable
	@NotNull
	private String phone; // editable
	private java.util.List ORM_houses = new java.util.ArrayList();
	org.orm.util.ORMAdapter _ormAdapter = new org.orm.util.AbstractORMAdapter() {
		public java.util.List getList(int key) {
			return this_getList(key);
		}
		
	};
	@JsonIgnore
	public final HouseListCollection houses = new HouseListCollection(this, _ormAdapter, ORMConstants.KEY_LANDLORD_HOUSES, ORMConstants.KEY_MUL_ONE_TO_MANY);
	
	public Landlord() {
	}
	
	private java.util.List this_getList(int key) {
		if (key == ORMConstants.KEY_LANDLORD_HOUSES) {
			return ORM_houses;
		}
		
		return null;
	}
	
	public int getId() {
		return id;
	}
	
	private void setId(int value) {
		this.id = value;
	}
	
	@JsonIgnore
	public int getORMID() {
		return getId();
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String value) {
		this.name = value;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String value) {
		this.email = value;
	}
	
	public String getUsername() {
		return username;
	}
	
	public void setUsername(String value) {
		this.username = value;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String value) {
		this.password = value;
	}
	
	public String getPhone() {
		return phone;
	}
	
	public void setPhone(String value) {
		this.phone = value;
	}
	
	public java.util.Date getBirthDate() {
		return birthDate;
	}
	
	public void setBirthDate(java.util.Date value) {
		this.birthDate = value;
	}
	
	public String getSex() {
		return sex;
	}
	
	public void setSex(String value) {
		this.sex = value;
	}
	
	public String getNif() {
		return nif;
	}
	
	public void setNif(String value) {
		this.nif = value;
	}
	
	public String getAddress() {
		return address;
	}
	
	public void setAddress(String value) {
		this.address = value;
	}
	
	@JsonIgnore
	private java.util.List getORM_Houses() {
		return ORM_houses;
	}
	
	private void setORM_Houses(java.util.List value) {
		this.ORM_houses = value;
	}
	
	public Avatar getAvatar() {
		return avatar;
	}
	
	public void setAvatar(Avatar value) {
		this.avatar = value;
	}
	
	public String toString() {
		return String.valueOf(getId());
	}
	
}
