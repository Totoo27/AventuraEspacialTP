package naves;

public enum VelocidadNave {
	ALTA(20),
	MEDIA(40),
	BAJA(60);
	
	private int probabilidadPeligro;
	
	VelocidadNave(int probabilidad){
		this.probabilidadPeligro = probabilidad;
	}
	
	public int getProbabilidadPeligro() {
		return probabilidadPeligro;
	}

}
