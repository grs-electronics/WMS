package com.grs.wms.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;

import com.grs.wms.bean.Rol;
import java.lang.String;

@Transactional
public interface RolDao  extends CrudRepository<Rol,Integer> {
	public List<Rol> findByIdRol(Integer id);
	public List<Rol> findAll();
	public List<Rol> findByNombre(String nombre);
}
