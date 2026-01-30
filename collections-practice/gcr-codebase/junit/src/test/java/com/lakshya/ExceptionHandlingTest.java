package com.lakshya;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
class ExceptionHandlingTest {
    private final ExceptionHandling mathUtils = new ExceptionHandling();
    @Test
    void testDivideByZeroThrowsException() {
        ArithmeticException exception = assertThrows(
                ArithmeticException.class,
                () -> mathUtils.divide(10, 0)
        );
        assertEquals("Division by zero is not allowed", exception.getMessage());
    }
    @Test
    void testDivideValidInput() {
        assertEquals(5, mathUtils.divide(10, 2));
    }
}