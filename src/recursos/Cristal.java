package recursos;

public class Cristal extends Recurso{

	public Cristal(int probabilidad) {
		
		super("Cristal", 35, 15, probabilidad);
		
	}
	
	public Cristal() {
		super("Cristal", 35, 15, 100);
	}
	
	public Cristal(Cristal cristal) {
		super(cristal);
	}
	
	@Override
	public Recurso copiar() {
        return new Cristal(this);
    }
	
}
