package com.alex.che.university.service;

import com.alex.che.university.dto.CourseDTO;
import com.alex.che.university.dto.StudentDTO;
import com.alex.che.university.entity.Course;
import com.alex.che.university.repository.CourseRepository;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Service
@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
public class CourseServiceImpl implements CourseService {

    private CourseRepository courseRepository;
    private ModelMapper mapper;

    @Autowired
    public CourseServiceImpl(CourseRepository courseRepository,
                             ModelMapper mapper) {
        this.courseRepository = courseRepository;
        this.mapper = mapper;
    }

    @Override
    public CourseDTO findCourseByTitle(String title) {
        Course course = courseRepository.findCourseByTitle(title);
        return convert(course);
    }

    @Override
    public CourseDTO findCourseById(Long id) {
        Course course = courseRepository.getOne(id);
        return convert(course);
    }

    @Override
    public List<CourseDTO> findAllCourses() {
        List<Course> courses = courseRepository.findAll();
        List<CourseDTO> courseDTOS = new ArrayList<>();
        courses.forEach(val -> courseDTOS.add(convert(val)));
        return courseDTOS;
    }

    @Override
    public void saveCourse(CourseDTO courseDTO) {
        courseRepository.save(mapper.map(courseDTO, Course.class));
    }

    @Override
    public void deleteCourse(CourseDTO courseDTO) {
        courseRepository.delete(mapper.map(courseDTO, Course.class));
    }

    private CourseDTO convert(Course course) {
        Set<StudentDTO> studentDTOS =
                mapper.map(course.getStudents(), new TypeToken<Set<StudentDTO>>() {
                }.getType());
        CourseDTO dto = mapper.map(course, CourseDTO.class);
        dto.setStudents(studentDTOS);
        return dto;
    }
}
