package com.example.coffeeservicedi.models.CoffeeBrewers;

import com.example.coffeeservicedi.interfaces.CoffeeBrewer;
import com.example.coffeeservicedi.models.Coffee;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;
import java.util.List;

@Slf4j
@Component
public class StrongWithSalt implements CoffeeBrewer {
    @Override
    public void brew(Coffee coffee, String coffeeName, int sugarLevel, boolean hasMilk, List<String> extraIngredients) {
        log.info("Brewing strong coffee with salt");
        coffee.setSugarLevel(sugarLevel);
        coffee.setHasMilk(hasMilk);
        coffee.setStrong(true);
        coffee.getIngredients().add("salt");
        coffee.setName(coffeeName);
        if(extraIngredients != null) {
            coffee.getIngredients().addAll(extraIngredients);
        }
        coffee.setCreatedAt(new Timestamp(System.currentTimeMillis()));
    }

    @Override
    public String getName() {
        return "StrongWithSalt";
    }
}
