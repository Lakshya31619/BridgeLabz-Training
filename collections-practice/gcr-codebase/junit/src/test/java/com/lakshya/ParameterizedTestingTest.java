package com.lakshya;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import static org.junit.jupiter.api.Assertions.*;
public class ParameterizedTestingTest {
    private ParameterizedTesting numberUtils;
    @BeforeEach
    void setUp() {
        numberUtils = new ParameterizedTesting();
    }
    @ParameterizedTest
    @ValueSource(ints = {2, 4, 6})
    void testIsEvenWithEvenNumbers(int number) {
        assertTrue(numberUtils.isEven(number), number + " should be even");
    }
    @ParameterizedTest
    @ValueSource(ints = {7, 9})
    void testIsEvenWithOddNumbers(int number) {
        assertFalse(numberUtils.isEven(number), number + " should be odd");
    }
}