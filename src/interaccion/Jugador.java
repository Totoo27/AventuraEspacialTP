package interaccion;

import naves.Nave;

public class Jugador {

	private String nombre;
	private int energia;
	private int creditos;
	private Nave nave;
	
	public Jugador(String nombre, int creditos, int energia,  Nave nave) {
				
		this.nombre = nombre;
		this.creditos = creditos;
		this.energia = energia;
		this.nave = nave;
		
	}
		
	public String getNombre() {
		return nombre;
	}
	
	public int getCreditos() {
		return creditos;
	}
	
	public int getEnergia() {
		return energia;
	}
	
	public Nave getNave() {
		return nave;
	}
	
	public void mostrarDatos() {
		
		System.out.println("Datos del jugador:");
		System.out.println("Nombre:" +nombre);
		System.out.println("Creditos: "+creditos);
		System.out.println("Energia:" +energia);
		System.out.println("Nave: "+nave);
			
	}
	
	public void operarCreditos(int creditos) {
		
		this.creditos += creditos;
		
		if(this.creditos < 0) {
			this.creditos = 0;
		}
		
	}
		
	public void restarEnergia(int energia) {
		
		this.energia -= energia;
		if(this.energia < 0) {
			this.energia = 0;
		}
	}
		
	public void descansar() {
		this.energia = 100;
	}
	
	
	}
		
	
		
		
	
	
	

