
package craps;

// TODO: Auto-generated Javadoc
/**
 * The Class ControlCraps. Controla la logica del juego: Tiros de salida, estado del juego, ronda con Punto
 * abandono de un jugador y los resultados de los puntos y los dados.
 */
public class ControlCraps {

	/** The dado 1 y dado 2 son las simulaciones de un dado real.*/
	private Dado dado1, dado2;
	
	/** The estado define si un jugador: Gana(1) , Pierde (2) , Punto(3) 
	 * 	The tiro es la suma de las dos caras de los dados
	 * 	The punto es la suma de las dos caras de los dados donde se establece Punto.
	 * */
	private int tiro, punto, estado;
	
	/** The lanzamiento. Define si un jugador puede o no volver a lanzar dependiendo del estado del juego.
	 * */
	private boolean lanzamiento;
	
	/** The caras dados. Es un vector que almacena las dos caras de los dados que saque el jugador*/
	private int[] carasDados;
	
	/**
	 * ControlCraps. Constructor, establece los valores por defecto que debe tener los atributos de la clase.
	 */
	public ControlCraps() { 
		
		dado1 = new Dado(); 	//Se crean los objetos que se utilizan en la clase Dado
		dado2 = new Dado();
		lanzamiento = true;		//Tiro inicial, ronda de tiro
		carasDados = new int[2];
	}
	
	/**
	 * Calcular tiro salida. Establece la suma de las dos caras de los dados.
	 */
	
	public void calcularTiroSalida() {
		carasDados[0]= dado1.getCaraVisible();
		carasDados[1]= dado2.getCaraVisible();
		tiro = carasDados[0] + carasDados[1];
		
		//tiro = dado1.getCaraVisible()+dado2.getCaraVisible(); //Valor del tiro
		
	}
	
	/**
	 * Determinar estado juego. Decide cual es el estado del juego dependiendo de un tiro determinado.
	 */
	public void determinarEstadoJuego() {
		if(lanzamiento) { //Si lanzamiento es true
			//Primer lanzamiento (ronda de tiro)
			if(tiro == 7 || tiro == 11) {
				estado= 1; //Ganó 
			}
			if(tiro == 2 || tiro == 3 || tiro == 12) {
				estado = 2; //Perdió
			}else { //Ronda punto
				
				estado = 3; //Entra a ronda de punto
				punto = tiro;
				lanzamiento = false; //Superó el primer tiro
			}
			
		}else {
			rondaPunto();
		}
	}
	
	/**
	 * Ronda punto. Decide que sucede en Punto dependiendo del valor de los dados al tirar nuevamente.
	 */
	private void rondaPunto() { //metodo privados cuando no van a ser llamados de clases externas
		if(tiro == punto) {
			estado= 1;
			lanzamiento = true;
		}
		if(tiro == 7) {
			estado = 2; 
			lanzamiento = true;
		}
	}
	
	/**
	 * Sets the abandono. Controla el estado del juego cuando un jugador se retira.
	 */
	public void setAbandono() {
		estado = 2;
		lanzamiento = true; 
	}
	
	/**
	 * Gets the tiro. Devuelve el valor del tiro. 
	 * @return the tiro. (Es un valor entero de la suma de los dos dados)
	 */
	
	public int getTiro() {
		return tiro;
	}
	
	/**
	 * Gets the punto. Devuelve el valor del punto 
	 * @return the punto (Suma de caras de los dos dados en condicion Punto Craps)
	 */
	public int getPunto() {
		return punto;
	}
	
	/**
	 * Gets the estado. Devuelve el estado del juego 
	 * @return the estado. Es la condicion del jugador en el juego (1 = Gana, 2= Pierde, 3= Punto)
	 */
	public int getEstado() {
		return estado;
	}
	
	/**
	 * Gets the caras dados. Devuelve vector con dos elementos. 
	 * @return the caras dados. (Vector con dos posiciones, dos dados)
	 */
	
	public int[] getCarasDados() {
		return carasDados;
	}
	
	/**
	 * Gets the cara dado 1. Devuelve la posicion de un vector. 
	 * @return the cara dado 1. (Un valor entero que simula la cara del primer dado)
	 */
	
	public int getCaraDado1() {
		return carasDados[0];
	}
	
	/**
	 * Gets the cara dado 2. Devuelve la posicion de un vector. 
	 * @return the cara dado 2. (Un valor entero que simula la cara del segundo dado)
	 */
	
	public int getCaraDado2() {
		return carasDados[1];
	}


}
