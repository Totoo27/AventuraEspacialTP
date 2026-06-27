package recursos;

public class Obsidiana extends Recurso{

	public Obsidiana(int probabilidad) {
		
		super("Obsidiana", 35, 15, probabilidad);
		
	}
	
	public Obsidiana(Obsidiana obsidiana) {
		super(obsidiana);
	}
	
	@Override
	public Recurso copiar() {
        return new Obsidiana(this);
    }
	
}
