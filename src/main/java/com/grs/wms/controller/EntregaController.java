package com.grs.wms.controller;

import java.util.HashMap;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.grs.wms.sap.controller.OrdenDeVentaController;
import com.sap.smb.sbo.api.SBOCOMException;

@RestController
@RequestMapping("/v1")
public class EntregaController {
	@RequestMapping("/entrega")
	@ResponseBody
	public List<HashMap<String,Object>> doEntrega() throws SBOCOMException{
		return OrdenDeVentaController.getInstancia().getAll();
	}
}
