package unitarios;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import entidades.Jugador;
import entidades.MismoJugadorException;
import propiedades.Construccion;
import propiedades.NadaParaConstruirException;
import propiedades.Terreno;

public class TerrenoTest {

	private List<Construccion> construcciones;
	
	@Before
	public void setUp() throws Exception {
		construcciones = new ArrayList<Construccion>();
		
		construcciones.add(Construccion.construirUnTerreno(2500));
		construcciones.add(Construccion.construirUnaCasa(5500, 3500));
		construcciones.add(Construccion.construirDosCasa(5500, 4000));
		construcciones.add(Construccion.construirUnHotel(9000, 6000));
	}
	
	@Test
	public void test01CrearUnTerreno() {
		Terreno unTerreno = new Terreno("BS AS ZONA NORTE", 25000, construcciones);
		
		Assert.assertNotNull(unTerreno);
	}

	@Test
	public void test02TerrenoObtenerDescripcionDeCasilla() {
		Terreno unTerreno = new Terreno("BS AS ZONA NORTE", 25000, construcciones);
		
		Assert.assertEquals("BS AS ZONA NORTE", unTerreno.descripcion());
	}

	@Test
	public void test03TerrenoObtenerNombreDelTerreno() {
		Terreno unTerreno = new Terreno("BS AS ZONA NORTE", 25000, construcciones);
		
		Assert.assertEquals("BS AS ZONA NORTE", unTerreno.nombre());
	}

	@Test
	public void test04TerrenoObtenerPrecioDeCompra() {
		Terreno unTerreno = new Terreno("BS AS ZONA NORTE", 25000, construcciones);
		
		Assert.assertEquals(25000, unTerreno.precioDeCompra());
	}

	@Test
	public void test05TerrenoComprarTerreno() {
		Terreno unTerreno = new Terreno("BS AS ZONA NORTE", 25000, construcciones);
		Jugador unJugador = new Jugador("Jugador de prueba");
		
		Assert.assertFalse(unJugador.tienePropiedad("BS AS ZONA NORTE"));

		unTerreno.comprar(unJugador);
		
		Assert.assertTrue(unJugador.tienePropiedad("BS AS ZONA NORTE"));
	}

	@Test
	public void test06TerrenoObtenerPropietarioDelTerreno() {
		Terreno unTerreno = new Terreno("BS AS ZONA NORTE", 25000, construcciones);
		Jugador unJugador = new Jugador("Jugador de prueba");
		
		Assert.assertFalse(unJugador == unTerreno.propietario());

		unTerreno.comprar(unJugador);
		
		Assert.assertEquals(unJugador, unTerreno.propietario());
	}

	@Test
	public void test07TerrenoSinPropietarioAfectaJugadorDebeComprarlo() {
		Terreno unTerreno = new Terreno("BS AS ZONA NORTE", 25000, construcciones);
		Jugador unJugador = new Jugador("Jugador de prueba");
		
		Assert.assertFalse(unJugador == unTerreno.propietario());

		unTerreno.afectar(unJugador);
		
		Assert.assertEquals(unJugador, unTerreno.propietario());
	}
	
	@Test
	public void test08TerrenoConComprarAfectarAUnJugadorPropietarioLeCobraAlquilerAljugador() {
		Terreno unTerreno = new Terreno("BS AS ZONA NORTE", 25000, construcciones);
		Jugador unPropietario = new Jugador("Propietario de prueba");
		Jugador unJugador = new Jugador("Jugador de prueba");
		int capitalPropietario, capitalJugador, variacionPropietario, variacionJugador;

		unTerreno.afectar(unPropietario); /*Compra la compania*/
		capitalPropietario = unPropietario.capital();
		capitalJugador = unJugador.capital();
		
		unTerreno.afectar(unJugador); /*Le paga al propietario*/
		variacionPropietario = unPropietario.capital() - capitalPropietario;
		variacionJugador = capitalJugador - unJugador.capital();
		
		Assert.assertEquals(variacionPropietario, variacionJugador);
	}
	
