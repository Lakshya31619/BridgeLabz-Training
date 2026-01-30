package com.lakshya;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
class DateFormatterTest {
    private final DateFormatter formatter = new DateFormatter();
    @Test
    void testValidDate() {
        assertEquals("25-12-2024", formatter.formatDate("2024-12-25"));
        assertEquals("01-01-2023", formatter.formatDate("2023-01-01"));
    }
    @Test
    void testInvalidDateFormat() {
        Exception exception = assertThrows(
                IllegalArgumentException.class,
                () -> formatter.formatDate("25-12-2024")
        );
        assertEquals("Invalid date format", exception.getMessage());
    }
    @Test
    void testInvalidDateValue() {
        Exception exception = assertThrows(
                IllegalArgumentException.class,
                () -> formatter.formatDate("2024-02-30")
        );
        assertEquals("Invalid date format", exception.getMessage());
    }
    @Test
    void testNullDate() {
        Exception exception = assertThrows(
                IllegalArgumentException.class,
                () -> formatter.formatDate(null)
        );
        assertEquals("Invalid date format", exception.getMessage());
    }
}