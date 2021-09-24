package co.com.jdti.school.services;

import co.com.jdti.school.model.entities.Subject;
import co.com.jdti.school.model.repositories.ISubjectDao;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Component
public class SubjectServicesImpl {

	private final ISubjectDao iSubjectDao;

	@Transactional(readOnly = true)
	public List<Subject> findAll() {
		return iSubjectDao.findAll();
	}

	@Transactional
	public Subject save(Subject subject) {
		return iSubjectDao.save(subject);
	}

	@Transactional(readOnly = true)
	public Optional<Subject> findById(Long id) {
		return iSubjectDao.findById(id);
	}
}
