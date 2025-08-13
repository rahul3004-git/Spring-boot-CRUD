package com.springboot.cruddemo.controller;

import com.springboot.cruddemo.entity.Student;
import com.springboot.cruddemo.service.StudentService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/students")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @PostMapping("/addStudent")
    public ResponseEntity<Map<String, Object>> addStudent(@Valid @RequestBody Student student){
       Student savedDetail = studentService.addStudent(student);

       Map<String,Object> response = new HashMap<>();
       response.put("success",true);
       response.put("message","Student Record Created");
       response.put("data",savedDetail);

       return new ResponseEntity<>(response,HttpStatus.CREATED);

    }

    @PostMapping("/addListOfStudent")
    public ResponseEntity<Map<String,Object>> saveAllStudent(@Valid @RequestBody List<Student> student){
        List<Student> savedStudents = studentService.saveAllStudent(student);

        Map<String,Object> response = new HashMap<>();
        response.put("success",true);
        response.put("message","Students List have been saved successfully");
        response.put("Data",savedStudents);

        return new ResponseEntity<>(response,HttpStatus.CREATED);
    }

    @GetMapping("/getStudent")
    public ResponseEntity<Map<String, Object>> getStudents(){
        List<Student> studentList = studentService.getAllStudents();
       studentList.stream()
                .filter(student -> student.getAge() < 28)
               .map(Student::getFirstName)
               .forEach(System.out::println);


        Map<String,Object> response = new HashMap<>();
        response.put("success",true);
        response.put("data",studentList);
        return new ResponseEntity<>(response,HttpStatus.OK);
    }

    @PutMapping("/updateStudent")
    public ResponseEntity<Map<String,Object>> updateStudent(@RequestBody Student student){

        Student updatedStudent = studentService.updatedStudentById(student);
        Map<String,Object> response = new HashMap<>();
        response.put("success",true);
        response.put("message","Student data has been updated");
        response.put("data",updatedStudent);

        return new ResponseEntity<>(response,HttpStatus.CREATED);
    }

    @PatchMapping("/updateSpecificField")
    public ResponseEntity<Map<String,Object>> updateStudentByPatch(@RequestBody Student student){

        Student updatedStudent = studentService.updateStudentByPatch(student);

        Map<String,Object> response = new HashMap<>();
        response.put("success",true);
        response.put("message","Student data has been updated");
        response.put("data",updatedStudent);

        return new ResponseEntity<>(response,HttpStatus.OK);
    }

    @DeleteMapping("/deleteStudent")
    public ResponseEntity<Map<String,Object>> deleteStudentById(@RequestBody Student student){

        studentService.deleteStudentById(student);
        Map<String,Object> response = new HashMap<>();
        response.put("success",true);
        response.put("message","Student data has been deleted");

        return new ResponseEntity<>(response,HttpStatus.OK);
    }

    @GetMapping("/getStudentById/{id}")
    public ResponseEntity<Map<String,Object>> getStudentsByPath(@PathVariable Long id){

        Optional<Student> getStudent = studentService.getStudentById(id);

        Map<String,Object> response = new HashMap<>();
        response.put("success",true);
        response.put("Data",getStudent);

        return new ResponseEntity<>(response,HttpStatus.OK);
    }

    @GetMapping("/getStudentByRequest")
    public ResponseEntity<Map<String,Object>> getStudentsByRequest(@RequestParam(name = "firstName") String name){

        Student getStudentByRequest = studentService.getStudentByRequest(name);

        Map<String,Object> response = new HashMap<>();

        response.put("success",true);
        response.put("Data",getStudentByRequest);

        return new ResponseEntity<>(response,HttpStatus.OK);
    }
}
