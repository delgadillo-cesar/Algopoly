package entidades;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import poseibles.Barrio;
import poseibles.Compania;

import tablero.Casilla;
import tablero.Comprable;
import tablero.Poseible;
import tablero.PosicionTablero;
import tablero.Tablero;

public abstract class Jugador {

	private String nombre;
	private int capital;
	private HashMap<String, Barrio> barrios;
	private List<Compania> companias;
	private TipoMovimiento tipoMovimiento;
	private PosicionTablero miPosicion;

	
	public Jugador(String unNombre) {
		this.nombre = unNombre;
		this.capital = 100000;
		this.barrios = new HashMap<String, Barrio>();
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
	
	public int cobrar(int unMonto) {
		capital += unMonto;
		
		return unMonto;
	}
/*
	public int pagar(int unMonto) {
		if (unMonto > this.capital) throw new JugadorSinSaldoException();
		
		capital -= unMonto;
		
		return unMonto;
	}
*/	
	public void comprarPropiedad(Comprable unComprable){
		unComprable.comprar(this);
	}

	public void agregarCompania(Compania unaCompania){
		this.companias.add(unaCompania);
	}
	
	public void agregarBarrio(Barrio unBarrio){
		this.barrios.put(unBarrio.nombre(), unBarrio);
	}
	
	public int cantidadPoseciones(){
		return (this.barrios.size() + this.companias.size());
	}
	
	public List<Compania> obtenerCompanias(){
		return this.companias;
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
		
		for (Map.Entry<String, Barrio>entry: this.barrios.entrySet()){
			cantPropiedades += entry.getValue().cantidadDePropiedades();
		}

		return cantPropiedades;
	}
	
	public abstract void pagarA (Jugador cobrador, int monto);
	public abstract int cobrarAJugador1 (int monto);
	public abstract int cobrarAJugador2 (int monto);
	public abstract int cobrarAJugador3 (int monto);
	public abstract int cobrarABanco (int monto);
	
}
