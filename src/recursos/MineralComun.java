package recursos;

public class MineralComun extends Recurso{

	public MineralComun(int probabilidad) {
		
		super("Mineral comun", 35, 15, probabilidad);
		
	}
	
	public MineralComun(MineralComun mineralComun) {
		super(mineralComun);
	}
	
	@Override
	public Recurso copiar() {
        return new MineralComun(this);
    }
	
}
