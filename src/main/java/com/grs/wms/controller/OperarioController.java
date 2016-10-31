package com.grs.wms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.grs.wms.bean.Usuario;
import com.grs.wms.dao.RolDao;
import com.grs.wms.dao.UsuarioDao;

@RestController
@RequestMapping("/v1")
public class OperarioController {
	@Autowired
	private RolDao rolDao;
	@Autowired
	private UsuarioDao usuarioDao;
	@RequestMapping("/operario")
	public List<Usuario> operario(){
		return usuarioDao.findByRol(rolDao.findByNombre("GRS-GT-OPER").get(0));
	}
	
}
