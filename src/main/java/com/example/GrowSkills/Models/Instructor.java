package com.example.GrowSkills.Models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "instructor")
public class Instructor {
    @Id
    @GeneratedValue
    private int instructor_id;
    private String instructor_name;
}
