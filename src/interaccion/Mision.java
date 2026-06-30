package interaccion;

import java.util.ArrayList;

import recursos.Recurso;

public class Mision {

	private String nombre;
	private ArrayList<Recurso> requisitos; 
	private boolean completada = false;
	private int recompensa;
	
	
	public Mision(String nombre, int recompensa, ArrayList<Recurso> requisitos) {
		
		this.nombre = nombre;
		this.requisitos = requisitos;
		this.recompensa = recompensa;
		
		
		
	}
	
	
	public int getRecompensa() {
		return recompensa;
	}
	
	public boolean isCompletado() {
		return completada;
	}

	
	 public ArrayList<Recurso> getRequerimientos() { 
		 return requisitos; 
		 }
	 

	public String getNombre() {
		return nombre;
	}

	public void completar() {
		completada = true;
	}
	
}
