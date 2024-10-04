package fr.app.lorcanaDex.controller;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class AuthController {

    
    @GetMapping("show-home")
    public String showHome() {

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        System.out.println("User: " + auth.getName() + ", Roles: " + auth.getAuthorities().toString());

        return "/";
    }

    
}
