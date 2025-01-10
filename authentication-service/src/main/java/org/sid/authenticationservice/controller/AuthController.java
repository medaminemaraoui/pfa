package org.sid.authenticationservice.controller;

import org.sid.authenticationservice.dao.UserRepository;
import org.sid.authenticationservice.model.User;
import org.sid.authenticationservice.payload.JwtRequest;
import org.sid.authenticationservice.payload.JwtResponse;
import org.sid.authenticationservice.payload.SignUpRequest;
import org.sid.authenticationservice.service.AuthService;
import org.sid.authenticationservice.util.JWTUtil;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final AuthService authService;
    private final UserRepository userRepository;
    private final AuthenticationManager authenticationManager;
    private final JWTUtil jwtUtil;

    public AuthController(AuthService authService, UserRepository userRepository, AuthenticationManager authenticationManager, JWTUtil jwtUtil) {
        this.authService = authService;
        this.userRepository = userRepository;
        this.authenticationManager = authenticationManager;
        this.jwtUtil = jwtUtil;
    }

    // Endpoint for user signup
    @PostMapping("/signup")
    public ResponseEntity<?> signUp(@RequestBody SignUpRequest signUpRequest) {
        if (userRepository.existsByUsername(signUpRequest.getUsername())) {
            return ResponseEntity.badRequest().body("Error: Username is already taken!");
        }
        if (userRepository.existsByEmail(signUpRequest.getEmail())) {
            return ResponseEntity.badRequest().body("Error: Email is already in use!");
        }

        // Create and save user
        User savedUser = authService.signUp(
                new User(null,
                        signUpRequest.getUsername(),
                        signUpRequest.getPassword(),
                        signUpRequest.getEmail(),
                        signUpRequest.getRoles())
        );

        return ResponseEntity.ok("User registered successfully!");
    }

    // Endpoint for user login (authentication)
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody JwtRequest jwtRequest) {
        try {
            // Authenticate the user using authenticationManager
            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(jwtRequest.getUsername(), jwtRequest.getPassword())
            );

            // Set authentication in the SecurityContext
            SecurityContextHolder.getContext().setAuthentication(authentication);

            // Generate JWT token
            String token = jwtUtil.generateToken(authentication);

            // Return the JWT token as part of the response
            return ResponseEntity.ok(new JwtResponse(token));
        } catch (Exception e) {
            // Return Unauthorized status if there is an authentication error
            return ResponseEntity.status(401).body("Username or password is incorrect!");
        }
    }

}
