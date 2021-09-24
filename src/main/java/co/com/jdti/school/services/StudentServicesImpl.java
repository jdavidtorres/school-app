package co.com.jdti.school.services;

import co.com.jdti.school.model.entities.Student;
import co.com.jdti.school.model.repositories.IStudentDao;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Component
public class StudentServicesImpl {

    private final IStudentDao iStudentDao;

    @Transactional(readOnly = true)
    public List<Student> findAll() {
        return iStudentDao.findAll();
    }

    @Transactional
    public Student save(Student student) {
        return iStudentDao.save(student);
    }

    @Transactional(readOnly = true)
    public Optional<Student> findById(String id) {
        return iStudentDao.findById(id);
    }

    @Transactional(readOnly = true)
    public Optional<Student> findByDni(String dni) {
        return iStudentDao.findByDni(dni);
    }
}
