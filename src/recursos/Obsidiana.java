package recursos;

public class Obsidiana extends Recurso{

	public Obsidiana(int probabilidad) {
		super("Obsidiana", 35, 15, probabilidad);	
	}
	
	public Obsidiana() {
		super("Obsidiana", 35, 15, 100);	
	}
	
	public Obsidiana(Obsidiana obsidiana) {
		super(obsidiana);
	}
	
	@Override
	public Recurso copiar() {
        return new Obsidiana(this);
    }
	
}
