package unitarios;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import modelo.entidades.Jugador;
import modelo.entidades.JugadorUno;
import modelo.tablero.PosicionTablero;
import modelo.tablero.Tablero;

public class TableroTest {

	@Before
	public void setUp() throws Exception {
		//Tablero.resetear();
	}

	@Test
	public void testObtenerTableroNoDevuelveNull() {

		Tablero tablero = Tablero.getInstance();

		Assert.assertNotNull(tablero);
	}

	@Test
	public void testDesplazarJugadorUnaCasillaHaciaAdelanteLoDesplazaCorrectamente() {

		Tablero tablero = Tablero.getInstance();
		Jugador jugador = new JugadorUno("Pepe");
		tablero.desplazar(jugador, new PosicionTablero(1));

		jugador.mover(1);

		PosicionTablero casillaActual = tablero.casillaDeJugador(jugador);
		Assert.assertEquals(casillaActual, new PosicionTablero(2));

	}

	@Test
	public void testDesplazarJugadorveintiunCasillasHaciaAdelanteLoDesplazaCorrectamente() {

		Tablero tablero = Tablero.getInstance();
		Jugador jugador = new JugadorUno("Pepe");
		tablero.desplazar(jugador, new PosicionTablero(1));

		jugador.mover(21);

		PosicionTablero casillaActual = tablero.casillaDeJugador(jugador);
		Assert.assertEquals(casillaActual,  new PosicionTablero(2));

	}

	@Test
	public void testDesplazarJugadorUnaCasillaHaciaAtrasLoDesplazaCorrectamente() {

		Tablero tablero = Tablero.getInstance();
		Jugador jugador = new JugadorUno("Pepe");
		tablero.desplazar(jugador, new PosicionTablero(1));

		jugador.mover(-1);

		PosicionTablero casillaActual = tablero.casillaDeJugador(jugador);
		Assert.assertEquals(casillaActual,  new PosicionTablero(20));

	}

	@Test
	public void testDesplazarJugadorVeintiunCasillaHaciaAtrasLoDesplazaCorrectamente() {

		Tablero tablero = Tablero.getInstance();
		Jugador jugador = new JugadorUno("Pepe");
		tablero.desplazar(jugador, new PosicionTablero(1));

		jugador.mover(-21);

		PosicionTablero casillaActual = tablero.casillaDeJugador(jugador);
		Assert.assertEquals(casillaActual,  new PosicionTablero(20));

	}

	@Test
	public void testDesplazarJugadorUnaPosicionHaciaAdelanteRemueveAlJugadorDeLaCasillaAnterior() {

		Tablero tablero = Tablero.getInstance();
		Jugador jugador = new JugadorUno("Pepe");
		tablero.desplazar(jugador, new PosicionTablero(1));

		jugador.mover(1);

		Assert.assertTrue(jugador.obtenerPosicion().getPosicion() != 1);

	}

	@Test
	public void testDesplazarJugadorUnaPosicionHaciAtrasRemueveAlJugadorDeLaCasillaAnterior() {

		Tablero tablero = Tablero.getInstance();
		Jugador jugador = new JugadorUno("Pepe");
		tablero.desplazar(jugador, new PosicionTablero(1));

		jugador.mover(-1);

		Assert.assertTrue(jugador.obtenerPosicion().getPosicion() != 1);

	}

	@Test
	public void testMovimientoDesdeSalidaHastaBsAsZonaNorteDesplazaCorrectamenteAUnJugadorPorElTablero() {

		Tablero tablero = Tablero.getInstance();
		Jugador jugador = new JugadorUno("Pepe");
		tablero.desplazar(jugador, new PosicionTablero(1));

		jugador.mover(4);

		Assert.assertTrue(jugador.obtenerPosicion().getPosicion() == 5);

	}

	@Test
	public void testMovimientoDesdeSubteHastaSaltaSurDesplazaCorrectamenteAUnJugadorPorElTablero() {

		Tablero tablero = Tablero.getInstance();
		Jugador jugador = new JugadorUno("Pepe");
		tablero.desplazar(jugador, new PosicionTablero(9));

		jugador.cobrar(2000000); /* Se agrega capital para que tenga suficiente para la prueba */

		for (int i = 1; i <= 6; i++) {
			jugador.mover(1);
		}

		Assert.assertTrue(jugador.obtenerPosicion().getPosicion() == 15);
	}
}
