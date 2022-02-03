package com.example.simplespringweb.controller;

import com.example.simplespringweb.model.Customer;
import com.example.simplespringweb.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CustomerController {

    @Autowired
    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping("/api/hello")
    public String hello(@RequestParam(value = "name", defaultValue = "World") String name) {
        return String.format("Hello %s", name);
    }

    @GetMapping("/api/customers")
    public List<Customer> getAll() {
        return customerService.getAllCustomers();
    }

    @GetMapping("/api/{id}")
    public Customer getById(@PathVariable("id") String id) {
        return customerService.getCustomerById(id);
    }

    @PostMapping("/api/add")
    public Customer addCustomer(@RequestBody Customer u){
        customerService.addCustomer(u);
        return u;
    }
}
