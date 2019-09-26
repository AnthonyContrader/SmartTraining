package it.contrader.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import it.contrader.model.Gruppo;
import it.contrader.model.Student;

@Repository
public interface GruppoRepository extends CrudRepository<Gruppo, Long>{
	
	Gruppo findGruppoById(long id);
	List<Gruppo> findAllByStudent(Student student);

}
