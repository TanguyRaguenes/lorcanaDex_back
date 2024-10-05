package fr.app.lorcanaDex.dto;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import java.nio.charset.StandardCharsets;

import java.security.Key;
import java.util.Date;

@Component
public class JwtUtil {

    private final Key secretKey = Keys.secretKeyFor(SignatureAlgorithm.HS256); //
    // Génération de clé sécurisée

    // private final String secretKeyString =
    // "your-very-secure-and-long-secret-key-32-chars";
    // private final Key secretKey =
    // Keys.hmacShaKeyFor(secretKeyString.getBytes(StandardCharsets.UTF_8));

    public String generateToken(String username) {
        return Jwts.builder()
                .setSubject(username)
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 30)) // Token valide 30 minutes
                .signWith(secretKey)
                .compact();
    }

    // public Boolean validateToken(String token, String username) {
    // final String extractedUsername = extractUsername(token);
    // return (extractedUsername.equals(username) && !isTokenExpired(token));
    // }

    public Boolean validateToken(String token, UserDetails userDetails) {
        final String extractedUsername = extractUsername(token);
        return (extractedUsername.equals(userDetails.getUsername()) &&
                !isTokenExpired(token));
    }

    private Boolean isTokenExpired(String token) {
        return extractExpiration(token).before(new Date());
    }

    public String extractUsername(String token) {
        return Jwts.parserBuilder().setSigningKey(secretKey).build().parseClaimsJws(token).getBody().getSubject();
    }

    private Date extractExpiration(String token) {
        return Jwts.parserBuilder().setSigningKey(secretKey).build().parseClaimsJws(token).getBody().getExpiration();
    }
}