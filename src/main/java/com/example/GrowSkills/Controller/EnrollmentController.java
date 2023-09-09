package com.example.GrowSkills.Controller;

import com.example.GrowSkills.Dtos.EnrollEntryDto;
import com.example.GrowSkills.Models.Course;
import com.example.GrowSkills.Models.Customer;
import com.example.GrowSkills.Repository.CourseRepository;
import com.example.GrowSkills.Repository.CustomerRepository;
import com.example.GrowSkills.Service.EnrollmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EnrollmentController {
    @Autowired
    private EnrollmentService enrollmentService;
    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private CourseRepository courseRepository;

    @PostMapping("/enroll")
    private String find(@RequestBody EnrollEntryDto enrollEntryDto) throws Exception{
        String customer_name=enrollEntryDto.getCustomer_name();
        List<Customer> customerList=customerRepository.findAll();
        Customer cur=null;
        for(Customer customer:customerList){
            if(customer.getCustomer_name().equals(customer_name)){
                cur=customer;
            }
        }
        if(cur==null){
            return "Invalid Customer name";
        }
        Course c=null;
        String courseName=enrollEntryDto.getCourse_name();
        List<Course> courseList=courseRepository.findAll();
        for(Course course:courseList){
            if(course.getCourse_name().equals(courseName)){
                c=course;
            }
        }
        if(c==null){
            return "Invalid Course name";
        }
        return enrollmentService.addEnrollment(cur,c,enrollEntryDto.getAmount());
    }

}
