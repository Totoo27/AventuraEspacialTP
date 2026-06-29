package naves;

public class Nave {
	
	private final int VIDA_INICIAL = 100;
	
	private String nombre;
	private int vida = VIDA_INICIAL;
	private Bodega bodega;
	private VelocidadNave velocidad;
	
	protected Nave(String nombre,int capacidadBodega, VelocidadNave velocidad) {
		this.nombre=nombre;
		this.velocidad=velocidad;
		bodega= new Bodega(capacidadBodega);
	}
	
	public void mostrarDatos() {
		
		System.out.println("Datos de la nave:");
		System.out.println("Nombre: " + nombre);
		System.out.println("Vida: " + this.vida + "%");
		System.out.println("Velocidad: " + velocidad);
		System.out.println("Capacidad de la bodega: " + bodega.getCapacidad() + "T");
		
	}
	
	
	public void repararNave(int cantidad) {
		
		if(cantidad <= 0) {
			throw new IllegalArgumentException("La cantidad debe ser mayor a 0.");
		}
		
		this.vida += cantidad;
		
		if(this.vida > VIDA_INICIAL) {
			this.vida = VIDA_INICIAL;
		}
		
	}
	
	public void recibirDanio(int cantidad) {
		
		if(cantidad <= 0) {
			throw new IllegalArgumentException("La cantidad debe ser mayor a 0.");
		}
		
		this.vida -= cantidad;
		
		if(this.vida < 0) {
			this.vida = 0;
		}
		
		System.out.println("La nave recibió " + cantidad + "% de daño");
		
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
