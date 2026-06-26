package utilidades;

public final class Salida {

	private Salida(){}
	
	public static void imprimir(String texto) {
        System.out.println(texto);
        if(Configuracion.hayEspera) Sistema.esperar();
	}
    
	public static void imprimir(int numero) {
        System.out.println(String.valueOf(numero));
        if(Configuracion.hayEspera) Sistema.esperar();
	}
	
}
