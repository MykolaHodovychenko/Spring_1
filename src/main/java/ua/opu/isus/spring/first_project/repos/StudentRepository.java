package ua.opu.isus.spring.first_project.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.opu.isus.spring.first_project.entities.Student;

public interface StudentRepository extends JpaRepository<Student, Long> {}
