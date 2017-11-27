package unitarios;

import org.junit.Assert;
import org.junit.Test;

import poseibles.Aysa;
import poseibles.Edesur;
import poseibles.Subte;

import acciones.Carcel;
import entidades.Jugador;
import entidades.JugadorSinSaldoException;
import tablero.Comprable;
import tablero.Tablero;



public class JugadorTest {

	@Test
	public void testCrearJugadorConNombreValidoNoDevuelveNull() {
		Jugador jugador = new Jugador("Mario");
		Assert.assertNotNull(jugador);
	}
	
	@Test
	public void testObtenerElNombreDeUnJugador() {
		Jugador jugador = new Jugador("Mario");
		Assert.assertEquals("Mario", jugador.nombreJugador());
	}
	
	@Test
	public void testJugadorNuevoTieneCienMilPesosDeCapital() {
		Jugador jugador = new Jugador("Juan");
		Assert.assertEquals(100000, jugador.capital());
	}

	@Test
	public void testJugadorPagarDelvuelveElMontoPagado() {
		Jugador jugador = new Jugador("Juan");
		int unMonto = 20000;
		
		Assert.assertEquals(unMonto, jugador.pagar(20000));
	}

	@Test
	public void testJugadorPagaUnMontoSuCapitalDisminuyeEsaCantidad() {
		Jugador jugador = new Jugador("Juan");
		Assert.assertEquals(100000, jugador.capital());
		
		jugador.pagar(20000);
		Assert.assertEquals(80000, jugador.capital());
	}
	
	@Test(expected=JugadorSinSaldoException.class)
	public void testJugadorPagaUnMontoMayorQueSuCapitalDaError() {
		Jugador jugador = new Jugador("Juan");
		Assert.assertEquals(100000, jugador.capital());
		
		jugador.pagar(100001);
	}
	
	@Test
	public void testJugadorCobraUnMontoSuCapitalAumentaEsaCantidad() {
		Jugador jugador = new Jugador("Juan");
		Assert.assertEquals(100000, jugador.capital());
		
		jugador.cobrar(20000);
		Assert.assertEquals(120000, jugador.capital());
	}
	
	@Test
	public void testJugadorCompraUnaPropiedadObtieneLaPropiedadYSuCapitalDisminuyeAlPagarElCostoDeCompra() {
		Comprable unComprable = new Aysa();
		Jugador unJugador = new Jugador("Jugador de prueba");
		int capitalInicialJugador, costoPropiedad;
		
		Assert.assertFalse(unJugador.esDuenoDe("AYSA"));

		capitalInicialJugador = unJugador.capital();
		costoPropiedad = unComprable.precioDeCompra();		
		unJugador.comprarPropiedad(unComprable);
		
		Assert.assertTrue(unJugador.esDuenoDe("AYSA"));
		Assert.assertEquals(costoPropiedad, (capitalInicialJugador - unJugador.capital()));
	}
	
	@Test(expected=JugadorSinSaldoException.class)
	public void testJugadorIntentaCompraUnaPropiedadPeroNoLeAlcanzaElCapitalDaError() {
		Comprable unComprable = new Aysa();
		Jugador unJugador = new Jugador("Jugador de prueba");
		
		Assert.assertFalse(unJugador.esDuenoDe("AYSA"));

		unJugador.pagar(unJugador.capital() - 1);
		unComprable.comprar(unJugador);
	}

	@Test
	public void testJugadorCantidadDePropiedadesQuePosee() {
		Comprable unComprable;
		Jugador unJugador = new Jugador("Jugador de prueba");
		
		Assert.assertEquals(0, unJugador.cantidadPoseciones());

		unJugador.cobrar(1000000);
		unComprable = new Aysa();
		
		unJugador.comprarPropiedad(unComprable);
		Assert.assertEquals(1, unJugador.cantidadPoseciones());

		unComprable = new Edesur();
		unJugador.comprarPropiedad(unComprable);
		unComprable = new Subte();
		unJugador.comprarPropiedad(unComprable);
		Assert.assertEquals(3, unJugador.cantidadPoseciones());
	}

	@Test
	public void testJugadorBuscaSiTieneUnPropiedadEspecifica() {
		Comprable unComprable;
		Jugador unJugador = new Jugador("Jugador de prueba");
		
		Assert.assertFalse(unJugador.esDuenoDe("AYSA"));

		unJugador.cobrar(1000000);
		unComprable = new Aysa();
		
		unJugador.comprarPropiedad(unComprable);
		Assert.assertTrue(unJugador.esDuenoDe("AYSA"));

		unComprable = new Edesur();
		unJugador.comprarPropiedad(unComprable);
		unComprable = new Subte();
		unJugador.comprarPropiedad(unComprable);
		Assert.assertTrue(unJugador.esDuenoDe("SUBTE"));
		Assert.assertTrue(unJugador.esDuenoDe("EDESUR"));
	}

	@Test
	public void testJugadorMoverSeMueveUnaCantidadDeCasilleros() {
		Jugador unJugador = new Jugador("Jugador de Prueba");
		int casillaInicial, casillaFinal;
		
		casillaInicial = Tablero.getInstance().casillaDeJugador(unJugador);
		unJugador.mover(10);
		casillaFinal = Tablero.getInstance().casillaDeJugador(unJugador);
		
		Assert.assertEquals((casillaInicial + 10), casillaFinal);
	}
	
	@Test
	public void testJugadorPricioneroMoverNoSeMueve() {
		Jugador unJugador = new Jugador("Jugador de Prueba");
		Carcel laCarcel = new Carcel();
		int casillaInicial, casillaFinal;

		laCarcel.afectar(unJugador);

		casillaInicial = Tablero.getInstance().casillaDeJugador(unJugador);
		unJugador.mover(10);
		casillaFinal = Tablero.getInstance().casillaDeJugador(unJugador);
		
		Assert.assertEquals(casillaInicial, casillaFinal);
	}	
	
}