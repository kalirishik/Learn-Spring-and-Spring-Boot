package com.example.LearnSpringSecurity.util;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Component;

import java.nio.charset.StandardCharsets;
import java.security.Key;
import java.util.Date;

@Component
public class JwtUtil {
    private final String SECRET = "Learn Spring Security - JWT and Understand the JWT and Security Token";
    private final Long EXPIRATION_TIME = (long) (1000 * 60 * 60 ); // 1- second * 60 = 60 seconds / 60 minutes
    private final Key secretKey = Keys.hmacShaKeyFor(SECRET.getBytes(StandardCharsets.UTF_8)); // encrption algorithm - hmacShaKeyFor

    public String generateToken(String emailId){
        return Jwts.builder()
                .setSubject(emailId)
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis()+EXPIRATION_TIME))
                .signWith(secretKey, SignatureAlgorithm.HS256)
                .compact();
    }

    public String extractEmail(String token){
        return Jwts.parserBuilder()
                .setSigningKey(secretKey)
                .build()
                .parseClaimsJws(token)
                .getBody()
                .getSubject();
    }
    public boolean validateToken(String token){
        try{
            extractEmail(token);
            return true;
        }
        catch (Exception e){
            System.out.println(e.getMessage());
            return false;
        }

    }

}
