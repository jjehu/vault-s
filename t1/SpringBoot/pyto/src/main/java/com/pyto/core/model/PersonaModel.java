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
@Table(name="persona")
public class PersonaModel {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	@Column(name = "nombre")
	private String nombre;
	@Column(name = "a_paterno")
	private String ap;
	@Column(name = "a_materno")
	private String am;
	@Column(name = "edad")
	private int edad;
	
	
	@ManyToOne
	@JoinColumn(name = "id_pais")
	private PaisModel pais;
	@ManyToOne
	@JoinColumn(name = "id_estado")
	private DepartamentoModel departamento;
	
	public PersonaModel() {}
	public PersonaModel(String nombre, String ap, String am, int edad, PaisModel pais, DepartamentoModel departamento) {
		super();
		this.nombre = nombre;
		this.ap = ap;
		this.am = am;
		this.edad = edad;
		this.pais = pais;
		this.departamento = departamento;
	}
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getAp() {
		return ap;
	}
	public void setAp(String ap) {
		this.ap = ap;
	}
	public String getAm() {
		return am;
	}
	public void setAm(String am) {
		this.am = am;
	}
	public int getEdad() {
		return edad;
	}
	public void setEdad(int edad) {
		this.edad = edad;
	}
	public PaisModel getPais() {
		return pais;
	}
	public void setPais(PaisModel pais) {
		this.pais = pais;
	}
	public DepartamentoModel getDepartamento() {
		return departamento;
	}
	public void setDepartamento(DepartamentoModel departamento) {
		this.departamento = departamento;
	}
	public int getId() {
		return id;
	}
}
