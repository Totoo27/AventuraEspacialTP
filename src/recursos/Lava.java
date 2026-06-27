package recursos;

public class Lava extends Recurso{

	public Lava(int probabilidad) {
		
		super("Lava", 35, 15, probabilidad);
		
	}
	
	public Lava(Lava lava) {
		super(lava);
	}
	
	@Override
	public Recurso copiar() {
        return new Lava(this);
    }
	
}
