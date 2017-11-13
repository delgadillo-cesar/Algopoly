package tablero;

import entidades.Jugador;

public class Tablero {

	private static Tablero elTablero;
	
	private Tablero(){
		
	}
		
	public static Tablero getInstance() {
		if (elTablero == null){
			elTablero = new Tablero();
		}
		return elTablero;
	}

	public void desplazar(Jugador jugador, int avanzarCasilleros) {
		/*Implementar*/
	}
	
	

}
