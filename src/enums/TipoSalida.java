package enums;

public enum TipoSalida {
	VICTORIA("Victoria"),
	DERROTA("Derrota"),
	SALIDA_VOLUNTARIA("Salida voluntaria");
	
	private String texto;
	
	TipoSalida(String texto){
		this.texto = texto;
	}
	
	public String getTexto() {
		return texto;
	}
}
