package com.pbi.map.resource;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.pbi.map.dto.SalaDTO;
import com.pbi.map.entity.SalaEntity;
import com.pbi.map.service.SalaService;


@RestController
@RequestMapping(value = "/salas")
public class SalaResource {

	@Autowired
	SalaService service;

	@RequestMapping(method = RequestMethod.GET)
	public List<SalaDTO> listardto() {
		List<SalaEntity> listaSalas = service.buscar();
		List<SalaDTO> listaDTO = listaSalas.stream().map(obj -> new SalaDTO(obj)).collect(Collectors.toList());
		return listaDTO;
	}

	@RequestMapping(method = RequestMethod.GET, value = "/{id}")
	public ResponseEntity<SalaEntity> buscar(@PathVariable Integer id) {
		SalaEntity Sala = service.buscar(id);
		return ResponseEntity.ok(Sala);
	}

}
