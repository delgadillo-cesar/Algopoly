package modelo.tablero;

import java.util.HashMap;

import modelo.entidades.Jugador;
import modelo.tablero.acciones.*;
import modelo.tablero.comprables.*;

public class Tablero {

	private static Tablero elTablero;
	private static final Integer CANTIDAD_CASILLAS = 20;
	private static HashMap<Integer, PosicionTablero> nroCasilla;

	public static final PosicionTablero CASILLA_SALIDA = new PosicionTablero(1);
	public static final PosicionTablero CASILLA_QUINI = new PosicionTablero(2);
	public static final PosicionTablero CASILLA_BUENOS_AIRES_SUR = new PosicionTablero(3);
	public static final PosicionTablero CASILLA_EDESUR = new PosicionTablero(4);
	public static final PosicionTablero CASILLA_BUENOS_AIRES_NORTE = new PosicionTablero(5);
	public static final PosicionTablero CASILLA_CARCEL = new PosicionTablero(6);
	public static final PosicionTablero CASILLA_CORDOBA_SUR = new PosicionTablero(7);
	public static final PosicionTablero CASILLA_AVANCE_DINAMICO = new PosicionTablero(8);
	public static final PosicionTablero CASILLA_SUBTE = new PosicionTablero(9);
	public static final PosicionTablero CASILLA_CORDOBA_NORTE = new PosicionTablero(10);
	public static final PosicionTablero CASILLA_IMPUESTO_DE_LUJO = new PosicionTablero(11);
	public static final PosicionTablero CASILLA_SANTA_FE = new PosicionTablero(12);
	public static final PosicionTablero CASILLA_AYSA = new PosicionTablero(13);
	public static final PosicionTablero CASILLA_SALTA_NORTE = new PosicionTablero(14);
	public static final PosicionTablero CASILLA_SALTA_SUR = new PosicionTablero(15);
	public static final PosicionTablero CASILLA_POLICIA = new PosicionTablero(16);
	public static final PosicionTablero CASILLA_TREN = new PosicionTablero(17);
	public static final PosicionTablero CASILLA_NEUQUEN = new PosicionTablero(18);
	public static final PosicionTablero CASILLA_RETROCESO_DINAMICO = new PosicionTablero(19);
	public static final PosicionTablero CASILLA_TUCUMAN = new PosicionTablero(20);
	
	private HashMap<PosicionTablero, Casilla> posicionCasilla;

	private void crearCasillas() {
		this.posicionCasilla.put(CASILLA_SALIDA, new Salida());
		this.posicionCasilla.put(CASILLA_QUINI, new Quini());
		this.posicionCasilla.put(CASILLA_BUENOS_AIRES_SUR, new BuenosAiresSurComprable());
		this.posicionCasilla.put(CASILLA_EDESUR, new EdesurComprable());
		this.posicionCasilla.put(CASILLA_BUENOS_AIRES_NORTE, new BuenosAiresNorteComprable());
		this.posicionCasilla.put(CASILLA_CARCEL, new Carcel());
		this.posicionCasilla.put(CASILLA_CORDOBA_SUR, new CordobaSurComprable());
		this.posicionCasilla.put(CASILLA_AVANCE_DINAMICO, new AvanceDinamico());
		this.posicionCasilla.put(CASILLA_SUBTE, new SubteComprable());
		this.posicionCasilla.put(CASILLA_CORDOBA_NORTE, new CordobaNorteComprable());
		this.posicionCasilla.put(CASILLA_IMPUESTO_DE_LUJO, new ImpuestoLujo());
		this.posicionCasilla.put(CASILLA_SANTA_FE, new SantaFeComprable());
		this.posicionCasilla.put(CASILLA_AYSA, new AysaComprable());
		this.posicionCasilla.put(CASILLA_SALTA_NORTE, new SaltaNorteComprable());
		this.posicionCasilla.put(CASILLA_SALTA_SUR, new SaltaSurComprable());
		this.posicionCasilla.put(CASILLA_POLICIA, new Policia());
		this.posicionCasilla.put(CASILLA_TREN, new TrenComprable());
		this.posicionCasilla.put(CASILLA_NEUQUEN, new NeuquenComprable());
		this.posicionCasilla.put(CASILLA_RETROCESO_DINAMICO, new RetrocesoDinamico());
		this.posicionCasilla.put(CASILLA_TUCUMAN, new TucumanComprable());
	}

