package com.example.GrowSkills.Service;

import com.example.GrowSkills.Models.Course;
import com.example.GrowSkills.Models.Customer;
import com.example.GrowSkills.Models.Enrollment;
import com.example.GrowSkills.Repository.CourseRepository;
import com.example.GrowSkills.Repository.CustomerRepository;
import com.example.GrowSkills.Repository.EnrollmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EnrollmentService {
    @Autowired
    private EnrollmentRepository enrollmentRepository;
    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private CourseRepository courseRepository;

    public String addEnrollment(Customer customer, Course course, int amount) throws Exception{
        int price=course.getPrice();
        if(price-amount!=0){
            return "Invalid Amount";
        }
        customer.getCourseList().add(course);
        Enrollment enrollment=new Enrollment();
        enrollment.setStatus(true);
        //customer.getCourseList().add(course);
        customer.setCourse(course);
        enrollmentRepository.save(enrollment);
        customerRepository.save(customer);
        return "Enrollment Added Successfully";
    }
}
