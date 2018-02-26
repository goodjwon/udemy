package com.luv2code.hibernate.demo;

import com.luv2code.hibernate.demo.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class PrimaryKeyDemo {

    public static void main(String[] args) {
        //create session factory
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();

        //create session
        Session session = factory.getCurrentSession();

        try {
            //use the session object to save java object
            System.out.println("Creating 3 student objects....");
            Student tempStudent1 = new Student("John", "Doe", "john@naver.com");
            Student tempStudent2 = new Student("Mary", "Public", "mary@naver.com");
            Student tempStudent3 = new Student("Bonita", "Applebaum", "bonita@naver.com");

            //create a student object
            session.beginTransaction();

            //start a transaction
            System.out.println("Saving the students");
            session.save(tempStudent1);
            session.save(tempStudent2);
            session.save(tempStudent3);
            //save the student

            //commit transaction
            session.getTransaction().commit();

            System.out.println("Done !");

        }
        finally {
            factory.close();
        }

    }
}
