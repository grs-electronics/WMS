package com.grs.wms.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="tarea")
public class Tarea {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer idTarea;
	@Column
	private String docNum;
	@ManyToOne
	private EstadoTarea estadoTarea;
	@ManyToOne
	private TipoTarea tipoTarea;
	@Column
	private String fechaAsignacion;
	@Column
	private String fecha_inicio;
	@Column
	private String comentario;
	@ManyToOne
	private Prioridad prioridad;
	@ManyToOne
	private Usuario usuario;
	public Integer getIdTarea() {
		return idTarea;
	}
	public void setIdTarea(Integer idTarea) {
		this.idTarea = idTarea;
	}
	public String getDocNum() {
		return docNum;
	}
	public void setDocNum(String docNum) {
		this.docNum = docNum;
	}
	public EstadoTarea getEstadoTarea() {
		return estadoTarea;
	}
	public void setEstadoTarea(EstadoTarea estadoTarea) {
		this.estadoTarea = estadoTarea;
	}
	public TipoTarea getTipoTarea() {
		return tipoTarea;
	}
	public void setTipoTarea(TipoTarea tipoTarea) {
		this.tipoTarea = tipoTarea;
	}
	public String getFechaAsignacion() {
		return fechaAsignacion;
	}
	public void setFechaAsignacion(String fechaAsignacion) {
		this.fechaAsignacion = fechaAsignacion;
	}
	public String getFecha_inicio() {
		return fecha_inicio;
	}
	public void setFecha_inicio(String fecha_inicio) {
		this.fecha_inicio = fecha_inicio;
	}
	public String getComentario() {
		return comentario;
	}
	public void setComentario(String comentario) {
		this.comentario = comentario;
	}
	public Prioridad getPrioridad() {
		return prioridad;
	}
	public void setPrioridad(Prioridad prioridad) {
		this.prioridad = prioridad;
	}
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	public Tarea() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Tarea(Integer idTarea, String docNum, EstadoTarea estadoTarea, TipoTarea tipoTarea, String fechaAsignacion,
			String fecha_inicio, String comentario, Prioridad prioridad, Usuario usuario) {
		super();
		this.idTarea = idTarea;
		this.docNum = docNum;
		this.estadoTarea = estadoTarea;
		this.tipoTarea = tipoTarea;
		this.fechaAsignacion = fechaAsignacion;
		this.fecha_inicio = fecha_inicio;
		this.comentario = comentario;
		this.prioridad = prioridad;
		this.usuario = usuario;
	}
	
}
