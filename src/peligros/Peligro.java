package peligros;

import naves.Nave;

public abstract class Peligro {

	private String nombre;
	protected int danioMinimo;
	protected int danioMaximo;
	
	public Peligro(String nombre, int danioMinimo, int danioMaximo) {
		
		if(danioMaximo < danioMinimo) {
			throw new IllegalArgumentException("El mínimo no puede ser mayor al máximo.");
		}
		
		this.nombre = nombre;
		this.danioMinimo = danioMinimo;
		this.danioMaximo = danioMaximo;
	}
	
	public String getNombre() {
		return this.nombre;
	}
	
	public abstract void realizarEvento(Nave nave);
	
}
