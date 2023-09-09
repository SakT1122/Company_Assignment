package com.example.GrowSkills.Repository;

import com.example.GrowSkills.Models.Enrollment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EnrollmentRepository extends JpaRepository<Enrollment,Integer> {
}
