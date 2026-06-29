package peligros;

import naves.Nave;
import naves.VelocidadNave;
import utilidades.Aleatorio;

public class Renegado extends Peligro{

	public Renegado() {
		super("Renegado", 3, 15);
	}
	
	@Override
	public void realizarEvento(Nave nave) {
		
		int danio = Aleatorio.getRandomInt(danioMinimo, danioMaximo);
		
		if(nave.getVelocidad() == VelocidadNave.BAJA) {
			danio *= 2;
		}
		
		nave.recibirDanio(danio);
		
	}
	
}
