package com.agent47.booklibraryapplication.configuration;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import lombok.Data;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.function.Function;

@Service
public class JwtService {
    private static final String SECRET_KEY="dwl96nGR/ae1WgcncFKjW8M6hnUFaZkEUZLgrD8eaRFcFzCqX+q7tR+bL30WiF/y";
    private Key getSigningKey(){
        byte[] keyBytes = Decoders.BASE64.decode(SECRET_KEY);
        return Keys.hmacShaKeyFor(keyBytes);
    }
    private Claims extractClaims(String token){
        return Jwts.parserBuilder()
                .setSigningKey(getSigningKey())
                .build()
                .parseClaimsJws(token)
                .getBody();
    }
    public  <T> T extractClaim(String token, Function<Claims,T> claimextractor){
        Claims claims = extractClaims(token);
        return claimextractor.apply(claims);

    }
    private Date extractExpiration(String token){
        return extractClaim(token,Claims::getExpiration);
    }
    private Boolean isExpired(String token){
        Date expiration = extractExpiration(token);
        return expiration.before(new Date());
    }
    public String extractUserName(String token){
        return extractClaim(token,Claims::getSubject);
    }
    public Boolean isTokenValid(String token, UserDetails userDetails){
        String username= extractUserName(token);
        return !isExpired(token)&& (username.equals(userDetails.getUsername()));
    }
    public String generateToken(UserDetails userDetails){
        Map<String, Objects> claims = new HashMap<>();
        return Jwts
                .builder()
                .setClaims(claims)
                .setSubject(userDetails.getUsername())
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis()+1000*60*60*24))
                .signWith(getSigningKey(), SignatureAlgorithm.HS256)
                .compact();
    }

}
