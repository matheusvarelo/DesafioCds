package com.matheus.desafio_cds.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.matheus.desafio_cds.domain.Pessoa;
import com.matheus.desafio_cds.dto.PessoaDTO;
import com.matheus.desafio_cds.repository.PessoaRepository;

@Service
public class PessoaService {
	
	@Autowired
	private PessoaRepository repo;
	
	public Pessoa findById(Integer id) {
		Pessoa obj = repo.findOne(id);

		return obj;
	}


	public Pessoa insert(Pessoa obj) {
		obj.setId(null);
		return repo.save(obj);
	}


	public Pessoa update(Pessoa obj) {
		Pessoa newObj = findById(obj.getId());

		updateData(newObj, obj);

		return repo.save(newObj);
	}


	public void delete(Integer id) {
		findById(id);

			repo.delete(id);

	}


	public List<Pessoa> findAll() {
		return repo.findAll();
	}


	public Page<Pessoa> findPage(Integer page, Integer linesPerPage, String orderBy, String direction) {
		PageRequest pageRequest = new PageRequest(page, linesPerPage, Direction.valueOf(direction), orderBy);
		return repo.findAll(pageRequest);

	}

	public Pessoa fromDTO(PessoaDTO objDto) {
		return new Pessoa(objDto.getId(), objDto.getNome(), objDto.getCpf(), objDto.getRg(), objDto.getTelefone(), objDto.getNome_mae(), objDto.getNome_pai(), objDto.getData_nascimento());
	}


	private void updateData(Pessoa newObj, Pessoa obj) {
		newObj.setNome(obj.getNome());
	}


}
