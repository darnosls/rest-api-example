package com.students.apirest.service;

import com.students.apirest.entity.Student;
import com.students.apirest.repository.StudentRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class StudentService {
    private StudentRepository studentRepository;


    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }


    @Transactional
    public Student saveStudent(Student student) {
        return this.studentRepository.save(student);
    }

    @Transactional
    public void deleteStudentById(Long id) {
        var student = this.studentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Estudante não encontrado"));
        this.studentRepository.deleteById(id);
    }

    public Student updateStudent(Student student) {

        return this.studentRepository.save(student);
    }

    public List<Student> findAllStudents(){
        return this.studentRepository.findAll();
    }

    public Student findStudentById(Long id) {
        return this.studentRepository.findById(id).orElseThrow(() -> new RuntimeException("Estudante não encontrado"));
    }
}
