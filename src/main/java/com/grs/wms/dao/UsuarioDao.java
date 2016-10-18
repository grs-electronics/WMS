package com.grs.wms.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;

import com.grs.wms.bean.Usuario;

@Transactional
public interface UsuarioDao extends CrudRepository<Usuario, Integer>{
	public List<Usuario> findByIdUsuario(Integer id);
	public Usuario findByUsername(String username);
	public List<Usuario> findAll();
}
