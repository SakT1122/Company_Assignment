package com.example.GrowSkills.Dtos;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

@Getter
public class CustomerEntryDto {
    private String customer_name;
    private String gender;
    private String password;
}
