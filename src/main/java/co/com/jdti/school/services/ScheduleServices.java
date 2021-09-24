package co.com.jdti.school.services;

import co.com.jdti.school.model.entities.Schedule;
import co.com.jdti.school.model.repositories.IScheduleDao;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
@RequiredArgsConstructor
public class ScheduleServices {

    private final IScheduleDao iScheduleDao;

    @Transactional
    public Schedule save(Schedule schedule) {
        return iScheduleDao.save(schedule);
    }

    @Transactional(readOnly = true)
    public List<Schedule> findAll() {
        return iScheduleDao.findAll();
    }
}
