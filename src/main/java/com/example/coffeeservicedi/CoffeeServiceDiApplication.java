package com.example.coffeeservicedi;

import com.example.coffeeservicedi.interfaces.CoffeeBrewer;
import com.example.coffeeservicedi.models.Coffee;
import com.example.coffeeservicedi.models.CoffeeBrewers.SoftWithSalt;
import com.example.coffeeservicedi.models.CoffeeBrewers.StrongWithCaramel;
import com.example.coffeeservicedi.models.CoffeeBrewers.StrongWithMint;
import com.example.coffeeservicedi.repositories.CoffeeRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
@Slf4j
public class CoffeeServiceDiApplication {

    private final CoffeeRepository coffeeRepository;

    @Autowired
    public CoffeeServiceDiApplication(CoffeeRepository coffeeRepository) {
        this.coffeeRepository = coffeeRepository;
    }

    public static void main(String[] args) {
        SpringApplication.run(CoffeeServiceDiApplication.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner() {
        return args -> {
            log.info("Creating coffee");
            List<CoffeeBrewer> coffeeBrewers = new ArrayList<>();
            coffeeBrewers.add(new StrongWithMint());
            coffeeBrewers.add(new StrongWithCaramel());
            coffeeBrewers.add(new SoftWithSalt());

            coffeeBrewers.forEach(coffeeBrewer -> {
                for(int i = 0; i < 10; i++) {
                    log.info("Brewing coffee with {}", coffeeBrewer.getName());
                    Coffee coffee = new Coffee();
                    coffeeBrewer.brew(coffee, coffeeBrewer.getName() + " " + i, 2, false, null);
                    coffeeRepository.save(coffee);
                    log.info("Coffee brewed: {}", coffee);
                }
            });
        };
    }
}
