package com.lakshya;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
class UserRegistrationTest {
    private final UserRegistration registration = new UserRegistration();
    @Test
    void testValidUserRegistration() {
        assertDoesNotThrow(() ->
                registration.registerUser(
                        "john_doe",
                        "john@example.com",
                        "Password1"
                )
        );
    }
    @Test
    void testInvalidUsername() {
        Exception exception = assertThrows(
                IllegalArgumentException.class,
                () -> registration.registerUser(
                        "",
                        "john@example.com",
                        "Password1"
                )
        );
        assertEquals("Invalid username", exception.getMessage());
    }
    @Test
    void testInvalidEmail() {
        Exception exception = assertThrows(
                IllegalArgumentException.class,
                () -> registration.registerUser(
                        "john_doe",
                        "johnexample.com",
                        "Password1"
                )
        );
        assertEquals("Invalid email", exception.getMessage());
    }
    @Test
    void testInvalidPassword() {
        Exception exception = assertThrows(
                IllegalArgumentException.class,
                () -> registration.registerUser(
                        "john_doe",
                        "john@example.com",
                        "pass"
                )
        );
        assertEquals("Invalid password", exception.getMessage());
    }
    @Test
    void testNullInputs() {
        assertThrows(
                IllegalArgumentException.class,
                () -> registration.registerUser(null, null, null)
        );
    }
}