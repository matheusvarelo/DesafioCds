package com.matheus.desafio_cds.dto;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;
import org.hibernate.validator.constraints.br.CPF;

import com.matheus.desafio_cds.domain.Pessoa;

public class PessoaDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	private Integer id;

	@NotEmpty(message = "Preenchimento Obrigatório!")
	@Length(min = 5, max = 80, message = "O tamanho precisa ser de 5 a 80 caracter!")
	private String nome;

	@NotEmpty(message = "Preenchimento Obrigatório!")
	@Length(min = 14, max = 14, message = "CPF inválido!")
//	@CPF
	private String cpf;

	@NotEmpty(message = "Preenchimento Obrigatório!")
	@Length(min = 5, max = 20, message = "O tamanho precisa ser de 5 a 30 caracter!")
	private String rg;

	@NotEmpty(message = "Preenchimento Obrigatório!")
	@Length(min = 13, max = 14, message = "O tamanho precisa ser de 13 a 14 caracter!")
	private String telefone;

	@NotEmpty(message = "Preenchimento Obrigatório!")
	private String nome_mae;

	private String nome_pai;

	private Date data_nascimento;

	public PessoaDTO() {
		// TODO Auto-generated constructor stub
	}

	public PessoaDTO(Pessoa obj) {
		super();
		this.id = obj.getId();
		this.nome = obj.getNome();
		this.cpf = obj.getCpf();
		this.rg = obj.getRg();
		this.telefone = obj.getTelefone();
		this.nome_mae = obj.getNome_mae();
		this.nome_pai = obj.getNome_pai();
		this.data_nascimento = obj.getData_nascimento();
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

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getRg() {
		return rg;
	}

	public void setRg(String rg) {
		this.rg = rg;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getNome_mae() {
		return nome_mae;
	}

	public void setNome_mae(String nome_mae) {
		this.nome_mae = nome_mae;
	}

	public String getNome_pai() {
		return nome_pai;
	}

	public void setNome_pai(String nome_pai) {
		this.nome_pai = nome_pai;
	}

	public Date getData_nascimento() {
		return data_nascimento;
	}
	
	public void setData_nascimento(Date data_nascimento) {
		this.data_nascimento = data_nascimento;
	}

	public void setData_nascimento(String data_nascimento) throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		this.data_nascimento = sdf.parse(data_nascimento);
	}
  
}
