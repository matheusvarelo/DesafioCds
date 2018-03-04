package com.matheus.desafio_cds.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.matheus.desafio_cds.domain.Estado;
import com.matheus.desafio_cds.domain.Municipio;
import com.matheus.desafio_cds.repository.EstadoRepository;
import com.matheus.desafio_cds.repository.MunicipioRepository;

@Service
public class MunicipioService {

	@Autowired
	private MunicipioRepository repo;

	@Autowired
	private EstadoRepository estadoRepository;

	public List<Municipio> findMunicipio(Integer id) {		
		Estado obj = estadoRepository.findOne(id);
		return repo.findByEstado(obj);
	}

}
