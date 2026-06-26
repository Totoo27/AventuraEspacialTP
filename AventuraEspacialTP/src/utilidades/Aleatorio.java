package utilidades;

public final class Aleatorio {

	private Aleatorio() {}
	
	public static int getRandomInt(int min, int max){
		
		if(min > max) {
			throw new IllegalArgumentException("El minimo no puede ser mayor al maximo");
		}
		
        return (int)(Math.random()*(max-min+1)+min);
        
    }

    public static int getRandomInt(int max){
        return getRandomInt(0,max-1);
    }
	
}
