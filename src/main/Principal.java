package main;

import utilidades.*;

import planetas.*;
import enums.*;
import interaccion.*;
import naves.*;
import peligros.*;

public class Principal {

	public static void main(String[] args) {

		Entrada entrada = new Entrada();
		
		Jugador jugador = ingresarJugador(entrada);
		
		jugador.mostrarDatos();
		
		mostrarMenuYElegirOpcion(entrada, jugador);
		
		cerrarSistema(entrada, jugador, TipoSalida.SALIDA_VOLUNTARIA);
		
	}
	
	public static void mostrarMenuYElegirOpcion(Entrada entrada, Jugador jugador) {
		
		final int FIN = 9;
		
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
			System.out.println("8. Ver estado del jugador");
			System.out.println("9. Terminar juego");
			System.out.print("Opcion: ");
		}while(ingresarOpcion(entrada, FIN, jugador) != FIN && jugador.getNave().getVida() > 0);
		
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
			jugador.mostrarDatos();
			break;
			
		case 9:
			
			break;
			
		default: 
			System.out.println("Hubo un error al ingresar opción.");
		
		}
		
		return opcion;
		
	}
	
	public static Jugador ingresarJugador(Entrada entrada) {
		String nombre;
		System.out.println("¡Bienvenido a Aventura Espacial!");
		System.out.println("¿Cual es su nombre viajero?");
		nombre = entrada.ingresarTexto();
		
		return new Jugador(nombre, elegirNave(entrada));
	}
	
	public static Nave  elegirNave(Entrada entrada) {
		System.out.println("Elija la nave con la que desa continuar su aventura:");
		mostrarNaves();
		
		System.out.println("\n¿Que nave desea tener?");
		int opcion = entrada.ingresarEntero(1,3);
		EnumNave naveElegida = EnumNave.values()[opcion-1];
		
		switch(naveElegida) {
			case EnumNave.FENIX:
				return  new Fenix();
			case EnumNave.ECLIPSE:
				return new Eclipse();
			case EnumNave.GALAXIAN:
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
		
		Planeta planetaViaje = elegirPlaneta(entrada.ingresarEntero(1,TipoPlaneta.values().length));
		
		mensajeEspera("Viajando", 1000);
		verificarPeligro(jugador.getNave());
		
		if(jugador.getNave().getVida() <= 0) {
			System.out.println("La nave ha sido destruida.");
			cerrarSistema(entrada, jugador, TipoSalida.DERROTA);
			return;
		}
		
		System.out.println("Has llegado al planeta " + planetaViaje.getNombre());
		
	}
	
	public static Planeta elegirPlaneta(int eleccion) {
		
		TipoPlaneta planeta = TipoPlaneta.values()[eleccion-1];
		
		switch(planeta) {
			case TipoPlaneta.ROCOSO:
				return new Rocoso();
			case TipoPlaneta.GASEOSO:
				return new Gaseoso();
			case TipoPlaneta.VOLCANICO:
				return new Volcanico();
			default:
				throw new IllegalStateException("Opción inválida.");
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
	
	public static void verificarPeligro(Nave nave) {
		
		int probabilidad = nave.getVelocidad().getProbabilidadPeligro();
		
		if(Aleatorio.getRandomInt(1, 100) <= probabilidad) {
			
			Peligro peligro = getRandomPeligro();
			System.out.println("Te has topado con un peligro espacial: " + peligro.getNombre());
			peligro.realizarEvento(nave);
			return;
			
		}
		
		System.out.println("No hubo ningun peligro");
		
		
	}
	
	public static void mensajeEspera(String mensaje, int milisegundos) {
		
		String puntos = ".";
		System.out.print(mensaje);
		for(int i = 0; i<3; i++) {
			System.out.print(puntos);
			Sistema.esperar(0);
		}
		System.out.println();
		
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
	
	public static void cerrarSistema(Entrada entrada, Jugador jugador, TipoSalida razonSalida) {
		
		System.out.println("ESTADISTICAS FINALES DEL JUEGO: ");
		jugador.mostrarDatos();
		jugador.getNave().getBodega().mostrarRecursos();
		
		System.out.println("\n Resultado final: " + razonSalida.getTexto());
		System.out.println("NOS VEMOS!");
		entrada.cerrarScanner();
		
	}

}
