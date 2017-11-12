package tablero;

import entidades.Jugador;
import entidades.JugadorConcreto;

public abstract class Casilla {
	
	public abstract void afectar(Jugador jugador);

	public abstract Jugador propietario();

	public abstract int numeroDeCasillerosAAvanzar(JugadorConcreto jugador, int numero);
	
	public abstract int numeroDeCasillerosARetroceder(JugadorConcreto jugador, int numero);
}
