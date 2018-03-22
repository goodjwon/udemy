package com.lov2code.springdemo.controller;


import com.lov2code.springdemo.dao.CustomerRepository;
import com.lov2code.springdemo.entitiy.Customer;
import com.lov2code.springdemo.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/customer")
public class CustomerController {


    private CustomerService service;

    @Autowired
    public void setRepository(CustomerService service) {
        this.service = service;
    }

    @GetMapping("/list")
    public String listCustomers(Model model) {

        List<Customer> theCustomers = service.getCustomers();

        model.addAttribute("customer", theCustomers);


        return "list-customers";
    }
}
