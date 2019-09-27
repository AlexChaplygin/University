package com.alex.che.university.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@ToString
public class CourseDTO {

    private Long id;
    private String title;
    private String description;
    List<StudentDTO> students;
}
