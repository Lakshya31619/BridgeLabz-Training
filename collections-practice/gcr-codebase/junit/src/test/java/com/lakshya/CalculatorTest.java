package com.lakshya;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
class CalculatorTest {
    private final Calculator calculator = new Calculator();
    @Test
    void testAdd() {
        assertEquals(5, calculator.add(2, 3)); 
        assertEquals(-1, calculator.add(2, -3));
    }
    @Test 
    void testSubtract() {
        assertEquals(1, calculator.subtract(3, 2));
        assertEquals(5, calculator.subtract(2, -3));
    }
    @Test
    void testMultiply() {
        assertEquals(6, calculator.multiply(2, 3));
        assertEquals(0, calculator.multiply(5, 0));
    }
    @Test
    void testDivide() {
        assertEquals(2, calculator.divide(6, 3));
    }
    @Test
    void testDivideByZero() {
        Exception exception = assertThrows(
                ArithmeticException.class,
                () -> calculator.divide(10, 0)
        );
        assertEquals("Division by zero is not allowed", exception.getMessage());
    }
}