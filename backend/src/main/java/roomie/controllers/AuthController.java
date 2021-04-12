package roomie.controllers;

import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;
import roomie.exception.ErrorDetails;
import roomie.helpers.JwtTokenUtil;
import roomie.models.auth.JwtRequest;
import roomie.models.auth.JwtResponse;
import roomie.services.MyUserDetailsService;

/**
 * @author: Vasco Ramos
 * @created: 12/04/2021 - 11:14
 */

@RestController
@RequestMapping("/auth")
public class AuthController {
	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Autowired
	private JwtTokenUtil jwtTokenUtil;
	
	@Autowired
	private MyUserDetailsService userDetailsService;
	
	@PostMapping("/login")
	@ApiResponse(responseCode = "200", content = @Content(mediaType = "application/json", schema = @Schema(implementation = JwtResponse.class)))
	public ResponseEntity<?> login(@RequestBody JwtRequest authenticationRequest) throws ErrorDetails {
		try {
			authenticate(authenticationRequest.getEmail(), authenticationRequest.getPassword());
			final UserDetails userDetails = userDetailsService.loadUserByUsername(authenticationRequest.getEmail());
			final String token = jwtTokenUtil.generateToken(userDetails);
			return ResponseEntity.ok(new JwtResponse(token));
		} catch (Exception e) {
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
