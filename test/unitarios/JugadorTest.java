package unitarios;

import org.junit.Assert;
import org.junit.Test;

import entidades.Jugador;
import entidades.JugadorConcreto;
import entidades.JugadorNadieException;
import entidades.JugadorSinSaldoException;
import entidades.MismoJugadorException;
import entidades.Nadie;
import propiedades.Aysa;
import propiedades.Edesur;
import propiedades.Propiedad;
import propiedades.Subte;
import propiedades.Terreno;



public class JugadorTest {

	@Test
	public void testCrearJugadorConNombreValidoNoDevuelveNull() {
		Jugador jugador = new JugadorConcreto("Mario");
		Assert.assertNotNull(jugador);
	}
	
	@Test
	public void testJugadorNuevoTieneCienMilPesosDeCapital() {
		Jugador jugador = new JugadorConcreto("Juan");
		Assert.assertEquals(100000, jugador.capital());
	}

	@Test
	public void testJugadorPagarDelvuelveElMontoPagado() {
		Jugador jugador = new JugadorConcreto("Juan");
		int unMonto = 20000;
		
		Assert.assertEquals(unMonto, jugador.pagar(20000));
	}

	@Test
	public void testJugadorPagaUnMontoSuCapitalDisminuyeEsaCantidad() {
		Jugador jugador = new JugadorConcreto("Juan");
		Assert.assertEquals(100000, jugador.capital());
		
		jugador.pagar(20000);
		Assert.assertEquals(80000, jugador.capital());
	}
	
	@Test(expected=JugadorSinSaldoException.class)
	public void testJugadorPagaUnMontoMayorQueSuCapitalDaError() {
		Jugador jugador = new JugadorConcreto("Juan");
		Assert.assertEquals(100000, jugador.capital());
		
		jugador.pagar(100001);
	}
	
	@Test
	public void testJugadorCobraUnMontoSuCapitalAumentaEsaCantidad() {
		Jugador jugador = new JugadorConcreto("Juan");
		Assert.assertEquals(100000, jugador.capital());
		
		jugador.cobrar(20000);
		Assert.assertEquals(120000, jugador.capital());
	}
	
	@Test
	public void testJugadorUnJugadorLeCobraAOtroJugadorSusCapitalesVarian() {
		Jugador jugadorCobrador = new JugadorConcreto("Cobrador de Prueba");
		Jugador jugadorPagador = new JugadorConcreto("Pagador de Prueba");
		int capitalInicialCobrador, capitalInicialPagador;
		int unMonto = 10000;
		
		capitalInicialCobrador = jugadorCobrador.capital();
		capitalInicialPagador = jugadorPagador.capital();
		
		jugadorCobrador.cobrar(unMonto, jugadorPagador);
		
		Assert.assertEquals((capitalInicialCobrador + unMonto), jugadorCobrador.capital());
		Assert.assertEquals((capitalInicialPagador - unMonto), jugadorPagador.capital());
	}
	
	@Test(expected=MismoJugadorException.class)
	public void testJugadorUnJugadorIntentaCombrarUnMontoASiMismoDaError() {
		Jugador unJugador = new JugadorConcreto("Jugador de Prueba");
		
		unJugador.cobrar(10000, unJugador);
	}
	
	@Test(expected=JugadorSinSaldoException.class)
	public void testJugadorUnJugadorLeCobraAOtroJugadorUnMontoMayorASuCapitalYNoPuedePagarloDaError() {
		Jugador jugadorCobrador = new JugadorConcreto("Cobrador de Prueba");
		Jugador jugadorPagador = new JugadorConcreto("Pagador de Prueba");
		
		jugadorCobrador.cobrar((jugadorPagador.capital() + 1), jugadorPagador);
	}
	
	@Test
	public void testJugadorCompraUnaPropiedadObtieneLaPropiedadYSuCapitalDisminuyeAlPagarElCostoDeCompra() {
		Propiedad unaPropiedad = new Aysa();
		Jugador unJugador = new JugadorConcreto("Jugador de prueba");
		int capitalInicialJugador, costoPropiedad;
		
		Assert.assertFalse(unJugador.tienePropiedad("AYSA"));

		capitalInicialJugador = unJugador.capital();
		costoPropiedad = unaPropiedad.precioDeCompra();		
		unaPropiedad.comprar(unJugador);
		
		Assert.assertTrue(unJugador.tienePropiedad("AYSA"));
		Assert.assertEquals(costoPropiedad, (capitalInicialJugador - unJugador.capital()));
	}
	
