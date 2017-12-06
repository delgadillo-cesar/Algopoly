package modelo.tablero;

import modelo.entidades.Jugador;

public interface Poseible extends Casilla{

	public Jugador propietario();
	public void vender();
}
