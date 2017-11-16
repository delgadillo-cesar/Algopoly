package tablero;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import acciones.*;
import entidades.Jugador;
import propiedades.*;

public class Tablero {

	private static Tablero elTablero;
	private final Integer CANTIDAD_CASILLAS = 20;
	private HashMap<String, Casilla> casillas;
	private HashMap<Integer, Casilla> numeroCasilla;
	private HashMap<Jugador, Integer> jugadorNroCasilla;
	
	private Casilla crearBsAsZonaSur(){
		List<Construccion> construcciones = new ArrayList<Construccion>();
		
		construcciones.add(Construccion.construirUnTerreno(2000));
		construcciones.add(Construccion.construirUnaCasa(5000, 3000));
		construcciones.add(Construccion.construirDosCasa(5000, 3500));
		construcciones.add(Construccion.construirUnHotel(8000, 5000));
		
		return (new Terreno("BS AS ZONA SUR", 20000, construcciones));
	}
	
	private Casilla crearBsAsZonaNorte(){
		List<Construccion> construcciones = new ArrayList<Construccion>();
		
		construcciones.add(Construccion.construirUnTerreno(2500));
		construcciones.add(Construccion.construirUnaCasa(5500, 3500));
		construcciones.add(Construccion.construirDosCasa(5500, 4000));
		construcciones.add(Construccion.construirUnHotel(9000, 6000));
		
		return (new Terreno("BS AS ZONA NORTE", 25000, construcciones));
	}
	
	private Casilla crearCordobaSur(){
		List<Construccion> construcciones = new ArrayList<Construccion>();
		
		construcciones.add(Construccion.construirUnTerreno(1000));
		construcciones.add(Construccion.construirUnaCasa(2000, 1500));
		construcciones.add(Construccion.construirDosCasa(2000, 2500));
		construcciones.add(Construccion.construirUnHotel(3000, 3000));
		
		return (new Terreno("CORDOBA SUR", 18000, construcciones));
	}
	
	private Casilla crearCordobaNorte(){
		List<Construccion> construcciones = new ArrayList<Construccion>();
		
		construcciones.add(Construccion.construirUnTerreno(1300));
		construcciones.add(Construccion.construirUnaCasa(2200, 1800));
		construcciones.add(Construccion.construirDosCasa(2200, 2900));
		construcciones.add(Construccion.construirUnHotel(3500, 3500));
		
		return (new Terreno("CORDOBA NORTE", 20000, construcciones));
	}
	
	private Casilla crearSantaFe(){
		List<Construccion> construcciones = new ArrayList<Construccion>();
		
		construcciones.add(Construccion.construirUnTerreno(1500));
		construcciones.add(Construccion.construirUnaCasa(4000, 3500));
		
		return (new Terreno("SANTA FE", 15000, construcciones));
	}

	private Casilla crearSaltaNorte(){
		List<Construccion> construcciones = new ArrayList<Construccion>();
		
		construcciones.add(Construccion.construirUnTerreno(2000));
		construcciones.add(Construccion.construirUnaCasa(4500, 3250));
		construcciones.add(Construccion.construirDosCasa(4500, 3850));
		construcciones.add(Construccion.construirUnHotel(7500, 5500));
		
		return (new Terreno("SALTA NORTE", 23000, construcciones));
	}
	
	private Casilla crearSaltaSur(){
		List<Construccion> construcciones = new ArrayList<Construccion>();
		
		construcciones.add(Construccion.construirUnTerreno(2000));
		construcciones.add(Construccion.construirUnaCasa(4500, 3250));
		construcciones.add(Construccion.construirDosCasa(4500, 3850));
		construcciones.add(Construccion.construirUnHotel(7500, 5500));
		
		return (new Terreno("SALTA SUR", 23000, construcciones));
	}
	
	private Casilla crearNeuquen(){
		List<Construccion> construcciones = new ArrayList<Construccion>();
		
		construcciones.add(Construccion.construirUnTerreno(1800));
		construcciones.add(Construccion.construirUnaCasa(4800, 3800));
		
		return (new Terreno("NEUQUEN", 17000, construcciones));
	}

	private Casilla crearTucuman(){
		List<Construccion> construcciones = new ArrayList<Construccion>();
		
		construcciones.add(Construccion.construirUnTerreno(1800));
		construcciones.add(Construccion.construirUnEdificioHistorico(7000, 4500));
		
		return (new Terreno("TUCUMAN", 25000, construcciones));
	}

	
	
