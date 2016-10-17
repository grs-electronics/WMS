package com.grs.wms.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;

import com.grs.wms.bean.Rol;

@Transactional
public interface RolDao  extends CrudRepository<Rol,Integer> {
	public List<Rol> findByIdAuthorities(Integer id);
	
}
