package com.dev.spring_boot_hibernate_basics;

import com.dev.spring_boot_hibernate_basics.dao.StudentDAO;
import com.dev.spring_boot_hibernate_basics.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(StudentDAO studentDAO) {

        return runner -> {
            System.out.println("---> commandLineRunner EXECUTING...");

//            createStudent(studentDAO);

            createMultipleStudents(studentDAO);

//            readStudent(studentDAO);

//            queryForStudents(studentDAO);

//            queryForStudentsByLastName(studentDAO);

//            updateStudent(studentDAO);

//            deleteStudent(studentDAO);

//            deleteAllStudents(studentDAO);

            System.out.println("---> commandLineRunner EXECUTED");
        };
    }

    // deleteAllStudents
    private void deleteAllStudents(StudentDAO studentDAO) {
        int numRowsDeleted = studentDAO.deleteAll();

        System.out.println("Deleted row count: " + numRowsDeleted);
    }

    // deleteStudent
    private void deleteStudent(StudentDAO studentDAO) {
        int id = 1;
        Student student = studentDAO.findById(id);

        if (student == null) {
            System.out.println("No data found.");

        } else {
            studentDAO.delete(id);
        }
    }

    // updateStudent
    private void updateStudent(StudentDAO studentDAO) {
        int id = 1;
        Student student = studentDAO.findById(id);

        if (student == null) {
            System.out.println("No data found.");
        } else {
            student.setFirstName("John");
            studentDAO.update(student);

        }
    }

    // queryForStudentsByLastName
    private void queryForStudentsByLastName(StudentDAO studentDAO) {
        List<Student> students = studentDAO.findByLastName("Doe1");

        if (students.isEmpty()) {
            System.out.println("No data found.");
        } else {
            students.forEach(System.out::println);
        }
    }

    // queryForStudents
    private void queryForStudents(StudentDAO studentDAO) {
        List<Student> students = studentDAO.findAll();

//        for (Student tempStudent : students) {
//            System.out.println(tempStudent);
//        }

//        students.forEach(student -> System.out.println(student));

        students.forEach(System.out::println);
    }

    // findStudentById
    private void readStudent(StudentDAO studentDAO) {
        Student createdStudent = createStudent(studentDAO);

        int studentId = createdStudent.getId();
        System.out.println(studentId);

        Student student = studentDAO.findById(studentId);

        System.out.println("Found the Student: " + student);
    }

    // createMultipleStudents
    private void createMultipleStudents(StudentDAO studentDAO) {
        Student tempStudent1 = new Student("John1", "Doe1", "test1@email.io");
        Student tempStudent2 = new Student("John2", "Doe2", "test2@email.io");
        Student tempStudent3 = new Student("John3", "Doe3", "test3@email.io");

        studentDAO.save(tempStudent1);
        studentDAO.save(tempStudent2);
        studentDAO.save(tempStudent3);
    }

    // createStudent
    private Student createStudent(StudentDAO studentDAO) {
        Student tempStudent = new Student("Daffy", "Beast", "test@gmail.io");

        studentDAO.save(tempStudent);

        return tempStudent;
    }
}
