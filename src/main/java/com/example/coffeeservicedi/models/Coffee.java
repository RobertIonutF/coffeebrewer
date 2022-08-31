package com.example.coffeeservicedi.models;

import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Component
@Data
@Document(collection = "coffee")
public class Coffee {
    @MongoId
    private String id;
    private String name;
    private Set<String> ingredients = new HashSet<>();
    private int sugarLevel;
    private boolean hasMilk;
    private boolean isStrong;
    @CreatedDate
    private Date createdAt;
}
