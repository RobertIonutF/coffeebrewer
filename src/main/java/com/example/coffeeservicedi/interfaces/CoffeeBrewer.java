package com.example.coffeeservicedi.interfaces;

import com.example.coffeeservicedi.models.Coffee;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface CoffeeBrewer {
    void brew(Coffee coffee, String coffeeName, int sugarLevel, boolean hasMilk, List<String> extraIngredients);
    String getName();
}
