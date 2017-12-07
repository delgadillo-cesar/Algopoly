package unitarios;

import org.junit.Assert;
import org.junit.Test;

import modelo.entidades.Jugador;
import modelo.entidades.JugadorDos;
import modelo.entidades.JugadorUno;
import modelo.juego.Dados;
import modelo.tablero.Casilla;
import modelo.tablero.PosicionTablero;
import modelo.tablero.Tablero;
import modelo.tablero.comprables.AysaComprable;
import modelo.tablero.comprables.EdesurComprable;
import modelo.tablero.poseibles.compania.Aysa;
import modelo.tablero.poseibles.compania.Compania;
import modelo.tablero.poseibles.compania.Edesur;
import modelo.tablero.poseibles.compania.Subte;
import modelo.tablero.poseibles.compania.Tren;

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
	public void testCompaniaCobraAJugadorDosYCapitalDeJugadorPropietarioIncrementa500Veces() {
		Jugador jugadorUno = new JugadorUno("Juan");
		Jugador jugadorDos = new JugadorDos("Pepe");
		Compania compania = new Edesur(jugadorUno);
		int capitalInicial = jugadorUno.capital();
		Dados.getInstance().lanzarDados();
		int valorACobrar = 500 * Dados.getInstance().getValor();
		compania.afectar(jugadorDos);
		Assert.assertEquals(capitalInicial + valorACobrar, jugadorUno.capital());
	}

	@Test
	public void testJugadorTieneAysaYEdesurYSuCapitalIncrementa1000Veces() {
		Jugador jugadorUno = new JugadorUno("Juan");
		Jugador jugadorDos = new JugadorDos("Pepe");
		AysaComprable companiaUno = new AysaComprable();
		EdesurComprable companiaDos = new EdesurComprable();
		jugadorUno.comprarPropiedad(companiaUno);
		jugadorUno.comprarPropiedad(companiaDos);		
		int capitalInicial = jugadorUno.capital();
		Dados.getInstance().lanzarDados();
		int valorACobrar = 1000 * Dados.getInstance().getValor();
		Casilla edesur = Tablero.getInstance().obtenerCasilla(new PosicionTablero(4));
		edesur.afectar(jugadorDos);
		Assert.assertEquals(capitalInicial + valorACobrar, jugadorUno.capital());
	}

	@Test
	public void testJugadorCaeEnEdesurConAysaYSuCapitalDecrementa1000Veces() {
		Jugador jugadorUno = new JugadorUno("Juan");
		Jugador jugadorDos = new JugadorDos("Pepe");
		AysaComprable companiaUno = new AysaComprable();
		EdesurComprable companiaDos = new EdesurComprable();
		jugadorUno.comprarPropiedad(companiaUno);
		jugadorUno.comprarPropiedad(companiaDos);		
		int capitalInicial = jugadorDos.capital();
		Dados.getInstance().lanzarDados();
		int valorACobrar = 1000 * Dados.getInstance().getValor();
		Casilla edesur = Tablero.getInstance().obtenerCasilla(new PosicionTablero(4));
		edesur.afectar(jugadorDos);
		Assert.assertEquals(capitalInicial - valorACobrar, jugadorDos.capital());
	}

	@Test
	public void testJugadorTieneTodasLasCompaniasSalvoAysaYSuCapitalIncrementa500Veces() {
		Jugador jugadorUno = new JugadorUno("Juan");
		Jugador jugadorDos = new JugadorDos("Pepe");
		Compania companiaEdesur = new Edesur(jugadorUno);
		Compania companiaTren = new Tren(jugadorUno);
		Compania companiaSubte = new Subte(jugadorUno);
		int capitalInicial = jugadorUno.capital();
		Dados.getInstance().lanzarDados();
		int valorACobrar = 500 * Dados.getInstance().getValor();
		companiaEdesur.afectar(jugadorDos);
		Assert.assertEquals(capitalInicial + valorACobrar, jugadorUno.capital());
	}

	@Test
	public void testJugadorTieneTodasLasCompaniasYVerificaBonusAlCobrar() {
		Jugador jugador = new JugadorUno("Juan");
		Compania companiaAysa = new Aysa(jugador);
		Compania companiaEdesur = new Edesur(jugador);
		Compania companiaTren = new Tren(jugador);
		Compania companiaSubte = new Subte(jugador);
		Assert.assertEquals(0, companiaEdesur.cobrarConEdesur());
		Assert.assertEquals(0, companiaEdesur.cobrarCon(companiaEdesur));
		Assert.assertEquals(200, companiaEdesur.cobrarConAysa());
		Assert.assertEquals(500, companiaEdesur.cobrarCon(companiaAysa));
		Assert.assertEquals(0, companiaEdesur.cobrarConTren());
		Assert.assertEquals(0, companiaEdesur.cobrarCon(companiaTren));
		Assert.assertEquals(0, companiaEdesur.cobrarConSubte());
		Assert.assertEquals(0, companiaEdesur.cobrarCon(companiaSubte));
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
