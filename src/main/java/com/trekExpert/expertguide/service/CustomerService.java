package com.trekExpert.expertguide.service;

import com.trekExpert.expertguide.model.Customer;
import com.trekExpert.expertguide.repository.CustomerRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {
    private final CustomerRepository repository;

    public CustomerService(CustomerRepository repository) {
        this.repository = repository;
    }

    public Customer save(Customer customer) {
        return repository.save(customer);
    }

    public Optional<Customer> findById(Long id) {
        return repository.findById(id);
    }

    public List<Customer> findAll() {
        return repository.findAll();
    }
}
