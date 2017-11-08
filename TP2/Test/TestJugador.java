import org.junit.Assert;
import org.junit.Test;

public class TestJugador {

	
/***********************************************/
		
	@Test
	public void test_01_CrearJugador() {
		
		Jugador jugador = new Jugador ();
		Assert.assertEquals (0,jugador.getCantidadDeVecesQueGanoQuini6());
		Assert.assertEquals (100000,jugador.getCapitalJugador());
		
	}
	
/***********************************************/
	
	@Test
	public void test_02_ContadorDeVecesQueGanoQuini6() {
		
		Jugador jugador = new Jugador ();
		jugador.incremetarCantidadDeVecesQueGanoQuini6();
		jugador.incremetarCantidadDeVecesQueGanoQuini6();
		Assert.assertEquals (2,jugador.getCantidadDeVecesQueGanoQuini6());
	}
	
/***********************************************/	
	
	@Test
	public void test_03_Capital() {
		
		Jugador jugador = new Jugador ();
		Assert.assertEquals (100000,jugador.getCapitalJugador()); // capital inicial
		jugador.incremetarCantidadDeVecesQueGanoQuini6();
		if (jugador.getCantidadDeVecesQueGanoQuini6() == 1)
			jugador.incrementarCapitalJugador(50000);
		Assert.assertEquals(150000,jugador.getCapitalJugador());
				
	}

	
/***********************************************/
	
	
}
