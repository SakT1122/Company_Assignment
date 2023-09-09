package com.example.GrowSkills.Models;

import com.example.GrowSkills.Enums.Course_category;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "course")
public class Course {
    @Id
    @GeneratedValue
    private int course_id;
    private String course_name;
    private int price;
    @Enumerated(value = EnumType.STRING)
    private Course_category courseCategory;
    @ManyToOne @JoinColumn
    private Customer customer;

    @OneToMany(mappedBy = "course", cascade = CascadeType.ALL)
    List<Customer> customerList;

    @OneToMany(mappedBy = "course", cascade = CascadeType.ALL)
    List<Classes> classesListRecordings;
}
