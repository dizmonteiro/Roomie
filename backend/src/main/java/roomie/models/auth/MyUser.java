package roomie.models.auth;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.io.Serializable;
import java.util.Collection;

/**
 * @author: Vasco Ramos
 * @created: 17/04/2021 - 13:50
 */

public class MyUser extends User implements Serializable {
	private int id;
	private String name;
	
	public MyUser(String username, String password, String name, int id, Collection<? extends GrantedAuthority> authorities) {
		super(username, password, authorities);
		this.name = name;
		this.id = id;
	}
	
	public String getType() {
		return super.getAuthorities().toArray()[0].toString().substring(5).toLowerCase();
	}
	
	@JsonIgnore
	@Override
	public Collection<GrantedAuthority> getAuthorities() {
		return super.getAuthorities();
	}
	
	@JsonIgnore
	@Override
	public boolean isEnabled() {
		return super.isEnabled();
	}
	
	@JsonIgnore
	@Override
	public boolean isAccountNonExpired() {
		return super.isAccountNonExpired();
	}
	
	@JsonIgnore
	@Override
	public boolean isAccountNonLocked() {
		return super.isAccountNonLocked();
	}
	
	@JsonIgnore
	@Override
	public boolean isCredentialsNonExpired() {
		return super.isCredentialsNonExpired();
	}
	
	@JsonIgnore
	@Override
	public String getPassword() {
		return super.getPassword();
	}
	
	@JsonProperty("email")
	@Override
	public String getUsername() {
		return super.getUsername();
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	
}
