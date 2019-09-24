package it.contrader.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import it.contrader.model.Student;


/**
 * Estende CrudRepository ed eredita tutti i metodi di CRUD. 
 * Definisce il metodo di login.
 * 
 * @author Vittorio Valent
 * @author Girolamo Murdaca
 *
 * @see CrudRepository
 *
 */
@Repository
public interface StudentRepository extends CrudRepository<Student, Long>{

	
	Student findStudentById (Long id);
	
}
