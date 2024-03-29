package com.alex.che.university.service;

import com.alex.che.university.dto.CourseDTO;

import java.util.List;

public interface CourseService {

    CourseDTO findCourseByTitle(String title);

    CourseDTO findCourseById(Long id);

    List<CourseDTO> findAllCourses();

    void saveCourse(CourseDTO courseDTO);

    void deleteCourse(CourseDTO courseDTO);
}
