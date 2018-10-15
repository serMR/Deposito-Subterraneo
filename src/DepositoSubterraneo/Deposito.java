package DepositoSubterraneo;

public class Deposito implements Comparable<Deposito>{
	private int superficie;
	private int profundidad;
	private int cant=1;
	public Deposito(int superficie, int profundidad) {
		this.profundidad = profundidad;
		this.superficie = superficie;
	}

	public int getSuperficie() {
		return superficie;
	}

	public void setSuperficie(int superficie) {
		this.superficie = superficie;
	}

	public int getProfundidad() {
		return profundidad;
	}

	public void setProfundidad(int profundidad) {
		this.profundidad = profundidad;
	}

	@Override
	public int compareTo(Deposito arg0) {
		// TODO Auto-generated method stub
		return this.profundidad-arg0.profundidad;
	}

	public int getDiferencia(Deposito deposito) {
		// TODO Auto-generated method stub
		return this.profundidad-deposito.profundidad;
	}

	public void setCantidad() {
		this.cant++;
		// TODO Auto-generated method stub
		
	}
	
	public int getCantidad() {
		return this.cant;
	}
	

}
