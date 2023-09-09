package com.example.GrowSkills.Repository;

import com.example.GrowSkills.Models.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {
}
