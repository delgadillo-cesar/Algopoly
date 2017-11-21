package propiedades;

import java.util.List;

import entidades.Jugador;
import entidades.MismoJugadorException;
import tablero.Casilla;

public class Barrio implements Casilla, Comprable  {
	
	protected String nombrePropiedad;
	protected Jugador propietario;
	protected int precioCompra;
	protected String descripcion;
	private Construccion construido;
	private List<Construccion> construcciones;

	
	public Barrio(String nombreDelBarrio, int precioCompra, List<Construccion> construcciones) {
		this.construido = construcciones.remove(0);
		this.construcciones = construcciones;
		this.precioCompra = precioCompra;
		this.nombrePropiedad = nombreDelBarrio;
		this.descripcion = nombreDelBarrio;
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
		unJugador.agregarBarrio(this);
	}

	public String descripcion() {
		return this.descripcion;
	}		
	
	public void construir() throws NadaParaConstruirException{
		if (this.construcciones.size() == 0) throw new NadaParaConstruirException();

		Construccion unaConstruccion = this.construcciones.get(0);
		
		this.propietario.pagar(unaConstruccion.costoConstruccion());
		this.construido = unaConstruccion;
		this.construcciones.remove(0);
	}
	
	
	public int costoConstruccion() throws NadaParaConstruirException{
		if (this.construcciones.size() == 0) throw new NadaParaConstruirException();

		return this.construcciones.get(0).costoConstruccion();
	}
	
	
	@Override
	public void afectar(Jugador jugador) throws MismoJugadorException {
		propietario.cobrar(jugador.pagar(construido.precioAlquiler()));
	}
}
