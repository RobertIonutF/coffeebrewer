package com.example.coffeeservicedi.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@Configuration
@EnableMongoRepositories("com.example.coffeeservicedi.repositories")
public class ProjectConfig {

}
