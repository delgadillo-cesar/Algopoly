package unitarios;

import org.junit.Assert;
import org.junit.Test;

import modelo.tablero.poseibles.barrios.construcciones.Construccion;


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
	
	@Test
	public void testConstruirEdificioHistoricoNoDevuelveNull() {
		
		Construccion terreno = Construccion.construirUnEdificioHistorico(2500, 2500);
		
		Assert.assertNotNull(terreno);
	}
	
	@Test
	public void testObtenerPrecioAlquilerDevuelveCorrectamenteElCosto() {
		
		Construccion terreno = Construccion.construirUnTerreno(1500);
		
		int precioAlquiler = terreno.precioAlquiler();
		
		Assert.assertEquals(precioAlquiler, 1500);
	}
	
	@Test
	public void testObtenerDescripcionDevuelveCorrectamenteLaDescripcionParaUnTerreno() {		
		
		Construccion terreno = Construccion.construirUnTerreno(1500);
		
		String descripcion = terreno.descripcion();
		
		Assert.assertEquals(descripcion, "un terreno");
		
	}
	
	@Test
	public void testObtenerDescripcionDevuelveCorrectamenteLaDescripcionParaUnaCasa() {		
		Construccion terreno = Construccion.construirUnaCasa(1500, 1500);
		
		String descripcion = terreno.descripcion();
		
		Assert.assertEquals(descripcion, "una casa");
	}
	
	@Test
	public void testObtenerDescripcionDevuelveCorrectamenteLaDescripcionParaDosCasas() {		
		Construccion terreno = Construccion.construirDosCasa(1500, 1500);
		
		String descripcion = terreno.descripcion();
		
		Assert.assertEquals(descripcion, "dos casas");
	}
	
	@Test
	public void testObtenerDescripcionDevuelveCorrectamenteLaDescripcionParaUnHotel() {		
		
		Construccion terreno = Construccion.construirUnHotel(1500, 1500);
		
		String descripcion = terreno.descripcion();
		
		Assert.assertEquals(descripcion, "un hotel");
	}
	
	@Test
	public void testObtenerDescripcionDevuelveCorrectamenteLaDescripcionParaUnEdificioHistorico() {		
		Construccion terreno = Construccion.construirUnEdificioHistorico(1500, 1500);
		
		String descripcion = terreno.descripcion();
		
		Assert.assertEquals(descripcion, "un edificio historico");
	}
	
	@Test
	public void testObtenerCostoConstruccionDevuelveCorrectamenteElCostoDeLaConstruccion() {
		
		Construccion terreno = Construccion.construirUnHotel(1500, 1500);
		
		int costoConstruccion = terreno.costoConstruccion();
		
		Assert.assertEquals(costoConstruccion, 1500);
	}
}
