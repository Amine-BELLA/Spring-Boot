package com.example.demo.services;

import ch.qos.logback.core.net.SyslogOutputStream;
import com.example.demo.models.Student;
import com.example.demo.repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    private final StudentRepository studentRepository;
    @Autowired
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public List<Student> getStudent() {
        return studentRepository.findAll();
    }

    public void addStudent(Student student) {
        Optional<Student> student1 = studentRepository.findStudentByEmail(student.getEmail());
        if (student1 == null) {
            studentRepository.save(student);
        }
        else {
            System.out.print("Email already exists");
        }
    }

    public void deleteStudent(Long id) {
        boolean b = studentRepository.existsById(id);
        if (b) {
            studentRepository.deleteById(id);
        }
    }

    public void updateStudent(Long id, String name, String email) {
        Optional<Student> student = studentRepository.findById(id);
        if (student.isPresent()) {
            student.setName(name);
            student.setEmail(email);
        }
    }
}
