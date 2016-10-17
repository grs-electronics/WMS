package com.grs.wms.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="authorities")
public class Rol {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer idAuthorities;
	@Column
	private String username;
	@Column
	private String authority;
	public Integer getIdAuthorities() {
		return idAuthorities;
	}
	public void setIdAuthorities(Integer idAuthorities) {
		this.idAuthorities = idAuthorities;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getAuthority() {
		return authority;
	}
	public void setAuthority(String authority) {
		this.authority = authority;
	}
	public Rol(Integer idAuthorities, String username, String authority) {
		super();
		this.idAuthorities = idAuthorities;
		this.username = username;
		this.authority = authority;
	}
	public Rol() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