	private Tablero() {
		posicionCasilla = new HashMap<PosicionTablero, Casilla>();

		this.crearCasillas();
	}

	public static Tablero getInstance() {
		if (elTablero == null) {
			nroCasilla = new HashMap<Integer, PosicionTablero>();
			nroCasilla.put(1, CASILLA_SALIDA);
			nroCasilla.put(2, CASILLA_QUINI);
			nroCasilla.put(3, CASILLA_BUENOS_AIRES_SUR);
			nroCasilla.put(4, CASILLA_EDESUR);
			nroCasilla.put(5, CASILLA_BUENOS_AIRES_NORTE);
			nroCasilla.put(6, CASILLA_CARCEL);
			nroCasilla.put(7, CASILLA_CORDOBA_SUR);
			nroCasilla.put(8, CASILLA_AVANCE_DINAMICO);
			nroCasilla.put(9, CASILLA_SUBTE);
			nroCasilla.put(10, CASILLA_CORDOBA_NORTE);
			nroCasilla.put(11, CASILLA_IMPUESTO_DE_LUJO);
			nroCasilla.put(12, CASILLA_SANTA_FE);
			nroCasilla.put(13, CASILLA_AYSA);
			nroCasilla.put(14, CASILLA_SALTA_NORTE);
			nroCasilla.put(15, CASILLA_SALTA_SUR);
			nroCasilla.put(16, CASILLA_POLICIA);
			nroCasilla.put(17, CASILLA_TREN);
			nroCasilla.put(18, CASILLA_NEUQUEN);
			nroCasilla.put(19, CASILLA_RETROCESO_DINAMICO);
			nroCasilla.put(20, CASILLA_TUCUMAN);

			elTablero = new Tablero();
		}
		return elTablero;
	}

	private static boolean estaEnRango(int unNroCasillero) {
		return ((0 < unNroCasillero) && (unNroCasillero <= CANTIDAD_CASILLAS));
	}

	public static PosicionTablero ajustarPosicionSegunBordes(PosicionTablero unaPosicion) {
		Integer nroCasilla = unaPosicion.getPosicion();

		while (!(estaEnRango(nroCasilla))) {
			if (nroCasilla > CANTIDAD_CASILLAS)
				nroCasilla -= CANTIDAD_CASILLAS;
			if (nroCasilla <= 0)
				nroCasilla += CANTIDAD_CASILLAS;
		}

		return Tablero.nroCasilla.get(nroCasilla);
	}

	public void desplazar(Jugador unJugador, PosicionTablero posCasilla) {
		unJugador.cambiarPosicion(posCasilla);

		this.elJugadorSeDesplazo(unJugador);
	}

	public PosicionTablero casillaDeJugador(Jugador unJugador) {
		return unJugador.obtenerPosicion();
	}

	public static void resetear() {
		elTablero = new Tablero();
	}

	public void elJugadorSeDesplazo(Jugador unJugador) {
		Casilla unaCasilla = posicionCasilla.get(unJugador.obtenerPosicion());

		unaCasilla.afectar(unJugador);
	}

	public static PosicionTablero obtenerPosicionInicial() {
		return CASILLA_SALIDA;
	}

	public void cambiarCasillaPor(PosicionTablero tagCasilla, Casilla nuevaCasilla) {
		this.posicionCasilla.put(tagCasilla, nuevaCasilla);
	}
	
	public Casilla obtenerCasilla(PosicionTablero tagCasilla){
		return this.posicionCasilla.get(tagCasilla);
	}
}
