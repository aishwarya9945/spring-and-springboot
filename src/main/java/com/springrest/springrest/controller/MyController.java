package com.springrest.springrest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.springrest.springrest.entities.Courses;
import com.springrest.springrest.service.CourseService;

import java.util.List;

@RestController
public class MyController {

    @Autowired
    private CourseService courseService;

    @GetMapping("/home")
    public String home() {
        return "Welcome to Courses Application";
    }

    //get the courses
    // @GetMapping("/courses")
    @RequestMapping(path = "/courses", method = RequestMethod.GET)
    public List<Courses> getCourses() {
        return this.courseService.getCourses();
    }

    //Single courses get
    @RequestMapping(path = "/courses/{courseId}", method = RequestMethod.GET)
    public Courses getCourse(@PathVariable String courseId){
        return this.courseService.getCourse(Long.parseLong(courseId)
        );
    }

    //add course
    @PostMapping(path = "/courses", consumes = "application/json")
    public Courses addCourse(@RequestBody Courses course){
        return this.courseService.addCourse(course);
    }

    //update course
    @RequestMapping(path = "/courses", method = RequestMethod.PUT, consumes = "application/json")
    public Courses updateCourse(@RequestBody Courses course){
        return this.courseService.addCourse(course);
    }

    //delete course
    
    @DeleteMapping("/courses/{courseId}")
    public Courses deleteCourse(@PathVariable String courseId) {
    return this.courseService.deleteCourse(Long.parseLong(courseId));
}


 //If our deleteCourse() in service returns void, update controller like this:
// @DeleteMapping("/courses/{courseId}")
// public ResponseEntity<Void> deleteCourse(@PathVariable String courseId) {
//     courseService.deleteCourse(Long.parseLong(courseId));
//     return ResponseEntity.noContent().build();
// }
//This is cleaner and returns a 204 No Content response on successful deletion.

}

