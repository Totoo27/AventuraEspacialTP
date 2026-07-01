package planetas;

import java.util.ArrayList;

import enums.TipoPlaneta;
import recursos.*;

public class Rocoso extends Planeta {

	public Rocoso() {
		
		super(TipoPlaneta.ROCOSO);
		
		ArrayList<Recurso> recursos = new ArrayList<>();
		
		recursos.add(new MineralComun(60));
		recursos.add(new Cristal(25));
		recursos.add(new NucleoEnergetico(15));
		
		super.setRecursos(recursos);
		
	}
	
}
