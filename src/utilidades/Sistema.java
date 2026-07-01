package utilidades;

public final class Sistema {
	
	private Sistema() {}
	
	public static void esperar(int milisegundos){
		
		if(milisegundos < 0){
			throw new IllegalArgumentException("los milisegundos no pueden ser negativos");
		}
		
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
