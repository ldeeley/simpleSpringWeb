package com.example.simplespringweb.service;

import com.example.simplespringweb.exception.CustomerNotFoundException;
import com.example.simplespringweb.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.nio.file.attribute.UserPrincipalNotFoundException;
import java.util.ArrayList;
import java.util.List;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public List<Customer> getAllCustomers
            () {
        List<Customer> users = new ArrayList<>();
        customerRepository.findAll().forEach(users::add);
        return users;
    }

    public void addCustomer(Customer u){
        customerRepository.save(u);
    }

    public Customer getCustomerById(String id) {
        return customerRepository
                .findById(id)
                .orElseThrow(CustomerNotFoundException::new);
    }

}
