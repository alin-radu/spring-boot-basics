package com.dev.spring_boot_jpa_basics;

import com.dev.spring_boot_jpa_basics.model.Course;
import com.dev.spring_boot_jpa_basics.repository.CourseSpringDataJpaRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class CourseCommandLineRunner implements CommandLineRunner{
    private final CourseSpringDataJpaRepository repository;
    public CourseCommandLineRunner(CourseSpringDataJpaRepository repository) {
        this.repository = repository;
    }

    @Override
    public void run(String... args) throws Exception {
        repository.save(new Course(1, "Learn AWS Jpa!", "in28minutes"));
        repository.save(new Course(2, "Learn Azure Jpa!", "in28minutes"));
        repository.save(new Course(3, "Learn DevOps Jpa!", "in28minutes"));


         // delete
        repository.deleteById(1L);

        System.out.println(repository.findById(2L));
//        System.out.println(repository.findById(3L));

//        System.out.println(repository.findAll());
//        System.out.println(repository.count());
//
//        System.out.println(repository.findByAuthor("in28minutes"));
//        System.out.println(repository.findByAuthor(""));
//
//        System.out.println(repository.findByName("Learn AWS Jpa!"));
//        System.out.println(repository.findByName("Learn DevOps Jpa!"));


    }
}
