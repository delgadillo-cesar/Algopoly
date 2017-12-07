package modelo.tablero.poseibles.barrios.construcciones;

import modelo.entidades.Banco;
import modelo.entidades.Jugador;
import modelo.tablero.poseibles.barrios.Barrio;
import modelo.tablero.poseibles.barrios.BarrioDoble;

public class Terreno implements Construccion {

	protected int precioAlquiler;
	protected int precioConstruccion;
	protected String unaDescripcion;
	protected int cantPropiedades;

	
	public Terreno(Barrio unBarrio){
		unBarrio.valoresDeTerreno(this);
		this.unaDescripcion = "terreno";
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

	
	
	private Construccion construccionEnBarrioSimple(Barrio unBarrio) {
		UnaCasa casa = new UnaCasa(unBarrio);
		unBarrio.valoresDeUnaCasa(casa);
		return casa;
	}

	@Override
	public int costoConstruirEnBarrioSimple(Barrio unBarrio) {
		Construccion construccion = this.construccionEnBarrioSimple(unBarrio);
		return construccion.costoCosntruccion(unBarrio);
	}

	@Override
	public Construccion construirEnBarrioSimple(Barrio unBarrio) {
		Construccion construccion = this.construccionEnBarrioSimple(unBarrio);
		unBarrio.propietario().pagarA(Banco.getInstance(), construccion.costoCosntruccion(unBarrio));
		return construccion;
	}


	
	private Construccion construccionEnBarrioDoble(Barrio unBarrio){
		UnaCasa casa = new UnaCasa(unBarrio);
		unBarrio.valoresDeUnaCasa(casa);
		return casa;
	}
	
	@Override
	public int costoConstruirEnBarrioDoble(Barrio unBarrio) {
		if(!((BarrioDoble) unBarrio).podesConstruirCasas()) throw new NadaParaConstruirException();

		Construccion construccion = this.construccionEnBarrioDoble(unBarrio);
		return construccion.costoCosntruccion(unBarrio);
	}

	@Override
	public Construccion construirEnBarrioDoble(Barrio unBarrio) {
		if(!((BarrioDoble) unBarrio).podesConstruirCasas()) throw new NadaParaConstruirException();

		Construccion construccion = this.construccionEnBarrioDoble(unBarrio);
		unBarrio.propietario().pagarA(Banco.getInstance(), construccion.costoCosntruccion(unBarrio));
		return construccion;
	}

	

	private Construccion construccionEnBarrioHistorico(Barrio unBarrio) {
		Edificio edificio = new Edificio(unBarrio);
		unBarrio.valoresDeEdificioHistorico(edificio);
		return edificio;
	}

	@Override
	public int costoConstruirEnBarrioHistorico(Barrio unBarrio) {
		Construccion construccion = this.construccionEnBarrioHistorico(unBarrio);
		return construccion.costoCosntruccion(unBarrio);
	}

	@Override
	public Construccion construirEnBarrioHistorico(Barrio unBarrio) {
		Construccion construccion = this.construccionEnBarrioHistorico(unBarrio);
		unBarrio.propietario().pagarA(Banco.getInstance(), construccion.costoCosntruccion(unBarrio));
		return construccion;
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
		return false;
	}

	@Override
	public Construccion vender() {
		return null;
	}


	@Override
	public int nivelConstruccion() {
		return 0;
	}

}
