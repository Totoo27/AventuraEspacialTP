package utilidades;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Entrada{

	private Scanner s = new Scanner(System.in);
	
	public int IngresarEntero(int min, int max) {
		
		if(min > max) {
			throw new IllegalArgumentException("El minimo no puede ser mayor al maximo");
		}
		
		int numero = 0;
		boolean error = false;
		
		do {
			
			error = false;
			
			try {
				
				numero = s.nextInt();
				if(numero < min || numero > max) {
					System.out.println("ERROR: El numero debe permanecer entre " + min + " y " + max + ".");
					error = true;
				}
				
			} catch(InputMismatchException e) {
				
				error = true;
				System.out.println("ERROR: tipo de dato erróneo");
				
			} finally {
				
				s.nextLine();
				if(error) {
					System.out.print("Ingrese nuevamente el numero: ");
				}
				
			}
			
		}while(error);
		
		return numero;
		
	}
	
}
