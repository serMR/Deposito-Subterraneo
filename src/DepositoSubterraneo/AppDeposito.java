package DepositoSubterraneo;

import java.io.FileNotFoundException;

public class AppDeposito {

	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
		Estacion estacion = Aechivo.leer(".\\deposito.in");
		Aechivo.escribir(".\\deposito.out", estacion.solucion());
	}

}
