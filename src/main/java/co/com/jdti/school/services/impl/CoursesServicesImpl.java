package co.com.jdti.school.services.impl;

import co.com.jdti.school.model.entities.Course;
import co.com.jdti.school.model.repositories.ICoursesDao;
import co.com.jdti.school.services.ICourseServices;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class CoursesServicesImpl implements ICourseServices {

    private final ICoursesDao iCoursesDao;

    public CoursesServicesImpl(ICoursesDao iCoursesDao) {
        this.iCoursesDao = iCoursesDao;
    }

    @Transactional(readOnly = true)
    @Override
    public List<Course> findAll() {
        return iCoursesDao.findAll();
    }

    @Transactional
    @Override
    public Course save(Course course) {
        return iCoursesDao.save(course);
    }

    @Override
    public Optional<Course> findById(String id) {
        return iCoursesDao.findById(id);
    }
}
