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

    @GetMapping("/student/{name}")
    public ResponseEntity<StudentDTO> getStudent(@PathVariable String name) {
        return ResponseEntity.ok(studentService.findStudentByName(name));
    }

    @GetMapping("/students")
    public ResponseEntity<List<StudentDTO>> getStudents() {
        return ResponseEntity.ok(studentService.findAllStudents());
    }

    @GetMapping("/course/{title}")
    public ResponseEntity<CourseDTO> getCourse(@PathVariable String title) {
        return ResponseEntity.ok(courseService.findCourseByTitle(title));
    }

    @GetMapping("/courses")
    public ResponseEntity<List<CourseDTO>> getCourses() {
        return ResponseEntity.ok(courseService.findAllCourses());
    }
}
