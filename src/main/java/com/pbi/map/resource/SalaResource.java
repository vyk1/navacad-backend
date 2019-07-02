package com.pbi.map.resource;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.pbi.map.dto.SalaDTO;
import com.pbi.map.entity.SalaEntity;
import com.pbi.map.service.SalaService;

@RestController
@RequestMapping(value = "/salas")
//@CrossOrigin(origins="*")
public class SalaResource {

	@Autowired
	SalaService service;

	@RequestMapping(method = RequestMethod.GET)
	public List<SalaDTO> listaSalas() {
		List<SalaEntity> listaSalas = service.buscar();
		List<SalaDTO> listaDTO = listaSalas.stream().map(obj -> new SalaDTO(obj)).collect(Collectors.toList());
		return listaDTO;
	}

	@RequestMapping(method = RequestMethod.GET, value = "/{id}")
	public ResponseEntity<SalaEntity> buscar(@PathVariable Integer id) {
		SalaEntity Sala = service.buscar(id);
		return ResponseEntity.ok(Sala);
	}

	@RequestMapping(value = "/search", method = RequestMethod.GET)
	public ResponseEntity<List<SalaDTO>> listarByNome(@RequestParam(value = "nome", defaultValue = "") String nome) {

		List<SalaEntity> listaSala = service.buscarByNome(nome);

		List<SalaDTO> listaDTO = listaSala.stream().map(obj -> new SalaDTO(obj)).collect(Collectors.toList());

		return ResponseEntity.ok().body(listaDTO);
	}

	// funfa
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> salvar(@Valid @RequestBody SalaEntity salaEntity) {
		SalaEntity obj = service.salvar(salaEntity);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();

		return ResponseEntity.created(uri).build();

	}

	@RequestMapping(method = RequestMethod.PUT, value = "/{id}")
	public ResponseEntity<Void> atualizar(@Valid @RequestBody SalaDTO objDTO, @PathVariable Integer id) {

		SalaEntity salaE = new SalaEntity(id, objDTO.getNome(), objDTO.getTelefone(), objDTO.getEmail(),
				objDTO.isTerreo());
		salaE = service.atualizar(salaE);

		return ResponseEntity.noContent().build();
	}
	
	@RequestMapping(method = RequestMethod.DELETE, value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable Integer id) {
		service.apagar(id);
		return ResponseEntity.noContent().build();
	}

}
