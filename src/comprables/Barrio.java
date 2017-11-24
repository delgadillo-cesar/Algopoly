package comprables;

import java.util.HashMap;

import barrios.Construible;
import entidades.Jugador;
import entidades.MismoJugadorException;
import tablero.Casilla;

public abstract class Barrio implements Casilla, Comprable  {
	
	protected int precioCompra;
	protected String nombrePropiedad;
	protected String descripcion;
	protected Construccion construido;

	protected Jugador propietario;
	protected HashMap<Construible,Construible> construcciones;

	public Jugador propietario(){
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
		unJugador.agregarBarrio(this);
	}

	public String descripcion() {
		return this.descripcion;
	}		
	
	public int cantidadDePropiedades(){
		return (this.construido.cantidadDePropiedades());
	}
	
	public void construir() throws NadaParaConstruirException{
		Construible aConstruir = this.construcciones.get(this.construido.construidoPor());

		try{
			this.construido = aConstruir.construirEn(this);
		}catch(NullPointerException e){
			throw new NadaParaConstruirException();
		}
	}
	
	public int costoConstruccion() throws NadaParaConstruirException{
		Construible aConstruir = this.construcciones.get(this.construido.construidoPor());

		try{
			return (aConstruir.costoConstruccion());
		}catch(NullPointerException e){
			throw new NadaParaConstruirException();
		}
	}
	
	public void afectar(Jugador jugador) throws MismoJugadorException {
		if (this.propietario == null) return;
		propietario.cobrar(jugador.pagar(construido.precioAlquiler()));
	}
}
