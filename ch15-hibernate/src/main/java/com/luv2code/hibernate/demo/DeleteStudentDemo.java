package com.luv2code.hibernate.demo;

import com.luv2code.hibernate.demo.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DeleteStudentDemo {

    public static void main(String[] args) {

        //create session factory
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();

        //create session
        Session session = factory.getCurrentSession();

        try {
            int studentId = 5;

            //use the session object to save java object
            System.out.println("Delete student object....");

            //create a student object
            session.beginTransaction();

            Student mystudent = session.get(Student.class, studentId);

            System.out.println("Delete student id 1 object....");

            if(mystudent!=null) session.delete(mystudent);

//            session.getTransaction().commit();


//            session.beginTransaction();

            System.out.println("Delete student id 2 object....");
            session.createQuery("delete from Student where id=4")
                    .executeUpdate();


            session.getTransaction().commit();

            System.out.println("Done !");

        }
        finally {
            factory.close();
        }
    }
}
