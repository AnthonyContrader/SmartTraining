package it.contrader.dao;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import it.contrader.model.Training;

@Repository
@Transactional
public interface TrainingRepository extends CrudRepository<Training, Long> {

	Training findByNameTrainingAndIdGroup (String nameTraining, int idGroup);

}

