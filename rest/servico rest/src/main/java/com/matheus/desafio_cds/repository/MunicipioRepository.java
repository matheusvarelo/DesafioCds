package com.matheus.desafio_cds.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.matheus.desafio_cds.domain.Estado;
import com.matheus.desafio_cds.domain.Municipio;

@Repository
public interface MunicipioRepository extends JpaRepository<Municipio, Integer> {

	@Transactional(readOnly = true)
	public List<Municipio> findByEstado(Estado obj);	
}
