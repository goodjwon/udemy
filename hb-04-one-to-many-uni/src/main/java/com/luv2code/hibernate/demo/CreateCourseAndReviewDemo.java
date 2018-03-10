package com.luv2code.hibernate.demo;

import com.luv2code.hibernate.demo.entity.Course;
import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;
import com.luv2code.hibernate.demo.entity.Review;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateCourseAndReviewDemo {

    public static void main(String[] args) {

        //create session factory
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .addAnnotatedClass(Course.class)
                .addAnnotatedClass(Review.class)
                .buildSessionFactory();

        //create session
        Session session = factory.getCurrentSession();

        try {


            //create a student object
            session.beginTransaction();


            //create a course
            Course tempCourse = new Course("Pacman - How To Score One Millon Points");

            //add some reviews
            tempCourse.addReview(new Review("Greate course... loved it!"));
            tempCourse.addReview(new Review("Cool course... loved it!"));
            tempCourse.addReview(new Review("What a dumb course, you are an idiot!"));

            //save the course... and veverage the cascade all
            System.out.println("Saving the course");
            System.out.println(tempCourse);
            System.out.println(tempCourse.getReviews());

            session.save(tempCourse);

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
