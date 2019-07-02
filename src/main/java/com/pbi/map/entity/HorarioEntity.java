package com.pbi.map.entity;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CollectionTable;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import com.pbi.sismapgeo.enums.DiaSemana;

@Entity
public class HorarioEntity {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String inicio;
	private String fim;

	@ElementCollection(fetch = FetchType.EAGER)
	@CollectionTable(name = "diaSemana")
	private Set<Integer> diaSemana = new HashSet<>();

	@ManyToMany(mappedBy = "horarios")
	private List<ServidorEntity> funcionarios = new ArrayList<>();

	public HorarioEntity() {

	}

	public HorarioEntity(Integer id, String inicio, String fim) {
		this.id = id;
		this.inicio = inicio;
		this.fim = fim;
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

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Set<Integer> getDiaSemana() {
		return diaSemana;
	}

	public void setDiaSemana(Set<Integer> diaSemana) {
		this.diaSemana = diaSemana;
	}

	public void addDiaSemana(DiaSemana ds) {
		diaSemana.add(ds.getCod());
	}
}