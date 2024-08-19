package com.pyto.core.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "departamento")
public class DepartamentoModel {
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@ManyToOne
    @JoinColumn(name = "pais_id")
    private PaisModel pais;
	@Column(name = "nombre")
	private String nombre;
	
	public DepartamentoModel() {}
	public DepartamentoModel(PaisModel pais, String nombre) {
		super();
		this.pais = pais;
		this.nombre = nombre;
	}

	public PaisModel getPais() {
		return pais;
	}

	public void setPais(PaisModel pais) {
		this.pais = pais;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
}
