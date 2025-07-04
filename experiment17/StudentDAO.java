package com.example.dao;

import com.example.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class StudentDAO {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Transactional
    public void insertAndUpdate(Student s1, Student s2) {
        jdbcTemplate.update("INSERT INTO student VALUES (?, ?, ?)", s1.getId(), s1.getName(), s1.getAddress());
        jdbcTemplate.update("INSERT INTO student VALUES (?, ?, ?)", s2.getId(), s2.getName(), s2.getAddress());

        // Simulate failure for transaction rollback
        if (true) {
            throw new RuntimeException("Simulated failure");
        }

        jdbcTemplate.update("UPDATE student SET address = ? WHERE id = ?", "Bangalore", s1.getId());
    }
}
