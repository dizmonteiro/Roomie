package roomie.controllers;

import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.*;
import roomie.exception.ErrorDetails;
import roomie.helpers.JwtTokenUtil;
import roomie.models.auth.JwtRequest;
import roomie.models.auth.JwtResponse;
import roomie.models.auth.MyUser;
import roomie.services.MyUserDetailsService;

import javax.validation.Valid;

/**
 * @author: Vasco Ramos
 * @created: 12/04/2021 - 11:14
 */

@RestController
@RequestMapping("/auth")
public class AuthController {
	private final Log logger = LogFactory.getLog(this.getClass());
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Autowired
	private JwtTokenUtil jwtTokenUtil;
	
	@Autowired
	private MyUserDetailsService userDetailsService;
	
	@PostMapping("/login")
	@ApiResponse(responseCode = "200", content = @Content(mediaType = "application/json", schema = @Schema(implementation = JwtResponse.class)))
	public ResponseEntity<?> login(@Valid @RequestBody JwtRequest authenticationRequest) throws ErrorDetails {
		try {
			authenticate(authenticationRequest.getEmail(), authenticationRequest.getPassword());
			final MyUser userDetails = userDetailsService.loadUserByUsername(authenticationRequest.getEmail());
			final String token = jwtTokenUtil.generateToken(userDetails);
			return ResponseEntity.ok(new JwtResponse(token));
		} catch (Exception e) {
			logger.info(e);
			throw new ErrorDetails("Invalid Credentials");
		}
	}
	
	private void authenticate(String username, String password) {
		authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
	}
	
	@GetMapping("/logout")
	public ResponseEntity<?> logout() {
		return ResponseEntity.ok("Logged out successfully!");
	}
	
}
