package com.pbi.map.dto;

import java.io.Serializable;

import com.pbi.map.entity.SalaEntity;

public class SalaDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	private Integer id;

	private String nome, telefone, email;

	private boolean terreo;

	public SalaDTO() {
	}

	public SalaDTO(SalaEntity obj) {
		this.nome = obj.getNome();
		this.telefone = obj.getTelefone();
		this.email = obj.getEmail();
		this.terreo = obj.isTerreo();
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		return result;
	}

	public boolean isTerreo() {
		return terreo;
	}

	public void setTerreo(boolean terreo) {
		this.terreo = terreo;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
