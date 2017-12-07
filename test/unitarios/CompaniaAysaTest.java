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

public class CompaniaAysaTest {

	@Test
	public void testCrearCompaniaYSeCrea() {
		Jugador jugador = new JugadorUno("Juan");
		Compania compania = new Aysa(jugador);
		Assert.assertNotNull(compania);
	}

	@Test
	public void testCrearCompaniaYSuPropietarioEsJugador() {
		Jugador jugador = new JugadorUno("Juan");
		Compania compania = new Aysa(jugador);
		Assert.assertEquals(jugador, compania.propietario());
	}

	@Test
	public void testCompaniaCobraAJugadorDosYCapitalDeJugadorPropietarioIncrementa300Veces() {
		Jugador jugadorUno = new JugadorUno("Juan");
		Jugador jugadorDos = new JugadorDos("Pepe");
		Compania compania = new Aysa(jugadorUno);
		int capitalInicial = jugadorUno.capital();
		Dados.getInstance().lanzarDados();
		int valorACobrar = 300 * Dados.getInstance().getValor();
		compania.afectar(jugadorDos);
		Assert.assertEquals(capitalInicial + valorACobrar, jugadorUno.capital());
	}

	@Test
	public void testJugadorTieneAysaYEdesurYSuCapitalIncrementa500Veces() {
		Jugador jugadorUno = new JugadorUno("Juan");
		Jugador jugadorDos = new JugadorDos("Pepe");
		Compania companiaUno = new Aysa(jugadorUno);
		Compania companiaDos = new Edesur(jugadorUno);
		int capitalInicial = jugadorUno.capital();
		Dados.getInstance().lanzarDados();
		int valorACobrar = 500 * Dados.getInstance().getValor();
		companiaUno.afectar(jugadorDos);
		Assert.assertEquals(capitalInicial + valorACobrar, jugadorUno.capital());
	}

	@Test
	public void testJugadorTieneTodasLasCompaniasSalvoEdesurYSuCapitalIncrementa300Veces() {
		Jugador jugadorUno = new JugadorUno("Juan");
		Jugador jugadorDos = new JugadorDos("Pepe");
		Compania companiaAysa = new Aysa(jugadorUno);
		Compania companiaTren = new Tren(jugadorUno);
		Compania companiaSubte = new Subte(jugadorUno);
		int capitalInicial = jugadorUno.capital();
		Dados.getInstance().lanzarDados();
		int valorACobrar = 300 * Dados.getInstance().getValor();
		companiaAysa.afectar(jugadorDos);
		Assert.assertEquals(capitalInicial + valorACobrar, jugadorUno.capital());
	}

	@Test
	public void testJugadorTieneTodasLasCompaniasYVerificaBonusAlCobrar() {
		Jugador jugador = new JugadorUno("Juan");
		Compania companiaAysa = new Aysa(jugador);
		Compania companiaEdesur = new Edesur(jugador);
		Compania companiaTren = new Tren(jugador);
		Compania companiaSubte = new Subte(jugador);
		Assert.assertEquals(0, companiaAysa.cobrarConAysa());
		Assert.assertEquals(0, companiaAysa.cobrarCon(companiaAysa));
		Assert.assertEquals(500, companiaAysa.cobrarConEdesur());
		Assert.assertEquals(200, companiaAysa.cobrarCon(companiaEdesur));
		Assert.assertEquals(0, companiaAysa.cobrarConTren());
		Assert.assertEquals(0, companiaAysa.cobrarCon(companiaTren));
		Assert.assertEquals(0, companiaAysa.cobrarConSubte());
		Assert.assertEquals(0, companiaAysa.cobrarCon(companiaSubte));
	}

	@Test
	public void testCompaniaCobraAJugadorDosYCapitalDeJugadorDosDecrementa() {
		Jugador jugadorUno = new JugadorUno("Juan");
		Jugador jugadorDos = new JugadorDos("Pepe");
		Compania compania = new Aysa(jugadorUno);
		int capitalInicial = jugadorDos.capital();
		compania.afectar(jugadorDos);
		Assert.assertTrue(capitalInicial > jugadorDos.capital());
	}

	@Test
	public void testCompaniaCobraAJugadorDosYCapitalDeJugadorDosDecrementaYCapitalJugadorUnoDecrementaEnIgualCantidad() {
		Jugador jugadorUno = new JugadorUno("Juan");
		Jugador jugadorDos = new JugadorDos("Pepe");
		Compania compania = new Aysa(jugadorUno);
		int capitalInicial = jugadorUno.capital();
		compania.afectar(jugadorDos);
		Assert.assertEquals(capitalInicial - jugadorDos.capital(), jugadorUno.capital() - capitalInicial);
	}
}
