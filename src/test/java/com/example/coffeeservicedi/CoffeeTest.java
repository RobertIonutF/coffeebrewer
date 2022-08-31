package com.example.coffeeservicedi;

import com.example.coffeeservicedi.models.Coffee;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CoffeeTest {
    private Coffee coffee;

    @BeforeEach
    public void setUp() {
        coffee = new Coffee();
    }

    @Test
    public void testCoffeeCreated() {
        assertNotNull(coffee);
    }

    @Test
    public void testCoffeeHasName() {
        coffee.setName("Coffee");
        assertEquals("Coffee", coffee.getName());
    }

    @Test
    public void testCoffeeHasIngredients() {
        coffee.getIngredients().add("Coffee");
        assertEquals(1, coffee.getIngredients().size());
    }

    @Test
    public void testCoffeeHasSugarLevel() {
        coffee.setSugarLevel(1);
        assertEquals(1, coffee.getSugarLevel());
    }

    @Test
    public void testCoffeeHasMilk() {
        coffee.setHasMilk(true);
        assertTrue(coffee.isHasMilk());
    }

    @Test
    public void testCoffeeHasStrong() {
        coffee.setStrong(true);
        assertTrue(coffee.isStrong());
    }

    @Test
    public void testCoffeeHasExtraIngredients() {
        coffee.getIngredients().add("Coffee");
        assertEquals(1, coffee.getIngredients().size());
    }

    @Test
    public void testCoffeeHaMultipleIngredients() {
        coffee.getIngredients().add("Mint");
        coffee.getIngredients().add("Salt");
        assertEquals(2, coffee.getIngredients().size());
    }

    @Test
    public void testCoffeeHasNoIngredients() {
        assertEquals(0, coffee.getIngredients().size());
    }

    @Test
    public void testCoffeeHasNoSugarLevel() {
        assertEquals(0, coffee.getSugarLevel());
    }

    @Test
    public void testCoffeeHasNoMilk() {
        assertFalse(coffee.isHasMilk());
    }

    @Test
    public void testCoffeeHasNoStrong() {
        assertFalse(coffee.isStrong());
    }
}
