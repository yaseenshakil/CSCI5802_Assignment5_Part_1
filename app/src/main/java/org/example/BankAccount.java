package org.example;

import java.io.IOException;
import java.io.OutputStream;
import java.util.Optional;

public class BankAccount {

    private volatile int ageOfAccount = 0;
    private String name;
    private double accountBalance;
    private String typeOfAccount;

    private OutputStream receipt = null;

    public BankAccount(String ownerName, double accountBalance, String typeOfAccount) throws Exception {
        if (name == null){
            throw new Exception("No Name is provided");
        }
        this.name = name;
        this.accountBalance = accountBalance;
        this.typeOfAccount = typeOfAccount;
    }


    public void printReceipt() throws IOException {
        String receiptData = String.format("" +
                "----THE BIG BANK RECEIPT----\n" +
                "Account Owner: %s\n" +
                "Age of Account: %d\n" +
                "Account Balance: $%.2f", this.name, this.ageOfAccount, this.accountBalance);
        this.receipt.write(receiptData.getBytes());
    }


    public void incrementAgeOfAccount(){
        this.ageOfAccount++;
        System.out.printf("The new age of the account is %d", this.ageOfAccount);
    }

    public double getAccountBalance() {
        return accountBalance;
    }

    public void setAccountBalance(double accountBalance) {
        this.accountBalance = accountBalance;
    }

    public void incrementAge(){
        int accountAge = 0;
        accountAge++;
    }
}
