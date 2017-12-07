package modelo.tablero.poseibles.barrios;

import modelo.entidades.*;
import modelo.tablero.Poseible;
import modelo.tablero.poseibles.barrios.construcciones.Construccion;
import modelo.tablero.poseibles.barrios.construcciones.ConstruccionPosible;
import modelo.tablero.poseibles.barrios.construcciones.Construible;
import modelo.tablero.poseibles.barrios.construcciones.NadaParaConstruirException;
import modelo.tablero.poseibles.barrios.construcciones.TerrenoConstruible;
import modelo.tablero.poseibles.compania.*;

public abstract class Barrio implements Poseible {

	protected Jugador propietario;
	protected Construccion construido;
	protected ConstruccionPosible construcciones;

	public Barrio(Jugador propietario) {
		TerrenoConstruible terreno = new TerrenoConstruible();

		this.propietario = propietario;
		this.construido = terreno.construirEn(this);
	}

	public Jugador propietario() {
		return this.propietario;
	}

	public int cantidadDePropiedades() {
		return (this.construido.cantidadDePropiedades());
	}

	public void construir() throws NadaParaConstruirException {
		this.construido = this.construcciones.construir(this);
	}

	public int costoConstruccion() throws NadaParaConstruirException {
		return this.construcciones.costoConstruccion(this);
	}

	public Construccion construccionActual() {
		return this.construido;
	}

	public void afectar(Jugador jugador) {
		this.construido.cobrarAlquiler(this.propietario, jugador);
	}

	public boolean sePuedeVenderConstruccion() {
		return this.construido.sePuedeVender();
	}

	public void venderConstruccion() {
		this.construido = this.construido.vender();
	}

	public abstract void valoresDeTerreno(Construible unConstruible);

	public abstract void valoresDeUnaCasa(Construible unConstruible);

	public abstract void valoresDeDosCasas(Construible unConstruible);

	public abstract void valoresDeHotel(Construible unConstruible);

	public abstract void valoresDeEdificioHistorico(Construible unConstruible);

	public void interactuarCon(Barrio otroBarrio) {
	}

	public void interactuarConBuenosAiresNorte(Barrio otroBarrio) {
	}

	public void interactuarConBuenosAiresSur(Barrio otroBarrio) {
	}

	public void interactuarConCordobaNorte(Barrio otroBarrio) {
	}

	public void interactuarConCordobaSur(Barrio otroBarrio) {
	}

	public void interactuarConSaltaNorte(Barrio otroBarrio) {
	}

	public void interactuarConSaltaSur(Barrio otroBarrio) {
	}

	public void interactuarConNeuquen(Barrio otroBarrio) {
	}

	public void interactuarConSantaFe(Barrio otroBarrio) {
	}

	public void interactuarConTucuman(Barrio otroBarrio) {
	}
}
