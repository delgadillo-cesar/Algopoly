package entidades;

import java.util.HashMap;

import propiedades.Propiedad;
import tablero.PosicionTablero;
import tablero.Tablero;

public class Jugador {

	private String nombre;
	private int capital;
	private HashMap<String, Propiedad> propiedades;
	private TipoMovimiento tipoMovimiento;
	private PosicionTablero miPosicion;

	
	public Jugador(String unNombre) {
		this.nombre = unNombre;
		this.capital = 100000;
		this.propiedades = new HashMap<String, Propiedad>();
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
	
	public void comprarPropiedad(Propiedad unaPropiedad){
		unaPropiedad.comprar(this);
		propiedades.put(unaPropiedad.nombre(), unaPropiedad);
	}

	public int cantidadPropiedades ()	{
		return this.propiedades.size();
	}

	public boolean tienePropiedad(String unaDescipcionDePropiedad) {
		return (propiedades.get(unaDescipcionDePropiedad) != null);
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
