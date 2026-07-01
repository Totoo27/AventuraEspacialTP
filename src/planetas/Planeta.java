package planetas;

import java.util.ArrayList;

import enums.TipoPlaneta;
import recursos.*;
import utilidades.Configuracion;
import utilidades.Aleatorio;

public abstract class Planeta {

	private final int PORCENTAJE_TOTAL = 100;
	
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
		
		if(probabilidadTotal != PORCENTAJE_TOTAL) {
			throw new IllegalArgumentException("El total de la probabilidad de aparicion de los recursos debe ser de " + PORCENTAJE_TOTAL + "%");
		}
		
	}
	
	public Recurso getRecursoAleatorio() {
		
		int numero = Aleatorio.getRandomInt(1, PORCENTAJE_TOTAL);
		int probabilidad = 0;
		
		for(Recurso recurso : recursosDisponibles) {
			
			probabilidad += recurso.getProbabilidad();
			
			if(numero <= probabilidad) {
				return recurso.copiar();
			}
			
		}
		
		throw new IllegalStateException("Las probabilidades no suman " + PORCENTAJE_TOTAL + ".");
	}
	
	public TipoPlaneta getTipo() {
		return this.tipo;
	}
	
	public String getNombre() {
		return this.tipo.getNombre() ;
	}
	public void mostrarDatos() {
		
		System.out.println("Planeta " + this.tipo.getNombre());
		System.out.println("Recursos:");
		
		for(Recurso recurso : recursosDisponibles) {
			System.out.println("- " + recurso.getNombre() + " " + recurso.getProbabilidad() + "%");
		}
		
	}

}
