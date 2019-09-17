package it.contrader.dao;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import it.contrader.model.Gruppo;

@Repository
@Transactional
public interface GruppoRepository extends CrudRepository<Gruppo, Long> {

	Gruppo findGruppoById(Long id);

}
