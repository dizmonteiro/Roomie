package roomie.models.auth;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * @author: Vasco Ramos
 * @created: 12/04/2021 - 11:19
 */

public class JwtRequest implements Serializable {
	@NotNull
	private String email;
	@NotNull
	private String password;
	
	public JwtRequest() {
	}
	
	public JwtRequest(String username, String password) {
		this.setEmail(username);
		this.setPassword(password);
	}
	
	public String getEmail() {
		return this.email;
	}
	
	public void setEmail(String username) {
		this.email = username;
	}
	
	public String getPassword() {
		return this.password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
}
