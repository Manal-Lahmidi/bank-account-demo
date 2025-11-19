package com.example.bank;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BankAccountTest {

    @Test
    void newAccountShouldHaveInitialBalance() {
        // Arrange
        BankAccount account = new BankAccount(100.0);

        // Act
        double balance = account.getBalance();

        // Assert
        assertEquals(120.0, balance);
    }

    @Test
    void depositShouldIncreaseBalance() {
        // Arrange
        BankAccount account = new BankAccount(100.0);

        // Act
        account.deposit(50.0);

        // Assert
        assertEquals(150.0, account.getBalance());
    }

    @Test
    void withdrawShouldDecreaseBalance() {
        // Arrange
        BankAccount account = new BankAccount(200.0);

        // Act
        account.withdraw(50.0);

        // Assert
        assertEquals(150.0, account.getBalance());
    }

    @Test
    void withdrawMoreThanBalanceShouldThrowException() {
        // Arrange
        BankAccount account = new BankAccount(100.0);

        // Act + Assert
        assertThrows(IllegalArgumentException.class,
                () -> account.withdraw(150.0));
    }

    @Test
    void depositNegativeAmountShouldThrowException() {
        // Arrange
        BankAccount account = new BankAccount(100.0);

        // Act + Assert
        assertThrows(IllegalArgumentException.class,
                () -> account.deposit(-10.0));
    }
}
