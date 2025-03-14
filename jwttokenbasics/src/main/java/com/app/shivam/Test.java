package com.app.shivam;

import java.security.Key;

import java.util.Date;
import java.util.concurrent.TimeUnit;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;

public class Test {

    public static void main(String[] args) {
        
        String secret = "TestAppOnesAMPLETestAppOnesAMPLE"; // Should be at least 32 characters for HMAC-SHA

        Key key = Keys.hmacShaKeyFor(secret.getBytes()); 

        String token = Jwts.builder()
                .setId("85858585") // user unique ID
                .setSubject("sample")
                .setIssuedAt(new Date(System.currentTimeMillis())) 
                .setExpiration(new Date(System.currentTimeMillis() + TimeUnit.MINUTES.toMillis(2)))
                .setIssuer("ASHOKIT") // token provider name
                .signWith(key, SignatureAlgorithm.HS256) // Correct way to sign
                .compact();
        
        System.out.println(token);
    
        Claims c = 
        Jwts.parser()
        .setSigningKey(secret.getBytes())
        .parseClaimsJws(token).getBody();
    
        
        System.out.println(c.getSubject());
        System.out.println(c.getIssuer());
        System.out.println(c.getExpiration());
    
    
    }
}
