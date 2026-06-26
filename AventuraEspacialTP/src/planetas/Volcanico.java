package planetas;

import java.util.ArrayList;

import recursos.*;

public class Volcanico extends Planeta {

	public Volcanico() {
		super(TipoPlaneta.VOLCANICO);
		
		ArrayList<Recurso> recursos = new ArrayList<>();
		
		recursos.add(new Lava(50));
		recursos.add(new Obsidiana(30));
		recursos.add(new NucleoEnergetico(20));
		
		super.setRecursos(recursos);
	}
	
}
