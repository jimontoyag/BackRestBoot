package com.bytespree.backrest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bytespree.backrest.model.Mensaje;
import com.bytespree.backrest.service.CuboService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/cubo")
public class CuboController {
	
	@Autowired
	private CuboService service;
	
	@RequestMapping("/ejecutar")
	private Mensaje ejecutar(@RequestParam(value="comando") String comando){
		Mensaje mensaje = new Mensaje();
		try{
			mensaje.setResultado(service.cuboProces(comando));
			mensaje.setCodigo(100);			
		}catch(IndexOutOfBoundsException iobe){
			mensaje.setCodigo(210);
			mensaje.setExcepcion(iobe.getMessage());
		}catch(NumberFormatException cce){
			mensaje.setCodigo(220);
			mensaje.setExcepcion(cce.getMessage());
		}
		return mensaje;
	}

}
