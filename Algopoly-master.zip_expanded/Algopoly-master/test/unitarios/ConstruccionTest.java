package unitarios;

import org.junit.Assert;
import org.junit.Test;

import propiedades.Construccion;

public class ConstruccionTest {
		
	@Test
	public void testConstruirTerrenoNoDevuelveNull() {
		
		Construccion terreno = Construccion.construirUnTerreno(1500);
		
		Assert.assertNotNull(terreno);
	}
	
	@Test
	public void testConstruirUnaCasaNoDevuelveNull() {
		
		Construccion terreno = Construccion.construirUnaCasa(1500, 1500);
		
		Assert.assertNotNull(terreno);
	}
	
	@Test
	public void testConstruirDosCasasDevuelveNull() {
		
		Construccion terreno = Construccion.construirDosCasa(3000, 3000);
		
		Assert.assertNotNull(terreno);
	}
	
	@Test
	public void testConstruirHotelNoDevuelveNull() {
		
		Construccion terreno = Construccion.construirUnHotel(7500, 7500);
		
		Assert.assertNotNull(terreno);
	}
}
