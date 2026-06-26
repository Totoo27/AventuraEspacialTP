package planetas;

public enum TipoPlaneta {
	
	ROCOSO("Rocoso"),
	GASEOSO("Gaseoso"), 
	VOLCANICO("Volcanico");
	
	private String nombre;
	
	TipoPlaneta(String nombre){
		this.nombre = nombre;
	}
	
	public String getNombre() {
		return nombre;
	}
	
}
