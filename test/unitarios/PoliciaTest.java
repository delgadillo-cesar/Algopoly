package unitarios;

import org.junit.Assert;
import org.junit.Test;

import modelo.entidades.Jugador;
import modelo.entidades.JugadorDos;
import modelo.entidades.JugadorUno;
import modelo.tablero.Casilla;
import modelo.tablero.Tablero;
import modelo.tablero.acciones.Policia;

public class PoliciaTest {

	/***********************************************/

	@Test
	public void test01UnJugadorVaALaCarcelYSuPosicionCambia() {

		Jugador jugadorPrueba = new JugadorUno("Jugador de prueba");
		Jugador jugadorReferencia = new JugadorDos("Jugador de referencia");
		Casilla policia = new Policia();
		policia.afectar(jugadorPrueba);
		Assert.assertNotEquals(jugadorReferencia.obtenerPosicion().getPosicion(),
				jugadorPrueba.obtenerPosicion().getPosicion());

	}

	@Test
	public void test02UnJugadorVaALaCarcelYSuPosicionEsLaCasillaDeCarcel() {

		Jugador jugadorPrueba = new JugadorUno("Jugador de prueba");
		Casilla policia = new Policia();
		policia.afectar(jugadorPrueba);
		Assert.assertEquals(Tablero.CASILLA_CARCEL, Integer.valueOf(jugadorPrueba.obtenerPosicion().getPosicion()));

	}

	/***********************************************/

}
