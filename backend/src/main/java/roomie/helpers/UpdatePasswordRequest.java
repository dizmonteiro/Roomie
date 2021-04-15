package roomie.helpers;

import javax.validation.constraints.NotNull;

/**
 * @author: Vasco Ramos
 * @created: 15/04/2021 - 13:54
 */

public class UpdatePasswordRequest {
	@NotNull
	private String oldPassword;
	@NotNull
	private String newPassword;
	
	public UpdatePasswordRequest() {
	
	}
	
	public String getOldPassword() {
		return oldPassword;
	}
	
	public void setOldPassword(String oldPassword) {
		this.oldPassword = oldPassword;
	}
	
	public String getNewPassword() {
		return newPassword;
	}
	
	public void setNewPassword(String newPassword) {
		this.newPassword = newPassword;
	}
}
