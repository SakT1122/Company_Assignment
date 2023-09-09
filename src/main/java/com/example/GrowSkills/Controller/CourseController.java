package com.example.GrowSkills.Controller;

import com.example.GrowSkills.Dtos.CourseEntryDto;
import com.example.GrowSkills.Models.Course;
import com.example.GrowSkills.Service.CourseService;
import com.example.GrowSkills.Service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.ByteArrayInputStream;
import java.util.List;

@RestController
public class CourseController {
    @Autowired
    private CourseService courseService;
    @Autowired
    private CustomerService customerService;
    @PostMapping("/add-course")
    private String addCourse(@RequestBody CourseEntryDto courseEntryDto){
        return courseService.addCourse(courseEntryDto);
    }

    @GetMapping("/get-all-courses")
    private List<Course> getAllCourses(){
        return courseService.seeAllCourses();
    }
    @PostMapping("/downloadPdf")
    public ResponseEntity<InputStreamResource> downloadPdf(){
        ByteArrayInputStream pdf=courseService.downloadPdf();
        HttpHeaders httpHeaders=new HttpHeaders();
        httpHeaders.add("Content-Disposition","inline;file=lcwd.pdf");
        return ResponseEntity.ok()
                .headers(httpHeaders)
                .contentType(MediaType.APPLICATION_PDF)
                .body(new InputStreamResource(pdf));
    }
}
