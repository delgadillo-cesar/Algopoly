package modelo.entidades;

import java.util.ArrayList;
import java.util.List;

import modelo.tablero.*;
import modelo.tablero.poseibles.barrios.Barrio;
import modelo.tablero.poseibles.compania.Compania;


public abstract class Jugador {

	private String nombre;
	protected int capital;
	private List<Barrio> barrios;
	private List<Compania> companias;
	private TipoMovimiento tipoMovimiento;
	private PosicionTablero miPosicion;

	
	public Jugador(String unNombre) {
		this.nombre = unNombre;
		this.capital = 100000;
		this.barrios = new ArrayList<Barrio>();
		this.companias = new ArrayList<Compania>();
		this.tipoMovimiento = new MovimientoLibre();
		this.miPosicion = Tablero.obtenerPosicionInicial();
	}

	public String nombreJugador(){
		return this.nombre;
	}
	
	public int capital(){
		return this.capital;
	}
	
	protected int cobrar(int unMonto) {
		capital += unMonto;
		return unMonto;
	}
	
	protected int pagar(int unMonto) {
		if (unMonto > this.capital) throw new JugadorSinSaldoException();
		
		capital -= unMonto;
		return unMonto;
	}

	public void agregarCompania(Compania unaCompania){
		this.companias.add(unaCompania);
	}

	public void quitarCompania(Compania unaCompania){
		this.companias.remove(unaCompania);
	}

	public void agregarBarrio(Barrio unBarrio){
		this.barrios.add(unBarrio);
	}
	
	public void quitarBarrio(Barrio unBarrio){
		this.barrios.remove(unBarrio);
	}
	
	public int cantidadPosesiones(){
		return (this.barrios.size() + this.companias.size());
	}
	
	public List<Compania> obtenerCompanias(){
		return this.companias;
	}

	public List<Barrio> obtenerBarrios() {
		return this.barrios;
	}

	public void mover(int cantidadDeCasilleros){
		this.tipoMovimiento.mover(this, cantidadDeCasilleros);
	}
	
	public void cambiarTipoDeMovimiento(TipoMovimiento unTipoMovimiento){
		this.tipoMovimiento = unTipoMovimiento;
	}

	public PosicionTablero obtenerPosicion(){
		return this.miPosicion;
	}
	
	public void cambiarPosicion(PosicionTablero unaNuevaPosicion){
		this.miPosicion = unaNuevaPosicion;
	}

	public int cantidadPropiedades() {
		int cantPropiedades = 0;
		
		for (Barrio barrio: this.barrios){
			cantPropiedades += barrio.cantidadDePropiedades();
		}

		return cantPropiedades;
	}
	
	public abstract void pagarA (Jugador cobrador, int monto);
	protected abstract int cobrarAJugador (JugadorUno pagador, int monto);
	protected abstract int cobrarAJugador (JugadorDos pagador, int monto);
	protected abstract int cobrarAJugador (JugadorTres pagador, int monto);
	protected abstract int cobrarABanco (Banco pagador, int monto);

	
}
