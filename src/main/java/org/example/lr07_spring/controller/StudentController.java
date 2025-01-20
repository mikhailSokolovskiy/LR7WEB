package org.example.lr07_spring.controller;


import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.example.lr07_spring.dao.StudentRepository;
import org.example.lr07_spring.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import java.util.Optional;

@RestController
@Slf4j
public class StudentController {

    private final StudentRepository studentRepository;
    @Autowired
    public StudentController(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }
    @GetMapping({"/list", "/"})
    public ModelAndView getAllStudents() {
        ModelAndView modelAndView = new ModelAndView("list-students");
        modelAndView.addObject("students", studentRepository.findAll());
        return modelAndView;
    }
    @GetMapping("/addStudentForm")
    public ModelAndView addStudentForm() {
        ModelAndView modelAndView = new ModelAndView("add-student-form");
        Student student = new Student();
        modelAndView.addObject("student", student);
        return modelAndView;
    }
    @PostMapping("/saveStudent")
    public RedirectView saveStudent(@ModelAttribute Student student) {
        studentRepository.save(student);
        return new RedirectView("list");
    }
    @GetMapping("/showUpdateForm")
    public ModelAndView showUpdateForm(@RequestParam Integer studentId) {
        ModelAndView modelAndView = new ModelAndView("add-student-form");
        Optional<Student> optionalStudent = studentRepository.findById(studentId);
        Student student = new Student();
        if (optionalStudent.isPresent()) {
            student = optionalStudent.get();
        }
        modelAndView.addObject("student", student);
        return modelAndView;
    }
    @GetMapping("/deleteStudent")
    public RedirectView deleteStudent(@RequestParam Integer studentId, ModelAndView modelAndView) {
        studentRepository.deleteById(studentId);
        return new RedirectView("list");
    }
}
