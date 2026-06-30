package recursos;

public class Plasma extends Recurso{

	public Plasma(int probabilidad) {
		
		super("Plasma", 35, 15, probabilidad);
		
	}
	
	public Plasma() {
		
		super("Plasma", 35, 15, 100);
		
	}
	
	public Plasma(Plasma plasma) {
		super(plasma);
	}
	
	@Override
	public Recurso copiar() {
        return new Plasma(this);
    }
	
}
