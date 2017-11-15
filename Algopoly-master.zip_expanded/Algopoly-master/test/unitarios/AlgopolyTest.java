package unitarios;

import org.junit.Assert;
import org.junit.Test;

public class AlgopolyTest {
	
	@Test
	public void testCrearAlgopolyNoDevuelveNull() {
		
		Algooly juego = new Algopoly();
		
		Assert.assertNotNull(juego);
	}
}
