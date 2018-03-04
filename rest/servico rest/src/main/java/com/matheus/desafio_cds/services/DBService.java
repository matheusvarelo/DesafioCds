package com.matheus.desafio_cds.services;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.matheus.desafio_cds.domain.Estado;
import com.matheus.desafio_cds.domain.Municipio;
import com.matheus.desafio_cds.domain.Pessoa;
import com.matheus.desafio_cds.repository.EstadoRepository;
import com.matheus.desafio_cds.repository.MunicipioRepository;
import com.matheus.desafio_cds.repository.PessoaRepository;

@Service
public class DBService {

	@Autowired
	private PessoaRepository pessoaRepository;
	@Autowired
	private EstadoRepository estadoRepository;
	@Autowired
	private MunicipioRepository municipioRepository;

	public void instantieateTestDatabase() throws ParseException {

		// Estado e municipio

		Estado est1 = new Estado(null, "Distrito Federal");
		Estado est2 = new Estado(null, "Rio de Janeiro");

		Municipio m1 = new Municipio(null, "Brasília", est1);
		Municipio m2 = new Municipio(null, "Rio de Janeiro", est2);
		Municipio m3 = new Municipio(null, "copacabana", est2);

		est1.getMunicipios().addAll(Arrays.asList(m1));
		est1.getMunicipios().addAll(Arrays.asList(m2, m3));

		estadoRepository.save(Arrays.asList(est1, est2));
		municipioRepository.save(Arrays.asList(m1, m2, m3));

		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Pessoa p1 = new Pessoa(null, "Matheus", "633.878.615-08",  "12345667", "(61)99865-4451", "Mãe", "Pai", sdf.parse("01/10/1991"));
		Pessoa p2 = new Pessoa(null, "Raphael", "855.536.338-18", "98765431", "(61)98424-6622", "Mãe", "Pai", sdf.parse("02/09/1992"));
		Pessoa p3 = new Pessoa(null, "Maria", "043.969.156-75", "42154141", "(61)98112-7723", "Mãe", "Pai", sdf.parse("03/08/1993"));
		Pessoa p4 = new Pessoa(null, "Celio", "174.057.765-58", "31521544", "(61)93315-8824", "Mãe", "Pai", sdf.parse("04/07/1994"));
		Pessoa p5 = new Pessoa(null, "Carmen", "342.830.374-19", "31245445", "(61)99152-9995", "Mãe", "Pai", sdf.parse("05/06/1995"));
		Pessoa p6 = new Pessoa(null, "Juliana", "079.103.658-88", "99215454", "(61)98894-6326", "Mãe", "Pai", sdf.parse("06/05/1991"));
		Pessoa p7 = new Pessoa(null, "Pedro", "509.174.531-90", "897441717","(61)99498-1227", "Mãe", "Pai", sdf.parse("07/04/1992"));

		
		pessoaRepository.save(Arrays.asList(p1, p2, p3, p4, p5, p6, p7));

	}

}
