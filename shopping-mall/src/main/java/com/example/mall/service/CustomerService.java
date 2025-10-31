package com.example.mall.service;

import com.example.mall.entity.Customer;
import com.example.mall.repository.CustomerRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {

    private final CustomerRepository repo;

    public CustomerService(CustomerRepository repo) {
        this.repo = repo;
    }

    // Get all customers
    public List<Customer> getAllCustomers() {
        return repo.findAll();
    }

    // Get customer by ID
    public Customer getCustomerById(Long id) {
        return repo.findById(id).orElse(null);
    }

    // Create new customer
    public Customer createCustomer(Customer customer) {
        return repo.save(customer);
    }

    // Update existing customer
    public Customer updateCustomer(Long id, Customer details) {
        Customer customer = repo.findById(id).orElse(null);
        if (customer != null) {
            customer.setName(details.getName());
            customer.setEmail(details.getEmail());
            customer.setPhone(details.getPhone());
            return repo.save(customer);
        }
        return null;
    }

    // Delete customer
    public void deleteCustomer(Long id) {
        repo.deleteById(id);
    }
}
