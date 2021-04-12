package roomie.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @author: Vasco Ramos
 * @created: 12/04/2021 - 17:42
 */

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends Exception {
	public ResourceNotFoundException(String message) {
		super(message);
	}
}