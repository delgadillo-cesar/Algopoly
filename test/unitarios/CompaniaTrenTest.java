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

public class CompaniaTrenTest {

	@Test
	public void testCrearCompaniaYSeCrea() {
		Jugador jugador = new JugadorUno("Juan");
		Compania compania = new Tren(jugador);
		Assert.assertNotNull(compania);
	}

	@Test
	public void testCrearCompaniaYSuPropietarioEsJugador() {
		Jugador jugador = new JugadorUno("Juan");
		Compania compania = new Tren(jugador);
		Assert.assertEquals(jugador, compania.propietario());
	}

	@Test
	public void testCompaniaCobraAJugadorDosYCapitalDeJugadorPropietarioIncrementa450Veces() {
		Jugador jugadorUno = new JugadorUno("Juan");
		Jugador jugadorDos = new JugadorDos("Pepe");
		Compania compania = new Tren(jugadorUno);
		int capitalInicial = jugadorUno.capital();
		Dados.getInstance().lanzarDados();
		int valorACobrar = 450 * Dados.getInstance().getValor();
		compania.afectar(jugadorDos);
		Assert.assertEquals(capitalInicial + valorACobrar, jugadorUno.capital());
	}

	@Test
	public void testJugadorTieneTrenYSubteYSuCapitalIncrementa800Veces() {
		Jugador jugadorUno = new JugadorUno("Juan");
		Jugador jugadorDos = new JugadorDos("Pepe");
		Compania companiaUno = new Tren(jugadorUno);
		Compania companiaDos = new Subte(jugadorUno);
		int capitalInicial = jugadorUno.capital();
		Dados.getInstance().lanzarDados();
		int valorACobrar = 800 * Dados.getInstance().getValor();
		companiaUno.afectar(jugadorDos);
		Assert.assertEquals(capitalInicial + valorACobrar, jugadorUno.capital());
	}

	@Test
	public void testJugadorTieneTodasLasCompaniasSalvoSubteYSuCapitalIncrementa450Veces() {
		Jugador jugadorUno = new JugadorUno("Juan");
		Jugador jugadorDos = new JugadorDos("Pepe");
		Compania companiaAysa = new Aysa(jugadorUno);
		Compania companiaTren = new Tren(jugadorUno);
		Compania companiaEdesur = new Edesur(jugadorUno);
		int capitalInicial = jugadorUno.capital();
		Dados.getInstance().lanzarDados();
		int valorACobrar = 450 * Dados.getInstance().getValor();
		companiaTren.afectar(jugadorDos);
		Assert.assertEquals(capitalInicial + valorACobrar, jugadorUno.capital());
	}

	@Test
	public void testJugadorTieneTodasLasCompaniasYVerificaBonusAlCobrar() {
		Jugador jugador = new JugadorUno("Juan");
		Compania companiaAysa = new Aysa(jugador);
		Compania companiaEdesur = new Edesur(jugador);
		Compania companiaTren = new Tren(jugador);
		Compania companiaSubte = new Subte(jugador);
		Assert.assertEquals(0, companiaTren.cobrarConAysa());
		Assert.assertEquals(0, companiaTren.cobrarCon(companiaAysa));
		Assert.assertEquals(0, companiaTren.cobrarConEdesur());
		Assert.assertEquals(0, companiaTren.cobrarCon(companiaEdesur));
		Assert.assertEquals(0, companiaTren.cobrarConTren());
		Assert.assertEquals(0, companiaTren.cobrarCon(companiaTren));
		Assert.assertEquals(500, companiaTren.cobrarConSubte());
		Assert.assertEquals(350, companiaTren.cobrarCon(companiaSubte));
	}

	@Test
	public void testCompaniaCobraAJugadorDosYCapitalDeJugadorDosDecrementa() {
		Jugador jugadorUno = new JugadorUno("Juan");
		Jugador jugadorDos = new JugadorDos("Pepe");
		Compania compania = new Tren(jugadorUno);
		int capitalInicial = jugadorDos.capital();
		compania.afectar(jugadorDos);
		Assert.assertTrue(capitalInicial > jugadorDos.capital());
	}

	@Test
	public void testCompaniaCobraAJugadorDosYCapitalDeJugadorDosDecrementaYCapitalJugadorUnoDecrementaEnIgualCantidad() {
		Jugador jugadorUno = new JugadorUno("Juan");
		Jugador jugadorDos = new JugadorDos("Pepe");
		Compania compania = new Tren(jugadorUno);
		int capitalInicial = jugadorUno.capital();
		compania.afectar(jugadorDos);
		Assert.assertEquals(capitalInicial - jugadorDos.capital(), jugadorUno.capital() - capitalInicial);
	}
}
