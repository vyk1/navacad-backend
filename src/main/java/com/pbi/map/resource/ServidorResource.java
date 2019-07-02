package com.pbi.map.resource;

import java.net.URI;
import java.util.Arrays;
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

import com.pbi.map.dto.ServidorDTO;
import com.pbi.map.dto.ServidorDTOIds;
import com.pbi.map.dto.ServidorDTOList;
import com.pbi.map.entity.HorarioEntity;
import com.pbi.map.entity.SalaEntity;
import com.pbi.map.entity.ServidorEntity;
import com.pbi.map.service.HorarioService;
import com.pbi.map.service.SalaService;
import com.pbi.map.service.ServidorService;

@RestController
@RequestMapping(value = "/servidores")
public class ServidorResource {
	@Autowired
	ServidorService service;

	@Autowired
	SalaService salaService;

	@Autowired
	HorarioService horarioService;
	
	@RequestMapping(method = RequestMethod.GET)
	public List<ServidorDTO> listardto() {
		List<ServidorEntity> listaServidor = service.buscar();
		List<ServidorDTO> listaDTO = listaServidor.stream().map(obj -> new ServidorDTO(obj))
				.collect(Collectors.toList());
		return listaDTO;
	}

	@RequestMapping(method = RequestMethod.GET, value = "/{id}")
	public ResponseEntity<ServidorEntity> buscar(@PathVariable Integer id) {
		ServidorEntity servidor = service.buscar(id);
		return ResponseEntity.ok(servidor);
	}

	@RequestMapping(value = "/search", method = RequestMethod.GET)
	public ResponseEntity<List<ServidorDTO>> listarByNome(
			@RequestParam(value = "nome", defaultValue = "") String nome) {

		List<ServidorEntity> listaServidores = service.buscarByNome(nome);

		List<ServidorDTO> listaDTO = listaServidores.stream().map(obj -> new ServidorDTO(obj))
				.collect(Collectors.toList());

		return ResponseEntity.ok().body(listaDTO);
	}

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<ServidorEntity> salvar(@Valid @RequestBody ServidorDTOList objDTO) {

		System.out.println(objDTO.getHorarios_id());
		System.out.println(objDTO.getSala_id());

		SalaEntity salaE = salaService.buscar(objDTO.getSala_id());
		ServidorEntity servE = new ServidorEntity(null, objDTO.getNome(), objDTO.getEmail(), salaE);
		List<Integer> listaDeHorarios = objDTO.getHorarios_id();
		
		for (Integer id : listaDeHorarios) {
			HorarioEntity horarioEntity = horarioService.buscar(id);
			servE.getHorarios().addAll(Arrays.asList(horarioEntity));
		}

		servE = service.salvar(servE);

		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(servE.getId()).toUri();
		return ResponseEntity.created(uri).build();

//		return ResponseEntity.ok().body(servE);
	}

	@RequestMapping(method = RequestMethod.PUT, value = "/{id}")
	public ResponseEntity<Void> atualizar(@Valid @RequestBody ServidorDTOIds objDTO, @PathVariable Integer id) {

		return ResponseEntity.noContent().build();
	}

	@RequestMapping(method = RequestMethod.DELETE, value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable Integer id) {
		service.apagar(id);
		return ResponseEntity.noContent().build();
	}

}
