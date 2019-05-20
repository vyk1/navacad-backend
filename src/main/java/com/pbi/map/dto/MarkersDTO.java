package com.pbi.map.dto;

import java.io.Serializable;

import com.pbi.map.entity.MarkersEntity;

public class MarkersDTO implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private String latitude, longitude, descricao, titulo;
	
	public MarkersDTO() {}

	public MarkersDTO(MarkersEntity obj) {
		this.latitude = obj.getLatitude();
		this.longitude = obj.getLongitude();
		this.descricao = obj.getDescricao();
		this.titulo = obj.getTitulo();
	}
	
	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getLatitude() {
		return latitude;
	}

	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}

	public String getLongitude() {
		return longitude;
	}

	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	
	
}
