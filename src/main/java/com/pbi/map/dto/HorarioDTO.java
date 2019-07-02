package com.pbi.map.dto;

import java.io.Serializable;

public class HorarioDTO implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private String inicio, fim;
	private Integer diaSemanaInt;

	public HorarioDTO() {

	}

	public HorarioDTO(Integer id, String inicio, String fim, Integer diaSemanaInt) {
		this.id = id;
		this.inicio = inicio;
		this.fim = fim;
		this.diaSemanaInt = diaSemanaInt;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getInicio() {
		return inicio;
	}

	public void setInicio(String inicio) {
		this.inicio = inicio;
	}

	public String getFim() {
		return fim;
	}

	public void setFim(String fim) {
		this.fim = fim;
	}

	public Integer getDiaSemanaInt() {
		return diaSemanaInt;
	}

	public void setDiaSemanaInt(Integer diaSemanaInt) {
		this.diaSemanaInt = diaSemanaInt;
	}


	@Override
	public String toString() {
		return "HorarioDTO [id=" + id + ", inicio=" + inicio + ", fim=" + fim + ", diaSemanaInt=" + diaSemanaInt + "]";
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
