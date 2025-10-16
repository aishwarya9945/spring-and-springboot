package com.springrest.springrest.service;
import com.springrest.springrest.entities.Courses;
import java.util.List;

public interface CourseService {

    List<Courses> getCourses();
    public Courses getCourse(long courseId);
    Courses addCourse(Courses course);
    Courses updateCourse(Courses course);
    Courses deleteCourse(long courseId);
}
