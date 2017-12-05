package unitarios;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import modelo.entidades.Jugador;
import modelo.entidades.MismoJugadorException;
import modelo.tablero.poseibles.NadaParaConstruirException;
import modelo.tablero.poseibles.barrios.Barrio;
import modelo.tablero.poseibles.barrios.construcciones.Construccion;

public class BarrioTest {

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
	public void test01CrearUnBarrio() {
		Barrio unBarrio = new Barrio("BS AS ZONA NORTE", 25000, construcciones);
		
		Assert.assertNotNull(unBarrio);
	}

	@Test
	public void test02BarrioObtenerDescripcionDeCasilla() {
		Barrio unBarrio = new Barrio("BS AS ZONA NORTE", 25000, construcciones);
		
		Assert.assertEquals("BS AS ZONA NORTE", unBarrio.descripcion());
	}

	@Test
	public void test03BarrioObtenerNombreDelBarrio() {
		Barrio unBarrio = new Barrio("BS AS ZONA NORTE", 25000, construcciones);
		
		Assert.assertEquals("BS AS ZONA NORTE", unBarrio.nombre());
	}

	@Test
	public void test04BarrioObtenerPrecioDeCompra() {
		Barrio unBarrio = new Barrio("BS AS ZONA NORTE", 25000, construcciones);
		
		Assert.assertEquals(25000, unBarrio.precioDeCompra());
	}

	@Test
	public void test05BarrioComprarBarrio() {
		Barrio unBarrio = new Barrio("BS AS ZONA NORTE", 25000, construcciones);
		Jugador unJugador = new Jugador("Jugador de prueba");
		
		Assert.assertFalse(unJugador.esDuenoDe("BS AS ZONA NORTE"));

		unBarrio.comprar(unJugador);
		
		Assert.assertTrue(unJugador.esDuenoDe("BS AS ZONA NORTE"));
	}

	@Test
	public void test06BarrioObtenerPropietarioDelBarrio() {
		Barrio unBarrio = new Barrio("BS AS ZONA NORTE", 25000, construcciones);
		Jugador unJugador = new Jugador("Jugador de prueba");
		
		Assert.assertFalse(unJugador == unBarrio.propietario());

		unBarrio.comprar(unJugador);
		
		Assert.assertEquals(unJugador, unBarrio.propietario());
	}

	@Test
	public void test07BarrioSinPropietarioAfectaJugadorDebeComprarlo() {
		Barrio unBarrio = new Barrio("BS AS ZONA NORTE", 25000, construcciones);
		Jugador unJugador = new Jugador("Jugador de prueba");
		
		Assert.assertFalse(unJugador == unBarrio.propietario());

		unBarrio.afectar(unJugador);
		
		Assert.assertEquals(unJugador, unBarrio.propietario());
	}
	
	@Test
	public void test08BarrioConComprarAfectarAUnJugadorPropietarioLeCobraAlquilerAljugador() {
		Barrio unBarrio = new Barrio("BS AS ZONA NORTE", 25000, construcciones);
		Jugador unPropietario = new Jugador("Propietario de prueba");
		Jugador unJugador = new Jugador("Jugador de prueba");
		int capitalPropietario, capitalJugador, variacionPropietario, variacionJugador;

		unBarrio.afectar(unPropietario); /*Compra la compania*/
		capitalPropietario = unPropietario.capital();
		capitalJugador = unJugador.capital();
		
		unBarrio.afectar(unJugador); /*Le paga al propietario*/
		variacionPropietario = unPropietario.capital() - capitalPropietario;
		variacionJugador = capitalJugador - unJugador.capital();
		
		Assert.assertEquals(variacionPropietario, variacionJugador);
	}
	
