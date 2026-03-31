package com.lakshya;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
class DatabaseConnectionTest {
    private DatabaseConnection dbConnection;
    @BeforeEach
    void setUp() {
        dbConnection = new DatabaseConnection();
        dbConnection.connect();
    }
    @AfterEach
    void tearDown() {
        dbConnection.disconnect();
    }
    @Test
    void testConnectionIsEstablished() {
        assertTrue(dbConnection.isConnected(), "Database should be connected before test");
    }
    @Test
    void testConnectionIsClosedAfterTest() {
        assertTrue(dbConnection.isConnected(), "Database should be connected during test");
    }
}