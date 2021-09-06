package co.com.jdti.school.services;

import co.com.jdti.school.model.entities.Subject;

import java.util.List;
import java.util.Optional;

public interface ISubjectServices {

	List<Subject> findAll();

	Subject save(Subject subject);

	Optional<Subject> findById(Long id);
}
