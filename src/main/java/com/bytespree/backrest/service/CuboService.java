package com.bytespree.backrest.service;

import org.springframework.stereotype.Service;

import com.bytespree.backrest.model.Cubo3D;

@Service
public class CuboService {
	
	private Cubo3D instanciaCubo;
	
	public String cuboProces(String comando) throws NumberFormatException{
		String respuesta;
		if(this.instanciaCubo == null){
			this.instanciaCubo = new Cubo3D(Integer.valueOf(comando).intValue());
			respuesta=comando.toString();
		}else{
			respuesta="Vieo cubo";
		}
		return respuesta;
	}
	
	
	
	

}
