package ua.opu.isus.spring.first_project.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.opu.isus.spring.first_project.entities.Student;
import ua.opu.isus.spring.first_project.repos.StudentRepository;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    @Autowired
    StudentRepository repository;

    public List<Student> getAllStudents() {
        return repository.findAll();
    }

    public Optional<Student> getStudentById(long id) {
        return repository.findById(id);
    }

    public void addStudent(Student s) {
        repository.saveAndFlush(s);
    }

}