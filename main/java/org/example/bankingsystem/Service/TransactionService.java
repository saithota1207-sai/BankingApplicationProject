package org.example.bankingsystem.Service;



import org.example.bankingsystem.Dao.TransactionDAO;
import org.example.bankingsystem.Entites.Account;
import org.example.bankingsystem.Entites.Transaction;

import java.util.List;
import java.util.Optional;

public class TransactionService {
    private final TransactionDAO tdao = new TransactionDAO();
    private final AccountService accountService = new AccountService();

    public Transaction createDeposit(Account account, double amount) {
        if (amount <= 0) throw new IllegalArgumentException("Amount > 0 required");
        accountService.deposit(account, amount);
        Transaction t = new Transaction(0, 0, account.getId(), amount, "DEPOSIT");
        return tdao.create(t);
    }

    public Transaction createWithdrawal(Account account, double amount) {
        if (amount <= 0) throw new IllegalArgumentException("Amount > 0 required");
        if (!accountService.withdraw(account, amount)) throw new IllegalArgumentException("Insufficient funds");
        Transaction t = new Transaction(0, account.getId(), 0, amount, "WITHDRAWAL");
        return tdao.create(t);
    }

    public Transaction createTransfer(Account from, Account to, double amount) {
        if (amount <= 0) throw new IllegalArgumentException("Amount > 0 required");
        if (from.getBalance() < amount) throw new IllegalArgumentException("Insufficient funds");
        accountService.withdraw(from, amount);
        accountService.deposit(to, amount);
        Transaction t = new Transaction(0, from.getId(), to.getId(), amount, "TRANSFER");
        return tdao.create(t);
    }

    public List<Transaction> getAll() { return tdao.findAll(); }
    public List<Transaction> getByAccountId(int accountId) { return tdao.findByAccountId(accountId); }
}

