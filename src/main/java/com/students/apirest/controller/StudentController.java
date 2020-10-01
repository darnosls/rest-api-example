package com.students.apirest.controller;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

import com.students.apirest.entity.Student;
import com.students.apirest.service.StudentService;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value="/api")
public class StudentController {

    private final StudentService studentService;

    StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

//    @GetMapping("/students")
//    public List<Student> listStudent() {
//        return this.studentService.findAllStudents();
//    }
    @GetMapping("/students")
    CollectionModel<EntityModel<Student>> listStudent() {

        List<EntityModel<Student>> students = this.studentService.findAllStudents().stream()
                .map(student -> EntityModel.of(student,
                        linkTo(methodOn(StudentController.class).getOneStudent(student.getId())).withSelfRel(),
                        linkTo(methodOn(StudentController.class).listStudent()).withRel("students")))
                .collect(Collectors.toList());

        return CollectionModel.of(students, linkTo(methodOn(StudentController.class).listStudent()).withSelfRel());
    }

    @GetMapping("/students/{id}")
    EntityModel<Student> getOneStudent(@PathVariable Long id) {

        Student student = studentService.findStudentById(id);

        return EntityModel.of(student,
                linkTo(methodOn(StudentController.class).getOneStudent(id)).withSelfRel(),
                linkTo(methodOn(StudentController.class).listStudent()).withRel("students"));
    }


//    @GetMapping("/students/{id}")
//    public Student getOneStudent(@PathVariable(value="id") long id) {
//        return studentService.findStudentById(id);
//    }

    @PostMapping("/students")
    public Student saveStudent(@RequestBody Student student) {
        return studentService.saveStudent(student);
    }

    @PutMapping("/students")
    public Student updateStudent(@RequestBody Student student) {
        return studentService.updateStudent(student);
    }

    @DeleteMapping("/students/{id}")
    public void deleteStudent(@PathVariable(value="id") long id ) {
        studentService.deleteStudentById(id);
    }
}
