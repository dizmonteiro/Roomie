package roomie.models.tenant;

/**
 * Licensee: vr(Universidade do Minho)
 * License Type: Academic
 */

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import org.springframework.format.annotation.DateTimeFormat;
import roomie.models.avatar.Avatar;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

public class Tenant implements Serializable {
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
	private String phone; // editable
	@NotNull
	@JsonFormat(pattern = "yyyy-MM-dd")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private java.util.Date birthDate;
	@NotNull
	private String sex; // editable
	@NotNull
	private String nif;
	@NotNull
	private String nationality; // editable
	@NotNull
	private String occupation; // editable
	@NotNull
	@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
	private String password; // editable
	
	public Tenant() {
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
