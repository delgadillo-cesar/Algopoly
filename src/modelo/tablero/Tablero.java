package modelo.tablero;

import java.util.HashMap;

import modelo.entidades.Jugador;
import modelo.tablero.casillas.acciones.*;
import modelo.tablero.casillas.comprables.*;

public class Tablero {

	private static Tablero elTablero;
	private static final Integer CANTIDAD_CASILLAS = 20;
	private static final Integer CASILLA_INICIAL = 1;

	public static final Integer CASILLA_SALIDA = 1;
	public static final Integer CASILLA_QUINI = 2;
	public static final Integer CASILLA_BUENOS_AIRES_SUR = 3;
	public static final Integer CASILLA_EDESUR = 4;
	public static final Integer CASILLA_BUENOS_AIRES_NORTE = 5;
	public static final Integer CASILLA_CARCEL = 6;
	public static final Integer CASILLA_CORDOBA_SUR = 7;
	public static final Integer CASILLA_AVANCE_DINAMICO = 8;
	public static final Integer CASILLA_SUBTE = 9;
	public static final Integer CASILLA_CORDOBA_NORTE = 10;
	public static final Integer CASILLA_IMPUESTO_DE_LUJO = 11;
	public static final Integer CASILLA_SANTA_FE = 12;
	public static final Integer CASILLA_AYSA = 13;
	public static final Integer CASILLA_SALTA_NORTE = 14;
	public static final Integer CASILLA_SALTA_SUR = 15;
	public static final Integer CASILLA_POLICIA = 16;
	public static final Integer CASILLA_TREN = 17;
	public static final Integer CASILLA_NEUQUEN = 18;
	public static final Integer CASILLA_RETROCESO_DINAMICO = 19;
	public static final Integer CASILLA_TUCUMAN = 20;

	
	private HashMap<Integer, Casilla> posicoinCasilla;
	
	private void crearCasillas(){		
		this.posicoinCasilla.put(CASILLA_SALIDA, new Salida());
		this.posicoinCasilla.put(CASILLA_QUINI, new Quini());
		this.posicoinCasilla.put(CASILLA_BUENOS_AIRES_SUR, new BuenosAiresSurComprable());
		this.posicoinCasilla.put(CASILLA_EDESUR, new EdesurComprable());
		this.posicoinCasilla.put(CASILLA_BUENOS_AIRES_NORTE, new BuenosAiresNorteComprable());
		this.posicoinCasilla.put(CASILLA_CARCEL, new Carcel());
		this.posicoinCasilla.put(CASILLA_CORDOBA_SUR, new CordobaSurComprable());
		this.posicoinCasilla.put(CASILLA_AVANCE_DINAMICO, new AvanceDinamico());
		this.posicoinCasilla.put(CASILLA_SUBTE, new SubteComprable());
		this.posicoinCasilla.put(CASILLA_CORDOBA_NORTE, new CordobaNorteComprable());
		this.posicoinCasilla.put(CASILLA_IMPUESTO_DE_LUJO, new ImpuestoLujo());
		this.posicoinCasilla.put(CASILLA_SANTA_FE, new SantaFeComprable());
		this.posicoinCasilla.put(CASILLA_AYSA, new AysaComprable());
		this.posicoinCasilla.put(CASILLA_SALTA_NORTE, new SaltaNorteComprable());
		this.posicoinCasilla.put(CASILLA_SALTA_SUR, new SaltaSurComprable());
		this.posicoinCasilla.put(CASILLA_POLICIA, new Policia());
		this.posicoinCasilla.put(CASILLA_TREN, new TrenComprable());
		this.posicoinCasilla.put(CASILLA_NEUQUEN, new NeuquenComprable());
		this.posicoinCasilla.put(CASILLA_RETROCESO_DINAMICO, new RetrocesoDinamico());
		this.posicoinCasilla.put(CASILLA_TUCUMAN, new TucumanComprable());
	}
	
	
	private Tablero(){
		posicoinCasilla = new HashMap<Integer, Casilla>();
		
		this.crearCasillas();
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

	public void desplazar(Jugador unJugador, int tagCasilla) {
		PosicionTablero unaPosicion = new PosicionTablero();
		unaPosicion.setPosicion(tagCasilla);
		unJugador.cambiarPosicion(unaPosicion);
		
		this.elJugadorSeDesplazo(unJugador);
	}

	public int casillaDeJugador(Jugador unJugador) {
		return unJugador.obtenerPosicion().getPosicion();
	}
	
	public static void resetear() {
		elTablero = new Tablero();
	}

	public void elJugadorSeDesplazo(Jugador unJugador) {
		Casilla unaCasilla = posicoinCasilla.get(unJugador.obtenerPosicion().getPosicion());
		
		unaCasilla.afectar(unJugador);
	}

	public static PosicionTablero obtenerPosicionInicial() {
		PosicionTablero posicionInicial = new PosicionTablero();
		
		posicionInicial.setPosicion(CASILLA_INICIAL);
		
		return posicionInicial;
	}

	public void cambiarCasillaPor(int tagCasilla, Casilla nuevaCasilla) {
		this.posicoinCasilla.put(tagCasilla, nuevaCasilla);
	}
}
