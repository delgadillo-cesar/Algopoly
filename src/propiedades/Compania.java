package propiedades;

import entidades.Jugador;
import tablero.Casilla;

public abstract class Compania implements Casilla, Comprable {

	protected String nombrePropiedad;
	protected Jugador propietario;
	protected int precioCompra;
	protected String descripcion;
	

	public void afectar(Jugador jugador) {
		this.propietario.cobrar(jugador.pagar(this.cobrar()));
	}

	public Jugador propietario() {
		return this.propietario;
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
		unJugador.agregarCompania(this);
	}

	public String descripcion() {
		return this.descripcion;
	}	

	protected abstract int cobrar();

}
