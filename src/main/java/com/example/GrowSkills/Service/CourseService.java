package com.example.GrowSkills.Service;

import com.example.GrowSkills.Dtos.CourseEntryDto;
import com.example.GrowSkills.Models.Course;
import com.example.GrowSkills.Repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseService {

    @Autowired
    private CourseRepository courseRepository;

    //Api to add a new course
    public String addCourse(CourseEntryDto courseEntryDto){
        Course course=new Course();

        //Setting necessary attributes
        course.setCourse_name(courseEntryDto.getCourse_name());
        course.setCourseCategory(courseEntryDto.getCourseCategory());
        course.setPrice(courseEntryDto.getPrice());
        courseRepository.save(course);

        //Return message on successful completion
        return "Course added Successfully";
    }
    public List<Course> seeAllCourses(){
        return courseRepository.findAll();
    }
}
