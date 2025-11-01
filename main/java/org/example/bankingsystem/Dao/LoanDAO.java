package org.example.bankingsystem.Dao;
import org.example.bankingsystem.Entites.Loan;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
public class LoanDAO {
    private final List<Loan> loans = new ArrayList<>();
    private int idSeq = 1;

    public Loan create(Loan l) {
        l.setId(idSeq++);
        loans.add(l);
        return l;
    }

    public Optional<Loan> findById(int id) {
        return loans.stream().filter(x -> x.getId() == id).findFirst();
    }

    public List<Loan> findAll() {
        return new ArrayList<>(loans);
    }

    public boolean update(Loan updated) {
        return findById(updated.getId()).map(existing -> {
            existing.setOutstanding(updated.getOutstanding());
            existing.setStatus(updated.getStatus());
            return true;
        }).orElse(false);
    }

    public boolean delete(int id) {
        return loans.removeIf(l -> l.getId() == id);
    }
}
