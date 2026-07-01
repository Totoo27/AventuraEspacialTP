package recursos;

public class Gas extends Recurso{

	public Gas(int probabilidad) {
		
		super("Gas", 15, 20, probabilidad);
		
	}
	
	public Gas() {
		
		super("Gas", 15, 20, 100);
		
	}
	
	public Gas(Gas gas) {
		super(gas);
	}
	
	@Override
	public Recurso copiar() {
        return new Gas(this);
    }
	
}
