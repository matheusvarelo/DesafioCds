package com.matheus.desafio_cds.resources;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.matheus.desafio_cds.domain.Estado;
import com.matheus.desafio_cds.domain.Municipio;
import com.matheus.desafio_cds.dto.EstadoDTO;
import com.matheus.desafio_cds.dto.MunicipioDTO;
import com.matheus.desafio_cds.services.EstadoService;
import com.matheus.desafio_cds.services.MunicipioService;

@RestController
@RequestMapping(value = "/estados")
public class EstadoResource {

	@Autowired
	private EstadoService service;

	@Autowired
	private MunicipioService municipioService;

	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<EstadoDTO>> findAll() {
		List<Estado> list = service.findAll();
		List<EstadoDTO> listDto = list.stream().map(obj -> new EstadoDTO(obj)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDto);
	}

	@RequestMapping(value = "/{estado_id}/municipios", method = RequestMethod.GET)
	public ResponseEntity<List<MunicipioDTO>> findMunicipios(@PathVariable Integer estado_id) {
		List<Municipio> list = municipioService.findMunicipio(estado_id);
		List<MunicipioDTO> listDto = list.stream().map(obj -> new MunicipioDTO(obj)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDto);
	}

}
