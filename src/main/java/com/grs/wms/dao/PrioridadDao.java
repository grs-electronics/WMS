package com.grs.wms.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;

import com.grs.wms.bean.Prioridad;

@Transactional
public interface PrioridadDao extends CrudRepository<Prioridad,Integer>{
	public List<Prioridad> findAll();
}
