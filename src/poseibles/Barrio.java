package poseibles;

import barrios.*;
import entidades.Jugador;
import entidades.MismoJugadorException;
import tablero.Poseible;

public abstract class Barrio implements Poseible  {
	
	protected Jugador propietario;
	protected Construccion construido;
	protected ConstruccionPosible construcciones;
	
	public Barrio(Jugador propietario) {
		Terreno terreno = new Terreno();

		this.construido = terreno.construirEn(this);
		this.propietario = propietario;
	}


	public Jugador propietario(){
		return this.propietario;
	}
	
	public int cantidadDePropiedades(){
		return (this.construido.cantidadDePropiedades());
	}
	
	public void construir() throws NadaParaConstruirException{
		Construccion nuevaConstruccion = this.construcciones.construir(this);
		this.construido = nuevaConstruccion;
	}
	
	public int costoConstruccion() throws NadaParaConstruirException{
		return this.construcciones.costoConstruccion(this);
	}
	
	public void afectar(Jugador jugador) throws MismoJugadorException {
		this.construido.cobrarAlquiler(this.propietario, jugador);
	}

	public abstract void valoresDeTerreno(Construible unConstruible);
	public abstract void valoresDeUnaCasa(Construible unConstruible);
	public abstract void valoresDeDosCasas(Construible unConstruible);
	public abstract void valoresDeHotel(Construible unConstruible);
	public abstract void valoresDeEdificioHistorico(Construible unConstruible);
}
