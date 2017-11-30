package unitarios;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import modelo.entidades.Jugador;
import modelo.entidades.JugadorUno;
import modelo.tablero.Tablero;

public class TableroTest {

	@Before
	public void setUp() throws Exception {
		Tablero.resetear();
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
		tablero.desplazar(jugador, "SALIDA");

		tablero.desplazar(jugador, 1);

		int casillaActual = tablero.casillaDeJugador(jugador);
		Assert.assertEquals(casillaActual, 2);

	}

	@Test
	public void testDesplazarJugadorveintiunCasillasHaciaAdelanteLoDesplazaCorrectamente() {

		Tablero tablero = Tablero.getInstance();
		Jugador jugador = new JugadorUno("Pepe");
		tablero.desplazar(jugador, "SALIDA");

		tablero.desplazar(jugador, 21);

		int casillaActual = tablero.casillaDeJugador(jugador);
		Assert.assertEquals(casillaActual, 2);

	}

	@Test
	public void testDesplazarJugadorUnaCasillaHaciaAtrasLoDesplazaCorrectamente() {

		Tablero tablero = Tablero.getInstance();
		Jugador jugador = new JugadorUno("Pepe");
		tablero.desplazar(jugador, "SALIDA");

		tablero.desplazar(jugador, -1);

		int casillaActual = tablero.casillaDeJugador(jugador);
		Assert.assertEquals(casillaActual, 20);

	}

	@Test
	public void testDesplazarJugadorVeintiunCasillaHaciaAtrasLoDesplazaCorrectamente() {

		Tablero tablero = Tablero.getInstance();
		Jugador jugador = new JugadorUno("Pepe");
		tablero.desplazar(jugador, "SALIDA");

		tablero.desplazar(jugador, -21);

		int casillaActual = tablero.casillaDeJugador(jugador);
		Assert.assertEquals(casillaActual, 20);

	}

	@Test
	public void testDesplazarJugadorUnaPosicionHaciaAdelanteRemueveAlJugadorDeLaCasillaAnterior() {

		Tablero tablero = Tablero.getInstance();
		Jugador jugador = new JugadorUno("Pepe");
		tablero.desplazar(jugador, "SALIDA");

		tablero.desplazar(jugador, 1);

		Assert.assertTrue(tablero.casillaEstaVacia(1));

	}

	@Test
	public void testDesplazarJugadorUnaPosicionHaciAtrasRemueveAlJugadorDeLaCasillaAnterior() {

		Tablero tablero = Tablero.getInstance();
		Jugador jugador = new JugadorUno("Pepe");
		tablero.desplazar(jugador, "SALIDA");

		tablero.desplazar(jugador, -1);

		Assert.assertTrue(tablero.casillaEstaVacia(1));

	}

	@Test
	public void testMovimientoDesdeSalidaHastaBsAsZonaNorteDesplazaCorrectamenteAUnJugadorPorElTablero() {

		Tablero tablero = Tablero.getInstance();
		Jugador jugador = new JugadorUno("Pepe");
		tablero.desplazar(jugador, "SALIDA");

		for (int i = 1; i <= 4; i++) {
			tablero.desplazar(jugador, 1);
		}

		for (int i = 1; i <= 4; i++) {
			Assert.assertTrue(tablero.casillaEstaVacia(i));
		}

	}

	@Test
	public void testMovimientoDesdeSubteHastaSaltaSurDesplazaCorrectamenteAUnJugadorPorElTablero() {

		Tablero tablero = Tablero.getInstance();
		Jugador jugador = new JugadorUno("Pepe");
		tablero.desplazar(jugador, "SUBTE");
		jugador.cobrar(2000000); /* Se agrega capital para que tenga suficiente para la prueba */

		for (int i = 1; i <= 6; i++) {
			tablero.desplazar(jugador, 1);
		}

		for (int i = 9; i <= 14; i++) {
			Assert.assertTrue(tablero.casillaEstaVacia(i));
		}

	}
}
