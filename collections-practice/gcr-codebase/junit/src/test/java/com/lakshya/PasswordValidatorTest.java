package com.lakshya;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
class PasswordValidatorTest {
    private final PasswordValidator validator = new PasswordValidator();
    @Test
    void testValidPassword() {
        assertTrue(validator.isValid("Password1"));
        assertTrue(validator.isValid("Secure123"));
    }
    @Test
    void testPasswordTooShort() {
        assertFalse(validator.isValid("Pass1"));
    }
    @Test
    void testMissingUppercase() {
        assertFalse(validator.isValid("password1"));
    }
    @Test
    void testMissingDigit() {
        assertFalse(validator.isValid("Password"));
    }
    @Test
    void testNullPassword() {
        assertFalse(validator.isValid(null));
    }
}