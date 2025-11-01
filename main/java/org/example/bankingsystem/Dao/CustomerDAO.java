package org.example.bankingsystem.Dao;
import org.example.bankingsystem.Entites.Customer;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class CustomerDAO {



        private final List<Customer> customers = new ArrayList<>();
        private int idSeq = 1;

        public Customer create(Customer c) {
            c.setId(idSeq++);
            customers.add(c);
            return c;
        }

        public Optional<Customer> findById(int id) {
            return customers.stream().filter(x -> x.getId() == id).findFirst();
        }

        public List<Customer> findAll() {
            return new ArrayList<>(customers);
        }

        public boolean update(Customer updated) {
            return findById(updated.getId()).map(existing -> {
                existing.setName(updated.getName());
                existing.setEmail(updated.getEmail());
                existing.setPhone(updated.getPhone());
                return true;
            }).orElse(false);
        }

        public boolean delete(int id) {
            return customers.removeIf(c -> c.getId() == id);
        }
    }


