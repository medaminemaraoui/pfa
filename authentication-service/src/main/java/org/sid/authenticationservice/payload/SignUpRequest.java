package org.sid.authenticationservice.payload;

import lombok.Data;

import java.util.Set;

@Data
public class SignUpRequest {
    private String username;
    private String email;
    private String password;
    private Set<String> roles; // Example: ["USER", "ADMIN"]
}
