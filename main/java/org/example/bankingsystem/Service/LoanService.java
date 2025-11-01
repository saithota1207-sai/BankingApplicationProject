package org.example.bankingsystem.Service;

import org.example.bankingsystem.Dao.LoanDAO;
import org.example.bankingsystem.Entites.Loan;

import java.util.List;
import java.util.Optional;

public class LoanService {
    private final LoanDAO dao = new LoanDAO();

    public Loan createLoan(int accountId, double principal, double interestRate) {
        Loan l = new Loan(0, accountId, principal, interestRate, "ACTIVE");
        return dao.create(l);
    }

    public Optional<Loan> getLoan(int id) { return dao.findById(id); }
    public List<Loan> getAll() { return dao.findAll(); }

    public boolean repay(Loan loan, double amount) {
        if (loan == null || amount <= 0) return false;
        double outstanding = loan.getOutstanding() - amount;
        loan.setOutstanding(Math.max(0, outstanding));
        if (loan.getOutstanding() == 0) loan.setStatus("PAID");
        return dao.update(loan);
    }
}

