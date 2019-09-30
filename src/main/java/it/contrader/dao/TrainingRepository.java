package it.contrader.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import it.contrader.model.Gruppo;
import it.contrader.model.Training;

@Repository
@Transactional
public interface TrainingRepository extends CrudRepository <Training, Long> {
	
	public Training findTrainingById(long id);
	public List<Training> findAllByGruppo(Gruppo gruppo);

}
