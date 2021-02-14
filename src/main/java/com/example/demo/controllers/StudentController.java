package com.example.demo.controllers;

import com.example.demo.models.Student;
import com.example.demo.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/api/v1/student")

public class StudentController {

    @Autowired
    private StudentService studentService;

    @GetMapping
    public List<Student> getStudent() {
        return studentService.getStudent();
    }

    @PostMapping
    public void addStudent(@RequestBody Student student) {
        studentService.addStudent(student);
    }

    @DeleteMapping(value = "/{id}")
    public void deleteStudent(@PathVariable Long id) {
        studentService.deleteStudent(id);
    }

    @PutMapping(value = "/{id}")
    public void updateStudent(
            @PathVariable Long id,
            @RequestParam String name,
            @RequestParam String email
    ) {
        studentService.updateStudent(id,name,email);
    }
}
