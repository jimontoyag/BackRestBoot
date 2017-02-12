package com.bytespree.backrest.service;

import org.springframework.stereotype.Service;

import com.bytespree.backrest.model.Cubo3D;

@Service
public class CuboService {
	
	private Cubo3D instanciaCubo;
	
	private Integer operaciones;
	
	private Integer M;
	
	public String cuboProces(String comando) throws NumberFormatException, IndexOutOfBoundsException{
		String respuesta;
		if(operaciones == null){
			this.operaciones = Integer.valueOf(comando);
			respuesta = this.operaciones.toString();
		}else if(this.instanciaCubo == null)
			{
				String[] NM = comando.split("\\s+");
				this.instanciaCubo = new Cubo3D(Integer.valueOf(NM[0]).intValue());
				this.M = Integer.valueOf(NM[1]);
				respuesta=comando.toString();
			}else if(M > 0){
				String[] sentencia = comando.split("\\s+");
				if(sentencia.length == 5){
					this.instanciaCubo.update(Integer.valueOf(sentencia[1]), Integer.valueOf(sentencia[2]), 
							Integer.valueOf(sentencia[3]), Integer.valueOf(sentencia[4]));
					respuesta="";
				}else if(sentencia.length == 7){
					respuesta = this.instanciaCubo.query(Integer.valueOf(sentencia[1]), Integer.valueOf(sentencia[2]), 
							Integer.valueOf(sentencia[3]), Integer.valueOf(sentencia[4]), Integer.valueOf(sentencia[5]), 
							Integer.valueOf(sentencia[6]))+"";			
				}else{
					throw new NumberFormatException("comando:"+comando);
				}
				M--;
			}else{
				this.operaciones--;
				if(this.operaciones == 0){
					this.operaciones = null;
					this.instanciaCubo = null;
					respuesta = this.cuboProces(comando);
				}else{
					this.instanciaCubo = null;
					respuesta = this.cuboProces(comando);
				}
			}
		
		return respuesta;
	}
	
	
	
	

}
