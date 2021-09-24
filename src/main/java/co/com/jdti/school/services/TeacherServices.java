package co.com.jdti.school.services;

import co.com.jdti.school.model.entities.Teacher;
import co.com.jdti.school.model.repositories.ITeacherDao;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Component
public class TeacherServices {

    private final ITeacherDao iTeacherDao;

    @Transactional
    public Teacher save(Teacher teacher) {
        return iTeacherDao.save(teacher);
    }
}
