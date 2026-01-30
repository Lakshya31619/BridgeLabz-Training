package com.lakshya;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
class BankAccountTest {
    @Test
    void testDeposit() {
        BankAccount account = new BankAccount();
        account.deposit(100.0);
        assertEquals(100.0, account.getBalance(), 0.001);
        account.deposit(50.0);
        assertEquals(150.0, account.getBalance(), 0.001);
    }
    @Test
    void testWithdraw() {
        BankAccount account = new BankAccount(200.0);
        account.withdraw(50.0);
        assertEquals(150.0, account.getBalance(), 0.001);
        account.withdraw(150.0);
        assertEquals(0.0, account.getBalance(), 0.001);
    }
    @Test
    void testWithdrawInsufficientFunds() {
        BankAccount account = new BankAccount(100.0);
        Exception exception = assertThrows(
                IllegalArgumentException.class,
                () -> account.withdraw(150.0)
        );
        assertEquals("Insufficient funds", exception.getMessage());
    }
    @Test
    void testNegativeDeposit() {
        BankAccount account = new BankAccount();
        Exception exception = assertThrows(
                IllegalArgumentException.class,
                () -> account.deposit(-50.0)
        );
        assertEquals("Deposit amount must be positive", exception.getMessage());
    }
    @Test
    void testNegativeWithdrawal() {
        BankAccount account = new BankAccount(100.0);
        Exception exception = assertThrows(
                IllegalArgumentException.class,
                () -> account.withdraw(-30.0)
        );
        assertEquals("Withdrawal amount must be positive", exception.getMessage());
    }
}