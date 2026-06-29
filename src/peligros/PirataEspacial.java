package peligros;

import naves.Nave;
import naves.VelocidadNave;
import utilidades.Aleatorio;

public class PirataEspacial extends Peligro {

	public PirataEspacial() {
		super("Pirata espacial", 3, 15);
	}
	
	@Override
	public void realizarEvento(Nave nave) {
		
		int danio = Aleatorio.getRandomInt(danioMinimo, danioMaximo);
		
		if(nave.getVelocidad() == VelocidadNave.ALTA) {
			danio *= 2;
		}
		
		nave.recibirDanio(danio);
		
		
	}
	
}
