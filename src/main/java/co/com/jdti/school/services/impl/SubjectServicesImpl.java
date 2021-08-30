package co.com.jdti.school.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.com.jdti.school.model.entities.Subject;
import co.com.jdti.school.model.repositories.ISubjectDao;
import co.com.jdti.school.services.ISubjectServices;

@Service
public class SubjectServicesImpl implements ISubjectServices {

	@Autowired
	private ISubjectDao iSubjectDao;

	@Override
	public List<Subject> findAll() {
		return iSubjectDao.findAll();
	}

	@Override
	public Subject save(Subject subject) {
		return iSubjectDao.save(subject);
	}
}
