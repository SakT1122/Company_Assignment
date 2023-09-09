package com.example.GrowSkills.Service;

import com.example.GrowSkills.Dtos.CourseEntryDto;
import com.example.GrowSkills.Models.Course;
import com.example.GrowSkills.Repository.CourseRepository;
import com.lowagie.text.Document;
import com.lowagie.text.Font;
import com.lowagie.text.FontFactory;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfWriter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.util.List;

@Service
public class CourseService {

    private Logger logger= LoggerFactory.getLogger(CustomerService.class);
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

    public ByteArrayInputStream downloadPdf(){
        logger.info("Create pdf started");
        String title="Welcome to Grow Skill";
        String content="Congratulations for successful course completion";
        ByteArrayOutputStream out=new ByteArrayOutputStream();
        Document document=new Document();
        PdfWriter.getInstance(document,out);
        document.open();
        Font titleFont= FontFactory.getFont(FontFactory.HELVETICA_BOLD,20);
        Paragraph paragraph=new Paragraph(title,titleFont);
        document.add(paragraph);
        Paragraph paragraph1=new Paragraph(content);
        document.add(paragraph1);
        document.close();
        return new ByteArrayInputStream(out.toByteArray());
    }

}