	private Tablero(){
		Casilla unaCasilla;
		
		casillas = new HashMap<String, Casilla>();
		numeroCasilla = new HashMap<Integer, Casilla>();
		jugadorNroCasilla = new HashMap<Jugador, Integer>();
		
		unaCasilla = new Salida();
		unaCasilla.descripcion();
		casillas.put(unaCasilla.descripcion(), unaCasilla);
		numeroCasilla.put(1, unaCasilla);
		
		unaCasilla = new Quini();
		casillas.put(unaCasilla.descripcion(), unaCasilla);
		numeroCasilla.put(2, unaCasilla);
		
		unaCasilla = this.crearBsAsZonaSur();
		casillas.put(unaCasilla.descripcion(), unaCasilla);
		numeroCasilla.put(3, unaCasilla);
		
		unaCasilla = new Edesur();
		casillas.put(unaCasilla.descripcion(), unaCasilla);
		numeroCasilla.put(4, unaCasilla);
		
		unaCasilla = this.crearBsAsZonaNorte();
		casillas.put(unaCasilla.descripcion(), unaCasilla);
		numeroCasilla.put(5, unaCasilla);
		
		unaCasilla = new Carcel();
		casillas.put(unaCasilla.descripcion(), unaCasilla);
		numeroCasilla.put(6, unaCasilla);
		
		unaCasilla = this.crearCordobaSur();
		casillas.put(unaCasilla.descripcion(), unaCasilla);
		numeroCasilla.put(7, unaCasilla);
		
		unaCasilla = new AvanceDinamico();
		casillas.put(unaCasilla.descripcion(), unaCasilla);
		numeroCasilla.put(8, unaCasilla);

		unaCasilla = new Subte();
		casillas.put(unaCasilla.descripcion(), unaCasilla);
		numeroCasilla.put(9, unaCasilla);

		unaCasilla = this.crearCordobaNorte();
		casillas.put(unaCasilla.descripcion(), unaCasilla);
		numeroCasilla.put(10, unaCasilla);
		
		unaCasilla = new ImpuestoLujo();
		casillas.put(unaCasilla.descripcion(), unaCasilla);
		numeroCasilla.put(11, unaCasilla);

		unaCasilla = this.crearSantaFe();
		casillas.put(unaCasilla.descripcion(), unaCasilla);
		numeroCasilla.put(12, unaCasilla);
		
		unaCasilla = new Aysa();
		casillas.put(unaCasilla.descripcion(), unaCasilla);
		numeroCasilla.put(13, unaCasilla);

		unaCasilla = this.crearSaltaNorte();
		casillas.put(unaCasilla.descripcion(), unaCasilla);
		numeroCasilla.put(14, unaCasilla);
		
		unaCasilla = this.crearSaltaSur();
		casillas.put(unaCasilla.descripcion(), unaCasilla);
		numeroCasilla.put(15, unaCasilla);
		
		unaCasilla = new Policia();
		casillas.put(unaCasilla.descripcion(), unaCasilla);
		numeroCasilla.put(16, unaCasilla);

		unaCasilla = new Trenes();
		casillas.put(unaCasilla.descripcion(), unaCasilla);
		numeroCasilla.put(17, unaCasilla);

		unaCasilla = this.crearNeuquen();
		casillas.put(unaCasilla.descripcion(), unaCasilla);
		numeroCasilla.put(18, unaCasilla);
		
		unaCasilla = new RetrocesoDinamico();
		casillas.put(unaCasilla.descripcion(), unaCasilla);
		numeroCasilla.put(19, unaCasilla);

		unaCasilla = this.crearTucuman();
		casillas.put(unaCasilla.descripcion(), unaCasilla);
		numeroCasilla.put(20, unaCasilla);
}

	public static Tablero getInstance() {
		if (elTablero == null){
			elTablero = new Tablero();
		}
		return elTablero;
	}

	private boolean estaEnRango(int unNroCasillero){
		return ((0 < unNroCasillero) && (unNroCasillero <= CANTIDAD_CASILLAS ));
	}
	
	public void desplazar(Jugador jugador, int desplazarCasilleros) {
		Casilla nuevaCasilla;
		Integer nroCasillaJugador = this.jugadorNroCasilla.get(jugador);
		Integer nroCasillaNueva = nroCasillaJugador + desplazarCasilleros;
		
		while (!(this.estaEnRango(nroCasillaNueva))){
			if (nroCasillaNueva > this.CANTIDAD_CASILLAS) nroCasillaNueva -= CANTIDAD_CASILLAS;
			if (nroCasillaNueva <= 0) nroCasillaNueva += CANTIDAD_CASILLAS;
		}
		
		nuevaCasilla = numeroCasilla.get(nroCasillaNueva);
		
		this.jugadorNroCasilla.remove(jugador);
		this.jugadorNroCasilla.put(jugador, nroCasillaNueva);

		
		nuevaCasilla.afectar(jugador);
	}
	
	public void desplazar(Jugador jugador, String unaDescrripcionCasilla) {
		Casilla nuevaCasilla = casillas.get(unaDescrripcionCasilla);
		
		
		for (Map.Entry<Integer, Casilla>entry: this.numeroCasilla.entrySet()){
			if(entry.getValue().descripcion() == nuevaCasilla.descripcion()){
				this.jugadorNroCasilla.remove(jugador);
				this.jugadorNroCasilla.put(jugador, entry.getKey());
			}				
		}		
		
		nuevaCasilla.afectar(jugador);
	}

	/**
	 * 
	 * @param jugador
	 * @return
	 */
	public int casillaDeJugador(Jugador jugador) {
		
		return jugadorNroCasilla.get(jugador);
	}
	
	/**
	 * Metodo de tests. No se deberia utilizar
	 * @param unNumeroDeCasilla
	 * @return
	 */
	public boolean casillaEstaVacia(int unNumeroDeCasilla) {
		return !jugadorNroCasilla.containsValue(unNumeroDeCasilla);
	}
	
	/**
	 * Metodo de tests. No se deberia utilizar	 
	 */
	public static void resetear() {
		
		elTablero = null;
	}
}
