package co.com.jdti.school.services;

import java.util.List;
import java.util.Optional;

import co.com.jdti.school.model.entities.Course;

public interface ICourseServices {

	Optional<Course> findById(String id);

	List<Course> findAll();

	Course save(Course course);
}
