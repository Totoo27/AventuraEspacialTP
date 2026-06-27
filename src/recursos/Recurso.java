package recursos;

import utilidades.Salida;

public abstract class Recurso {
	
	private String nombre;
	private int valor;
	private int peso;
	private int probabilidad = 100;
	
	public Recurso(String nombre, int valor, int peso, int probabilidad) {
		
		if(valor <= 0 || peso <= 0) {
			throw new IllegalArgumentException("Valores del recurso definidos de manera erronea (Deben ser mayores a 0)");
		}
		
		if(probabilidad < 0 || probabilidad > 100) {
			throw new IllegalArgumentException("Valor ingresado inválido");
		}
		
		this.nombre = nombre;
		this.valor = valor;
		this.peso = peso;
		this.probabilidad = probabilidad;
		
	}
	
	public Recurso(Recurso recurso) {
		
		this.nombre = recurso.getNombre();
		this.valor = recurso.getValor();
		this.peso = recurso.getPeso();
		this.probabilidad = recurso.getProbabilidad();
		
	}
	
	public void mostrarDatos() {
		Salida.imprimir("Nombre: " + this.nombre + " | " + this.peso + "Tons. | " + this.valor + "$ | ");
	}

	public String getNombre() {
		return this.nombre;
	}
	
	public int getValor() {
		return this.valor;	
	}
	
	public int getPeso() {
		return this.peso;
	}
	
	public int getProbabilidad() {
		return this.probabilidad;	
	}
	
	public abstract Recurso copiar();
	
}
