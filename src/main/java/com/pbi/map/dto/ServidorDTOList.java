package com.pbi.map.dto;

import java.io.Serializable;
import java.util.ArrayList;


public class ServidorDTOList implements Serializable {
	private static final long serialVersionUID = 1L;

	private Integer id, sala_id;

	private String nome, email;

	private ArrayList<Integer> horarios_id;

	public ServidorDTOList() {
	}

	public ServidorDTOList(Integer id, String nome, String email, Integer sala_id) {

		this.id = id;
		this.sala_id = sala_id;
		this.nome = nome;
		this.email = email;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Integer getSala_id() {
		return sala_id;
	}

	public void setSala_id(Integer sala_id) {
		this.sala_id = sala_id;
	}
	
	public ArrayList<Integer> getHorarios_id() {
		return horarios_id;
	}

	public void setHorarios_id(ArrayList<Integer> horarios_id) {
		this.horarios_id = horarios_id;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
