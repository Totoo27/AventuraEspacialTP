package utilidades;

public final class Sistema {
	
	private Sistema() {}
	
	public static void esperar(int milisegundos){
        try {
            Thread.sleep(milisegundos);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
	
	public static void esperar(){
        esperar(Configuracion.milisegundos);
    }

}
