package co.com.jdti.school.model.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import co.com.jdti.school.model.entities.Course;

@Repository
public interface ICoursesDao extends JpaRepository<Course, Long> {

}
