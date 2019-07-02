package com.pbi.map.dto;

import java.io.Serializable;

public class ServidorDTOIds implements Serializable {
	private static final long serialVersionUID = 1L;

	private Integer id, sala_id, horario_id;

	private String nome, email;

	public ServidorDTOIds() {
	}

	public ServidorDTOIds(Integer id, String nome, String email, Integer sala_id, Integer horario_id) {

		this.id = id;
		this.nome = nome;
		this.email = email;
		this.sala_id = sala_id;
		this.horario_id = horario_id;
	}

	public Integer getHorario_id() {
		return horario_id;
	}

	public void setHorario_id(Integer horario_id) {
		this.horario_id = horario_id;
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

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
