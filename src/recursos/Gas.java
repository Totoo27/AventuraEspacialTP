package recursos;

public class Gas extends Recurso{

	public Gas(int probabilidad) {
		
		super("Gas", 35, 15, probabilidad);
		
	}
	
	public Gas() {
		
		super("Gas", 35, 15, 100);
		
	}
	
	public Gas(Gas gas) {
		super(gas);
	}
	
	@Override
	public Recurso copiar() {
        return new Gas(this);
    }
	
}
