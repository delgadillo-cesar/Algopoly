package propiedades;

import java.util.List;

import entidades.Jugador;
import entidades.JugadorNadieException;
import entidades.MismoJugadorException;

public class Terreno extends Propiedad {
	
	private Construccion construido;
	private List<Construccion> construcciones;

	
	public Terreno(String nombreTerreno, int precioCompra, List<Construccion> construcciones) {
		this.construido = construcciones.remove(0);
		this.construcciones = construcciones;
		this.precioCompra = precioCompra;
		this.nombrePropiedad = nombreTerreno;
	}

	
	public void construir() throws NadaParaConstruirException{
		if (this.construcciones.size() == 0) throw new NadaParaConstruirException();

		Construccion unaConstruccion = this.construcciones.get(0);
		
		this.propietario.cobrar(unaConstruccion.costoConstruccion());
		this.construido = unaConstruccion;
		this.construcciones.remove(0);
	}
	
	
	public int costoConstruccion() throws NadaParaConstruirException{
		if (this.construcciones.size() == 0) throw new NadaParaConstruirException();

		return this.construcciones.get(0).costoConstruccion();
	}
	
	
	@Override
	public void afectar(Jugador jugador) throws MismoJugadorException {
		try {
			propietario.cobrar(construido.precioAlquiler(), jugador);
		} catch (JugadorNadieException e) {
			this.comprar(jugador);
		}
	}
}
