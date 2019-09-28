package com.alex.che.university.service;

import com.alex.che.university.dto.CourseDTO;
import com.alex.che.university.dto.StudentDTO;
import com.alex.che.university.entity.Student;
import com.alex.che.university.repository.StudentRepository;
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
public class StudentServiceImpl implements StudentService {

    private StudentRepository studentRepository;
    private ModelMapper mapper;

    @Autowired
    public StudentServiceImpl(StudentRepository studentRepository,
                              ModelMapper mapper) {
        this.studentRepository = studentRepository;
        this.mapper = mapper;
    }

    @Override
    @Transactional(readOnly = true, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public StudentDTO findStudentByName(String name) {
        Student student = studentRepository.findStudentByName(name);
        return convert(student);
    }

    @Override
    public StudentDTO findStudentById(Long id) {
        Student student = studentRepository.getOne(id);
        return convert(student);
    }

    @Override
    @Transactional(readOnly = true, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public List<StudentDTO> findAllStudents() {
        List<Student> students = studentRepository.findAll();
        List<StudentDTO> studentDTOS = new ArrayList<>();
        students.forEach(val -> studentDTOS.add(convert(val)));
        return studentDTOS;
    }

    @Override
    public void saveStudent(StudentDTO studentDTO) {
        studentRepository.save(mapper.map(studentDTO, Student.class));
    }

    @Override
    public void deleteStudent(StudentDTO studentDTO) {
        studentRepository.delete(mapper.map(studentDTO, Student.class));
    }

    private StudentDTO convert(Student student) {
        Set<CourseDTO> courseDTOS =
                mapper.map(student.getCourses(), new TypeToken<Set<CourseDTO>>() {
                }.getType());
        StudentDTO dto = mapper.map(student, StudentDTO.class);
        dto.setCourses(courseDTOS);
        return dto;
    }
}
