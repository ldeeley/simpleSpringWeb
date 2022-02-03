package com.example.simplespringweb.controller;

import com.example.simplespringweb.model.Customer;
import com.example.simplespringweb.service.CustomerService;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@WebMvcTest(CustomerController.class)
class CustomerControllerTest {

    @MockBean
    private CustomerService customerService;

    @Autowired
    MockMvc mockMvc;

    @Test
    void shouldCreateMockMvc(){
        assertNotNull(mockMvc);
    }

    @Test
    void shouldReturnAllCustomers() throws Exception {
        when(customerService.getAllCustomers()).thenReturn(List.of(new Customer("lgd","Lester","Deeley"),new Customer("grr","Gillianca","babes")));


        this.mockMvc.perform(MockMvcRequestBuilders
                .get("/api/customers"))
//                .header("id", "xyz"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.size()", Matchers.is(2)))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].firstName").value("Lester"));

    }
/*
    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void hello() {
    }

    @Test
    void testHello() {
    }

    @Test
    void getAll() {
    }

    @Test
    void getById() {
    }

    @Test
    void addCustomer() {
    }

 */

}