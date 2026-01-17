package com.dev.spring_boot_rest_basics.rest;

import com.dev.spring_boot_rest_basics.entity.Student;
import jakarta.annotation.PostConstruct;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")

public class StudentRestController {
    private List<Student> students;

    @PostConstruct
    public void loadData() {

        students = new ArrayList<>();

        students.add(new Student("StudentFirstNameNo1", "StudentLastNameNo1"));
        students.add(new Student("StudentFirstNameNo2", "StudentLastNameNo2"));
        students.add(new Student("StudentFirstNameNo3", "StudentLastNameNo3"));
    }

    @GetMapping("/students")
    public List<Student> getStudents() {

        return students;
    }

    @GetMapping("/students/{studentId}")
    public Student getStudent(@PathVariable int studentId) {

        if ((studentId >= students.size()) || (studentId < 0)) {
            throw new StudentNotFoundException("Student id not found: " + studentId);
        }

        return students.get(studentId);
    }
}

//@ExceptionHandler
//public ResponseEntity<StudentErrorResponse> handleException(StudentNotFoundException exc) {
//
//    System.out.println("EXECUTED | StudentNotFoundException | 1");
//
//    StudentErrorResponse error = new StudentErrorResponse();
//
//    error.setStatus(HttpStatus.NOT_FOUND.value());
//    error.setMessage(exc.getMessage() + " 1");
//    error.setTimeStamp(System.currentTimeMillis());
//
//    return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
//}
//
//@ExceptionHandler
//public ResponseEntity<StudentErrorResponse> handleException(Exception exc) {
//
//    System.out.println("EXECUTED | Exception | 1");
//
//    StudentErrorResponse error = new StudentErrorResponse();
//
//    error.setStatus(HttpStatus.BAD_REQUEST.value());
//    error.setMessage(exc.getMessage() + " 1");
//    error.setTimeStamp(System.currentTimeMillis());
//
//    return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
//}
