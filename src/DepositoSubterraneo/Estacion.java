package DepositoSubterraneo;

import java.util.ArrayList;
import java.util.List;

public class Estacion {
	
	private int volumen;
	private List <Deposito> depositos = new ArrayList<Deposito>();
	private String rebalso=null;
	private int respProf;
	private int respCantDep;
	
	public Estacion(List<Deposito> depositos2, int volumen2) {

		this.depositos= depositos2;
		this.volumen = volumen2;
	}
	
	public Estacion solucion() {
		
		int cantDepUtilizados =0;
		int i=0, difAltura=0, superficie = 1;
		
		while(i<depositos.size()-1 && volumen >0) {
			
			difAltura = depositos.get(i).getDiferencia(depositos.get(i+1));
			superficie = depositos.get(i).getSuperficie();
			this.volumen -= difAltura * superficie;
			if(volumen >=0) 
				depositos.get(i+1).setSuperficie(depositos.get(i).getSuperficie()+
												depositos.get(i+1).getSuperficie());
			cantDepUtilizados+=depositos.get(i).getCantidad();
			i++;
		}
		
		if(volumen>0) {
			superficie = depositos.get(i).getSuperficie();
			cantDepUtilizados+=depositos.get(i).getCantidad();
			this.volumen-= depositos.get(i).getProfundidad()* superficie;
		}
		
		
		
		if(volumen>0)
			rebalso ="REBALSO " + volumen;
		else{
			respCantDep = cantDepUtilizados;
			respProf = (volumen*-1)/superficie;
			if(respProf !=0)
				respProf += depositos.get(i).getProfundidad();
		}
		
		return this;
	}

	public String getRebalso() {
		return rebalso;
	}

	public int getRespProf() {
		return respProf;
	}


	public int getRespCantDep() {
		return respCantDep;
	}

}
