package co.com.jdti.school.model.repositories;

import co.com.jdti.school.model.entities.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IStudentDao extends JpaRepository<Student, Long> {

    Optional<Student> findByDni(String dni);
}
