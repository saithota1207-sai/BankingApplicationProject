package org.example.bankingsystem.Dao;



import org.example.bankingsystem.Entites.Admin;

public class AdminDAO {
    // For demo, just returns a single admin.
    private final Admin admin = new Admin("admin", "admin123");

    public Admin findAdmin() {
        return admin;
    }

    public boolean validate(String username, String password) {
        return admin.getUsername().equals(username) && admin.getPassword().equals(password);
    }
}
