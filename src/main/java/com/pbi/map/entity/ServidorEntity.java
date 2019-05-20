package com.pbi.map.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
public class ServidorEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String nome, email;

//	@JsonBackReference
	@JsonIgnoreProperties("funcionarios")
	@ManyToOne
	@JoinColumn(name = "sala")
	private SalaEntity sala;

	public ServidorEntity() {
	}

	public ServidorEntity(Integer id, String nome, String email, SalaEntity sala) {
		this.id = id;
		this.nome = nome;
		this.email = email;
		this.sala = sala;
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

	public SalaEntity getSala() {
		return sala;
	}

	public void setSala(SalaEntity sala) {
		this.sala = sala;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "ServidorEntity [id=" + id + ", nome=" + nome + ", email=" + email + ", sala=" + sala + "]";
	}

}
