package com.springrest.springrest.service;
import java.util.ArrayList;
import java.util.List;
import com.springrest.springrest.entities.Courses;
import org.springframework.stereotype.Service;

@Service
public class CourseServiceImpl implements CourseService{

    List<Courses> list;
    
    public CourseServiceImpl(){
       
        list = new ArrayList<>();
        list.add(new Courses(145, "Java Core Course", "This course contains basic of java"));
        list.add(new Courses(146, "Spring Boot Course", "Creating Rest API using Spring"));
    }
        

    //     list = List.of(
    //         new Courses(145, "Java Core Course", "This course contains basic of java"),
    //         new Courses(146, "Spring Boot Course", "Creating Rest API using Spring Boot")
    //     );
    // }


    
    @Override
    public List<Courses> getCourses() {
        return list;
    }

    
    // Java 8 Lambda style
    // @Override
    // public Courses addCourse(Courses course) {
    //     Optional.ofNullable(course)
    //             .ifPresent(c -> list.add(c));
    //     return course;
    // }

    // Traditional style
    /*
    @Override
    public Courses addCourse(Courses course) {
        if (course != null) {
            list.add(course);
        }
        return course;
    }
    */

    @Override
    public Courses addCourse(Courses course) {
        list.add(course);
        return course;
    }

    

    // @Override
    // public Courses getCourse(long courseId) {

    //     Courses c = null;
    //     for (Courses course : list) {
    //         // assuming Courses has a getId() method returning a long or Long
    //         if (course.getId() == courseId) {
    //             c = course;
    //             break;
    //         }
    //     }
    //     return c;
    // }

    @Override
public Courses getCourse(long courseId) {
    return list.stream()
            .filter(course -> course.getId() == courseId)
            .findFirst()
            .orElse(null);
}


 @Override
    public Courses updateCourse(Courses course) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getId() == course.getId()) {
                list.set(i, course);
                return course;
            }
        }
        return null;
    }

    @Override
    public Courses deleteCourse(long courseId) {
        Courses deletedCourse = null;
        for (Courses course : list) {
            if (course.getId() == courseId) {
                deletedCourse = course;
                break;
            }
        }
        list.removeIf(course -> course.getId() == courseId);
        return deletedCourse;
    }

    // @Override
    // public Courses updateCourse(Courses course) {
    //     list.stream()
    //         .filter(c -> c.getId() == course.getId())
    //         .findFirst()
    //         .ifPresent(c -> {
    //             int index = list.indexOf(c);
    //             list.set(index, course);
    //         });
    //     return course;
    // }

    // @Override
    // public void deleteCourse(long courseId) {
    //     list.removeIf(course -> course.getId() == courseId);
    // }


}
