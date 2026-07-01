package interaccion;

import java.util.ArrayList;

import recursos.Cristal;
import recursos.MineralComun;
import recursos.Recurso;

public class CatalogoMisiones {
	

	    private ArrayList<Mision> misiones;

	    public CatalogoMisiones() {
	    	this.misiones = new ArrayList<Mision>();
	    	cargarMisiones();
	    	
	    }

	    

	    public void mostrarMisiones() {

	        for (int i = 0; i < misiones.size(); i++) {

	            System.out.println((i + 1) + ". " + misiones.get(i).getNombre());

	        }

	    }
	    private void cargarMisiones() {
	    		
	    	ArrayList<Recurso> requisitos = new ArrayList<Recurso>();
	    	requisitos.add(new MineralComun(100));
	    	requisitos.add(new MineralComun(100));
	    	requisitos.add(new MineralComun(100));
	    	requisitos.add(new Cristal(100));
	    	
	    	ArrayList<Recurso> requisitos2 = new ArrayList<Recurso>();
	    	requisitos.add(new MineralComun(100));
	    	requisitos.add(new MineralComun(100));
	    	requisitos.add(new MineralComun(100));
	    	requisitos.add(new Cristal(100));
	    	
	    	ArrayList<Recurso> requisitos3 = new ArrayList<Recurso>();
	    	requisitos.add(new MineralComun(100));
	    	requisitos.add(new MineralComun(100));
	    	requisitos.add(new MineralComun(100));
	    	requisitos.add(new Cristal(100));
	    	
	    	misiones.add(new Mision("Reparación del casco exterior", 120, requisitos));

	    	misiones.add(new Mision("Te quiero toto", 120, requisitos2));

	    	misiones.add(new Mision("Reparación del casco exterior", 120, requisitos3));
	    	
	    	
	    }
	    
	    
	    public void verificarMision(int posicion) {
	    	
	    }


	    public Mision getMision(int posicion) {
	    		
	    	return misiones.get(posicion - 1);
	    	
	    }

	}
	

