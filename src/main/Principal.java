package main;

import utilidades.*;

import planetas.*;
import interaccion.*;
import naves.*;

public class Principal {

	public static void main(String[] args) {

		Jugador jugador = new Jugador("Juan", new Fenix());
		
		jugador.mostrarDatos();
		
		jugador.operarCreditos(10);
		
		jugador.mostrarDatos();
		
	}

}
