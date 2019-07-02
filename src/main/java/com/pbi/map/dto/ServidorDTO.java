package com.pbi.map.dto;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.pbi.map.entity.SalaEntity;
import com.pbi.map.entity.ServidorEntity;

public class ServidorDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private Integer id;
	private String nome, email;

	@JsonIgnoreProperties("funcionarios")
	private SalaEntity sala;

	public ServidorDTO() {
	}

	public ServidorDTO(ServidorEntity obj) {
		this.id = obj.getId();
		this.nome = obj.getNome();
		this.email = obj.getEmail();
		this.sala = obj.getSala();
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

	public SalaEntity getSala() {
		return sala;
	}

	public void setSala(SalaEntity sala) {
		this.sala = sala;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
