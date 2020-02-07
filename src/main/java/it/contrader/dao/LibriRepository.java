package it.contrader.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import it.contrader.model.Libri;
import it.contrader.model.Libri.Categoria;

@Repository

public interface LibriRepository extends CrudRepository<Libri, Long> {
	List <Libri> findByCategoria(Categoria categoria);

}
