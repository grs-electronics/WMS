package com.grs.wms.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="prioridad")
public class Prioridad {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer idPrioridad;
	@Column
	private String nombre;
	@Column
	private String descripcion;
	public Integer getIdPrioridad() {
		return idPrioridad;
	}
	public void setIdPrioridad(Integer idPrioridad) {
		this.idPrioridad = idPrioridad;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public Prioridad() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Prioridad(Integer idPrioridad, String nombre, String descripcion) {
		super();
		this.idPrioridad = idPrioridad;
		this.nombre = nombre;
		this.descripcion = descripcion;
	}	
	
}
