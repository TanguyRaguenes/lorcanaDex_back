package fr.app.lorcanaDex.controller;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.app.lorcanaDex.security.JwtUtil;
import java.util.Map;
import java.util.HashMap;

@RestController
@RequestMapping("auth")
public class AuthController {

    private AuthenticationManager authenticationManager;
    private JwtUtil jwtUtil;

    public AuthController(AuthenticationManager authenticationManager, JwtUtil jwtUtil) {
        this.authenticationManager = authenticationManager;
        this.jwtUtil = jwtUtil;
    }

    @PostMapping("")
    public Map<String, String> authentication(@RequestBody Map<String, String> requestBody) {

        Map<String, String> response = new HashMap<>();

        final String username = requestBody.get("username");
        final String password = requestBody.get("password");

        if (username != null && password != null) {
            try {

                System.out.println(username + " " + password);

                authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
                String jwt = jwtUtil.generateToken(username);
                response.put("token", jwt);
                response.put("username", username);

            } catch (Exception e) {
                response.put("error", "authentication fail");
                System.out.println(e);
            }
        } else {
            response.put("error", "username and/or password are null");
        }

        System.out.println(response);
        return response;
    }
}