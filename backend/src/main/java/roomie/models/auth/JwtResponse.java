package roomie.models.auth;

import java.io.Serializable;

/**
 * @author: Vasco Ramos
 * @created: 12/04/2021 - 11:21
 */

public class JwtResponse implements Serializable {
	private final String token;
	
	public JwtResponse(String token) {
		this.token = token;
	}
	
	public String getToken() {
		return this.token;
	}
}
