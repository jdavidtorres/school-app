package co.com.jdti.school.services;

import java.util.List;
import java.util.Optional;

import co.com.jdti.school.model.entities.Student;

public interface IStudentServices {

	List<Student> findAll();

	Student save(Student student);

	Optional<Student> findById(String id);

	Optional<Student> findByDni(String dni);
}
