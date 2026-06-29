package main;

import utilidades.*;

import planetas.*;
import interaccion.*;
import naves.*;
import peligros.*;

public class Principal {

	public static void main(String[] args) {

		Jugador jugador = new Jugador("Juan", new Fenix());
		
		jugador.mostrarDatos();
		
		for(int i = 0; i<5; i++) {			
			verificarPeligro(jugador.getNave());
		}
		
		jugador.mostrarDatos();
		
	}
	
	public static void verificarPeligro(Nave nave) {
		
		int probabilidad = nave.getVelocidad().getProbabilidadPeligro();
		
		if(Aleatorio.getRandomInt(1, 100) <= probabilidad) {
			
			Peligro peligro = getRandomPeligro();
			Salida.imprimir("Te has topado con un peligro espacial: " + peligro.getNombre());
			peligro.realizarEvento(nave);
			return;
			
		}
		
		Salida.imprimir("No hubo ningun peligro");
		
	}
	
	public static Peligro getRandomPeligro(){
		
		EnumPeligro[] peligros = EnumPeligro.values();
		EnumPeligro peligroAleatorio = peligros[Aleatorio.getRandomInt(peligros.length - 1)];
		
		switch(peligroAleatorio) {
		
		case EnumPeligro.PIRATA_ESPACIAL:
			return new PirataEspacial();
		case EnumPeligro.RENEGADO:
			return new Renegado();
		case EnumPeligro.TORMENTA_COSMICA:
			return new TormentaCosmica();
			
		default: 
			throw new IllegalArgumentException("Hubo un error al cargar el peligro.");
		
		}
		
	}

}
