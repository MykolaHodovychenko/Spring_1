package ua.opu.isus.spring.first_project.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ua.opu.isus.spring.first_project.entities.Student;
import ua.opu.isus.spring.first_project.services.StudentService;

import java.util.List;
import java.util.Optional;

@RestController
public class StudentController {

    @Autowired
    StudentService service;

    // http://localhost:8080/students/123
    @RequestMapping("/students/{id}")
    public Student getStudentByPathVariableId(@PathVariable(name = "id") long id) {
        Optional<Student> student = service.getStudentById(id);

        return student.orElse(null);
    }

    /* Реализация через query string

    // http://localhost:8080/students?id=123
    @RequestMapping("/students")
    public Student getStudentByQueryStringId(@RequestParam(name = "id", required = true) long id) {

        Optional<Student> student = service.getStudentById(id);
        return student.orElse(null);
    }

    */

    /* Пример обработки запроса с несколькими параметрами

    // http://localhost:8080/someurl?arg0=123&arg2=999&arg3=500
    @RequestMapping("/someurl")
    public void foo(@RequestParam(name="arg0") int val0,
                    @RequestParam(name="arg1") int val1,
                    @RequestParam(name="arg2") int val2) {
        // val0 = 123
        // val1 = 999
        // val2 = 500
    }

    */

    @RequestMapping("/students")
    public List<Student> getAllStudents() {
        return service.getAllStudents();
    }

    @RequestMapping(value = "/students", method = RequestMethod.POST)
    public void addStudent(@RequestBody Student s) {
        service.addStudent(s);
    }

}
