package com.alex.che.university.repository;

import com.alex.che.university.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {

    Course findCourseByTitle(String title);
}
