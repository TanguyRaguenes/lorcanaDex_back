package fr.app.lorcanaDex.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/decks")
public class DecksController {

    @PostMapping("")
    public String addDeckToBdd() {

        System.out.println("Coucou du back");
        return "Coucou du back";
    }

    @GetMapping("")
    public String getDecksByUserName() {

        System.out.println("Coucou du back");
        return "Coucou du back";

    }

}
