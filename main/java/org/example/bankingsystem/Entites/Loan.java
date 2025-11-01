package org.example.bankingsystem.Entites;


public class Loan {
    private int id;
    private int accountId;
    private double principal;
    private double outstanding;
    private double interestRate;
    private String status;

    public Loan() {}

    public Loan(int id, int accountId, double principal, double interestRate, String status) {
        this.id = id;
        this.accountId = accountId;
        this.principal = principal;
        this.outstanding = principal;
        this.interestRate = interestRate;
        this.status = status;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public int getAccountId() { return accountId; }
    public void setAccountId(int accountId) { this.accountId = accountId; }

    public double getPrincipal() { return principal; }
    public void setPrincipal(double principal) { this.principal = principal; }

    public double getOutstanding() { return outstanding; }
    public void setOutstanding(double outstanding) { this.outstanding = outstanding; }

    public double getInterestRate() { return interestRate; }
    public void setInterestRate(double interestRate) { this.interestRate = interestRate; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    @Override
    public String toString() {
        return "Loan{" +
                "id=" + id +
                ", accountId=" + accountId +
                ", principal=" + principal +
                ", outstanding=" + outstanding +
                ", interestRate=" + interestRate +
                ", status='" + status + '\'' +
                '}';
    }
}
