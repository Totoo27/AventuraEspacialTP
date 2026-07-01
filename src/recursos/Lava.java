package recursos;

public class Lava extends Recurso{

	public Lava(int probabilidad) {
		
		super("Lava", 20, 30, probabilidad);
		
	}
	
	public Lava() {
		
		super("Lava", 20, 30, 100);
		
	}
	
	public Lava(Lava lava) {
		super(lava);
	}
	
	@Override
	public Recurso copiar() {
        return new Lava(this);
    }
	
}
