package enums;

public enum TipoPlaneta {
	
	ROCOSO("Rocoso"),
	GASEOSO("Gaseoso"), 
	VOLCANICO("Volcanico");
	
	private String nombre;
	
	TipoPlaneta(String nombre){
		this.nombre = nombre;
	}
	
	public static void mostrarPlanetas() {
	    int i = 1;
	    for (TipoPlaneta tipo : TipoPlaneta.values()) {
	        System.out.println(i + ". " + tipo.getNombre());
	        i++;
	    }
	}
	public String getNombre() {
		return nombre;
	}
	
}
