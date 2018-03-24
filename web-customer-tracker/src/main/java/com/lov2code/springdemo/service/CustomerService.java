package com.lov2code.springdemo.service;

import com.lov2code.springdemo.entitiy.Customer;

import java.util.List;

public interface CustomerService {

    public List<Customer> getCustomers();


    public Customer saveCustomer(Customer customer);
}
