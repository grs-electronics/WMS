package com.grs.wms.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.grs.wms.bean.Usuario;
import com.grs.wms.dao.UsuarioDao;

@RestController
@RequestMapping("/v1")
public class UsuarioController {
	@RequestMapping("/user")
	@ResponseBody
	public List<Usuario> getAll(){
		return usuarioDao.findAll();
	}
	@Autowired
	private UsuarioDao usuarioDao;
}
