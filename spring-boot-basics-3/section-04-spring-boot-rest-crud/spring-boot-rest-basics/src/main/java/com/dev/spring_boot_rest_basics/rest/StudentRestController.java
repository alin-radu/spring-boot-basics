package com.dev.spring_boot_rest_basics.rest;

import com.dev.spring_boot_rest_basics.entity.Student;
import com.dev.spring_boot_rest_basics.exception.StudentNotFoundException;
import jakarta.annotation.PostConstruct;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<List<Student>> getStudents() {

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(students);
    }

    @GetMapping("/students/{studentId}")
    public ResponseEntity<Student> getStudent(@PathVariable int studentId) {

        if ((studentId >= students.size()) || (studentId < 0)) {
            throw new StudentNotFoundException("Student id not found: " + studentId);
        }

        Student student = students.get(studentId);

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(student);
    }
}

//@ExceptionHandler
//public ResponseEntity<StudentErrorResponse> handleException(StudentNotFoundException exc) {
//
//    System.out.println("EXECUTED | StudentNotFoundException | v1");
//
//    StudentErrorResponse error = new StudentErrorResponse();
//
//    error.setStatus(HttpStatus.NOT_FOUND.value());
//    error.setMessage(exc.getMessage() + " v1");
//    error.setTimeStamp(System.currentTimeMillis());
//
//    return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
//}
//
//@ExceptionHandler
//public ResponseEntity<StudentErrorResponse> handleException(Exception exc) {
//
//    System.out.println("EXECUTED | Exception | v1");
//
//    StudentErrorResponse error = new StudentErrorResponse();
//
//    error.setStatus(HttpStatus.BAD_REQUEST.value());
//    error.setMessage(exc.getMessage() + " v1");
//    error.setTimeStamp(System.currentTimeMillis());
//
//    return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
//}
