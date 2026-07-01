package main;

import utilidades.*;

import planetas.*;
import interaccion.*;
import naves.*;
import peligros.*;
import recursos.*;

public class Principal {

	public static void main(String[] args) {

		Entrada entrada = new Entrada();
		
		Jugador jugador = ingresarJugador(entrada);
		
		jugador.getNave().getBodega().almacenarRecurso(new Gas());
		
		new PirataEspacial().realizarEvento(jugador.getNave());
		
		mostrarMenuYElegirOpcion(entrada, jugador);
		
		cerrarSistema(entrada);
		
	}
	
	public static void mostrarMenuYElegirOpcion(Entrada entrada, Jugador jugador) {
		
		final int FIN = 8;
		
		do {
			System.out.println();
			System.out.println("--- AVENTURA ESPACIAL ---");
			System.out.println("1. Viajar a un planeta");
			System.out.println("2. Ver bodega de la nave");
			System.out.println("3. Vender recursos");
			System.out.println("4. Ver misiones");
			System.out.println("5. Terminar misión");
			System.out.println("6. Reparar nave");
			System.out.println("7. Descansar");
			System.out.println("8. Terminar juego");
			System.out.print("Opcion: ");
		}while(ingresarOpcion(entrada, FIN, jugador) != FIN);
		
	}
	
	public static int ingresarOpcion(Entrada entrada, int fin, Jugador jugador) {
		
		int opcion = entrada.ingresarEntero(1, fin);
		
		switch(opcion) {
		
		case 1:
			viajar(jugador,entrada);
			break;
			
		case 2:
			jugador.getNave().getBodega().mostrarRecursos();
			break;
			
		case 3:
			
			break;
			
		case 4:
			
			break;
			
		case 5:
			
			break;
			
		case 6:
			gestionarReparacionNave(jugador, entrada);
			break;
			
		case 7:
			mensajeEspera("Descansando", 1000);
			jugador.descansar();
			System.out.println("\nEnergía recargada exitosamente: " + jugador.getEnergia() + "%");
			break;
			
		case 8:
			
			break;
			
		default: 
			System.out.println("Hubo un error al ingresar opción.");
		
		}
		
		return opcion;
		
	}
	
	public static Jugador ingresarJugador(Entrada entrada) {
		String nombre;
		System.out.println("Bienvenido al juego de aventura espacial!!");
		System.out.println("¿Cual es su nombre viajero?");
		nombre=entrada.ingresarTexto();
	
		
		return new Jugador(nombre,eleccionNave(entrada));
	}
	
	public static Nave eleccionNave(Entrada entrada) {
		System.out.println("Elija la nave con la que desa continuar su aventura");
		mostrarNaves();
		
		System.out.println("\n¿Que nave desea tener?");
		int naveElegida=entrada.ingresarEntero(1,3);
		
		switch(naveElegida) {
			case 1:
				return  new Fenix();
			case 2:
				return new Eclipse();
			case 3:
				return new Galaxian();
			default:
				throw new IllegalStateException("Opción inválida.");
				
		}
		
		
	}
	
	public static void mostrarNaves() {
		Nave fenix = new Fenix();
		Nave eclipse = new Eclipse();
		Nave galaxian = new Galaxian();
		
		System.out.print("1. ");
		fenix.mostrarDatos();
		Sistema.esperar(1000);
		
		System.out.print("\n2. ");
		eclipse.mostrarDatos();
		Sistema.esperar(1000);
		
		System.out.print("\n3. ");
		galaxian.mostrarDatos();
		Sistema.esperar(1000);
	}
	
	public static void viajar(Jugador jugador,Entrada entrada) {
		System.out.println("A que planeta desea viajar");
		TipoPlaneta.mostrarPlanetas();
		Planeta planetaViaje=elegirPlaneta(entrada.ingresarEntero(1,TipoPlaneta.values().length));
		verificarPeligro(jugador);
		if(jugador.getNave().getVida()<=0) {
			System.out.println("La nave a sido destruida");
			return;
		}
		else {
			System.out.println("Has llegado al planeta " + planetaViaje.getNombre());
		}
		
	}
	
	public static Planeta elegirPlaneta(int eleccion) {
		
		switch(eleccion) {
			case 1:
				return new Rocoso();
			case 2:
				return new Gaseoso();
			case 3:
				return new Volcanico();
			default:
				return null;
		}
		
	}
	
	
	public static void gestionarReparacionNave(Jugador jugador, Entrada entrada) {

		final Nave NAVE = jugador.getNave();
		
		if(NAVE.isVidaAlMaximo()) {
			System.out.println("La nave tiene la vida al máximo.");
			return;
		}
		
		final int CURACION = 10;
		final int PRECIO = 25;
		int maxReparaciones = (NAVE.getVidaMaxima() / CURACION) - (NAVE.getVida() / CURACION);
		
		System.out.println("PRECIO: " + PRECIO + "$ cada " + CURACION + "%");
		System.out.print("Indique cuantas veces quiere reparar su nave (0 para cancelar): ");
		int cantReparaciones = entrada.ingresarEntero(0, maxReparaciones);
		
		if(cantReparaciones == 0) {
			System.out.println("Se ha cancelado la reparación");
		}
		
		int gastoTotal = cantReparaciones * PRECIO;
		
		if(jugador.getCreditos() < gastoTotal) {
			System.out.println("No tenes créditos suficientes para reparar la nave");
			return;
		}
		
		int curacionTotal = cantReparaciones * CURACION;
		
		NAVE.repararNave(curacionTotal);
		jugador.operarCreditos(-gastoTotal);
		
		System.out.println("Se gastó " + gastoTotal + "$ para reparar un " + curacionTotal + " de la nave.");
		System.out.println("Vida actual: " + NAVE.getVida());
		
	}
	
	public static void verificarPeligro(Jugador jugador) {
		
		int probabilidad = jugador.getNave().getVelocidad().getProbabilidadPeligro();
		
		if(Aleatorio.getRandomInt(1, 100) <= probabilidad) {
			
			Peligro peligro = getRandomPeligro();
			System.out.println("Te has topado con un peligro espacial: " + peligro.getNombre());
			peligro.realizarEvento(jugador.getNave());
			return;
			
		}
		
		System.out.println("No hubo ningun peligro");
		
		
	}
	
	public static void mensajeEspera(String mensaje, int milisegundos) {
		
		String puntos = ".";
		System.out.print(mensaje);
		for(int i = 0; i<3; i++) {
			System.out.print(puntos);
			Sistema.esperar(milisegundos);
		}
		
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
	
	public static void cerrarSistema(Entrada entrada) {
		
		System.out.println("NOS VEMOS!");
		entrada.cerrarScanner();
		
	}

}
