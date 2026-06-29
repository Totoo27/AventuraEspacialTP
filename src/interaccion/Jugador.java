package interaccion;

import naves.Nave;

public class Jugador {

	private final int ENERGIA_INICIAL = 100;
	private final int CREDITOS_INICIALES = 0;
	
	private String nombre;
	private int energia = ENERGIA_INICIAL;
	private int creditos = CREDITOS_INICIALES;
	private Nave nave;
	
	public Jugador(String nombre, Nave nave) {
				
		this.nombre = nombre;
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
		System.out.println("Nombre: " + nombre);
		System.out.println("Creditos: " + creditos);
		System.out.println("Energia: " + energia + "%");
		nave.mostrarDatos();
			
	}
	
	public void operarCreditos(int creditos) {
		
		this.creditos += creditos;
		
		if(this.creditos < 0) {
			throw new IllegalArgumentException("Los creditos no pueden ser negativos");
		}
		
	}
		
	public void restarEnergia(int energia) {
		
		this.energia -= energia;
		
		if(this.energia < 0) {
			throw new IllegalArgumentException("La energia no puede ser negativa");
		}
		
	}
		
	public void descansar() {
		this.energia = ENERGIA_INICIAL;
	}
	
	
}