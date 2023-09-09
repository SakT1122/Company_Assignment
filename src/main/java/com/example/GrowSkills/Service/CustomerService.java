package com.example.GrowSkills.Service;


import com.example.GrowSkills.Dtos.CustomerEntryDto;
import com.example.GrowSkills.Dtos.LiveClassDto;
import com.example.GrowSkills.Models.Classes;
import com.example.GrowSkills.Models.Course;
import com.example.GrowSkills.Models.Customer;
import com.example.GrowSkills.Repository.ClassesRepository;
import com.example.GrowSkills.Repository.CourseRepository;
import com.example.GrowSkills.Repository.CustomerRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Service
public class CustomerService {
    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private CourseRepository courseRepository;
    @Autowired
    private ClassesRepository classesRepository;
    private Logger logger= LoggerFactory.getLogger(CustomerService.class);

    public String createCustomer(CustomerEntryDto customerEntryDto){
        Customer customer=new Customer();

        //Setting all the attributes
        customer.setCustomer_name(customerEntryDto.getCustomer_name());
        customer.setGender(customerEntryDto.getGender());
        customer.setPassword(customerEntryDto.getPassword());
        customerRepository.save(customer);

        //Returning message on successful creation
        return "Customer Created Successfully";
    }

    public List<Customer> getAll(){
        return customerRepository.findAll();
    }
    public Course getLive(Customer customer) throws Exception{
        Course course=customer.getCourse();
        return course;
    }
    public String attendLiveClass(Customer customer, Course course, LiveClassDto liveClassDto) throws Exception{
        List<Customer> customerList=customerRepository.findAll();
        List<Course> courseList=courseRepository.findAll();
        List<Course> enrolledList=customer.getCourseList();
        //if(!enrolledList.contains(course)) return "Course not enrolled";
        //if(!courseList.contains(course)) throw new Exception("Course Doesn't Exist");
        //if(!customerList.contains(customer)) throw new Exception("Customer doesn't exist");
        LocalDate date= LocalDate.now();
        LocalTime time=LocalTime.now();
        Classes courseClass=new Classes();
        courseClass.setTopic(liveClassDto.getTopic());
        courseClass.setTime(Time.valueOf(time).toLocalTime());
        courseClass.setDate(Date.valueOf(date).toLocalDate());
        classesRepository.save(courseClass);
        courseRepository.save(course);
        return "Link for live lecture : livelect.zoom.com";
    }


}
