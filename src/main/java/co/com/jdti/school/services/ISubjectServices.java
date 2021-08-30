package co.com.jdti.school.services;

import java.util.List;

import co.com.jdti.school.model.entities.Subject;

public interface ISubjectServices {

	List<Subject> findAll();

	Subject save(Subject subject);
}
