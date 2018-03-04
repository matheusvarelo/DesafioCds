package com.matheus.desafio_cds.dto;

import com.matheus.desafio_cds.domain.Municipio;

public class MunicipioDTO {

	private Integer id;
	private String nome;

	public MunicipioDTO() {
	}

	public MunicipioDTO(Municipio obj) {
		this.id = obj.getId();
		this.nome = obj.getNome();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

}
