package fr.app.lorcanaDex.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DecksController {

    @PostMapping("/")
    public void addDeckToBdd() {

    }

    @GetMapping("/")
    public void getDecksByUserName() {

    }

}
