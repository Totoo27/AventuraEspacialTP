package naves;

public class Nave {
	final int VIDA_INICIAL=100;
	
	private String nombre;
	private int vida=VIDA_INICIAL;
	private Bodega bodega;
	private VelocidadNave velocidad;
	
	protected Nave(String nombre,int capacidadBodega, VelocidadNave velocidad) {
		this.nombre=nombre;
		this.velocidad=velocidad;
		bodega= new Bodega(capacidadBodega);
	}
	
	public void mostrarDatos() {
		System.out.println("Datos de la nave:");
		System.out.println("Nombre" + nombre);
		System.out.println("Vida;" + this.vida + "%");
		System.out.println("Velocidad:" + velocidad);
		System.out.println("Capacidad de la bodega: " + bodega.getCapacidad() + "T");
		
	}
	
	
	public void repararNave(int cantidad) {
		this.vida+=cantidad;
		
		if(this.vida>=100) {
			this.vida=100;
		}
		
	}
	public String getNombre() {
		return nombre;
	}

	public int getVida() {
		return vida;
	}

	public Bodega getBodega() {
		return bodega;
	}

	public VelocidadNave getVelocidad() {
		return velocidad;
	}
	
}
