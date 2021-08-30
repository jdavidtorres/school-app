package co.com.jdti.school.model.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import co.com.jdti.school.model.entities.Subject;

@Repository
public interface ISubjectDao extends JpaRepository<Subject, Integer> {

}
