package co.com.jdti.school.model.repositories;

import co.com.jdti.school.model.entities.Schedule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IScheduleDao extends JpaRepository<Schedule, Long> {

}
