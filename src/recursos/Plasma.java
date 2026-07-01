package recursos;

public class Plasma extends Recurso{

	public Plasma(int probabilidad) {
		
		super("Plasma", 45, 25, probabilidad);
		
	}
	
	public Plasma() {
		
		super("Plasma", 45, 25, 100);
		
	}
	
	public Plasma(Plasma plasma) {
		super(plasma);
	}
	
	@Override
	public Recurso copiar() {
        return new Plasma(this);
    }
	
}
