package com.springboot.cruddemo.repository;

import com.springboot.cruddemo.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;


public interface StudentRepository extends JpaRepository<Student,Long> {

    Student findByFirstName(String name);
}
