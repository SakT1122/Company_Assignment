package com.example.GrowSkills.Controller;

import com.example.GrowSkills.Dtos.CustomerEntryDto;
import com.example.GrowSkills.Dtos.LiveClassDto;
import com.example.GrowSkills.Models.Course;
import com.example.GrowSkills.Models.Customer;
import com.example.GrowSkills.Repository.CourseRepository;
import com.example.GrowSkills.Repository.CustomerRepository;
import com.example.GrowSkills.Service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CustomerController {
    @Autowired
    private CustomerService customerService;
    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private CourseRepository courseRepository;

    @PostMapping("/add")
    public String addCustomer(@RequestBody CustomerEntryDto customerEntryDto){
        return customerService.createCustomer(customerEntryDto);
    }

    @GetMapping("/get-all-cust")
    public List<Customer> getAllCustomers(){
        return customerService.getAll();
    }
    @GetMapping("/get-link")
    public String getLive(@RequestBody LiveClassDto liveClassDto) throws Exception{
        String customer_name=liveClassDto.getCustomer_name();
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
        Course course=cur.getCourse();
        List<Course> courseList=courseRepository.findAll();
        if(!courseList.contains(course)){
            return "Customer Not Enrolled";
        }
        return customerService.attendLiveClass(cur,course,liveClassDto);
    }

}
