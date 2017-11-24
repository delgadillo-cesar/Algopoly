package entidades;

import java.util.HashMap;
import java.util.Map;

import comprables.Barrio;
import comprables.Compania;
import comprables.Comprable;
import tablero.Casilla;
import tablero.PosicionTablero;
import tablero.Tablero;

public class Jugador {

	private String nombre;
	private int capital;
	private HashMap<String, Barrio> barrios;
	private HashMap<String, Compania> companias;
	private TipoMovimiento tipoMovimiento;
	private PosicionTablero miPosicion;

	
	public Jugador(String unNombre) {
		this.nombre = unNombre;
		this.capital = 100000;
		this.barrios = new HashMap<String, Barrio>();
		this.companias = new HashMap<String, Compania>();
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

	public int pagar(int unMonto) {
		if (unMonto > this.capital) throw new JugadorSinSaldoException();
		
		capital -= unMonto;
		
		return unMonto;
	}
	
	public void comprarPropiedad(Comprable unComprable){
		unComprable.comprar(this);
	}

	public void agregarCompania(Compania unaCompania){
		this.companias.put(unaCompania.nombre(), unaCompania);
	}
	
	public void agregarBarrio(Barrio unBarrio){
		this.barrios.put(unBarrio.nombre(), unBarrio);
	}
	
	public int cantidadPoseciones(){
		return (this.barrios.size() + this.companias.size());
	}

	public boolean esDuenoDe(String unaDescipcionDePropiedad) {
		return ((this.barrios.containsKey(unaDescipcionDePropiedad)) || (this.companias.containsKey(unaDescipcionDePropiedad)));
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
}
