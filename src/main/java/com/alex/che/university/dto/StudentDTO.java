package com.alex.che.university.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@ToString
public class StudentDTO {

    private Long id;
    private String name;
    List<CourseDTO> courseStudent;
}
