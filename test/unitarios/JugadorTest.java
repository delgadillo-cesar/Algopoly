package unitarios;

import org.junit.Assert;
import org.junit.Test;

import entidades.Jugador;



public class JugadorTest {

	@Test
	public void testCrearJugadorConNombreValidoNoDevuelveNull() {

		Jugador jugador = new Jugador("Mario");
		Assert.assertNotNull(jugador);
	}
	
	@Test
	public void testJugadorNuevoTieneCienMilPesosDeCapital() {
		
		Jugador jugador = new Jugador("Juan");
		Assert.assertEquals(jugador.capital(), 100000);
	}

}