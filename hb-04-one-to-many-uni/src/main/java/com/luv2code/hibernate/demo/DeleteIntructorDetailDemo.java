package com.luv2code.hibernate.demo;

import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DeleteIntructorDetailDemo {

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

            //get hte instructor detail object
            int theId = 3;
            InstructorDetail instructorDetail =
                    session.get(InstructorDetail.class, theId);

            System.out.println("instructorDetail: "+instructorDetail);

            System.out.println("the associated instructor: "
                +instructorDetail.getInstructor());

            System.out.println("Deleting: "+instructorDetail);


            //관계 삭제  mapManagedFlushFailure 오류 예외 처리.
            instructorDetail.getInstructor().setInstructorDetail(null);

            session.delete(instructorDetail);

            //commit transaction
            session.getTransaction().commit();

            System.out.println("Done !");

        }
        catch (Exception exc){
            exc.printStackTrace();

        }
        finally {
            session.close();
            factory.close();
        }
    }
}
