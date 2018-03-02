package com.luv2code.hibernate.demo;

import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DeleteDemo {

    public static void main(String[] args) {

        //create session factory
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .buildSessionFactory();

        //create session
        Session session = factory.getCurrentSession();

        try {

            //create a student object
            session.beginTransaction();

            //
            int theId = 1;
            Instructor instructor = session.get(Instructor.class, theId);
            System.out.println("Found instructor: "+instructor);

            if (instructor != null){
                System.out.println("Deleting"+instructor);

                //Note: will ALSO delete associated "details" object
                //because of CascadeType.ALL
                session.delete(instructor);
            }

            //commit transaction
            session.getTransaction().commit();

            System.out.println("Done !");

        }
        finally {
            factory.close();
        }
    }
}
