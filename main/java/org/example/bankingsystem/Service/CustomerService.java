package org.example.bankingsystem.Service;



import org.example.bankingsystem.Dao.CustomerDAO;
import org.example.bankingsystem.Entites.Customer;

import java.util.List;
import java.util.Optional;

public class CustomerService {
    private final CustomerDAO dao = new CustomerDAO();

    public Customer createCustomer(String name, String email, String phone) {
        Customer c = new Customer(0, name, email, phone);
        return dao.create(c);
    }

    public Optional<Customer> getCustomer(int id) { return dao.findById(id); }
    public List<Customer> getAllCustomers() { return dao.findAll(); }
    public boolean updateCustomer(Customer c) { return dao.update(c); }
    public boolean deleteCustomer(int id) { return dao.delete(id); }
}

