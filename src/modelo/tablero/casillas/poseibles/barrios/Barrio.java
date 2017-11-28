package modelo.tablero.casillas.poseibles.barrios;

import modelo.entidades.*;
import modelo.tablero.Poseible;
import modelo.tablero.casillas.poseibles.*;


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
	
	public void interactuarCon(Barrio otroBarrio){}
	public void interactuarConBuenosAiresNorte(Barrio otroBarrio){}
	public void interactuarConBuenosAiresSur(Barrio otroBarrio){}
	public void interactuarConCordobaNorte(Barrio otroBarrio){}
	public void interactuarConCordobaSur(Barrio otroBarrio){}
	public void interactuarConSaltaNorte(Barrio otroBarrio){}
	public void interactuarConSaltaSur(Barrio otroBarrio){}
	public void interactuarConNeuquen(Barrio otroBarrio){}
	public void interactuarConSantaFe(Barrio otroBarrio){}
	public void interactuarConTucuman(Barrio otroBarrio){}
}
