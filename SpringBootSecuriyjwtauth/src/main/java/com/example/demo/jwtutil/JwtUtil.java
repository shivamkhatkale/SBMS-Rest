package com.example.demo.jwtutil;

import java.sql.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;


@Component
public class JwtUtil {

	@Value("${app.secret}")
	private String secret;

	public String getUsername() {
		return getClaims(secret).getSubject();
	}
	
	
	public String generateToken(String subject) {
		Map<String, Object> claims = new HashMap<>();
		return generateToken(null, subject);
	}
	
	
	// print
	private Claims getClaims(String token) {
		return Jwts.parser()
				.setSigningKey(secret.getBytes())
				.parseClaimsJws(token).getBody();
	}
	
	public String generateToken(Map<String, Object> claims, String subject) {
		return Jwts.builder()
                .setClaims(claims) // usero unique ID
                .setSubject(subject)
                .setIssuedAt(new Date(System.currentTimeMillis())) 
                .setExpiration(new Date(System.currentTimeMillis() + TimeUnit.MINUTES.toMillis(2)))
                .setIssuer("ASHOKIT") // token provider name
                .signWith(SignatureAlgorithm.HS256,secret.getBytes()) // Correct way to sign
                .compact();
	}



}
