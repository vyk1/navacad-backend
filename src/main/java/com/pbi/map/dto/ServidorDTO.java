package com.pbi.map.dto;

import java.io.Serializable;

import com.pbi.map.entity.ServidorEntity;

public class ServidorDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private String nome;

	private String email;

	private Integer sala_id;

	public ServidorDTO() {
	}

	public ServidorDTO(ServidorEntity obj) {
//		super();
		this.nome = obj.getNome();
		this.email = obj.getEmail();
		this.sala_id = obj.getSala().getId();
//		this.sala_id = 100000;
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
