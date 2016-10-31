package com.grs.wms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.grs.wms.bean.Prioridad;
import com.grs.wms.dao.PrioridadDao;

@RestController
@RequestMapping("/v1")
public class PrioridadController {
	@Autowired
	private PrioridadDao prioridadDao;
	@RequestMapping("/prioridad")
	@ResponseBody
	public List<Prioridad> doPrioridad() {
		return prioridadDao.findAll();
	}
}
