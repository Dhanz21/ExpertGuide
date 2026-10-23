package com.trekExpert.expertguide.controller;

import com.trekExpert.expertguide.dto.CustomerDto;
import com.trekExpert.expertguide.model.Customer;
import com.trekExpert.expertguide.service.CustomerService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/customers")
public class CustomerController {

    private final CustomerService service;

    public CustomerController(CustomerService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<CustomerDto> createCustomer(@RequestBody CustomerDto customerDto) {
        Customer saved = service.save(toEntity(customerDto));
        return ResponseEntity.created(URI.create("/customers/" + saved.getId())).body(toDto(saved));
    }

    @GetMapping("/{id}")
    public ResponseEntity<CustomerDto> getCustomer(@PathVariable Long id) {
        return service.findById(id)
                    .map(this::toDto)
                    .map(ResponseEntity::ok)
                    .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping
    public ResponseEntity<List<CustomerDto>> listCustomers() {
        List<CustomerDto> customers = service.findAll().stream().map(this::toDto).toList();
        return ResponseEntity.ok(customers);
    }

    private Customer toEntity(CustomerDto dto) {
        if (dto == null) {
            return null;
        }
        return new Customer(dto.id(), dto.name(), dto.email(), dto.isPreviliged(), dto.postcode());
    }

    private CustomerDto toDto(Customer customer) {
        if (customer == null) {
            return null;
        }
        return new CustomerDto(customer.getId(), customer.getName(), customer.getEmail(), customer.isPreviliged(), customer.getPostcode());
    }
}
