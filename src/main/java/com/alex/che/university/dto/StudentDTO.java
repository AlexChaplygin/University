package com.alex.che.university.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
public class StudentDTO {

    private Long id;
    private String name;
    Set<CourseDTO> courses;
}
