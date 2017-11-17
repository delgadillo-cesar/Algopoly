package propiedades;

import entidades.Jugador;
import entidades.MismoJugadorException;
import tablero.Casilla;

public abstract class Propiedad extends Casilla {
	
	protected String nombrePropiedad;
	protected Jugador propietario;
	protected int precioCompra;

	
	public Propiedad() {
		propietario = new Jugador("Nadie");
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
		this.propietario = unJugador;
	}
	
	public abstract void afectar(Jugador jugador) throws MismoJugadorException;
}
