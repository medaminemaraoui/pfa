package org.sid.authenticationservice.util;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class JWTUtil {

    // Secret key used to sign the JWT token (secure this key in a real application)
    private final String SECRET_KEY = "mySecretKeyForJWT";

    // Token expiration time in milliseconds (e.g., 24 hours = 86400000 ms)
    private final long EXPIRATION_TIME = 24 * 60 * 60 * 1000;

    /**
     * Generates a JWT token for the authenticated user.
     *
     * @param authentication the authentication object containing user details
     * @return the generated JWT token
     */
    public String generateToken(Authentication authentication) {
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();

        return Jwts.builder()
                .setSubject(userDetails.getUsername()) // The "subject" claim is typically the username or user ID
                .setIssuedAt(new Date()) // Issue timestamp
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME)) // Expiration time
                .signWith(SignatureAlgorithm.HS512, SECRET_KEY) // Sign the token with the secret key
                .compact();
    }

    /**
     * Extracts the username (subject) from the token.
     *
     * @param token the JWT token
     * @return the username from the token
     */
    public String extractUsername(String token) {
        return Jwts.parser()
                .setSigningKey(SECRET_KEY)
                .parseClaimsJws(token)
                .getBody()
                .getSubject();
    }

    /**
     * Validates the given JWT token against the user details.
     *
     * @param token       the JWT token
     * @param userDetails the user details to validate against
     * @return true if the token is valid, false otherwise
     */
    public boolean validateToken(String token, UserDetails userDetails) {
        String username = extractUsername(token);
        return username.equals(userDetails.getUsername()) && !isTokenExpired(token);
    }

    /**
     * Checks if the JWT token is expired.
     *
     * @param token the JWT token
     * @return true if the token is expired, false otherwise
     */
    private boolean isTokenExpired(String token) {
        Date expiration = Jwts.parser()
                .setSigningKey(SECRET_KEY)
                .parseClaimsJws(token)
                .getBody()
                .getExpiration();

        return expiration.before(new Date());
    }
}
