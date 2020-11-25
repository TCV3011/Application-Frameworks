package be.ehb.backend.dao;

import be.ehb.backend.models.Course;
import org.springframework.data.repository.CrudRepository;

public interface CourseDAO extends CrudRepository<Course, Integer> {
}
