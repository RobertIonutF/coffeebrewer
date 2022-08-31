package com.example.coffeeservicedi.controllers;

import com.example.coffeeservicedi.exceptions.BrewerNameNotFound;
import com.example.coffeeservicedi.models.Coffee;
import com.example.coffeeservicedi.services.CoffeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/coffee")
public class CoffeeController {
    private final CoffeeService coffeeService;

    @Autowired
    public CoffeeController(CoffeeService coffeeService) {
        this.coffeeService = coffeeService;
    }

    @GetMapping("/brew")
    public ResponseEntity<Coffee> getCoffee(@RequestParam("brewer") String brewerName,
                                            @RequestParam("name") String name,
                                            @RequestParam int sugarLevel,
                                            @RequestParam("milk") boolean hasMilk,
                                            @RequestParam(name = "extra", required = false) List<String> ingredients)
            throws BrewerNameNotFound {
        return ResponseEntity.ok(coffeeService.brewCoffee(brewerName, name, sugarLevel, hasMilk, ingredients));
    }

    @GetMapping("/brewers")
    public ResponseEntity<String> getAllBrewerNames() {
        return ResponseEntity.ok(coffeeService.getAllBrewerNames().toString());
    }

    @GetMapping("/")
    public ResponseEntity<List<Coffee>> getAllCoffees(@RequestParam Integer page) {
        return ResponseEntity.ok(coffeeService.getAllCoffees(page).getContent());
    }
}
