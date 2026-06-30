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
	
	public void almacenarRecurso(Recurso recurso) {
		if(comprobarCapacidad(recurso.getPeso())==false) {
			System.out.println("No hay espacio suficiente en la bodega");
		}
		else {
			recursos.add(recurso);
			System.out.println("Recurso guardado con exito");
			capacidad-=recurso.getPeso();
		}
		
	}
	

	
	public void retirarRecurso(Recurso recurso) {
		boolean eliminado = recursos.remove(recurso);

		if (eliminado) {
	        System.out.println("Recurso retirado.");
	    } else {
	        System.out.println("Ese recurso no estaba en la bodega.");
	    }
	}
	
	public void mostrarRecursos() {
		
		if(recursos.isEmpty()) {
			System.out.println("No hay recursos guardados en la bodega");
			return;
		}		

		System.out.println("RECURSOS 2EN BODEGA:");
		for( Recurso recurso: recursos) {
			recurso.mostrarDatos();
		}
		
	}
	
	public boolean comprobarCapacidad(int peso) {
		
		if(calcularCarga() + peso > capacidad) {
			return false;
		}
		else {
			return true;
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
