package com.example.GrowSkills.Dtos;

import com.example.GrowSkills.Models.Course;
import com.example.GrowSkills.Models.Customer;
import lombok.Getter;
import lombok.Setter;

@Getter
public class EnrollEntryDto {
    private String customer_name;
    private String course_name;
    private int amount;
}
