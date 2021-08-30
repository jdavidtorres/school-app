package co.com.jdti.school.services.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.com.jdti.school.model.entities.Student;
import co.com.jdti.school.model.repositories.IStudentDao;
import co.com.jdti.school.services.IStudentServices;

@Service
public class StudentServicesImpl implements IStudentServices {

	@Autowired
	private IStudentDao iStudentDao;

	@Override
	public List<Student> findAll() {
		return iStudentDao.findAll();
	}

	@Override
	public Student save(Student student) {
		return iStudentDao.save(student);
	}

	@Override
	public Optional<Student> findById(String id) {
		return iStudentDao.findById(id);
	}

	@Override
	public Optional<Student> findByDni(String dni) {
		return iStudentDao.findByDni(dni);
	}
}
