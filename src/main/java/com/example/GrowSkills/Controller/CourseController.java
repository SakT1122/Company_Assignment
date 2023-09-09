package com.example.GrowSkills.Controller;

import com.example.GrowSkills.Dtos.CourseEntryDto;
import com.example.GrowSkills.Models.Course;
import com.example.GrowSkills.Service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CourseController {
    @Autowired
    private CourseService courseService;
    @PostMapping("/add-course")
    private String addCourse(@RequestBody CourseEntryDto courseEntryDto){
        return courseService.addCourse(courseEntryDto);
    }

    @GetMapping("/get-all-courses")
    private List<Course> getAllCourses(){
        return courseService.seeAllCourses();
    }
}
