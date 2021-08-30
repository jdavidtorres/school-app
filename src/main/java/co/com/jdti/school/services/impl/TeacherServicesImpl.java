package co.com.jdti.school.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.com.jdti.school.model.entities.Teacher;
import co.com.jdti.school.model.repositories.ITeacherDao;
import co.com.jdti.school.services.ITeacherServices;

@Service
public class TeacherServicesImpl implements ITeacherServices {

	@Autowired
	private ITeacherDao iTeacherDao;

	@Override
	public Teacher save(Teacher teacher) {
		return iTeacherDao.save(teacher);
	}
}
