package org.example.bankingsystem.Dao;
import org.example.bankingsystem.Entites.Account;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class AccountDAO {




        private final List<Account> accounts = new ArrayList<>();
        private int idSeq = 1;

        public Account create(Account a) {
            a.setId(idSeq++);
            accounts.add(a);
            return a;
        }

        public Optional<Account> findById(int id) {
            return accounts.stream().filter(a -> a.getId() == id).findFirst();
        }

        public Optional<Account> findByAccountNumber(String accNo) {
            return accounts.stream().filter(a -> a.getAccountNumber().equals(accNo)).findFirst();
        }

        public List<Account> findAll() {
            return new ArrayList<>(accounts);
        }

        public List<Account> findByCustomerId(int customerId) {
            List<Account> res = new ArrayList<>();
            for (Account a : accounts) if (a.getCustomerId() == customerId) res.add(a);
            return res;
        }

        public boolean update(Account updated) {
            return findById(updated.getId()).map(existing -> {
                existing.setBalance(updated.getBalance());
                existing.setType(updated.getType());
                existing.setAccountNumber(updated.getAccountNumber());
                return true;
            }).orElse(false);
        }

        public boolean delete(int id) {
            return accounts.removeIf(a -> a.getId() == id);
        }
    }


