package modelo.tablero.poseibles.barrios.construcciones;

import modelo.entidades.Banco;
import modelo.entidades.Jugador;
import modelo.tablero.poseibles.barrios.Barrio;

public class Hotel implements Construccion {

	protected int precioAlquiler;
	protected int precioConstruccion;
	protected String unaDescripcion;
	protected int cantPropiedades;
	protected Barrio elBarrio;

	public Hotel(Barrio unBarrio) {
		unBarrio.valoresDeHotel(this);
		this.unaDescripcion = "hotel";
		this.elBarrio = unBarrio;
	}
	
	@Override
	public void costoCosntruccion(int costo) {
		this.precioConstruccion = costo;
	}

	@Override
	public void precioAlquiler(int precio) {
		this.precioAlquiler = precio;
	}

	@Override
	public int costoCosntruccion(Barrio unBarrio) {
		return this.precioConstruccion;
	}

	@Override
	public int precioAlquiler(Barrio unBarrio) {
		return this.precioAlquiler;
	}


	@Override
	public int costoConstruirEnBarrioSimple(Barrio unBarrio) {
		throw new NadaParaConstruirException();
	}

	@Override
	public Construccion construirEnBarrioSimple(Barrio unBarrio) {
		throw new NadaParaConstruirException();
	}

	
	
	@Override
	public int costoConstruirEnBarrioDoble(Barrio unBarrio) {
		throw new NadaParaConstruirException();
	}

	@Override
	public Construccion construirEnBarrioDoble(Barrio unBarrio) {
		throw new NadaParaConstruirException();
	}

	
	
	@Override
	public int costoConstruirEnBarrioHistorico(Barrio unBarrio) {
		throw new NadaParaConstruirException();
	}

	@Override
	public Construccion construirEnBarrioHistorico(Barrio unBarrio) {
		throw new NadaParaConstruirException();
	}

	
	
	@Override
	public void cobrarAlquiler(Jugador propietario, Jugador unVisitante) {
		unVisitante.pagarA(propietario, this.precioAlquiler);
	}

	@Override
	public String descripcion() {
		return this.descripcion();
	}

	@Override
	public int cantidadDePropiedades() {
		return 1;
	}

	@Override
	public boolean sePuedeVender() {
		return true;
	}

	@Override
	public Construccion vender() {
		Terreno terreno = new Terreno(this.elBarrio);
		Banco.getInstance().pagarA(this.elBarrio.propietario(), (int) (this.precioConstruccion * 0.85));
		return terreno;
	}
	
	@Override
	public int nivelConstruccion() {
		return 3;
	}
}
