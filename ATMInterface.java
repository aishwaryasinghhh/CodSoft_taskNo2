/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.atminterface;

/**
 *
 * @author aishwaryasingh
 */
import java.util.Scanner;

class BankAccount {
    private double balance;

    public BankAccount(double initialBalance) {
        this.balance = initialBalance;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("₹" + amount + " deposited successfully.");
        } else {
            System.out.println("Enter a valid deposit amount.");
        }
    }

    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("₹" + amount + " withdrawn successfully.");
        } else if (amount > balance) {
            System.out.println("Insufficient balance.");
        } else {
            System.out.println("Enter a valid withdrawal amount.");
        }
    }

    public void checkBalance() {
        System.out.println("Current balance: ₹" + balance);
    }
}

class ATM {
    private BankAccount account;
    private Scanner scanner;

    public ATM(BankAccount account) {
        this.account = account;
        this.scanner = new Scanner(System.in);
    }

    public void start() {
        while (true) {
            System.out.println("\nATM Interface");
            System.out.println("1. Check Balance");
            System.out.println("2. Deposit Money");
            System.out.println("3. Withdraw Money");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");
            
            int choice = scanner.nextInt();
            
            switch (choice) {
                case 1:
                    account.checkBalance();
                    break;
                case 2:
                    System.out.print("Enter deposit amount: ₹");
                    double depositAmount = scanner.nextDouble();
                    account.deposit(depositAmount);
                    break;
                case 3:
                    System.out.print("Enter withdrawal amount: ₹");
                    double withdrawAmount = scanner.nextDouble();
                    account.withdraw(withdrawAmount);
                    break;
                case 4:
                    System.out.println("Thank you for using the ATM!");
                    return;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }
}

public class ATMInterface {
    public static void main(String[] args) {
        BankAccount myAccount = new BankAccount(5000);
        ATM myATM = new ATM(myAccount);
        myATM.start();
    }
}
