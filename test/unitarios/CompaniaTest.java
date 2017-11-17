package unitarios;

import juego.Dados;

import org.junit.Assert;
import org.junit.Test;

import entidades.Jugador;
import entidades.Jugador;
import entidades.MismoJugadorException;
import propiedades.Aysa;
import propiedades.Compania;
import propiedades.Edesur;
import propiedades.Subte;
import propiedades.Trenes;

public class CompaniaTest {

	@Test
	public void test01CrearCompanias() {
		Compania unaCompania = new Aysa();
		Assert.assertNotNull(unaCompania);
		
		unaCompania = new Edesur();
		Assert.assertNotNull(unaCompania);
		
		unaCompania = new Subte();
		Assert.assertNotNull(unaCompania);
		
		unaCompania = new Trenes();
		Assert.assertNotNull(unaCompania);
		
	}
	
	@Test
	public void test02CompaniaObtenerNombre() {
		Compania unaCompania = new Aysa();
		Assert.assertEquals("AYSA", unaCompania.nombre());
		
		unaCompania = new Edesur();
		Assert.assertEquals("EDESUR", unaCompania.nombre());
		
		unaCompania = new Subte();
		Assert.assertEquals("SUBTE", unaCompania.nombre());
		
		unaCompania = new Trenes();
		Assert.assertEquals("TRENES", unaCompania.nombre());
	}
	
	@Test
	public void test03CompaniaPrecioDeCompra() {
		Compania unaCompania = new Aysa();
		Assert.assertEquals(30000, unaCompania.precioDeCompra());
	}

	@Test
	public void test04CompaniaSinPropietarioAfectaJugadorDebeComprarla() {
		Jugador unJugador = new Jugador("Jugador de prueba");
		Compania unaCompania = new Aysa();
		
		Assert.assertFalse(unJugador == unaCompania.propietario());

		unaCompania.afectar(unJugador);
		
		Assert.assertEquals(unJugador, unaCompania.propietario());
		
	}

	@Test
	public void test05CompaniaObtenerPropietario() {
		Jugador unJugador = new Jugador("Jugador de prueba");
		Compania unaCompania = new Aysa();
		
		unaCompania.afectar(unJugador);
		
		Assert.assertEquals(unJugador, unaCompania.propietario());
		
	}	
	
	@Test
	public void test06CompaniaConPropietarioAfectaJugadorDebePagarAlPropietario() {
		Jugador unPropietario = new Jugador("Propietario de prueba");
		Jugador unJugador = new Jugador("Jugador de prueba");
		int capitalPropietario, capitalJugador, variacionPropietario, variacionJugador;

		Compania unaCompania = new Aysa();
		
		unaCompania.afectar(unPropietario); /*Compra la compania*/
		capitalPropietario = unPropietario.capital();
		capitalJugador = unJugador.capital();
		
		unaCompania.afectar(unJugador); /*Le paga al propietario*/
		variacionPropietario = unPropietario.capital() - capitalPropietario;
		variacionJugador = capitalJugador - unJugador.capital();
		
		Assert.assertEquals(variacionPropietario, variacionJugador);
	}

	@Test(expected = MismoJugadorException.class)
	public void test07CompaniaPropietarioCaeEnSuPropiaCompaniaAfectaJugadorDebeLanzarUnaExcepcion() {
		Jugador unPropietario = new Jugador("Propietario de prueba");
		Compania unaCompania = new Aysa();
		
		unaCompania.afectar(unPropietario); /*Compra la compania*/
		unaCompania.afectar(unPropietario); /*Intenta cobrarle*/
	}


	@Test
	public void test08CompaniaComprarAysaCuesta30000() {
		Jugador unJugador = new Jugador("Jugador de prueba");
		int capitalInicial = unJugador.capital();

		Compania unaCompania = new Aysa();
		unaCompania.afectar(unJugador);

		Assert.assertEquals((capitalInicial - 30000), unJugador.capital());
	}

	@Test
	public void test09CompaniaComprarEdesurCuesta35000() {
		Jugador unJugador = new Jugador("Jugador de prueba");
		int capitalInicial = unJugador.capital();

		Compania unaCompania = new Edesur();
		unaCompania.afectar(unJugador);

		Assert.assertEquals((capitalInicial - 35000), unJugador.capital());
	}

	@Test
	public void test10CompaniaComprarSubteCuesta40000() {
		Jugador unJugador = new Jugador("Jugador de prueba");
		int capitalInicial = unJugador.capital();

		Compania unaCompania = new Subte();
		unaCompania.afectar(unJugador);

		Assert.assertEquals((capitalInicial - 40000), unJugador.capital());
	}

	@Test
	public void test11CompaniaComprarTrenesCuesta38000() {
		Jugador unJugador = new Jugador("Jugador de prueba");
		int capitalInicial = unJugador.capital();

		Compania unaCompania = new Trenes();
		unaCompania.afectar(unJugador);

		Assert.assertEquals((capitalInicial - 38000), unJugador.capital());
	}

	@Test
	public void test12CompaniaAysaCobra300VecesLosDados() {
		Jugador unPropietario = new Jugador("Propietario de prueba");
		Jugador unJugador = new Jugador("Jugador de prueba");
		Dados losDados = Dados.getInstance();
		int capitalInicial = unJugador.capital();
		int valorACobrar;

		Compania unaCompania = new Aysa();
		unaCompania.afectar(unPropietario); /*Compra la compania*/
		
		losDados.lanzarDados();
		valorACobrar = 300 * losDados.getValor();
		unaCompania.afectar(unJugador); /*Le paga al propietario*/
		
		Assert.assertEquals(capitalInicial - valorACobrar, unJugador.capital());
	}

