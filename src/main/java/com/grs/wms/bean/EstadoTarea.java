package com.grs.wms.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="estado_tarea")
public class EstadoTarea {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer idEstado_Tarea;
	@Column
	private String nombre;
	@Column
	private String descripcion;
	public Integer getIdEstado_Tarea() {
		return idEstado_Tarea;
	}
	public void setIdEstado_Tarea(Integer idEstado_Tarea) {
		this.idEstado_Tarea = idEstado_Tarea;
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
	public EstadoTarea(Integer idEstado_Tarea, String nombre, String descripcion) {
		super();
		this.idEstado_Tarea = idEstado_Tarea;
		this.nombre = nombre;
		this.descripcion = descripcion;
	}
	public EstadoTarea() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
