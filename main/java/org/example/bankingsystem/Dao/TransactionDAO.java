package org.example.bankingsystem.Dao;

import org.example.bankingsystem.Entites.Transaction;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
public class TransactionDAO {
    private final List<Transaction> transactions = new ArrayList<>();
    private int idSeq = 1;

    public Transaction create(Transaction t) {
        t.setId(idSeq++);
        transactions.add(t);
        return t;
    }

    public Optional<Transaction> findById(int id) {
        return transactions.stream().filter(t -> t.getId() == id).findFirst();
    }

    public List<Transaction> findAll() {
        return new ArrayList<>(transactions);
    }

    public List<Transaction> findByAccountId(int accountId) {
        List<Transaction> out = new ArrayList<>();
        for (Transaction t : transactions) {
            if (t.getFromAccountId() == accountId || t.getToAccountId() == accountId) out.add(t);
        }
        return out;
    }
}


