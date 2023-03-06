package com.cruelkid.guitarcloudapp.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class GuitarsController {

    @GetMapping("/guitars")
    public List<String> getGuitars() {
        return List.of("Schecter", "B.C. Rich", "Cort", "Jackson");
    }

}
