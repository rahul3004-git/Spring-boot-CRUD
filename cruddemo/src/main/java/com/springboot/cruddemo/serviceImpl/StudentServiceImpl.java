package com.springboot.cruddemo.serviceImpl;

import com.springboot.cruddemo.entity.Student;
import com.springboot.cruddemo.repository.StudentRepository;
import com.springboot.cruddemo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Override
    public Student addStudent(Student student) {
        return studentRepository.save(student);

    }

    @Override
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    @Override
    public Student updatedStudentById(Student student) {

        Optional<Student> getStudentById = studentRepository.findById(student.getId());

        if (getStudentById.isPresent()) {
            Student updateStudent = getStudentById.get();
            updateStudent.setFirstName(student.getFirstName());
            updateStudent.setLastName(student.getLastName());
            updateStudent.setEmail(student.getEmail());
            updateStudent.setAge(student.getAge());
            updateStudent.setPhoneNumber(student.getPhoneNumber());
            return studentRepository.save(updateStudent);
        }

        return null;

    }

    @Override
    public List<Student> saveAllStudent(List<Student> student) {
        return studentRepository.saveAll(student);
    }

    @Override
    public Student updateStudentByPatch(Student student) {

        Optional<Student> getStudent = studentRepository.findById(student.getId());

        if (getStudent.isPresent()){
            Student existingStudent = getStudent.get();

            if (student.getFirstName() != null) {
                existingStudent.setFirstName(student.getFirstName());
            }
            if (student.getLastName() != null) {
                existingStudent.setLastName(student.getLastName());
            }
            if (student.getEmail() != null) {
                existingStudent.setEmail(student.getEmail());
            }
            if (student.getAge() != null) {
                existingStudent.setAge(student.getAge());
            }
            if (student.getPhoneNumber() != null) {
                existingStudent.setPhoneNumber(student.getPhoneNumber());
            }
            return studentRepository.save(existingStudent);
        }
        return null;
    }

    @Override
    public void deleteStudentById(Student student) {

        studentRepository.deleteById(student.getId());
    }

    @Override
    public Optional<Student> getStudentById(Long id) {
        
        return studentRepository.findById(id);
    }

    @Override
    public Student getStudentByRequest(String name) {
        return studentRepository.findByFirstName(name);
    }
}
