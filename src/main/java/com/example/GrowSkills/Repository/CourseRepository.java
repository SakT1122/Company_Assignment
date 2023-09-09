package com.example.GrowSkills.Repository;

import com.example.GrowSkills.Models.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<Course, Integer> {
}
