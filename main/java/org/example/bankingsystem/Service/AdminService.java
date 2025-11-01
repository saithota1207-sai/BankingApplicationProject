package org.example.bankingsystem.Service;



import org.example.bankingsystem.Dao.AdminDAO;

public class AdminService {
    private final AdminDAO dao = new AdminDAO();

    public boolean login(String username, String password) {
        return dao.validate(username, password);
    }
}
