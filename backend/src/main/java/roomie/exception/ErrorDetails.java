package roomie.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @author: Vasco Ramos
 * @created: 12/04/2021 - 17:41
 */

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class ErrorDetails extends RuntimeException {
	public ErrorDetails(String message) {
		super(message);
	}
}