	@Test(expected = MismoJugadorException.class)
	public void test09TerrenoPropietarioCaeEnSuPropioTerrenoAfectaJugadorDebeLanzarUnaExcepcion() {
		Terreno unTerreno = new Terreno("BS AS ZONA NORTE", 25000, construcciones);
		Jugador unPropietario = new Jugador("Propietario de prueba");
		
		unTerreno.afectar(unPropietario); /*Compra la compania*/
		unTerreno.afectar(unPropietario); /*Intenta cobrarle*/
	}
	
	@Test
	public void test10TerrenoObtenerCostoDeConstruccion() {
		Terreno unTerreno = new Terreno("BS AS ZONA NORTE", 25000, construcciones);
				
		Assert.assertEquals(5500, unTerreno.costoConstruccion());
	}	

	@Test
	public void test11TerrenoConstruirUnaConstruccionLeCobraElPrecioDeConstruccionAlPropietario() {
		Terreno unTerreno = new Terreno("BS AS ZONA NORTE", 25000, construcciones);
		Jugador unPropietario = new Jugador("Propietario de prueba");
		int capitalPropietario, variacionPropietario, costoConstruccion;
		
		unTerreno.afectar(unPropietario); /*Compra la compania*/
		
		capitalPropietario = unPropietario.capital();
		costoConstruccion = unTerreno.costoConstruccion();
		
		unTerreno.construir();
		variacionPropietario = capitalPropietario - unPropietario.capital();
		
		Assert.assertEquals(costoConstruccion, variacionPropietario);
	}
	
	@Test
	public void test12TerrenoConstruirUnaConstruccionCambiaElPrecioDeAlquiler() {
		Terreno unTerreno = new Terreno("BS AS ZONA NORTE", 25000, construcciones);
		Jugador unPropietario = new Jugador("Propietario de prueba");
		Jugador unJugador = new Jugador("Jugador de prueba");
		int capitalJugador, variacionJugador;

		unTerreno.afectar(unPropietario); /*Compra la compania*/

		capitalJugador = unJugador.capital();
		unTerreno.afectar(unJugador); /*Le paga al propietario*/
		variacionJugador = capitalJugador - unJugador.capital();
		
		Assert.assertEquals(2500, variacionJugador);
		
		unTerreno.construir();
		
		capitalJugador = unJugador.capital();
		unTerreno.afectar(unJugador); /*Le paga al propietario*/
		variacionJugador = capitalJugador - unJugador.capital();
		
		Assert.assertEquals(3500, variacionJugador);		
	}

	@Test(expected=NadaParaConstruirException.class)
	public void test13TerrenoDespuesDeConstruirTodasLasConstruccionesPosiblesAlQuererConsultarElCostoDeConstruccionDaError() {
		Terreno unTerreno = new Terreno("BS AS ZONA NORTE", 25000, construcciones);
		Jugador unPropietario = new Jugador("Propietario de prueba");

		unTerreno.afectar(unPropietario); /*Compra la compania*/
		
		Assert.assertTrue(unTerreno.costoConstruccion() > 0);
		unTerreno.construir(); /*una casa*/

		Assert.assertTrue(unTerreno.costoConstruccion() > 0);
		unTerreno.construir(); /*dos casas*/

		Assert.assertTrue(unTerreno.costoConstruccion() > 0);
		unTerreno.construir(); /*un hotel*/

		unTerreno.costoConstruccion(); /*Se espera una excepcion*/
	}

	@Test(expected=NadaParaConstruirException.class)
	public void test14TerrenoDespuesDeConstruirTodasLasConstruccionesPosiblesAlQuererConstruirDaError() {
		Terreno unTerreno = new Terreno("BS AS ZONA NORTE", 25000, construcciones);
		Jugador unPropietario = new Jugador("Propietario de prueba");

		unTerreno.afectar(unPropietario); /*Compra la compania*/
		
		unTerreno.construir(); /*una casa*/
		unTerreno.construir(); /*dos casas*/
		unTerreno.construir(); /*un hotel*/

		unTerreno.construir(); /*Se espera una excepcion*/
	}

}
