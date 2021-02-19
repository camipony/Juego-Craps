package craps;

import java.util.Random;

// TODO: Auto-generated Javadoc
/**
 * The Class Dado. La clase dado simula un dado y permite ver el valor de la cara visible.
 */
public class Dado {
	
	/** The cara visible. Es el valor (1-6) obtenido por el usuario en la cara del dado*/
	private int caraVisible;

	/**
	 * Gets the cara visible. Determina el valor de la cara visible del dado.
	 * @return the cara visible. Es un valor entre 1 y 6.
	 */
	
	public int getCaraVisible() {
		Random aleatorio = new Random(); //Instancia un objeto tipo Random
		caraVisible = aleatorio.nextInt(6)+1; //Numero aleatorio entre 1 y 6
		return caraVisible;
	}
	
	
}
