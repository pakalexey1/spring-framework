package com.example.controller;

import com.example.dto.CourseDTO;
import com.example.service.CourseService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController // @Controller + @ResponseBody
@RequestMapping("/courses/api/v1")
public class CourseController {

    private final CourseService courseService;

    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }

    @GetMapping
    public List<CourseDTO> getAllCourses(){
        List<CourseDTO> list = courseService.getCourses();
        return list;
    }

    @GetMapping("category/{name}")
    public List<CourseDTO> getCourseByCategory(@PathVariable("name") String category){

        return courseService.getCoursesByCategory(category);
    }
    @PostMapping
    public CourseDTO createCourse(@RequestBody CourseDTO course){

        return courseService.createCourse(course);
    }

    @PostMapping
    public void updateCourse(@PathVariable("id") Long courseId, @RequestBody CourseDTO course){

         courseService.updateCourse(courseId,course);
    }

    @DeleteMapping
    public void deleteCourse(@PathVariable("id") Long courseId){
        courseService.deleteCourseById(courseId);
    }

    @DeleteMapping
    public void deleteCourses(){
        courseService.deleteCourses();
    }
}
