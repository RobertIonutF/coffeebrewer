package com.example.coffeeservicedi.repositories;

import com.example.coffeeservicedi.controllers.CoffeeController;
import com.example.coffeeservicedi.models.Coffee;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CoffeeRepository extends MongoRepository<Coffee, String>, PagingAndSortingRepository<Coffee, String> {
    List<Coffee> getTopBySugarLevel(int sugarLevel, Pageable pageable);
}

