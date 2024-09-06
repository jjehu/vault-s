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
@Table(name = "estado")
public class EstadoModel {
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@ManyToOne
    @JoinColumn(name = "pais_id")
    private PaisModel pais;
	@Column(name = "nombre")
	private String nombre;
	
	public EstadoModel() {}
	public EstadoModel(PaisModel pais, String nombre) {
		super();
		this.pais = pais;
		this.nombre = nombre;
	}
	

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
