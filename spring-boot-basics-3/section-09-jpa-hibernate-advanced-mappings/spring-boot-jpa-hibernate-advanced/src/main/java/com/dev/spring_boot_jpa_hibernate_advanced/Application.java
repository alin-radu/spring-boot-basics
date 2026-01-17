package com.dev.spring_boot_jpa_hibernate_advanced;

import com.dev.spring_boot_jpa_hibernate_advanced.dao.AppDAO;
import com.dev.spring_boot_jpa_hibernate_advanced.entity.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SuppressWarnings({"DuplicatedCode"})
@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(AppDAO appDAO) {
        return runner -> {
//            createInstructor(appDAO);

//            findInstructorSummaryById(appDAO);

//            deleteInstructorById(appDAO);

//            findInstructorDetailById(appDAO);

//            deleteInstructorDetailById(appDAO);

//            createInstructorWithCourses(appDAO);

//            findCoursesForInstructorId(appDAO);

//            findInstructorFullInfoById(appDAO);

//            updateInstructor(appDAO);

//            updateCourse(appDAO);

//            deleteCourseById(appDAO);

//            createCourseAndReviews(appDAO);

//            retrieveCourseAndReviews(appDAO);

//            deleteCourseAndReviews(appDAO);

//            createCourseAndStudents(appDAO);

//            findCourseAndStudents(appDAO);

//            findStudentAndCourses(appDAO);

//            addMoreCoursesForStudent(appDAO);

//            deleteCourse(appDAO);

//            deleteStudent(appDAO);

        };
    }
    private void deleteStudent(AppDAO appDAO) {

        int id = 1;

        System.out.println("Deleting student id: " + id);

        appDAO.deleteStudentById(id);

        System.out.println("---> Operation completed.");
    }

    private void addMoreCoursesForStudent(AppDAO appDAO) {

        int id = 2;
        Student tempStudent = appDAO.findStudentAndCoursesByStudentId(id);

        Course tempCourse1 = new Course("Rubik's Cube - How to Speed Cube");
        Course tempCourse2 = new Course("Atari 2600 - Game Development");

        tempStudent.addCourse(tempCourse1);
        tempStudent.addCourse(tempCourse2);

        System.out.println("Updating student: " + tempStudent);
        System.out.println("associated courses: " + tempStudent.getCourses());

        appDAO.updateStudent(tempStudent);

        System.out.println("---> Operation completed.");
    }

    private void findStudentAndCourses(AppDAO appDAO) {

        int id = 2;
        Student tempStudent = appDAO.findStudentAndCoursesByStudentId(id);

        System.out.println("Loaded student: " + tempStudent);
        System.out.println("Courses: " + tempStudent.getCourses());

        System.out.println("---> Operation completed.");
    }

    private void findCourseAndStudents(AppDAO appDAO) {

        int id = 10;
        Course tempCourse = appDAO.findCourseAndStudentsByCourseId(id);

        System.out.println("Loaded course: " + tempCourse);
        System.out.println("Students: " + tempCourse.getStudents());

        System.out.println("---> Operation completed.");
    }

    private void createCourseAndStudents(AppDAO appDAO) {

        Course tempCourse = new Course("Pacman - How To Score One Million Points");

        Student tempStudent1 = new Student("John", "Doe", "john@luv2code.com");
        Student tempStudent2 = new Student("Mary", "Public", "mary@luv2code.com");

        tempCourse.addStudent(tempStudent1);
        tempCourse.addStudent(tempStudent2);

        System.out.println("Saving the course: " + tempCourse);
        System.out.println("associated students: " + tempCourse.getStudents());

        appDAO.saveCourse(tempCourse);

        System.out.println("---> Operation completed.");
    }

    private void deleteCourseAndReviews(AppDAO appDAO) {

        int id = 10;

        System.out.println("Deleting course id: " + id);

        appDAO.deleteCourseById(id);

        System.out.println("---> Operation completed.");
    }

    // retrieveCourseAndReviews
    private void retrieveCourseAndReviews(AppDAO appDAO) {

        int id = 10;

        Course tempCourse = appDAO.findCourseAndReviewsByCourseId(id);

        System.out.println(tempCourse);
        System.out.println(tempCourse.getReviews());

        System.out.println("---> Operation completed.");
    }

    // createCourseAndReviews
    private void createCourseAndReviews(AppDAO appDAO) {

        Course tempCourse = new Course("Pacman - How To Score One Million Points");

        tempCourse.addReview(new Review("Great course ... loved it!"));
        tempCourse.addReview(new Review("Cool course, job well done."));
        tempCourse.addReview(new Review("What a dumb course, you are an idiot!"));

        System.out.println("---> Saving the course: " + tempCourse + " ...");

        appDAO.saveCourse(tempCourse);

        System.out.println("---> Operation completed.");
    }

    // deleteInstructorDetailById
    private void deleteCourseById(AppDAO appDAO) {

        int id = 15;

        System.out.println("---> Deleting the course with the id: " + id);

        appDAO.deleteCourseById(id);

        System.out.println("---> Operation completed.");
    }

    private void updateCourse(AppDAO appDAO) {

        int id = 10;

        System.out.println("---> Finding the course with the id: " + id);

        Course tempCourse = appDAO.findCourseById(id);

        tempCourse.setTitle("course_NO_3_UPDATED");

        appDAO.updateCourse(tempCourse);

        System.out.println("---> Operation completed.");
    }

    private void updateInstructor(AppDAO appDAO) {

        int id = 1;

        System.out.println("---> Finding the instructor with the id: " + id);

        Instructor tempInstructor = appDAO.findInstructorSummaryById(id);

        tempInstructor.setFirstName("FirstName_UPDATED");

        appDAO.updateInstructor(tempInstructor);

        System.out.println("---> Operation completed.");

    }

    // findInstructorFullInfoById
    private void findInstructorFullInfoById(AppDAO appDAO) {

        int id = 1;

        System.out.println("---> Finding the instructor with the id: " + id);

        Instructor tempInstructor = appDAO.findInstructorFullInfoById(id);

        System.out.println("---> instructor: " + tempInstructor);

        System.out.println("---> courses: " + tempInstructor.getCourses());

        System.out.println("---> Operation completed.");
    }
    private void findCoursesForInstructorId(AppDAO appDAO) {

        int id = 1;

        System.out.println("---> Finding the instructor with the id: " + id);

        Instructor tempInstructor = appDAO.findInstructorSummaryById(id);

        System.out.println("---> instructor: " + tempInstructor);

        List<Course> courses = appDAO.findCoursesByInstructorId(id);

        tempInstructor.setCourses(courses);

        System.out.println("---> courses: " + tempInstructor.getCourses());

        System.out.println("---> Operation completed.");
    }

    // createInstructorWithCourses
    private void createInstructorWithCourses(AppDAO appDAO) {

        int id = 15;

        Instructor tempInstructor =
                new Instructor("FirstName_" + id, "LastName_" + id, "test." + id + "@email.com");

        InstructorDetail tempInstructorDetail = new InstructorDetail("https://wwww.youtube/channel/" + id, "gaming_" + id);
        tempInstructor.setInstructorDetail(tempInstructorDetail);

        Course tempCourse1 = new Course("course_NO_" + (id + 2));
        Course tempCourse2 = new Course("course_NO_" + (id + 3));
        tempInstructor.addCourse(tempCourse1);
        tempInstructor.addCourse(tempCourse2);

        System.out.println("---> Saving instructor with the id : " + id + " ...");

        appDAO.saveInstructor(tempInstructor);

        System.out.println("---> Operation completed.");
    }

    // deleteInstructorDetailById
    private void deleteInstructorDetailById(AppDAO appDAO) {

        int id = 18;

        System.out.println("---> Deleting the instructorDetail with the id: " + id);

        appDAO.deleteInstructorDetailById(id);

        System.out.println("---> Operation completed.");
    }

    // findInstructorDetailById
    private void findInstructorDetailById(AppDAO appDAO) {

        int id = 7;

        System.out.println("---> Finding the instructorDetail with the id: " + id);

        InstructorDetail tempInstructorDetail = appDAO.findInstructorDetailById(id);

        System.out.println("---> tempInstructorDetail: " + tempInstructorDetail);
        System.out.println("---> instructor: " + tempInstructorDetail.getInstructor());

        System.out.println("---> Operation completed.");
    }

    // deleteInstructorById
    private void deleteInstructorById(AppDAO appDAO) {

        int id = 3;

        System.out.println("---> Deleting the instructor with the id: " + id);

        appDAO.deleteInstructorById(id);

        System.out.println("---> Operation completed.");
    }

    // findInstructorSummaryById
    private void findInstructorById(AppDAO appDAO) {

        int id = 1;

        System.out.println("---> Finding the instructor with the id: " + id);

        Instructor tempInstructor = appDAO.findInstructorSummaryById(id);

        System.out.println("---> instructor: " + tempInstructor);
        System.out.println("---> instructorDetail: " + tempInstructor.getInstructorDetail());
        System.out.println("---> courses: " + tempInstructor.getCourses());

        System.out.println("---> Operation completed.");
    }

    // createInstructor
    private void createInstructor(AppDAO appDAO) {

        int id = 5;

        Instructor tempInstructor =
                new Instructor("FirstName_" + id, "LastName_" + id, "test." + id + "@email.com");

        InstructorDetail tempInstructorDetail = new InstructorDetail("https://wwww.youtube/channel/" + id, "code_" + id);

        tempInstructor.setInstructorDetail(tempInstructorDetail);

        System.out.println("---> Saving instructor: " + tempInstructor);

        appDAO.saveInstructor(tempInstructor);

        System.out.println("---> Operation completed.");
    }

}
