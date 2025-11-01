package org.example.bankingsystem.Entites;


public class Account {
    private int id;
    private int customerId;
    private String accountNumber;
    private double balance;
    private String type; // e.g., SAVINGS/CURRENT

    public Account() {}

    public Account(int id, int customerId, String accountNumber, double balance, String type) {
        this.id = id;
        this.customerId = customerId;
        this.accountNumber = accountNumber;
        this.balance = balance;
        this.type = type;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public int getCustomerId() { return customerId; }
    public void setCustomerId(int customerId) { this.customerId = customerId; }

    public String getAccountNumber() { return accountNumber; }
    public void setAccountNumber(String accountNumber) { this.accountNumber = accountNumber; }

    public double getBalance() { return balance; }
    public void setBalance(double balance) { this.balance = balance; }

    public String getType() { return type; }
    public void setType(String type) { this.type = type; }

    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", customerId=" + customerId +
                ", accountNumber='" + accountNumber + '\'' +
                ", balance=" + balance +
                ", type='" + type + '\'' +
                '}';
    }
}


