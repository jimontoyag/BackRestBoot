package com.bytespree.backrest.model;

import java.util.HashMap;

public class Cubo3D {
	
	private final int dimension;
	
	private HashMap<Integer,HashMap<Integer,HashMap<Integer,Integer>>> coordenadas;

	public Cubo3D(int dimension) {
		this.dimension = dimension;
		this.coordenadas =  new HashMap<Integer,HashMap<Integer,HashMap<Integer,Integer>>>();
	}
	
	public void update(int x , int y, int z,int w) throws IndexOutOfBoundsException{
		validaPuntos(new int[]{x,y,z});
		HashMap<Integer,HashMap<Integer,Integer>> X;
		HashMap<Integer,Integer> Y;		
		X = this.coordenadas.get(x);
		if(X == null){
			this.coordenadas.put(x, new HashMap<Integer,HashMap<Integer,Integer>>());
			X = this.coordenadas.get(x);
		}
		Y = X.get(y);
		if(Y == null){
			X.put(y, new HashMap<Integer,Integer>());
			Y = X.get(y);
		}
		Y.put(z, w);
	}
	
	public int query(int x1 , int y1, int z1, int x2 , int y2, int z2) throws IndexOutOfBoundsException{
		validaPuntos(new int[]{x1,y1,z1,x2,y2,z2});
		int incx=inc(x1,x2);
		int incy=inc(y1,y2);
		int incz=inc(z1,z2);
		int yaux = y1, zaux = z1;
		int contador = 0;
		HashMap<Integer,HashMap<Integer,Integer>> X;
		HashMap<Integer,Integer> Y;		
		while(true){
			//INICIO While X
			X = this.coordenadas.get(x1);
			if(X != null){
				y1 = yaux;
				while(true){
					//INICIO While Y
					Y = X.get(y1);
					if(Y != null){
						z1 = zaux;
						while(true){
							//INICIO While Z
							Integer valorW = Y.get(z1);
							if(valorW != null && valorW.intValue()!=0){
								contador+=valorW.intValue();
							}
							//FIN While Z
							if(z1==z2)
								break;
							else
								z1+=incz;
						}	
					}								
					//FIN While Y
					if(y1==y2)
						break;
					else
						y1+=incy;
				}
			}			
			//FIN While X
			if(x1==x2)
				break;
			else
				x1+=incx;
		}
		return contador;
	}
	
	private void validaPuntos(int[] puntos) throws IndexOutOfBoundsException {
		for(int punto:puntos){
			if(!existe(punto)){
				throw new IndexOutOfBoundsException("punto:"+punto+",dimension:"+this.dimension);
			}
		}
		
	}

	private int inc(int a, int b){
		if(a > b){
			return -1;
		}else{
			return 1;
		}
	}
	
	private boolean existe(int punto){
		if(punto >=1 && punto <= dimension){
			return true;
		}else{
			return false;
		}
	}
	
	public String toJson(){
		String jsonFormat = this.coordenadas.toString().replaceAll("=", ":");
		//jsonFormat = jsonFormat.substring(1, jsonFormat.length()-1);
		return jsonFormat;
	}	

}
