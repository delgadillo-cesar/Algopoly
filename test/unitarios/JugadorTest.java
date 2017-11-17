package unitarios;

import org.junit.Assert;
import org.junit.Test;

import acciones.Carcel;
import entidades.Jugador;
import entidades.JugadorSinSaldoException;
import juego.Dados;
import propiedades.Aysa;
import propiedades.Edesur;
import propiedades.Propiedad;
import propiedades.Subte;
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
		Propiedad unaPropiedad = new Aysa();
		Jugador unJugador = new Jugador("Jugador de prueba");
		int capitalInicialJugador, costoPropiedad;
		
		Assert.assertFalse(unJugador.tienePropiedad("AYSA"));

		capitalInicialJugador = unJugador.capital();
		costoPropiedad = unaPropiedad.precioDeCompra();		
		unJugador.comprarPropiedad(unaPropiedad);
		
		Assert.assertTrue(unJugador.tienePropiedad("AYSA"));
		Assert.assertEquals(costoPropiedad, (capitalInicialJugador - unJugador.capital()));
	}
	
	@Test(expected=JugadorSinSaldoException.class)
	public void testJugadorIntentaCompraUnaPropiedadPeroNoLeAlcanzaElCapitalDaError() {
		Propiedad unaPropiedad = new Aysa();
		Jugador unJugador = new Jugador("Jugador de prueba");
		
		Assert.assertFalse(unJugador.tienePropiedad("AYSA"));

		unJugador.pagar(unJugador.capital() - 1);
		unaPropiedad.comprar(unJugador);
	}

	@Test
	public void testJugadorCantidadDePropiedadesQuePosee() {
		Propiedad unaPropiedad;
		Jugador unJugador = new Jugador("Jugador de prueba");
		
		Assert.assertEquals(0, unJugador.cantidadPropiedades());

		unJugador.cobrar(1000000);
		unaPropiedad = new Aysa();
		
		unJugador.comprarPropiedad(unaPropiedad);
		Assert.assertEquals(1, unJugador.cantidadPropiedades());

		unaPropiedad = new Edesur();
		unJugador.comprarPropiedad(unaPropiedad);
		unaPropiedad = new Subte();
		unJugador.comprarPropiedad(unaPropiedad);
		Assert.assertEquals(3, unJugador.cantidadPropiedades());
	}

	@Test
	public void testJugadorBuscaSiTieneUnPropiedadEspecifica() {
		Propiedad unaPropiedad;
		Jugador unJugador = new Jugador("Jugador de prueba");
		
		Assert.assertFalse(unJugador.tienePropiedad("AYSA"));

		unJugador.cobrar(1000000);
		unaPropiedad = new Aysa();
		
		unJugador.comprarPropiedad(unaPropiedad);
		Assert.assertTrue(unJugador.tienePropiedad("AYSA"));

		unaPropiedad = new Edesur();
		unJugador.comprarPropiedad(unaPropiedad);
		unaPropiedad = new Subte();
		unJugador.comprarPropiedad(unaPropiedad);
		Assert.assertTrue(unJugador.tienePropiedad("SUBTE"));
		Assert.assertTrue(unJugador.tienePropiedad("EDESUR"));
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
	public void testJugadorPricioneroMoverDevuelveCero() {
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