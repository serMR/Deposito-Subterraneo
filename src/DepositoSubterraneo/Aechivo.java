package DepositoSubterraneo;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Aechivo {
	public static Estacion leer(String path) throws FileNotFoundException {
		
		Scanner sc = new Scanner(new File(path));
		List <Deposito> depositos = new ArrayList<Deposito>();
		int sup, prof, volumen;
		int cantDepositos = sc.nextInt();
		int j=0;
		
		for(int i=0; i<cantDepositos; i++) {
			sup = sc.nextInt();
			prof = sc.nextInt();
			depositos.add(new Deposito(sup, prof));
		}
		
		while(j <depositos.size()-1){
			if(depositos.get(j).compareTo(depositos.get(j+1)) == 0) {
				depositos.get(j).setSuperficie(depositos.get(j).getSuperficie()+
											   depositos.get(j+1).getSuperficie());
				depositos.remove(j+1);
				depositos.get(j).setCantidad();
			}
			else
				j++;	
		}
		volumen = sc.nextInt();
		sc.close();
		
		return new Estacion(depositos, volumen);
		
	}
	
	public static void escribir(String path,Estacion estacion) throws FileNotFoundException {
		
		PrintWriter salida = new PrintWriter(new File(path));
		
		if(estacion.getRebalso()!=null)
			salida.println(estacion.getRebalso());
		else {
			salida.println(estacion.getRespCantDep());
			salida.println(estacion.getRespProf());
		}
		
		salida.close();
		
	}
}
