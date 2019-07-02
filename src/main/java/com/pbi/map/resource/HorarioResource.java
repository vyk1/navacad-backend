package com.pbi.map.resource;

import java.net.URI;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.pbi.map.dto.HorarioDTO;
import com.pbi.map.entity.HorarioEntity;
import com.pbi.map.service.HorarioService;

@RestController
@RequestMapping(value = "/horarios")
public class HorarioResource {

	@Autowired
	HorarioService service;

	@RequestMapping(method = RequestMethod.GET)
	public List<HorarioEntity> listar() {
		List<HorarioEntity> lista = service.buscar();
		return lista;
	}

	@RequestMapping(method = RequestMethod.GET, value = "/{id}")
	public ResponseEntity<HorarioEntity> buscar(@PathVariable Integer id) {
		HorarioEntity Horario = service.buscar(id);
		return ResponseEntity.ok(Horario);
	}

	// funfa
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> salvar(@Valid @RequestBody HorarioDTO obj) {

		System.out.println(obj.toString());
		HorarioEntity obj2 = new HorarioEntity(null, obj.getInicio(), obj.getFim());
		Set<Integer> set = new HashSet<Integer>();
		set.add(obj.getDiaSemanaInt());
		System.out.println(set);
		obj2.setDiaSemana(set);

		obj2 = service.salvar(obj2);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj2.getId()).toUri();

		return ResponseEntity.created(uri).build();
	}

	@RequestMapping(method = RequestMethod.PUT, value = "/{id}")
	public ResponseEntity<Void> atualizar(@Valid @RequestBody HorarioDTO obj, @PathVariable Integer id) {

		System.out.println(obj);
		HorarioEntity obj2 = new HorarioEntity(id, obj.getInicio(), obj.getFim());
		Set<Integer> set = new HashSet<Integer>();
		set.add(obj.getDiaSemanaInt());
		System.out.println(set);
		obj2.setDiaSemana(set);
		obj2 = service.atualizar(obj2);

		return ResponseEntity.noContent().build();
	}

	@RequestMapping(method = RequestMethod.DELETE, value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable Integer id) {
		service.apagar(id);
		return ResponseEntity.noContent().build();
	}

}