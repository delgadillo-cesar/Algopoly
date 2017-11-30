package unitarios;

import org.junit.Assert;
import org.junit.Test;

import modelo.entidades.Jugador;
import modelo.entidades.JugadorDos;
import modelo.entidades.JugadorUno;
import modelo.tablero.casillas.poseibles.Edesur;
import modelo.tablero.casillas.poseibles.Compania;

public class CompaniaEdesurTest {

	@Test
	public void testCrearCompaniaYSeCrea() {
		Jugador jugador = new JugadorUno("Juan");
		Compania compania = new Edesur(jugador);
		Assert.assertNotNull(compania);
	}

	@Test
	public void testCrearCompaniaYSuPropietarioEsJugador() {
		Jugador jugador = new JugadorUno("Juan");
		Compania compania = new Edesur(jugador);
		Assert.assertEquals(jugador, compania.propietario());
	}

	@Test
	public void testCompaniaCobraAJugadorDosYCapitalDeJugadorPropietarioIncrementa() {
		Jugador jugadorUno = new JugadorUno("Juan");
		Jugador jugadorDos = new JugadorDos("Pepe");
		Compania compania = new Edesur(jugadorUno);
		int capitalInicial = jugadorUno.capital();
		compania.afectar(jugadorDos);
		Assert.assertTrue(capitalInicial < jugadorUno.capital());
	}

	@Test
	public void testCompaniaCobraAJugadorDosYCapitalDeJugadorDosDecrementa() {
		Jugador jugadorUno = new JugadorUno("Juan");
		Jugador jugadorDos = new JugadorDos("Pepe");
		Compania compania = new Edesur(jugadorUno);
		int capitalInicial = jugadorDos.capital();
		compania.afectar(jugadorDos);
		Assert.assertTrue(capitalInicial > jugadorDos.capital());
	}

	@Test
	public void testCompaniaCobraAJugadorDosYCapitalDeJugadorDosDecrementaYCapitalJugadorUnoDecrementaEnIgualCantidad() {
		Jugador jugadorUno = new JugadorUno("Juan");
		Jugador jugadorDos = new JugadorDos("Pepe");
		Compania compania = new Edesur(jugadorUno);
		int capitalInicial = jugadorUno.capital();
		compania.afectar(jugadorDos);
		Assert.assertEquals(capitalInicial - jugadorDos.capital(), jugadorUno.capital() - capitalInicial);
	}
}
