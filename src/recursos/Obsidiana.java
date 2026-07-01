package recursos;

public class Obsidiana extends Recurso{

	public Obsidiana(int probabilidad) {
		super("Obsidiana", 50, 25, probabilidad);	
	}
	
	public Obsidiana() {
		super("Obsidiana", 50, 25, 100);	
	}
	
	public Obsidiana(Obsidiana obsidiana) {
		super(obsidiana);
	}
	
	@Override
	public Recurso copiar() {
        return new Obsidiana(this);
    }
	
}
