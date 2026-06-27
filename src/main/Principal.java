package main;

import utilidades.*;

import planetas.*;

public class Principal {

	public static void main(String[] args) {

		Planeta planeta = new Gaseoso();
		
		planeta.mostrarDatos();
		
		for(int i = 0; i<10; i++) {
			Salida.imprimir( (i+1) + " - " + planeta.getRecursoAleatorio().getNombre());
		}
		
		
	}

}
