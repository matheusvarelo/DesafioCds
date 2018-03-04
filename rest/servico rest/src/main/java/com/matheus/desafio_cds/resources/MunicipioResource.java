package com.matheus.desafio_cds.resources;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.matheus.desafio_cds.domain.Municipio;
import com.matheus.desafio_cds.dto.MunicipioDTO;
import com.matheus.desafio_cds.services.MunicipioService;

@RestController
@RequestMapping(value = "/municipios")
public class MunicipioResource {

	@Autowired
	private MunicipioService service;

	@RequestMapping(value = "/estados/{estado_id}", method = RequestMethod.GET)
	public ResponseEntity<List<MunicipioDTO>> findMunicipios(@PathVariable Integer estado_id) {
		List<Municipio> list = service.findMunicipio(estado_id);
		List<MunicipioDTO> listDto = list.stream().map(obj -> new MunicipioDTO(obj)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDto);
	}

}
