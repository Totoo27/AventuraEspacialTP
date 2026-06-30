package interaccion;

import java.util.ArrayList;

import recursos.Recurso;

public class CatalogoMisiones {
	

	    private ArrayList<Mision> misiones;

	    public CatalogoMisiones(ArrayList<Mision> misiones) {
	    		
	    	this.misiones = misiones;
	    }

	    

	    public void mostrarMisiones() {

	        for (int i = 0; i < misiones.size(); i++) {

	            System.out.println((i + 1) + ". " + misiones.get(i).getNombre());

	        }

	    }
	    private void cargarMisiones() {
	    		
	    	misiones.add(new Mision(/*NOMBRE, REQUISITOS, RECOMPENSA*/));

	    	misiones.add(new Mision(/*NOMBRE, REQUISITOS, RECOMPENSA*/));

	    	misiones.add(new Mision(/*NOMBRE, REQUISITOS, RECOMPENSA*/));
	    	
	    	
	    }
	    
	    
	    public void verificarMision(int posicion) {
	    	
	    }


	    public Mision getMision(int posicion) {
	    		
	    	return misiones.get(posicion - 1);
	    	
	    }

	}
	

