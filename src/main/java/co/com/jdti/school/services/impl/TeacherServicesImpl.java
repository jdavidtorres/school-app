package co.com.jdti.school.services.impl;

import co.com.jdti.school.model.entities.Teacher;
import co.com.jdti.school.model.repositories.ITeacherDao;
import co.com.jdti.school.services.ITeacherServices;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class TeacherServicesImpl implements ITeacherServices {

    private final ITeacherDao iTeacherDao;

    public TeacherServicesImpl(ITeacherDao iTeacherDao) {
        this.iTeacherDao = iTeacherDao;
    }

    @Transactional
    @Override
    public Teacher save(Teacher teacher) {
        return iTeacherDao.save(teacher);
    }
}
