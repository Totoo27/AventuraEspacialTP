package recursos;

public class MineralComun extends Recurso{

public MineralComun(int probabilidad) {
		
		super("Mineral comun", 10, 10, probabilidad);
		
	}
	
	public MineralComun() {
		
		super("Mineral comun", 10, 10, 100);
		
	}
	
	public MineralComun(MineralComun mineralComun) {
		super(mineralComun);
	}
	
	@Override
	public Recurso copiar() {
        return new MineralComun(this);
    }
	
}
