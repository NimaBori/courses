package com.nimacode.springboot.learnjpaandhibernate.course.jdbc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
// import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.nimacode.springboot.learnjpaandhibernate.course.Course;

// responsible for talking to database
@Repository
public class CourseJdbcRepository {

    @Autowired
    private JdbcTemplate springJdbcTemplate;

    // text block in Java 15+ | Java 11 > Multi Line String
    // to pass values from Course class, ? used and then
    // their values passed into update method in the same order.
    private static String INSERT_QUERY = "insert into course (id, name, author)\n values(?, ?, ?)";
    // delete a row
    private static String DELETE_QUERY = "delete from course where id=?";
    // retrive data from database // SELECT * FROM TEST ORDER BY ID;
    // select * from course where id=?
    private static String SELECT_QUERY = "select * from course where id=?";

    public void insert(Course course) {
        springJdbcTemplate.update(INSERT_QUERY,
                course.getId(), course.getName(), course.getAuthor());
    }

    public void delete(long id) {
        springJdbcTemplate.update(DELETE_QUERY, id);
    }

    public Course findById(long id) {
        // ResultSet -> Bean mapping (Course class) => rowMapper : I want to map to
        // Course class
        // id is input - id will be replaced in query
        return springJdbcTemplate.queryForObject(SELECT_QUERY,
                new BeanPropertyRowMapper<>(Course.class), id);

    }

}

//