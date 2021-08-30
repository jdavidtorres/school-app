package co.com.jdti.school.model.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import co.com.jdti.school.model.entities.Student;

@Repository
public interface IStudentDao extends JpaRepository<Student, String> {

	Optional<Student> findByDni(String dni);
}
