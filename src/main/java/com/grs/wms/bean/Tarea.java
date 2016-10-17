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
}
