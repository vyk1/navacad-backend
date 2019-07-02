package com.pbi.map.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
public class ServidorEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String nome, email;

	@JsonIgnoreProperties("funcionarios")
	@ManyToOne
	@JoinColumn(name = "sala")
	private SalaEntity sala;

	@ManyToMany
	@JoinTable(name = "itinerarios", joinColumns = @JoinColumn(name = "servidor_id"), inverseJoinColumns = @JoinColumn(name = "horario_id"))
	private List<HorarioEntity> horarios = new ArrayList<>();

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

	public List<HorarioEntity> getHorarios() {
		return horarios;
	}

	public void setHorarios(List<HorarioEntity> horarios) {
		this.horarios = horarios;
	}

	@Override
	public String toString() {
		return "ServidorEntity [id=" + id + ", nome=" + nome + ", email=" + email + ", sala=" + sala + "]";
	}

}
