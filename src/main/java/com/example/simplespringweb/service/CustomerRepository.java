package com.example.simplespringweb.service;

import com.example.simplespringweb.model.Customer;
import org.springframework.data.repository.CrudRepository;

public interface CustomerRepository extends CrudRepository<Customer,String> {
}
