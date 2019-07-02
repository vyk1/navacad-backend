package com.pbi.map.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pbi.map.dao.ServidorDAO;
import com.pbi.map.entity.ServidorEntity;
import com.pbi.map.exception.ObjNaoEncontradoException;

@Service
public class ServidorService {

	@Autowired
	public ServidorDAO dao;

	public ServidorEntity buscar(Integer id) {
		Optional<ServidorEntity> Servidor = dao.findById(id);
		return Servidor.orElseThrow(() -> new ObjNaoEncontradoException("Objeto não encontrado"));
	}

	public List<ServidorEntity> buscarByNome(String nome) {
		return dao.search(nome);
	}

	public List<ServidorEntity> buscar() {
		return dao.findAll();
	}

	public ServidorEntity salvar(ServidorEntity obj) {
		obj.setId(null);
		return dao.save(obj);
	}
	
	public void apagar(Integer id) {
		dao.deleteById(id);
	}

	public ServidorEntity atualizar(ServidorEntity obj) {
		return dao.save(obj);
	}

}
