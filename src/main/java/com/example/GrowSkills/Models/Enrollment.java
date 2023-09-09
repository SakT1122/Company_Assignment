package com.example.GrowSkills.Models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "enrollment")
public class Enrollment {
    @Id
    @GeneratedValue
    private int enrollment_id;
    private boolean status;
    private int amount;
}
