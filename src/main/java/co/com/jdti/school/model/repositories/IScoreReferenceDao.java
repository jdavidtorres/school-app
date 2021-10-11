package co.com.jdti.school.model.repositories;

import co.com.jdti.school.model.entities.ScoreReference;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IScoreReferenceDao extends JpaRepository<ScoreReference, Long> {

}
