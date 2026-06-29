package peligros;

import naves.Nave;
import utilidades.Aleatorio;

public class TormentaCosmica extends Peligro {

	public TormentaCosmica() {
		super("Tormenta cosmica", 5, 20);
	}
	
	@Override
	public void realizarEvento(Nave nave) {
		
		int danio = Aleatorio.getRandomInt(danioMinimo, danioMaximo);
		nave.recibirDanio(danio);
		
	}
	
}
