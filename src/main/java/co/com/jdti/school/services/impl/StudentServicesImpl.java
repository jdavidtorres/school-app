package co.com.jdti.school.services.impl;

import co.com.jdti.school.model.entities.Student;
import co.com.jdti.school.model.repositories.IStudentDao;
import co.com.jdti.school.services.IStudentServices;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class StudentServicesImpl implements IStudentServices {

    private final IStudentDao iStudentDao;

    public StudentServicesImpl(IStudentDao iStudentDao) {
        this.iStudentDao = iStudentDao;
    }

    @Transactional(readOnly = true)
    @Override
    public List<Student> findAll() {
        return iStudentDao.findAll();
    }

    @Transactional
    @Override
    public Student save(Student student) {
        return iStudentDao.save(student);
    }

    @Transactional(readOnly = true)
    @Override
    public Optional<Student> findById(String id) {
        return iStudentDao.findById(id);
    }

    @Transactional(readOnly = true)
    @Override
    public Optional<Student> findByDni(String dni) {
        return iStudentDao.findByDni(dni);
    }
}
