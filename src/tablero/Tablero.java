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
	private static final Integer CANTIDAD_CASILLAS = 20;
	private static final Integer CASILLA_INICIAL = 1;
	private HashMap<String, Casilla> casillas;
	private HashMap<Integer, Casilla> numeroCasilla;
//	private HashMap<Jugador, Integer> jugadorNroCasilla;
	
	private Casilla crearBsAsZonaSur(){
		List<Construccion> construcciones = new ArrayList<Construccion>();
		
		construcciones.add(Construccion.construirUnTerreno(2000));
		construcciones.add(Construccion.construirUnaCasa(5000, 3000));
		construcciones.add(Construccion.construirDosCasa(5000, 3500));
		construcciones.add(Construccion.construirUnHotel(8000, 5000));
		
		return (new Barrio("BS AS ZONA SUR", 20000, construcciones));
	}
	
	private Casilla crearBsAsZonaNorte(){
		List<Construccion> construcciones = new ArrayList<Construccion>();
		
		construcciones.add(Construccion.construirUnTerreno(2500));
		construcciones.add(Construccion.construirUnaCasa(5500, 3500));
		construcciones.add(Construccion.construirDosCasa(5500, 4000));
		construcciones.add(Construccion.construirUnHotel(9000, 6000));
		
		return (new Barrio("BS AS ZONA NORTE", 25000, construcciones));
	}
	
	private Casilla crearCordobaSur(){
		List<Construccion> construcciones = new ArrayList<Construccion>();
		
		construcciones.add(Construccion.construirUnTerreno(1000));
		construcciones.add(Construccion.construirUnaCasa(2000, 1500));
		construcciones.add(Construccion.construirDosCasa(2000, 2500));
		construcciones.add(Construccion.construirUnHotel(3000, 3000));
		
		return (new Barrio("CORDOBA SUR", 18000, construcciones));
	}
	
	private Casilla crearCordobaNorte(){
		List<Construccion> construcciones = new ArrayList<Construccion>();
		
		construcciones.add(Construccion.construirUnTerreno(1300));
		construcciones.add(Construccion.construirUnaCasa(2200, 1800));
		construcciones.add(Construccion.construirDosCasa(2200, 2900));
		construcciones.add(Construccion.construirUnHotel(3500, 3500));
		
		return (new Barrio("CORDOBA NORTE", 20000, construcciones));
	}
	
	private Casilla crearSantaFe(){
		List<Construccion> construcciones = new ArrayList<Construccion>();
		
		construcciones.add(Construccion.construirUnTerreno(1500));
		construcciones.add(Construccion.construirUnaCasa(4000, 3500));
		
		return (new Barrio("SANTA FE", 15000, construcciones));
	}

	private Casilla crearSaltaNorte(){
		List<Construccion> construcciones = new ArrayList<Construccion>();
		
		construcciones.add(Construccion.construirUnTerreno(2000));
		construcciones.add(Construccion.construirUnaCasa(4500, 3250));
		construcciones.add(Construccion.construirDosCasa(4500, 3850));
		construcciones.add(Construccion.construirUnHotel(7500, 5500));
		
		return (new Barrio("SALTA NORTE", 23000, construcciones));
	}
	
	private Casilla crearSaltaSur(){
		List<Construccion> construcciones = new ArrayList<Construccion>();
		
		construcciones.add(Construccion.construirUnTerreno(2000));
		construcciones.add(Construccion.construirUnaCasa(4500, 3250));
		construcciones.add(Construccion.construirDosCasa(4500, 3850));
		construcciones.add(Construccion.construirUnHotel(7500, 5500));
		
		return (new Barrio("SALTA SUR", 23000, construcciones));
	}
	
	private Casilla crearNeuquen(){
		List<Construccion> construcciones = new ArrayList<Construccion>();
		
		construcciones.add(Construccion.construirUnTerreno(1800));
		construcciones.add(Construccion.construirUnaCasa(4800, 3800));
		
		return (new Barrio("NEUQUEN", 17000, construcciones));
	}

	private Casilla crearTucuman(){
		List<Construccion> construcciones = new ArrayList<Construccion>();
		
		construcciones.add(Construccion.construirUnTerreno(1800));
		construcciones.add(Construccion.construirUnEdificioHistorico(7000, 4500));
		
		return (new Barrio("TUCUMAN", 25000, construcciones));
	}

	
	
	private Tablero(){
		Casilla unaCasilla;
		
		casillas = new HashMap<String, Casilla>();
		numeroCasilla = new HashMap<Integer, Casilla>();
//		jugadorNroCasilla = new HashMap<Jugador, Integer>();
		
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

	private static boolean estaEnRango(int unNroCasillero){
		return ((0 < unNroCasillero) && (unNroCasillero <= CANTIDAD_CASILLAS ));
	}
	
	public static PosicionTablero ajustarPosicionSegunBordes(PosicionTablero unaPosicion){
		Integer nroCasilla = unaPosicion.getPosicion();
		PosicionTablero nuevaPosicion = unaPosicion;
		
		while (!(estaEnRango(nroCasilla))){
			if (nroCasilla > CANTIDAD_CASILLAS) nroCasilla -= CANTIDAD_CASILLAS;
			if (nroCasilla <= 0) nroCasilla += CANTIDAD_CASILLAS;
		}
		nuevaPosicion.setPosicion(nroCasilla);
		
		return nuevaPosicion;
	}

	public void desplazar(Jugador unJugador, int desplazarCasilleros) {
		Casilla nuevaCasilla;
		Integer nroCasillaJugador = unJugador.obtenerPosicion().getPosicion();
		Integer nroCasillaNueva = nroCasillaJugador + desplazarCasilleros;
		
		while (!(estaEnRango(nroCasillaNueva))){
			if (nroCasillaNueva > CANTIDAD_CASILLAS) nroCasillaNueva -= CANTIDAD_CASILLAS;
			if (nroCasillaNueva <= 0) nroCasillaNueva += CANTIDAD_CASILLAS;
		}
		
		nuevaCasilla = numeroCasilla.get(nroCasillaNueva);
		unJugador.obtenerPosicion().setPosicion(nroCasillaNueva);
		
		nuevaCasilla.afectar(unJugador);
	}


	public void desplazar(Jugador unJugador, String unaDescrripcionCasilla) {
		Casilla nuevaCasilla = casillas.get(unaDescrripcionCasilla);
		
		for (Map.Entry<Integer, Casilla>entry: this.numeroCasilla.entrySet()){
			if(entry.getValue().descripcion() == nuevaCasilla.descripcion()){
				PosicionTablero posicionJugador = unJugador.obtenerPosicion();
				
				posicionJugador.setPosicion(entry.getKey());
				unJugador.cambiarPosicion(posicionJugador);
			}
		}
		
		this.elJugadorSeDesplazo(unJugador);
	}

	/**
	 * 
	 * @param jugador
	 * @return
	 */
	public int casillaDeJugador(Jugador unJugador) {
		return unJugador.obtenerPosicion().getPosicion();
//		return jugadorNroCasilla.get(jugador);
	}
	
	/**
	 * Metodo de tests. No se deberia utilizar
	 * @param unNumeroDeCasilla
	 * @return
	 */
	public boolean casillaEstaVacia(int unNumeroDeCasilla) {
		return true;
		//return !jugadorNroCasilla.containsValue(unNumeroDeCasilla);
	}
	
	/**
	 * Metodo de tests. No se deberia utilizar	 
	 */
	public static void resetear() {
		
		elTablero = new Tablero();
	}

	public static int getNumeroCasillas() {
		return CANTIDAD_CASILLAS;
	}

	public void elJugadorSeDesplazo(Jugador unJugador) {
		Casilla unaCasilla = numeroCasilla.get(unJugador.obtenerPosicion().getPosicion());
		
		unaCasilla.afectar(unJugador);
	}

	public static PosicionTablero obtenerPosicionInicial() {
		PosicionTablero posicionInicial = new PosicionTablero();
		
		posicionInicial.setPosicion(CASILLA_INICIAL);
		
		return posicionInicial;
	}
}
