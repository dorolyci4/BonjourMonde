package fr.socom.security;

import java.io.IOException;
import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;

import fr.socom.service.JwtUserDetailsService;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;


@Component
public class TokenUtil implements Serializable {

	private static final long serialVersionUID = -2550185165626007488L;
	
	
	@Value("${jwt.secret}")
	private String secret;
	
	public String generateToken(UserDetails userDetails) {
		Map<String, Object> claims = new HashMap<>();
	return Jwts.builder().setClaims(claims).setSubject(userDetails.getUsername()).setIssuedAt(new Date(System.currentTimeMillis()))
				.setExpiration(new Date(System.currentTimeMillis() + 360*1000)).signWith(SignatureAlgorithm.HS512, secret).compact();

	}


	public Boolean validateToken(String token, UserDetails userDetails) {
		
		return (getUsernameFromToken(token).equals(userDetails.getUsername()));
	}


	public String getUsernameFromToken(String token) {
		// TODO Auto-generated method stub
		final Claims claims =  Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody();
		 String username = claims.getSubject();
		 return username;
	}
}


