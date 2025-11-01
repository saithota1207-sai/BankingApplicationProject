package org.example.bankingsystem.Service;



import org.example.bankingsystem.Dao.AccountDAO;
import org.example.bankingsystem.Entites.Account;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class AccountService {
    private final AccountDAO dao = new AccountDAO();

    public Account openAccount(int customerId, String type, double initialDeposit) {
        String accNo = UUID.randomUUID().toString().substring(0, 12).replace("-", "");
        Account a = new Account(0, customerId, accNo, initialDeposit, type);
        return dao.create(a);
    }

    public Optional<Account> getAccountById(int id) { return dao.findById(id); }
    public Optional<Account> getAccountByNumber(String accNo) { return dao.findByAccountNumber(accNo); }
    public List<Account> getAccountsByCustomer(int custId) { return dao.findByCustomerId(custId); }
    public List<Account> getAllAccounts() { return dao.findAll(); }

    public boolean deposit(Account account, double amount) {
        if (amount <= 0) return false;
        account.setBalance(account.getBalance() + amount);
        return dao.update(account);
    }

    public boolean withdraw(Account account, double amount) {
        if (amount <= 0 || account.getBalance() < amount) return false;
        account.setBalance(account.getBalance() - amount);
        return dao.update(account);
    }

    public boolean updateAccount(Account a) { return dao.update(a); }
    public boolean closeAccount(int id) { return dao.delete(id); }
}

