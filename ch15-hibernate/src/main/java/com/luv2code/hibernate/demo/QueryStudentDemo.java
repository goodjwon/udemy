package com.luv2code.hibernate.demo;

import com.luv2code.hibernate.demo.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class QueryStudentDemo {

    public static void main(String[] args) {

        //create session factory
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();

        //create session
        Session session = factory.getCurrentSession();

        try {


            //start a transaction
            session.beginTransaction();

            //query students
            List<Student> theStudents = session.createQuery("from Student").list() ;

            //display the students
            System.out.println("\n\nStudents");
            displayTheStudents(theStudents);

            //query students: lastName= 'Doe'
            System.out.println("\n\nStudents who have last name of Doe");
            theStudents = session.createQuery("from Student s where s.lastName='Doe'").list();

            //display display Students
            displayTheStudents(theStudents);


            //query students: lastName Doe or firstName Daffy
            System.out.println("\n\nStudents who have last name of Doe OR first name Daffy");
            theStudents = session.createQuery("from Student s where " +
                    " s.lastName='Doe' OR s.firstName='Daffy'").list();

            //display the students
            displayTheStudents(theStudents);


            //query students where email Like '%naver.com'
            theStudents = session.createQuery("from Student s where" +
                    " s.email LIKE '%naver.com'").list();
            System.out.println("\n\nStudents whose email Like '%naver.com");
            //display the students
            displayTheStudents(theStudents);


            //commit transaction
            session.getTransaction().commit();

            System.out.println("Done !");

        }
        finally {
            factory.close();
        }
    }

    private static void displayTheStudents(List<Student> theStudents) {
        for (Student tempStudent:theStudents){
            System.out.println(tempStudent);
        }
    }
}
