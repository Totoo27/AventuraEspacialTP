package main;

import utilidades.*;
import interaccion.CatalogoMisiones;
import planetas.*;

public class Principal {

	public static void main(String[] args) {

		CatalogoMisiones catalogoMisiones = new CatalogoMisiones();
		
		
		
		System.out.println(	catalogoMisiones.getMision(2).getNombre()	);
	}

}
