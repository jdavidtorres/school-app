package co.com.jdti.school.model.repositories;

import co.com.jdti.school.model.entities.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ITeacherDao extends JpaRepository<Teacher, Long> {

}
