package propiedades;

import entidades.Jugador;
import entidades.Nadie;
import entidades.MismoJugadorException;
import tablero.Casilla;

public abstract class Propiedad extends Casilla {
	
	protected String nombrePropiedad;
	protected Jugador propietario;
	protected int precioCompra;

	
	public Propiedad() {
		propietario = new Nadie();
		precioCompra = 0;
	}
	
	
	public Jugador propietario() {
		return propietario;
	}
	
	
	public String nombre(){
		return this.nombrePropiedad;
	}
	
	
	public int precioDeCompra(){
		return this.precioCompra;
	}
	
	
	public void comprar(Jugador unJugador){
		unJugador.pagar(precioCompra);
		propietario = unJugador;
		unJugador.agregar(this);
	}
	
	public abstract void afectar(Jugador jugador) throws MismoJugadorException;
}
