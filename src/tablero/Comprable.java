package tablero;

import entidades.Jugador;

public interface Comprable extends Casilla{

	public int precioDeCompra();	
	public void comprar(Jugador unJugador);
}
