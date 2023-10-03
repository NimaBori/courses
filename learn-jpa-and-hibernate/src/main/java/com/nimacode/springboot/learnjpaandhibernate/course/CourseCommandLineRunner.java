package com.nimacode.springboot.learnjpaandhibernate.course;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.nimacode.springboot.learnjpaandhibernate.course.jdbc.CourseJdbcRepository;
import com.nimacode.springboot.learnjpaandhibernate.course.springdatajpa.CourseSpringDataJpaRepository;

// commend line runner allow us to run starter
@Component
public class CourseCommandLineRunner implements CommandLineRunner {

    // @Autowired /// dindById method not working
    // private CourseJdbcRepository repository;

    // @Autowired ??? not working!
    // private CourseJpaRepository repository;

    @Autowired // best practice
    private CourseSpringDataJpaRepository repository;

    @Override
    public void run(String... args) throws Exception {
        repository.save(new Course(1, "Learn H2 Databse", "nimacode"));
        repository.save(new Course(2, "Learn SQL", "nimacode"));
        repository.save(new Course(3, "Learn Java", "nimacode"));

        // repository.delete(3); // for CourseJdbcRepository

        // repository.deleteById(3); // for CourseJpaRepository

        repository.deleteById(1l);

        System.out.println(repository.count());
        System.out.println(repository.findById(1l));
        System.out.println(repository.findByAuthor("nimacode"));
        System.out.println(repository.findByName("Learn Java"));

        // repository.findById(1);
    }

}
