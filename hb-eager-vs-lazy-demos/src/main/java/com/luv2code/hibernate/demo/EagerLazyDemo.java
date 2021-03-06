package com.luv2code.hibernate.demo;

import com.luv2code.hibernate.demo.entity.Course;
import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class EagerLazyDemo {

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


            //create a student object
            session.beginTransaction();


            // get the instructor from db
            int theId = 1;
            Instructor tempInstructor = session.get(Instructor.class, theId);


            System.out.println("luv2code: Instructor: "+tempInstructor);

            //option 1


            System.out.println("luv2code: Courses: "+tempInstructor.getCourses());


            //commit transaction
            session.getTransaction().commit();

            //Close the session
            session.close();

            System.out.println("\nSession closed!!! \n");

            //since courses are lazy loaded ... this should fail.

            //option 1: call getter method while session is open.
            //option 2:
            System.out.println("luv2code: Courses: "+tempInstructor.getCourses());

            System.out.println("luv2code: Done !");

        }
        finally {
            session.close();
            factory.close();
        }
    }
}
