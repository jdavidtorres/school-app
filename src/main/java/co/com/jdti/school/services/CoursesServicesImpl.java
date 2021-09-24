package co.com.jdti.school.services;

import co.com.jdti.school.model.entities.Course;
import co.com.jdti.school.model.repositories.ICoursesDao;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Component
public class CoursesServicesImpl {

    private final ICoursesDao iCoursesDao;

    @Transactional(readOnly = true)
    public List<Course> findAll() {
        return iCoursesDao.findAll();
    }

    @Transactional
    public Course save(Course course) {
        return iCoursesDao.save(course);
    }

    public Optional<Course> findById(String id) {
        return iCoursesDao.findById(id);
    }
}
