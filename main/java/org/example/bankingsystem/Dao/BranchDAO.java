package org.example.bankingsystem.Dao;

import org.example.bankingsystem.Entites.Branch;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class BranchDAO {
    private final List<Branch> branches = new ArrayList<>();
    private int idSeq = 1;

    public Branch create(Branch b) {
        b.setId(idSeq++);
        branches.add(b);
        return b;
    }

    public Optional<Branch> findById(int id) {
        return branches.stream().filter(x -> x.getId() == id).findFirst();
    }

    public List<Branch> findAll() {
        return new ArrayList<>(branches);
    }

    public boolean delete(int id) {
        return branches.removeIf(b -> b.getId() == id);
    }
}
