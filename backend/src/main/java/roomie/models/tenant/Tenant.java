package roomie.models.tenant;

/**
 * Licensee: vr(Universidade do Minho)
 * License Type: Academic
 */

import roomie.models.avatar.Avatar;

import java.io.Serializable;

public class Tenant implements Serializable {
	private int id;
	private Avatar avatar;
	private String name;
	private String email;
	private String username;
	private String phone;
	private java.util.Date birthDate;
	private String sex;
	private String nif;
	private String nationality;
	private String occupation;
	private String password;
	
	public Tenant() {
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
	
	public String getNationality() {
		return nationality;
	}
	
	public void setNationality(String value) {
		this.nationality = value;
	}
	
	public String getOccupation() {
		return occupation;
	}
	
	public void setOccupation(String value) {
		this.occupation = value;
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
