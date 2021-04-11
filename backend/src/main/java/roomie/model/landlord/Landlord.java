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
package roomie.model.landlord;

import roomie.model.ORMConstants;
import roomie.model.avatar.Avatar;
import roomie.model.house.HouseListCollection;

import java.io.Serializable;

public class Landlord implements Serializable {
	private int id;
	private Avatar avatar;
	private String name;
	private String email;
	private String username;
	private java.util.Date birthDate;
	private String sex;
	private String nif;
	private String address;
	private String password;
	private String phone;
	private java.util.List ORM_houses = new java.util.ArrayList();
	org.orm.util.ORMAdapter _ormAdapter = new org.orm.util.AbstractORMAdapter() {
		public java.util.List getList(int key) {
			return this_getList(key);
		}
		
	};
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
