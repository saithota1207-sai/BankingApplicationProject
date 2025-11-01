package org.example.bankingsystem.Service;



import org.example.bankingsystem.Dao.BranchDAO;
import org.example.bankingsystem.Entites.Branch;

import java.util.List;
import java.util.Optional;

public class BranchService {
    private final BranchDAO dao = new BranchDAO();

    public Branch createBranch(String name, String address, String ifsc) {
        Branch b = new Branch(0, name, address, ifsc);
        return dao.create(b);
    }

    public Optional<Branch> getBranch(int id) { return dao.findById(id); }
    public List<Branch> getAll() { return dao.findAll(); }
    public boolean deleteBranch(int id) { return dao.delete(id); }
}
