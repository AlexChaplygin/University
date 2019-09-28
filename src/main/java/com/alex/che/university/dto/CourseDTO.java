package com.alex.che.university.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
public class CourseDTO {
    private Long id;
    private String title;
    private String description;
    Set<StudentDTO> students;
}
