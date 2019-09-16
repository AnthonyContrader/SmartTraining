package it.contrader.dao;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import it.contrader.model.Content;

@Repository
@Transactional
public interface ContentRepository extends CrudRepository<Content, Long> {

Content findByUsernameAndPassword(String tag, String title, String text, int idTraining);

}