	@Test
	public void test13CompaniaAysaPropoetarioTieneEdesurCobra500VecesLosDados() {
		Jugador unPropietario = new Jugador("Propietario de prueba");
		Jugador unJugador = new Jugador("Jugador de prueba");
		Dados losDados = Dados.getInstance();
		int capitalInicial = unJugador.capital();
		int valorACobrar;

		Compania unaCompania = new Edesur();
		unaCompania.afectar(unPropietario); /*Compra la compania*/

		unaCompania = new Aysa();
		unaCompania.afectar(unPropietario); /*Compra la compania*/
		
		losDados.lanzarDados();
		valorACobrar = 500 * losDados.getValor();
		unaCompania.afectar(unJugador); /*Le paga al propietario*/
		
		Assert.assertEquals(capitalInicial - valorACobrar, unJugador.capital());
	}

	@Test
	public void test14CompaniaEdesurCobra500VecesLosDados() {
		Jugador unPropietario = new Jugador("Propietario de prueba");
		Jugador unJugador = new Jugador("Jugador de prueba");
		Dados losDados = Dados.getInstance();
		int capitalInicial = unJugador.capital();
		int valorACobrar;

		Compania unaCompania = new Edesur();
		unaCompania.afectar(unPropietario); /*Compra la compania*/
		
		losDados.lanzarDados();
		valorACobrar = 500 * losDados.getValor();
		unaCompania.afectar(unJugador); /*Le paga al propietario*/
		
		Assert.assertEquals(capitalInicial - valorACobrar, unJugador.capital());
	}

	@Test
	public void test15CompaniaEdesurPropoetarioTieneAysaCobra1000VecesLosDados() {
		Jugador unPropietario = new Jugador("Propietario de prueba");
		Jugador unJugador = new Jugador("Jugador de prueba");
		Dados losDados = Dados.getInstance();
		int capitalInicial = unJugador.capital();
		int valorACobrar;

		Compania unaCompania = new Aysa();
		unaCompania.afectar(unPropietario); /*Compra la compania*/

		unaCompania = new Edesur();
		unaCompania.afectar(unPropietario); /*Compra la compania*/
		
		losDados.lanzarDados();
		valorACobrar = 1000 * losDados.getValor();
		unaCompania.afectar(unJugador); /*Le paga al propietario*/
		
		Assert.assertEquals(capitalInicial - valorACobrar, unJugador.capital());
	}

	@Test
	public void test16CompaniaSubteCobra600VecesLosDados() {
		Jugador unPropietario = new Jugador("Propietario de prueba");
		Jugador unJugador = new Jugador("Jugador de prueba");
		Dados losDados = Dados.getInstance();
		int capitalInicial = unJugador.capital();
		int valorACobrar;

		Compania unaCompania = new Subte();
		unaCompania.afectar(unPropietario); /*Compra la compania*/
		
		losDados.lanzarDados();
		valorACobrar = 600 * losDados.getValor();
		unaCompania.afectar(unJugador); /*Le paga al propietario*/
		
		Assert.assertEquals(capitalInicial - valorACobrar, unJugador.capital());
	}

	@Test
	public void test17CompaniaSubtePropoetarioTieneTrenesCobra1100VecesLosDados() {
		Jugador unPropietario = new Jugador("Propietario de prueba");
		Jugador unJugador = new Jugador("Jugador de prueba");
		Dados losDados = Dados.getInstance();
		int capitalInicial = unJugador.capital();
		int valorACobrar;

		Compania unaCompania = new Trenes();
		unaCompania.afectar(unPropietario); /*Compra la compania*/

		unaCompania = new Subte();
		unaCompania.afectar(unPropietario); /*Compra la compania*/
		
		losDados.lanzarDados();
		valorACobrar = 1100 * losDados.getValor();
		unaCompania.afectar(unJugador); /*Le paga al propietario*/
		
		Assert.assertEquals(capitalInicial - valorACobrar, unJugador.capital());
	}

	@Test
	public void test18CompaniaTrenesCobra450VecesLosDados() {
		Jugador unPropietario = new Jugador("Propietario de prueba");
		Jugador unJugador = new Jugador("Jugador de prueba");
		Dados losDados = Dados.getInstance();
		int capitalInicial = unJugador.capital();
		int valorACobrar;

		Compania unaCompania = new Trenes();
		unaCompania.afectar(unPropietario); /*Compra la compania*/
		
		losDados.lanzarDados();
		valorACobrar = 450 * losDados.getValor();
		unaCompania.afectar(unJugador); /*Le paga al propietario*/
		
		Assert.assertEquals(capitalInicial - valorACobrar, unJugador.capital());
	}

	@Test
	public void test19CompaniaTrenesPropoetarioTieneSubteCobra800VecesLosDados() {
		Jugador unPropietario = new Jugador("Propietario de prueba");
		Jugador unJugador = new Jugador("Jugador de prueba");
		Dados losDados = Dados.getInstance();
		int capitalInicial = unJugador.capital();
		int valorACobrar;

		Compania unaCompania = new Subte();
		unaCompania.afectar(unPropietario); /*Compra la compania*/

		unaCompania = new Trenes();
		unaCompania.afectar(unPropietario); /*Compra la compania*/
		
		losDados.lanzarDados();
		valorACobrar = 800 * losDados.getValor();
		unaCompania.afectar(unJugador); /*Le paga al propietario*/
		
		Assert.assertEquals(capitalInicial - valorACobrar, unJugador.capital());
	}

}
