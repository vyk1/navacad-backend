package com.pbi.map.resource;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.pbi.map.dto.MarkersDTO;
import com.pbi.map.entity.MarkersEntity;
import com.pbi.map.service.MarkersService;

@RestController
@RequestMapping(value = "/markers")
public class MarkersResource {

	@Autowired
	MarkersService service;

	@RequestMapping(method = RequestMethod.GET)
	public List<MarkersDTO> listardto() {
		List<MarkersEntity> listaMarkerss = service.buscar();
		List<MarkersDTO> listaDTO = listaMarkerss.stream().map(obj -> new MarkersDTO(obj)).collect(Collectors.toList());
		return listaDTO;
	}

	@RequestMapping(method = RequestMethod.GET, value = "/{id}")
	public ResponseEntity<MarkersEntity> buscar(@PathVariable Integer id) {
		MarkersEntity Markers = service.buscar(id);
		return ResponseEntity.ok(Markers);
	}
}