package propiedades;

import entidades.Jugador;

public interface Comprable {

	public Jugador propietario();	
	public String nombre();	
	public int precioDeCompra();	
	public void comprar(Jugador unJugador);
}
