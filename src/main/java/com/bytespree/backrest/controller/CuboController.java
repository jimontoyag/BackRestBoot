package com.bytespree.backrest.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bytespree.backrest.model.Mensaje;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/cubo")
public class CuboController {
	
	@RequestMapping("/ejecutar")
	private Mensaje ejecutar(@RequestParam(value="comando") String comando){
		Mensaje mensaje = new Mensaje();
		try{
			
		}catch(IndexOutOfBoundsException iobe){
			mensaje.setCodigo(210);
			mensaje.setExcepcion(iobe.getMessage());
		}
		return mensaje;
	}

}
