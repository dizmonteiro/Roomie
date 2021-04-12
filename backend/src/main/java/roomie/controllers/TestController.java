package roomie.controllers;

/**
 * @author: Vasco Ramos
 * @created: 12/04/2021 - 16:27
 */

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class TestController {
	
	@PreAuthorize("hasRole('TENANT')")
	@GetMapping
	public String test() {
		return "Hello";
	}
}
