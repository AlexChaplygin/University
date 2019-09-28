package com.alex.che.university.controller;

import com.alex.che.university.dto.CourseDTO;
import com.alex.che.university.dto.StudentDTO;
import com.alex.che.university.service.CourseService;
import com.alex.che.university.service.StudentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/")
public class UniversityController {

    private StudentService studentService;
    private CourseService courseService;

    public UniversityController(StudentService studentService,
                                CourseService courseService) {
        this.studentService = studentService;
        this.courseService = courseService;
    }

    @GetMapping("/student/{id}")
    public ResponseEntity<StudentDTO> getStudentById(@PathVariable Long id) {
        return ResponseEntity.ok(studentService.findStudentById(id));
    }

    @GetMapping("/students")
    public List<StudentDTO> getStudents() {
        return studentService.findAllStudents();
    }

    @GetMapping("/course/{id}")
    public ResponseEntity<CourseDTO> getCourseById(@PathVariable Long id) {
        return ResponseEntity.ok(courseService.findCourseById(id));
    }

    @GetMapping("/courses")
    public ResponseEntity<List<CourseDTO>> getCourses() {
        return ResponseEntity.ok(courseService.findAllCourses());
    }
}
