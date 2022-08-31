package com.example.coffeeservicedi.services;

import com.example.coffeeservicedi.exceptions.BrewerNameNotFound;
import com.example.coffeeservicedi.interfaces.CoffeeBrewer;
import com.example.coffeeservicedi.models.Coffee;
import com.example.coffeeservicedi.repositories.CoffeeRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class CoffeeService {
    private final List<CoffeeBrewer> coffeeBrewerList;
    private final CoffeeRepository coffeeRepository;

    @Autowired
    public CoffeeService(List<CoffeeBrewer> coffeeBrewerList, CoffeeRepository coffeeRepository) {
        this.coffeeBrewerList = coffeeBrewerList;
        this.coffeeRepository = coffeeRepository;
    }

    public List<String> getAllBrewerNames() {
        return coffeeBrewerList.stream().map(CoffeeBrewer::getName).toList();
    }

    public Coffee brewCoffee(String coffeeBrewerName, String coffeeName, int sugarLevel, boolean hasMilk, List<String> extraIngredients) throws BrewerNameNotFound {
        Coffee coffee = new Coffee();
        coffeeBrewerList.stream()
                .filter(coffeeBrewer -> coffeeBrewer.getName().equals(coffeeBrewerName))
                .findFirst()
                .orElseThrow(() -> new BrewerNameNotFound("Brewer not found"))
                .brew(coffee, coffeeName, sugarLevel, hasMilk, extraIngredients);
        coffeeRepository.save(coffee);
        return coffee;
    }

    public Page<Coffee> getAllCoffees(int page) {
        Pageable pageable = PageRequest.of(page, 10, Sort.by("createdAt").descending());
        return coffeeRepository.findAll(pageable);
    }
}
