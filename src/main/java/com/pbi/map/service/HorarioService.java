package com.pbi.map.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pbi.map.dao.HorarioDAO;
import com.pbi.map.entity.HorarioEntity;
import com.pbi.map.exception.ObjNaoEncontradoException;

@Service
public class HorarioService {
	@Autowired
	public HorarioDAO dao;

	public HorarioEntity buscar(Integer id) {
		Optional<HorarioEntity> horario = dao.findById(id);
		return horario.orElseThrow(() -> new ObjNaoEncontradoException("Objeto não encontrado"));
	}

	public List<HorarioEntity> buscar() {
		return dao.findAll();
	}

	public HorarioEntity salvar(HorarioEntity obj) {
		obj.setId(null);
		return dao.save(obj);
	}

	public void apagar(Integer id) {
		dao.deleteById(id);
	}

	public HorarioEntity atualizar(HorarioEntity obj) {
		return dao.save(obj);
	}
}
