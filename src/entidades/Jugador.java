package entidades;

import java.util.HashMap;

import propiedades.Compania;
import propiedades.Comprable;
import propiedades.Terreno;
import tablero.PosicionTablero;
import tablero.Tablero;

public class Jugador {

	private String nombre;
	private int capital;
	private HashMap<String, Terreno> terrenos;
	private HashMap<String, Compania> companias;
	private TipoMovimiento tipoMovimiento;
	private PosicionTablero miPosicion;

	
	public Jugador(String unNombre) {
		this.nombre = unNombre;
		this.capital = 100000;
		this.terrenos = new HashMap<String, Terreno>();
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
	
	public void agregarTerreno(Terreno unTerreno){
		this.terrenos.put(unTerreno.nombre(), unTerreno);
	}
	
	public int cantidadPoseciones(){
		return (this.terrenos.size() + this.companias.size());
	}

	public boolean esDuenoDe(String unaDescipcionDePropiedad) {
		return ((this.terrenos.containsKey(unaDescipcionDePropiedad)) || (this.companias.containsKey(unaDescipcionDePropiedad)));
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
}
