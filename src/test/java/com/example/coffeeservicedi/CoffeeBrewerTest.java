package com.example.coffeeservicedi;

import com.example.coffeeservicedi.interfaces.CoffeeBrewer;
import com.example.coffeeservicedi.models.Coffee;
import com.example.coffeeservicedi.models.CoffeeBrewers.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CoffeeBrewerTest {
    private CoffeeBrewer coffeeBrewer;
    private Coffee coffee;

    @BeforeEach
    public void setUp() {
        coffee = new Coffee();
    }

    @Test
    public void testBrewForSoftWithCaramel() {
        coffeeBrewer = new SoftWithCaramel();
        coffeeBrewer.brew(coffee, "Coffee", 1, false, null);
        assertEquals("Coffee", coffee.getName());
        assertEquals(1, coffee.getSugarLevel());
        assertFalse(coffee.isHasMilk());
        assertFalse(coffee.isStrong());
        assertEquals(1, coffee.getIngredients().size());
        assertTrue(coffee.getIngredients().contains("caramel"));
        assertEquals("SoftWithCaramel", coffeeBrewer.getName());
    }

    @Test
    public void testBrewForSoftWithMint() {
        coffeeBrewer = new SoftWithMint();
        coffeeBrewer.brew(coffee, "Coffee", 1, false, null);
        assertEquals("Coffee", coffee.getName());
        assertEquals(1, coffee.getSugarLevel());
        assertFalse(coffee.isHasMilk());
        assertFalse(coffee.isStrong());
        assertEquals(1, coffee.getIngredients().size());
        assertTrue(coffee.getIngredients().contains("mint"));
        assertEquals("SoftWithMint", coffeeBrewer.getName());
    }

    @Test
    public void testBrewForSoftWithSalt() {
        coffeeBrewer = new SoftWithSalt();
        coffeeBrewer.brew(coffee, "Coffee", 1, false, null);
        assertEquals("Coffee", coffee.getName());
        assertEquals(1, coffee.getSugarLevel());
        assertFalse(coffee.isHasMilk());
        assertFalse(coffee.isStrong());
        assertEquals(1, coffee.getIngredients().size());
        assertTrue(coffee.getIngredients().contains("salt"));
        assertEquals("SoftWithSalt", coffeeBrewer.getName());
    }

    @Test
    public void testBrewForStrongWithCaramel() {
        coffeeBrewer = new StrongWithCaramel();
        coffeeBrewer.brew(coffee, "Coffee", 1, false, null);
        assertEquals("Coffee", coffee.getName());
        assertEquals(1, coffee.getSugarLevel());
        assertFalse(coffee.isHasMilk());
        assertTrue(coffee.isStrong());
        assertEquals(1, coffee.getIngredients().size());
        assertTrue(coffee.getIngredients().contains("caramel"));
        assertEquals("StrongWithCaramel", coffeeBrewer.getName());
    }

    @Test
    public void testBrewForStrongWithMint() {
        coffeeBrewer = new StrongWithMint();
        coffeeBrewer.brew(coffee, "Coffee", 1, false, null);
        assertEquals("Coffee", coffee.getName());
        assertEquals(1, coffee.getSugarLevel());
        assertFalse(coffee.isHasMilk());
        assertTrue(coffee.isStrong());
        assertEquals(1, coffee.getIngredients().size());
        assertTrue(coffee.getIngredients().contains("mint"));
        assertEquals("StrongWithMint", coffeeBrewer.getName());
    }

    @Test
    public void testBrewForStrongWithSalt() {
        coffeeBrewer = new StrongWithSalt();
        coffeeBrewer.brew(coffee, "Coffee", 1, false, null);
        assertEquals("Coffee", coffee.getName());
        assertEquals(1, coffee.getSugarLevel());
        assertFalse(coffee.isHasMilk());
        assertTrue(coffee.isStrong());
        assertEquals(1, coffee.getIngredients().size());
        assertTrue(coffee.getIngredients().contains("salt"));
        assertEquals("StrongWithSalt", coffeeBrewer.getName());
    }
}
