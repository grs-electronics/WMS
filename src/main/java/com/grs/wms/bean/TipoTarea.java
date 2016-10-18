package com.grs.wms.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="tipo_tarea")
public class TipoTarea {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer idTipo_tarea;
	@Column
	private String nombre;
	@Column
	private String descripcion;
	public Integer getIdTipo_tarea() {
		return idTipo_tarea;
	}
	public void setIdTipo_tarea(Integer idTipo_tarea) {
		this.idTipo_tarea = idTipo_tarea;
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
	public TipoTarea(Integer idTipo_tarea, String nombre, String descripcion) {
		super();
		this.idTipo_tarea = idTipo_tarea;
		this.nombre = nombre;
		this.descripcion = descripcion;
	}
	public TipoTarea() {
		super();
	}
	
}
