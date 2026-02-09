package com.bank;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ProgramTest {

    @Test
    void testDepositValidAmount() {
        Program account = new Program(100);
        account.deposit(50);
        assertEquals(150, account.getBalance());
    }

    @Test
    void testDepositNegativeAmount() {
        Program account = new Program(100);
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            account.deposit(-50);
        });
        assertEquals("Deposit amount cannot be negative", exception.getMessage());
    }

    @Test
    void testWithdrawValidAmount() {
        Program account = new Program(100);
        account.withdraw(40);
        assertEquals(60, account.getBalance());
    }

    @Test
    void testWithdrawInsufficientFunds() {
        Program account = new Program(100);
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            account.withdraw(150);
        });
        assertEquals("Insufficient funds.", exception.getMessage());
    }
}
