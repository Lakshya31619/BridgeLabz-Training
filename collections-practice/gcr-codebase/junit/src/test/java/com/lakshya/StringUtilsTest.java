package com.lakshya;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
class StringUtilsTest {
    private final StringUtils stringUtils = new StringUtils();
    @Test
    void testReverse() {
        assertEquals("olleh", stringUtils.reverse("hello"));
        assertEquals("", stringUtils.reverse(""));
        assertNull(stringUtils.reverse(null));
    }
    @Test
    void testIsPalindrome() {
        assertTrue(stringUtils.isPalindrome("madam"));
        assertTrue(stringUtils.isPalindrome("level"));
        assertFalse(stringUtils.isPalindrome("hello"));
        assertFalse(stringUtils.isPalindrome(null));
    }
    @Test
    void testToUpperCase() {
        assertEquals("HELLO", stringUtils.toUpperCase("hello"));
        assertEquals("JAVA", stringUtils.toUpperCase("Java"));
        assertNull(stringUtils.toUpperCase(null));
    }
}