package planetas;

import java.util.ArrayList;

import enums.TipoPlaneta;
import recursos.*;

public class Gaseoso extends Planeta {
	
	public Gaseoso() {
		
		super(TipoPlaneta.GASEOSO);
		
		ArrayList<Recurso> recursos = new ArrayList<>();
		
		recursos.add(new Gas(60));
		recursos.add(new Plasma(25));
		recursos.add(new Cristal(15));
		
		super.setRecursos(recursos);
		
	}
	
}
