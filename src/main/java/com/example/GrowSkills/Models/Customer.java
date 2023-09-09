package com.example.GrowSkills.Models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "customer")
public class Customer {
    @Id
    @GeneratedValue
    private int customer_id;
    private String customer_name;
    private String gender;
    private String password;

    @ManyToOne @JoinColumn
    private Course course;

    @ManyToOne @JoinColumn
    private Classes classes;
    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
    private List<Course> courseList;
}
