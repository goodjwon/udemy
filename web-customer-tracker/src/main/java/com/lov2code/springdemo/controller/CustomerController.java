package com.lov2code.springdemo.controller;


import com.lov2code.springdemo.dao.CustomerRepository;
import com.lov2code.springdemo.entitiy.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    private CustomerRepository repository;


    @RequestMapping("/list")
    public String listCustomers(Model model) {

        List<Customer> theCustomers = (List<Customer>) repository.findAll();

        model.addAttribute("customer", theCustomers);


        return "list-customers";
    }
}
