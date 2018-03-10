package com.luv2code.hibernate.demo;

import com.luv2code.hibernate.demo.entity.Course;
import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateInstructorDemo {

    public static void main(String[] args) {

        //create session factory
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .addAnnotatedClass(Course.class)
                .buildSessionFactory();

        //create session
        Session session = factory.getCurrentSession();

        try {

            Instructor instructor =
                    new Instructor("Susan", "Public", "susan.public@luv2code.com");

            InstructorDetail instructorDetail =
                    new InstructorDetail("http://luv2code.com", "Video Games");


            //create a student object
            session.beginTransaction();

            //associate the objects
            instructor.setInstructorDetail(instructorDetail);


            //Note: this will ALSO save the details object
            //because of CascadeType.ALL
            System.out.println("Saving instructor: "+instructor);
            session.save(instructor);

            //commit transaction
            session.getTransaction().commit();

            System.out.println("Done !");

        }
        finally {
            session.close();
            factory.close();
        }
    }
}
