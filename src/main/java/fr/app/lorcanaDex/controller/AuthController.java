package fr.app.lorcanaDex.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.*;

import fr.app.lorcanaDex.dto.AuthRequest;
import fr.app.lorcanaDex.dto.AuthResponse;
import fr.app.lorcanaDex.security.JwtUtil;

@RestController
public class AuthController {

    private AuthenticationManager authenticationManager;
    private JwtUtil jwtUtil;

    public AuthController(AuthenticationManager authenticationManager, JwtUtil jwtUtil) {
        this.authenticationManager = authenticationManager;
        this.jwtUtil = jwtUtil;
    }

    @GetMapping("/")
    public String home() {
        return "Dans le back";
    }

    @PostMapping("/login")
    // @CrossOrigin(origins = "http://localhost:4200")
    public ResponseEntity<?> createAuthenticationToken(@RequestBody AuthRequest authRequest) {

        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(authRequest.getUsername(), authRequest.getPassword()));

            final String jwt = jwtUtil.generateToken(authRequest.getUsername());

            return ResponseEntity.ok(new AuthResponse(jwt));

        } catch (AuthenticationException e) {

            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Nom d'utilisateur ou mot de passe incorrect");

        }
    }
}