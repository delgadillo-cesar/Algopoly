import org.junit.Assert;
import org.junit.Test;

public class TestJugador {

	
/***********************************************/
		
	@Test
	public void test_01_CrearJugador() {
		
		Jugador jugador = new Jugador ();
		Assert.assertEquals (100000,jugador.getCapitalJugador());
		
	}
	
/***********************************************/
	
	@Test
	public void test_02_Capital() {
		
		Jugador jugador = new Jugador ();
		Assert.assertEquals (100000,jugador.getCapitalJugador()); // capital inicial
		jugador.incrementarCapitalJugador(50000);
		Assert.assertEquals(150000,jugador.getCapitalJugador());
				
	}
		
/***********************************************/	
	
	
/***********************************************/
	
}
