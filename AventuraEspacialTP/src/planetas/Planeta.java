package planetas;

import java.util.ArrayList;
import recursos.*;
import utilidades.Configuracion;
import utilidades.Aleatorio;
import utilidades.Salida;

public abstract class Planeta {

	private TipoPlaneta tipo;
	protected ArrayList<Recurso> recursosDisponibles;
	
	public Planeta(TipoPlaneta tipo) {
		
		this.tipo = tipo;
		this.recursosDisponibles = new ArrayList<>();
		
	}
	
	protected void setRecursos(ArrayList<Recurso> recursos) {
		
		if(recursos.isEmpty()) {
			throw new IllegalArgumentException("El planeta debe tener recursos cargados");
		}
		
		int probabilidadTotal = 0;
		
		for(Recurso recurso : recursos) {
			
			recursosDisponibles.add(recurso);
			probabilidadTotal += recurso.getProbabilidad();
			
		}
		
		if(probabilidadTotal != 100) {
			throw new IllegalArgumentException("El total de la probabilidad de aparicion de los recursos debe ser de 100%");
		}
		
	}
	
	public Recurso getRecursoAleatorio() {
		
		Recurso recurso = null;
		
		return recurso;
	}
	
	public TipoPlaneta getTipo() {
		return this.tipo;
	}
	
	public void mostrarDatos() {
		
		boolean esperaOriginal = Configuracion.hayEspera;
		Configuracion.hayEspera = false;
		
		Salida.imprimir("Planeta " + this.tipo.getNombre());
		Salida.imprimir("Recursos:");
		
		for(Recurso recurso : recursosDisponibles) {
			Salida.imprimir("- " + recurso.getNombre() + " " + recurso.getProbabilidad() + "%");
		}
		
		Configuracion.hayEspera = esperaOriginal;
	}

}
