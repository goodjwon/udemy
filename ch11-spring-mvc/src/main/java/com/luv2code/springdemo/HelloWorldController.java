package com.luv2code.springdemo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

@Controller
public class HelloWorldController {

    @RequestMapping("/showForm")
    public String showForm(){
        return "helloworld-form";
    }

    @RequestMapping("/processForm")
    public String processForm(HttpServletRequest request,
        @RequestParam(value = "studentName", required = false, defaultValue = "World")String name, Model model) {

            model.addAttribute("name", name);

        return "helloworld";
    }

    // new a controller method to read form data and
    // add data to the model
    @RequestMapping("/processFormVersionTwo")
    public String letsShoutDude(HttpServletRequest request, Model model){

        // read the request parameter from the HTML form
        String theName = request.getParameter("studentName");

        // convert the data to all caps
        theName = theName.toUpperCase();

        // create the message
        String result = "Yo!" + theName;

        // add message to the model
        model.addAttribute("name", theName);
        model.addAttribute("message", result);

        return "helloworld";
    }



}
