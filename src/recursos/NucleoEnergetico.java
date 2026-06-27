package recursos;

public class NucleoEnergetico extends Recurso{

	public NucleoEnergetico(int probabilidad) {
		
		super("Nucleo energetico", 35, 15, probabilidad);
		
	}
	
	public NucleoEnergetico(NucleoEnergetico nucleoEnergetico) {
		super(nucleoEnergetico);
	}
	
	@Override
	public Recurso copiar() {
        return new NucleoEnergetico(this);
    }
	
}
