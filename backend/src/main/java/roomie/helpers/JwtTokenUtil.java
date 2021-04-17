package roomie.helpers;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import roomie.models.auth.MyUser;

import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

/**
 * @author: Vasco Ramos
 * @created: 12/04/2021 - 10:52
 */

@Component
public class JwtTokenUtil implements Serializable {
	public static final long JWT_TOKEN_VALIDITY = 5 * 60 * 60;
	@Value("${jwt.secret}")
	private String JWT_TOKEN_SECRET;
	
	public String getUsernameFromToken(String token) {
		return getClaimFromToken(token, Claims::getSubject);
	}
	
	public Date getExpirationDateFromToken(String token) {
		return getClaimFromToken(token, Claims::getExpiration);
	}
	
	public <T> T getClaimFromToken(String token, Function<Claims, T> claimsResolver) {
		final Claims claims = getAllClaimsFromToken(token);
		return claimsResolver.apply(claims);
	}
	
	private Claims getAllClaimsFromToken(String token) {
		return Jwts.parser().setSigningKey(JWT_TOKEN_SECRET).parseClaimsJws(token).getBody();
	}
	
	private Boolean isTokenExpired(String token) {
		return getExpirationDateFromToken(token).before(new Date());
	}
	
	public String generateToken(MyUser userDetails) {
		Map<String, Object> claims = new HashMap<>();
		return doGenerateToken(claims, userDetails);
	}
	
	private String doGenerateToken(Map<String, Object> claims, MyUser user) {
		return Jwts.builder().setClaims(claims).setSubject(user.getUsername())
		           .setIssuedAt(new Date(System.currentTimeMillis())).claim("user", user)
		           .setExpiration(new Date(System.currentTimeMillis() + JWT_TOKEN_VALIDITY * 1000))
		           .signWith(SignatureAlgorithm.HS512, JWT_TOKEN_SECRET).compact();
	}
	
	public Boolean validateToken(String token, UserDetails userDetails) {
		final String username = getUsernameFromToken(token);
		return (userDetails != null && username.equals(userDetails.getUsername()) && !isTokenExpired(token));
	}
}
