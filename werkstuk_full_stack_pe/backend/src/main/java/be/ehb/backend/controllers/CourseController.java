package be.ehb.backend.controllers;

import be.ehb.backend.dao.CourseDAO;
import be.ehb.backend.models.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.ConstraintViolationException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/api")
public class CourseController {
    private final CourseDAO courseDAO;

    @Autowired
    public CourseController(CourseDAO courseDAO) {
        this.courseDAO = courseDAO;
    }


    @RequestMapping(value = "/courses", method = RequestMethod.GET)
    @ResponseBody
    public List<Course> getAllCourses() {
        ArrayList<Course> courses = new ArrayList<>();

        courseDAO.findAll().forEach(courses::add);

        return courses;
    }


    @RequestMapping(value = "/courses/{id}", method = RequestMethod.GET)
    @ResponseBody
    public Optional<Course> getCourseById(@PathVariable(name = "id") int id) {
        return courseDAO.findById(id);
    }

    @RequestMapping(value = "/courses/add", method = RequestMethod.POST)
    @ResponseBody
    public HttpStatus addCourse(@RequestParam(name = "name") String name, @RequestParam(name = "description") String description, @RequestParam(name = "price") double price) {
        Course temp = new Course();
        temp.setId(0);
        temp.setName(name);
        temp.setDescription(description);
        temp.setPrice(price);

        courseDAO.save(temp);

        return HttpStatus.CREATED;
    }

    @RequestMapping(value = "/courses/delete/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public HttpStatus deleteCourseById(@PathVariable(name = "id") int id) {
        if (courseDAO.existsById(id)) {
            courseDAO.deleteById(id);
            return HttpStatus.OK;
        }
        else {
            return HttpStatus.NOT_FOUND;
        }
    }
}
