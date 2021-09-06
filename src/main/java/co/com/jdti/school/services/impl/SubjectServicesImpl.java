package co.com.jdti.school.services.impl;

import co.com.jdti.school.model.entities.Subject;
import co.com.jdti.school.model.repositories.ISubjectDao;
import co.com.jdti.school.services.ISubjectServices;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class SubjectServicesImpl implements ISubjectServices {

	private final ISubjectDao iSubjectDao;

	public SubjectServicesImpl(ISubjectDao iSubjectDao) {
		this.iSubjectDao = iSubjectDao;
	}

	@Transactional(readOnly = true)
	@Override
	public List<Subject> findAll() {
		return iSubjectDao.findAll();
	}

	@Transactional
	@Override
	public Subject save(Subject subject) {
		return iSubjectDao.save(subject);
	}

	@Transactional(readOnly = true)
	@Override
	public Optional<Subject> findById(Long id) {
		return iSubjectDao.findById(id);
	}
}
