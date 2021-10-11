package co.com.jdti.school.model.repositories;

import co.com.jdti.school.model.entities.Score;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IScoreDao extends JpaRepository<Score, Long> {

}
