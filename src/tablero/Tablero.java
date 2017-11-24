package tablero;

import java.util.HashMap;
import java.util.Map;

import entidades.Jugador;
import juego.Dados;

public class Tablero {

	private static Tablero elTablero;
	private static final Integer CANTIDAD_CASILLAS = 20;
	private static final Integer CASILLA_INICIAL = 1;
	private HashMap<String, Casilla> casillas;
	private HashMap<Integer, Casilla> posicoinCasilla;
	
	private void crearCasillas(){
		FactoryCasillas fabricaCasillas = new FactoryAcciones();
		casillas.putAll(fabricaCasillas.crearCasillas());

		fabricaCasillas = new FactoryCompanias();
		casillas.putAll(fabricaCasillas.crearCasillas());

		fabricaCasillas = new FactoryBarriosSimples();
		casillas.putAll(fabricaCasillas.crearCasillas());

		fabricaCasillas = new FactoryBarriosDobles();
		casillas.putAll(fabricaCasillas.crearCasillas());
	}
	
	public void armarTablero(){
		this.crearCasillas();
		
		posicoinCasilla.put(1, casillas.get("SALIDA"));
		posicoinCasilla.put(2, casillas.get("QUINI"));
		posicoinCasilla.put(3, casillas.get("BUENOS_AIRES_SUR"));
		posicoinCasilla.put(4, casillas.get("EDESUR"));
		posicoinCasilla.put(5, casillas.get("BUENOS_AIRES_NORTE"));
		posicoinCasilla.put(6, casillas.get("CARCEL"));
		posicoinCasilla.put(7, casillas.get("CORDOBA_SUR"));
		posicoinCasilla.put(8, casillas.get("AVANCE_DINAMICO"));
		posicoinCasilla.put(9, casillas.get("SUBTE"));
		posicoinCasilla.put(10, casillas.get("CORDOBA_NORTE"));
		posicoinCasilla.put(11, casillas.get("IMPUESTO_LUJO"));
		posicoinCasilla.put(12, casillas.get("SANTA_FE"));
		posicoinCasilla.put(13, casillas.get("AYSA"));
		posicoinCasilla.put(14, casillas.get("SALTA_NORTE"));
		posicoinCasilla.put(15, casillas.get("SALTA_SUR"));
		posicoinCasilla.put(16, casillas.get("POLICIA"));
		posicoinCasilla.put(17, casillas.get("TRENES"));
		posicoinCasilla.put(18, casillas.get("NEUQUEN"));
		posicoinCasilla.put(19, casillas.get("RETROCESO_DINAMICO"));
		posicoinCasilla.put(20, casillas.get("TUCUMAN"));		
	}
	
	
	private Tablero(){
		casillas = new HashMap<String, Casilla>();
		posicoinCasilla = new HashMap<Integer, Casilla>();
		
		for(int i=0; i<CANTIDAD_CASILLAS; i++){
			posicoinCasilla.put(i, new CasillaVacia());
		}
		
//		this.crearCasillas();
//		this.armarTablero();
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

	public void desplazar(Jugador unJugador, String unaDescrripcionCasilla) {
		Casilla nuevaCasilla = casillas.get(unaDescrripcionCasilla);
		
		for (Map.Entry<Integer, Casilla>entry: this.posicoinCasilla.entrySet()){
			if(entry.getValue() == nuevaCasilla){
				PosicionTablero unaPosicion = new PosicionTablero();
				unaPosicion.setPosicion(entry.getKey());
				unJugador.cambiarPosicion(unaPosicion);
			}
		}
		
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
}
