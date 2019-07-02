package com.pbi.sismapgeo.enums;

public enum DiaSemana {

	SEGUNDA(1), TERÇA(2), QUARTA(3), QUINTA(4), SEXTA(5);

	private Integer cod;

	private DiaSemana() {
	}

	private DiaSemana(Integer cod) {
		this.cod = cod;
	}

	public Integer getCod() {
		return cod;
	}

	public void setCod(Integer cod) {
		this.cod = cod;
	}

	public static DiaSemana toEnum(Integer cod) {
		if (cod == null) {
			return null;
		}

		for (DiaSemana x : DiaSemana.values()) {
			if (cod.equals(x.getCod())) {
				return x;
			}
		}

		throw new IllegalArgumentException("Id inválido");
	}
}
