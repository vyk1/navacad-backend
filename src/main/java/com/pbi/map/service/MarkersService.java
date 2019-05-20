package com.pbi.map.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.pbi.map.dao.MarkersDAO;
import com.pbi.map.entity.MarkersEntity;
import com.pbi.map.exception.ObjNaoEncontradoException;

@Service
public class MarkersService {

	@Autowired
	public MarkersDAO dao;
	
	public MarkersEntity buscar(Integer id) {
		Optional<MarkersEntity> Markers = dao.findById(id);
		return Markers.orElseThrow(()-> new ObjNaoEncontradoException("Objeto não encontrado"));
	}
	
	public List<MarkersEntity> buscar(){
		 return dao.findAll();
	}

	public MarkersEntity salvar(MarkersEntity obj) {
		obj.setId(null);
		return dao.save(obj);
	}

	public MarkersEntity atualizar(MarkersEntity obj) {	
		MarkersEntity Markers_banco = buscar(obj.getId());
		if(obj.getDescricao()==null)
			obj.setDescricao(Markers_banco.getDescricao());
		
		if(obj.getLatitude()==null)
			obj.setLatitude(Markers_banco.getLatitude());
		
		if(obj.getLongitude()==null)
			obj.setLongitude(Markers_banco.getLongitude());
		
		if(obj.getTitulo()==null)
			obj.setTitulo(Markers_banco.getTitulo());
		
		return dao.save(obj);
	}
	
	public Page<MarkersEntity> buscarPorPagina(
			Integer pagina, 
			Integer qtdLinhas, 
			String orderBy, 
			String dir){		
		PageRequest pageRequest = PageRequest.of(
				pagina, 
				qtdLinhas, 
				Direction.valueOf(dir), 
				orderBy);
		
		return dao.findAll(pageRequest);
	}
	
	public void apagar(Integer id) {
		dao.deleteById(id);		
	}
	
}