	@Test(expected=JugadorSinSaldoException.class)
	public void testJugadorIntentaCompraUnaPropiedadPeroNoLeAlcanzaElCapitalDaError() {
		Propiedad unaPropiedad = new Aysa();
		Jugador unJugador = new JugadorConcreto("Jugador de prueba");
		
		Assert.assertFalse(unJugador.tienePropiedad("AYSA"));

		unJugador.pagar(unJugador.capital() - 1);
		unaPropiedad.comprar(unJugador);
	}

	@Test
	public void testJugadorCantidadDePropiedadesQuePosee() {
		Propiedad unaPropiedad;
		Jugador unJugador = new JugadorConcreto("Jugador de prueba");
		
		Assert.assertEquals(0, unJugador.cantidadPropiedades());

		unJugador.cobrar(1000000);
		unaPropiedad = new Aysa();
		
		unaPropiedad.comprar(unJugador);
		Assert.assertEquals(1, unJugador.cantidadPropiedades());

		unaPropiedad = new Edesur();
		unaPropiedad.comprar(unJugador);
		unaPropiedad = new Subte();
		unaPropiedad.comprar(unJugador);		
		Assert.assertEquals(3, unJugador.cantidadPropiedades());
	}

	@Test
	public void testJugadorBuscaSiTieneUnPropiedadEspecifica() {
		Propiedad unaPropiedad;
		Jugador unJugador = new JugadorConcreto("Jugador de prueba");
		
		Assert.assertFalse(unJugador.tienePropiedad("AYSA"));

		unJugador.cobrar(1000000);
		unaPropiedad = new Aysa();
		
		unaPropiedad.comprar(unJugador);
		Assert.assertTrue(unJugador.tienePropiedad("AYSA"));

		unaPropiedad = new Edesur();
		unaPropiedad.comprar(unJugador);
		unaPropiedad = new Subte();
		unaPropiedad.comprar(unJugador);		
		Assert.assertTrue(unJugador.tienePropiedad("SUBTE"));
		Assert.assertTrue(unJugador.tienePropiedad("EDESUR"));
	}

	@Test
	public void testJugadorAgregarUnaPropiedad() {
		Propiedad unaPropiedad;
		Jugador unJugador = new JugadorConcreto("Jugador de prueba");
		
		Assert.assertFalse(unJugador.tienePropiedad("AYSA"));

		unaPropiedad = new Aysa();
		
		unJugador.agregar(unaPropiedad);
		Assert.assertTrue(unJugador.tienePropiedad("AYSA"));
	}
	

	@Test
	public void testJugadorNadieTodosLosMetodosLanzanLaExcepcionJugadorNadieException() {
		Nadie jugadorNadie = new Nadie();
		
		try{
			jugadorNadie.cobrar(10000);			
			Assert.fail("Se esperaba una excepcion");
		}catch(JugadorNadieException e){
		}

		try{
			jugadorNadie.capital();
			Assert.fail("Se esperaba una excepcion");
		}catch(JugadorNadieException e){
		}

		try{
			jugadorNadie.cantidadPropiedades();
			Assert.fail("Se esperaba una excepcion");
		}catch(JugadorNadieException e){
		}

		try{
			jugadorNadie.agregar(new Aysa());
			Assert.fail("Se esperaba una excepcion");
		}catch(JugadorNadieException e){
		}

		try{
			jugadorNadie.pagar(10000);
			Assert.fail("Se esperaba una excepcion");
		}catch(JugadorNadieException e){
		}

		try{
			jugadorNadie.cobrar(10000, new JugadorConcreto("Jugador de Prueba"));
			Assert.fail("Se esperaba una excepcion");
		}catch(JugadorNadieException e){
		}

		try{
			jugadorNadie.tienePropiedad("AYSA");			
			Assert.fail("Se esperaba una excepcion");
		}catch(JugadorNadieException e){
		}
	}

}