	@Test(expected = MismoJugadorException.class)
	public void test09BarrioPropietarioCaeEnSuPropioBarrioAfectaJugadorDebeLanzarUnaExcepcion() {
		Barrio unBarrio = new Barrio("BS AS ZONA NORTE", 25000, construcciones);
		Jugador unPropietario = new Jugador("Propietario de prueba");
		
		unBarrio.afectar(unPropietario); /*Compra la compania*/
		unBarrio.afectar(unPropietario); /*Intenta cobrarle*/
	}
	
	@Test
	public void test10BarrioObtenerCostoDeConstruccion() {
		Barrio unBarrio = new Barrio("BS AS ZONA NORTE", 25000, construcciones);
				
		Assert.assertEquals(5500, unBarrio.costoConstruccion());
	}	

	@Test
	public void test11BarrioConstruirUnaConstruccionLeCobraElPrecioDeConstruccionAlPropietario() {
		Barrio unBarrio = new Barrio("BS AS ZONA NORTE", 25000, construcciones);
		Jugador unPropietario = new Jugador("Propietario de prueba");
		int capitalPropietario, variacionPropietario, costoConstruccion;
		
		unBarrio.afectar(unPropietario); /*Compra la compania*/
		
		capitalPropietario = unPropietario.capital();
		costoConstruccion = unBarrio.costoConstruccion();
		
		unBarrio.construir();
		variacionPropietario = capitalPropietario - unPropietario.capital();
		
		Assert.assertEquals(costoConstruccion, variacionPropietario);
	}
	
	@Test
	public void test12BarrioConstruirUnaConstruccionCambiaElPrecioDeAlquiler() {
		Barrio unBarrio = new Barrio("BS AS ZONA NORTE", 25000, construcciones);
		Jugador unPropietario = new Jugador("Propietario de prueba");
		Jugador unJugador = new Jugador("Jugador de prueba");
		int capitalJugador, variacionJugador;

		unBarrio.afectar(unPropietario); /*Compra la compania*/

		capitalJugador = unJugador.capital();
		unBarrio.afectar(unJugador); /*Le paga al propietario*/
		variacionJugador = capitalJugador - unJugador.capital();
		
		Assert.assertEquals(2500, variacionJugador);
		
		unBarrio.construir();
		
		capitalJugador = unJugador.capital();
		unBarrio.afectar(unJugador); /*Le paga al propietario*/
		variacionJugador = capitalJugador - unJugador.capital();
		
		Assert.assertEquals(3500, variacionJugador);		
	}

	@Test(expected=NadaParaConstruirException.class)
	public void test13BarrioDespuesDeConstruirTodasLasConstruccionesPosiblesAlQuererConsultarElCostoDeConstruccionDaError() {
		Barrio unBarrio = new Barrio("BS AS ZONA NORTE", 25000, construcciones);
		Jugador unPropietario = new Jugador("Propietario de prueba");

		unBarrio.afectar(unPropietario); /*Compra la compania*/
		
		Assert.assertTrue(unBarrio.costoConstruccion() > 0);
		unBarrio.construir(); /*una casa*/

		Assert.assertTrue(unBarrio.costoConstruccion() > 0);
		unBarrio.construir(); /*dos casas*/

		Assert.assertTrue(unBarrio.costoConstruccion() > 0);
		unBarrio.construir(); /*un hotel*/

		unBarrio.costoConstruccion(); /*Se espera una excepcion*/
	}

	@Test(expected=NadaParaConstruirException.class)
	public void test14BarrioDespuesDeConstruirTodasLasConstruccionesPosiblesAlQuererConstruirDaError() {
		Barrio unBarrio = new Barrio("BS AS ZONA NORTE", 25000, construcciones);
		Jugador unPropietario = new Jugador("Propietario de prueba");

		unBarrio.afectar(unPropietario); /*Compra la compania*/
		
		unBarrio.construir(); /*una casa*/
		unBarrio.construir(); /*dos casas*/
		unBarrio.construir(); /*un hotel*/

		unBarrio.construir(); /*Se espera una excepcion*/
	}

}
