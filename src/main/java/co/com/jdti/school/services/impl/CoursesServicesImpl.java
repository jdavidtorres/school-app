package co.com.jdti.school.services.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.com.jdti.school.model.entities.Course;
import co.com.jdti.school.model.repositories.ICoursesDao;
import co.com.jdti.school.services.ICourseServices;

@Service
public class CoursesServicesImpl implements ICourseServices {

	@Autowired
	private ICoursesDao iCoursesDao;

	@Override
	public List<Course> findAll() {
		return iCoursesDao.findAll();
	}

	@Override
	public Course save(Course course) {
		return iCoursesDao.save(course);
	}

	@Override
	public Optional<Course> findById(String id) {
		return iCoursesDao.findById(id);
	}
}
