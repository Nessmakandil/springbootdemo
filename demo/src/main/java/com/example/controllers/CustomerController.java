package com.example.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.entities.Customer;
import com.example.services.CustomerService;

@RestController
@RequestMapping("/rest/customers")
public class CustomerController {
    
    @Autowired
    private CustomerService customerService;

    @GetMapping
    public List<Customer> getAllCustomers() {
    	List<Customer> customers = customerService.getAllCustomers();
    	
    	return customers;
    }

    @PostMapping
    public void addCustomer(@RequestBody Customer customer) {
        customerService.inserCustomer(customer);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Customer> updateCustomer(@PathVariable int id, @RequestBody Customer customer) {
        Customer existingCustomer = customerService.getCustomerById(id);
        if (existingCustomer == null) {
            return ResponseEntity.notFound().build();
        }
        customer.setId(id);
        customerService.updateCustomer(customer);
        return ResponseEntity.ok(customer);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCustomer(@PathVariable int id) {
        Customer existingCustomer = customerService.getCustomerById(id);
        if (existingCustomer == null) {
            return ResponseEntity.notFound().build();
        }
        customerService.deleteCustomer(existingCustomer);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/search")
    public List<Customer> searchCustomersByFirstName(@RequestParam("keyword") String firstName) {
        return customerService.searchCustomersByFirstName(firstName);
    }
}
