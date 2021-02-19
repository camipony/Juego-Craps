/*
 * Programación interactiva.
 * Autor: Maria Camila Rodriguez - 2025987.
 * Caso 1: Juego Craps.
 */

package craps;
import java.util.Scanner;

// TODO: Auto-generated Javadoc
/**
 * The Class VistaConsola. Clase que se encarga de toda la parte visual de la consola. 
 */
public class VistaConsola {
	
	/** The control craps. Objeto que conecta la clase ControlCraps que se encarga de la parte logica del juego.*/
	private ControlCraps controlCraps; //definiendo el objeto
	
	/** The pregunta. String que almacena la respuesta de el jugador si quiere jugar o no (si/no)*/
	private String pregunta;
	
	/** The lectura datos. Scanner que se encarga de recibir la respuesta del usuario por consola. */
	private Scanner lecturaDatos;

	/**
	 * VistaConsola. Constructor de la clase. 
	 */
	public VistaConsola() {
		controlCraps = new ControlCraps();
		lecturaDatos = new Scanner(System.in); //System.in porque estamos leyendo de la consola

	}

	/**
	 * Iniciar juego. Permite al usuario empezar a jugar, muestra el resultado de cada dado y el tiro 
	 * Y controla el evento del juego: Punto.
	 */
	
	public void iniciarJuego(){
		System.out.println("Desea lanzar los dados? si/no");
		pregunta= lecturaDatos.nextLine();
		if(pregunta.equalsIgnoreCase("si")) {
			//Inicia juego
			controlCraps.calcularTiroSalida();  
			/* printf para preparar una salida con variables
			Formatos de salida: %d es para mostrar variables de numeros enteros*/
			System.out.printf("Dado 1= %d Dado 2= %d Tiro= %d \n", controlCraps.getCaraDado1(), controlCraps.getCaraDado2(), controlCraps.getTiro());

			controlCraps.determinarEstadoJuego();

			switch(controlCraps.getEstado()){
			case 1: System.out.println("Ganaste el juego.");
			break;
			case 2: System.out.println("Perdiste el juego."); 
			break;
			case 3: System.out.printf("Estableciste punto= %d, Debes lanzar nuevamente. \n", controlCraps.getPunto());
			//Ronda punto. Analizar cuantas veces va a lanzar el usuario
			while(controlCraps.getEstado() == 3) {
				System.out.println("Desea lanzar los dados? si/no");
				pregunta = lecturaDatos.nextLine();

				if(pregunta.equalsIgnoreCase("si")) {
					controlCraps.calcularTiroSalida();
					System.out.printf("Dado 1= %d Dado 2= %d Tiro= %d \n", controlCraps.getCaraDado1(), controlCraps.getCaraDado2(), controlCraps.getTiro());
					controlCraps.determinarEstadoJuego();

				}else {
					System.out.println("Abandonaste la partida. Pierdes.");
					controlCraps.setAbandono();
				}
			}

			if(controlCraps.getEstado() == 1) {
				System.out.println("Sacaste el punto. Ganas.");
			}else {
				System.out.println("Pierdes.");
			}
			break;
			}

			seguirJuego();
		}else {
			System.out.println("Adios.");
		}
	}
	
	/**
	 * Seguir juego. Permite que el jugador pueda jugar de nuevo una vez perdió.
	 */
	
	private void seguirJuego() {
		System.out.println("Quieres jugar de nuevo? si/no");
		pregunta = lecturaDatos.nextLine();
		if(pregunta.equalsIgnoreCase("si")) {
			iniciarJuego();
		}else {
			System.out.println("Adios.");
		}
	}
}
