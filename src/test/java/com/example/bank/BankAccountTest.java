package com.example.bank;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BankAccountTest {

    // -------------------------------------------------------------
    // TEST 1 : Vérifier que le solde initial est bien pris en compte
    // -------------------------------------------------------------
    @Test
    void newAccountShouldHaveInitialBalance() {
        // Arrange
        BankAccount account = new BankAccount(100.0);

        // Act
        double balance = account.getBalance();

        // Assert
        assertEquals(100, account.getBalance());
        assertFalse(account.isEmpty());
    }

    // -------------------------------------------------------------
    // TEST 2 : Vérifier que deposit() augmente correctement le solde
    // -------------------------------------------------------------
    @Test
    void depositShouldIncreaseBalance() {
        // Arrange
        BankAccount account = new BankAccount(100.0);

        // Act
        account.deposit(50.0);

        // Assert
        assertEquals(150.0, account.getBalance());
    }

    // -------------------------------------------------------------
    // TEST 3 : Vérifier que withdraw() diminue correctement le solde
    // -------------------------------------------------------------
    @Test
    void withdrawShouldDecreaseBalance() {
        // Arrange
        BankAccount account = new BankAccount(200.0);

        // Act
        account.withdraw(50.0);

        // Assert
        assertEquals(150.0, account.getBalance());
    }

    // -------------------------------------------------------------
    // TEST 4 : Vérifier qu'on NE PEUT PAS retirer plus que le solde
    // -------------------------------------------------------------
    @Test
    void withdrawMoreThanBalanceShouldThrowException() {
        // Arrange
        BankAccount account = new BankAccount(100.0);

        // Act + Assert
        assertThrows(IllegalArgumentException.class,    //← TYPE D’ERREUR ATTENDUE
                () -> account.withdraw(150.0)); //← CODE QUI DOIT PLANTER
    }

    // -------------------------------------------------------------
    // TEST 5 : Vérifier que deposit() refuse les montants négatifs
    // -------------------------------------------------------------
    @Test
    void depositNegativeAmountShouldThrowException() {
        // Arrange
        BankAccount account = new BankAccount(100.0);

        // Act + Assert
        assertThrows(IllegalArgumentException.class,
                () -> account.deposit(-10.0));
    }
}
