package unitarios;

import org.junit.Assert;
import org.junit.Test;

import entidades.JugadorConcreto;



public class JugadorTest {

	@Test
	public void testCrearJugadorConNombreValidoNoDevuelveNull() {

		JugadorConcreto jugador = new JugadorConcreto("Mario");
		Assert.assertNotNull(jugador);
	}
	
	@Test
	public void testJugadorNuevoTieneCienMilPesosDeCapital() {
		
		JugadorConcreto jugador = new JugadorConcreto("Juan");
		Assert.assertEquals(jugador.capital(), 100000);
	}

}