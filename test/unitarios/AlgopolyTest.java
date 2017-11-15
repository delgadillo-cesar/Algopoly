package unitarios;

import org.junit.Assert;

public class AlgopolyTest {
	
	@Test
	public void testCrearAlgopolyNoDevuelveNull() {
		
		Algooly juego = new Algopoly();
		
		Assert.assertNotNull(juego);
}
