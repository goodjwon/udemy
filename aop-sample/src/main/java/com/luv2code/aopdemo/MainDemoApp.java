package com.luv2code.aopdemo;

import com.luv2code.aopdemo.dao.AccountDAO;
import com.luv2code.aopdemo.dao.MemberShipDAO;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.lang.reflect.Member;

public class MainDemoApp {

    public static void main(String[] args) {
        // read spring config
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(DemoConfig.class);


        // get the bean from spring container
        AccountDAO theAccountDAO = context.getBean("accountDAO", AccountDAO.class);

        MemberShipDAO theMemberShipDAO = context.getBean("memberShipDAO", MemberShipDAO.class);

        // call the business method
        theAccountDAO.addAccount();

        theMemberShipDAO.addAccount();

        System.out.println("\n let's call again");

        theAccountDAO.addAccount();

        // close the context
        context.close();
    }
}
