package com.pbi.map.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pbi.map.dao.SalaDAO;
import com.pbi.map.entity.SalaEntity;
import com.pbi.map.exception.ObjNaoEncontradoException;

@Service
public class SalaService {
	@Autowired
	public SalaDAO dao;

	public SalaEntity buscar(Integer id) {
		Optional<SalaEntity> Sala = dao.findById(id);
		return Sala.orElseThrow(() -> new ObjNaoEncontradoException("Objeto não encontrado"));
	}

	public List<SalaEntity> buscar() {
		return dao.findAll();
	}

	public List<SalaEntity> buscarByNome(String nome) {
		return dao.search(nome);
	}

	public SalaEntity salvar(SalaEntity obj) {
		// faz requsição com a de baixo
		// ServidorEntity servidor = servidorService.buscar(obj.getServidor().getId());
		// AlunoEntity aluno = alunoService.buscar(obj.getAluno().getId());
		obj.setId(null);

		return dao.save(obj);
	}

	public void apagar(Integer id) {
		dao.deleteById(id);
	}

	public SalaEntity atualizar(SalaEntity obj) {
		return dao.save(obj);
	}
}
