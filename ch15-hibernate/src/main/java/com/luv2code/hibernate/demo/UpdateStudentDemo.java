package com.luv2code.hibernate.demo;

import com.luv2code.hibernate.demo.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class UpdateStudentDemo {

    public static void main(String[] args) {

        //create session factory
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();

        //create session
        Session session = factory.getCurrentSession();

        try {
            int studentId = 1;

            //use the session object to save java object
            System.out.println("Updating student object....");

            //create a student object
            session.beginTransaction();

            Student mystudent = session.get(Student.class, studentId);

            System.out.println("Updating student....");
            mystudent.setFirstName("Scooby");

            //commit transaction
            session.getTransaction().commit();

            session = factory.getCurrentSession();
            session.beginTransaction();

            System.out.println("Update email for all students");

            session.createQuery("update Student set email='foo@gmail.com'")
                    .executeUpdate();


            session.getTransaction().commit();


            System.out.println("Done !");

        }
        finally {
            factory.close();
        }
    }
}
