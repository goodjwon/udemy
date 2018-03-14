package com.luv2code.hibernate.demo;

import com.luv2code.hibernate.demo.entity.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DeletePacmanCourseDemo {

    public static void main(String[] args) {

        //create session factory
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .addAnnotatedClass(Course.class)
                .addAnnotatedClass(Review.class)
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();

        //create session
        Session session = factory.getCurrentSession();

        try {


            //create a student object
            session.beginTransaction();

            int courseId =1;
            Course tempCourse = session.get(Course.class, courseId);

            System.out.println("Delete course: "+tempCourse);

            session.delete(tempCourse);


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
