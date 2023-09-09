package com.example.GrowSkills.Models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Getter
@Setter
@Table(name = "classes")
public class Classes {

    @Id
    @GeneratedValue
    private int class_id;
    private LocalTime time;
    private LocalDate date;
    private String topic;
    private String zoom_link;
    private String recording_link;

    @ManyToOne @JoinColumn
    private Course course;
}
