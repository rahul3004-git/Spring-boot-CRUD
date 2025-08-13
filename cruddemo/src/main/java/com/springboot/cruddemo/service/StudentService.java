package com.springboot.cruddemo.service;

import com.springboot.cruddemo.entity.Student;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

public interface StudentService {

    Student addStudent(Student student);

    List<Student> getAllStudents();

    Student updatedStudentById(@Valid Student student);

    List<Student> saveAllStudent(@Valid List<Student> student);

    Student updateStudentByPatch(Student student);

    void deleteStudentById(Student student);

    Optional<Student> getStudentById(Long id);

    Student getStudentByRequest(String name);
}
