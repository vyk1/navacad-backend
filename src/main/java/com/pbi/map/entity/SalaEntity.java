package com.pbi.map.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
public class SalaEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String nome, telefone, email;

	private boolean terreo;

//	@JsonManagedReference
	@JsonIgnoreProperties ("sala")
	@OneToMany(mappedBy = "sala")
	private List<ServidorEntity> funcionarios = new ArrayList<>();

	public SalaEntity() {
	}

	public SalaEntity(Integer id, String nome, String telefone, String email, boolean terreo) {
		this.id = id;
		this.nome = nome;
		this.telefone = telefone;
		this.email = email;
		this.terreo = terreo;
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

	public boolean isTerreo() {
		return terreo;
	}

	public void setTerreo(boolean terreo) {
		this.terreo = terreo;
	}

	public List<ServidorEntity> getFuncionarios() {
		return funcionarios;
	}

	public void setFuncionarios(List<ServidorEntity> funcionarios) {
		this.funcionarios = funcionarios;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "SalaEntity [id=" + id + ", nome=" + nome + ", telefone=" + telefone + ", email=" + email + ", terreo="
				+ terreo + ", funcionarios=" + funcionarios + "]";
	}
	
	
}
