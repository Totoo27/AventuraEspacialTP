package naves;
import java.util.ArrayList;

import recursos.Recurso;

public class Bodega {
	
	private int capacidad;
	private ArrayList <Recurso> recursos;
	
	public Bodega(int capacidad) {
		
		this.capacidad = capacidad;
		this.recursos = new ArrayList<>();
		
	}
	
	public void sumarRecurso() {
		
	}
	
	public void retirarRecurso() {
		
	}
	
	public void mostrarRecursos() {
		
		if(recursos.isEmpty()) {
			System.out.println("No hay recursos guardados en la bodega");
			return;
		}		

		for( Recurso recurso: recursos) {
			recurso.mostrarDatos();
		}
		
	}
	
	
	public int calcularCarga() {
		int capacidadOcupada = 0;
		
		for (Recurso recurso : recursos) {
			capacidadOcupada += recurso.getPeso();
		}
		
		return capacidadOcupada;
	}
	
	public int getCapacidad() {
		return this.capacidad;
	}
}
