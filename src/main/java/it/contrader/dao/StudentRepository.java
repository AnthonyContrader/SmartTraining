package it.contrader.dao;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import it.contrader.model.Student;

@Repository
@Transactional
public interface StudentRepository extends CrudRepository<Student, Long>{
	
	Student findStudentById(Long id);

}
