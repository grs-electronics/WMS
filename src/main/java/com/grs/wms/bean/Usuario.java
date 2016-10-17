package com.grs.wms.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.jboss.logging.Property;

@Entity
@Table(name="users")
public class Usuario {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer idUsers;
	@Column
	private String nombre;
	@Column
	private String username;
	@Column
	private String password;
	@Column
	private String correo;
	@Column
	private Boolean habilitado;
	public Integer getIdUsers() {
		return idUsers;
	}
	public void setIdUsers(Integer idUsers) {
		this.idUsers = idUsers;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getCorreo() {
		return correo;
	}
	public void setCorreo(String correo) {
		this.correo = correo;
	}
	public Boolean isHabilitado() {
		return habilitado;
	}
	public void setHabilitado(Boolean habilitado) {
		this.habilitado = habilitado;
	}
	public Usuario(Integer idUsers, String nombre, String username, String password, String correo,
			Boolean habilitado) {
		super();
		this.idUsers = idUsers;
		this.nombre = nombre;
		this.username = username;
		this.password = password;
		this.correo = correo;
		this.habilitado = habilitado;
	}
	public Usuario() {
		super();
		// TODO Auto-generated constructor stub
	}

	
}
