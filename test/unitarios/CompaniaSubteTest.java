package unitarios;

import org.junit.Assert;
import org.junit.Test;

import modelo.entidades.Jugador;
import modelo.entidades.JugadorDos;
import modelo.entidades.JugadorUno;
import modelo.juego.Dados;
import modelo.tablero.poseibles.compania.Aysa;
import modelo.tablero.poseibles.compania.Compania;
import modelo.tablero.poseibles.compania.Edesur;
import modelo.tablero.poseibles.compania.Subte;
import modelo.tablero.poseibles.compania.Tren;

public class CompaniaSubteTest {

	@Test
	public void testCrearCompaniaYSeCrea() {
		Jugador jugador = new JugadorUno("Juan");
		Compania compania = new Subte(jugador);
		Assert.assertNotNull(compania);
	}

	@Test
	public void testCrearCompaniaYSuPropietarioEsJugador() {
		Jugador jugador = new JugadorUno("Juan");
		Compania compania = new Subte(jugador);
		Assert.assertEquals(jugador, compania.propietario());
	}

	@Test
	public void testCompaniaCobraAJugadorDosYCapitalDeJugadorPropietarioIncrementa600Veces() {
		Jugador jugadorUno = new JugadorUno("Juan");
		Jugador jugadorDos = new JugadorDos("Pepe");
		Compania compania = new Subte(jugadorUno);
		int capitalInicial = jugadorUno.capital();
		Dados.getInstance().lanzarDados();
		int valorACobrar = 600 * Dados.getInstance().getValor();
		compania.afectar(jugadorDos);
		Assert.assertEquals(capitalInicial + valorACobrar, jugadorUno.capital());
	}

	@Test
	public void testJugadorTieneSubteYTrenYSuCapitalIncrementa1100Veces() {
		Jugador jugadorUno = new JugadorUno("Juan");
		Jugador jugadorDos = new JugadorDos("Pepe");
		Compania companiaUno = new Subte(jugadorUno);
		Compania companiaDos = new Tren(jugadorUno);
		int capitalInicial = jugadorUno.capital();
		Dados.getInstance().lanzarDados();
		int valorACobrar = 1100 * Dados.getInstance().getValor();
		companiaUno.afectar(jugadorDos);
		Assert.assertEquals(capitalInicial + valorACobrar, jugadorUno.capital());
	}

	@Test
	public void testJugadorTieneTodasLasCompaniasSalvoTrenYSuCapitalIncrementa600Veces() {
		Jugador jugadorUno = new JugadorUno("Juan");
		Jugador jugadorDos = new JugadorDos("Pepe");
		Compania companiaAysa = new Aysa(jugadorUno);
		Compania companiaTren = new Edesur(jugadorUno);
		Compania companiaSubte = new Subte(jugadorUno);
		int capitalInicial = jugadorUno.capital();
		Dados.getInstance().lanzarDados();
		int valorACobrar = 600 * Dados.getInstance().getValor();
		companiaSubte.afectar(jugadorDos);
		Assert.assertEquals(capitalInicial + valorACobrar, jugadorUno.capital());
	}

	@Test
	public void testJugadorTieneTodasLasCompaniasYVerificaBonusAlCobrar() {
		Jugador jugador = new JugadorUno("Juan");
		Compania companiaAysa = new Aysa(jugador);
		Compania companiaEdesur = new Edesur(jugador);
		Compania companiaTren = new Tren(jugador);
		Compania companiaSubte = new Subte(jugador);
		Assert.assertEquals(0, companiaSubte.cobrarConAysa());
		Assert.assertEquals(0, companiaSubte.cobrarCon(companiaAysa));
		Assert.assertEquals(0, companiaSubte.cobrarConEdesur());
		Assert.assertEquals(0, companiaSubte.cobrarCon(companiaEdesur));
		Assert.assertEquals(350, companiaSubte.cobrarConTren());
		Assert.assertEquals(500, companiaSubte.cobrarCon(companiaTren));
		Assert.assertEquals(0, companiaSubte.cobrarConSubte());
		Assert.assertEquals(0, companiaSubte.cobrarCon(companiaSubte));
	}

	@Test
	public void testCompaniaCobraAJugadorDosYCapitalDeJugadorDosDecrementa() {
		Jugador jugadorUno = new JugadorUno("Juan");
		Jugador jugadorDos = new JugadorDos("Pepe");
		Compania compania = new Subte(jugadorUno);
		int capitalInicial = jugadorDos.capital();
		compania.afectar(jugadorDos);
		Assert.assertTrue(capitalInicial > jugadorDos.capital());
	}

	@Test
	public void testCompaniaCobraAJugadorDosYCapitalDeJugadorDosDecrementaYCapitalJugadorUnoDecrementaEnIgualCantidad() {
		Jugador jugadorUno = new JugadorUno("Juan");
		Jugador jugadorDos = new JugadorDos("Pepe");
		Compania compania = new Subte(jugadorUno);
		int capitalInicial = jugadorUno.capital();
		compania.afectar(jugadorDos);
		Assert.assertEquals(capitalInicial - jugadorDos.capital(), jugadorUno.capital() - capitalInicial);
	}
}
