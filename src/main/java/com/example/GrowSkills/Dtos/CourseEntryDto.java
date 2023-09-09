package com.example.GrowSkills.Dtos;

import com.example.GrowSkills.Enums.Course_category;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Getter;
import lombok.Setter;

@Getter
public class CourseEntryDto {
    private String course_name;
    @Enumerated(value = EnumType.STRING)
    private Course_category courseCategory;
    private int price;
}
