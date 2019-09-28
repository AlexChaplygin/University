package com.alex.che.university.service;

import com.alex.che.university.dto.StudentDTO;

import java.util.List;

public interface StudentService {

    StudentDTO findStudentByName(String name);

    StudentDTO findStudentById(Long id);

    List<StudentDTO> findAllStudents();

    void saveStudent(StudentDTO studentDTO);

    void deleteStudent(StudentDTO studentDTO);

}
