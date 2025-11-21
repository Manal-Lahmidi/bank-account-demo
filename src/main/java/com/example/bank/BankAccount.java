package com.example.bank;

public class BankAccount {

    // balance = argent disponible
    private double balance;

    // Constructeur : créé un compte avec un solde initial
    public BankAccount(double initialBalance) {

        // Validation : on interdit les soldes initiaux négatifs
        if (initialBalance < 0) {
            throw new IllegalArgumentException("Initial balance must be >= 0");
        }
        this.balance = initialBalance;
    }

    // Retourne le solde actuel du compte
    public double getBalance() {
        return balance;
    }

    // Vérifie si le compte est vide (solde égal à 0)
    public boolean isEmpty() {
        return balance == 0;
    }

    // déposer de l'argent sur le compte
    public void deposit(double amount) {
        // On interdit les dépôts négatifs ou nuls
        if (amount <= 0) {
            throw new IllegalArgumentException("Deposit amount must be > 0");
        }
        balance += amount;
    }

    // retirer de l'argent du compte
    public void withdraw(double amount) {

        // On interdit les retraits négatifs ou nuls
        if (amount <= 0) {
            throw new IllegalArgumentException("Withdraw amount must be > 0");
        }
        // On interdit de retirer plus que le solde disponible
        if (amount > balance) {
            throw new IllegalArgumentException("Insufficient balance");
        }
        balance -= amount;
    }
}
