package roomie.models.auth;

import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * @author: Vasco Ramos
 * @created: 15/04/2021 - 13:54
 */

public class AcceptRejectApplication implements Serializable {
	@NotNull
	private int tenantId;
	@NotNull
	private boolean accept;
	
	public AcceptRejectApplication() {
	
	}
	
	public int getTenantId() {
		return tenantId;
	}
	
	public boolean isAccept() {
		return accept;
	}
	
	public void setTenantId(int tenantId) {
		this.tenantId = tenantId;
	}
	
	public void setAccept(boolean accept) {
		this.accept = accept;
	}
}
