package com.grs.wms.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="solucionTarea")
public class SolucionTarea {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer idSolucion_Tarea;
	@ManyToOne
	private Tarea tarea;
	@Column
	private String codigo;
	public Integer getIdSolucion_Tarea() {
		return idSolucion_Tarea;
	}
	public void setIdSolucion_Tarea(Integer idSolucion_Tarea) {
		this.idSolucion_Tarea = idSolucion_Tarea;
	}
	public Tarea getTarea() {
		return tarea;
	}
	public void setTarea(Tarea tarea) {
		this.tarea = tarea;
	}
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	public SolucionTarea(Integer idSolucion_Tarea, Tarea tarea, String codigo) {
		super();
		this.idSolucion_Tarea = idSolucion_Tarea;
		this.tarea = tarea;
		this.codigo = codigo;
	}
	public SolucionTarea() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
