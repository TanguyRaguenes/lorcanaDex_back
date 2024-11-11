package fr.app.lorcanaDex.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.app.lorcanaDex.bll.IRegistrationManager;

@RestController
@RequestMapping("/registration")
public class RegistrationController {

    private IRegistrationManager registrationManager;

    public RegistrationController(IRegistrationManager registrationManager) {
        this.registrationManager = registrationManager;
    }

    @PostMapping("")
    public Map<String, String> saveUser(@RequestBody Map<String, String> body) {
        System.out.println(body);
        return registrationManager.saveUser(body.get("illumineerName"), body.get("email"), body.get("password"));
        // Map<String, String> response = new HashMap<String, String>();
        // response.put("back response", body.toString());
        // return response;

    }

}
