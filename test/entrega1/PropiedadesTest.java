package entrega1;

import junit.framework.Assert;
import org.junit.Test;

import entidades.Jugador;
import entidades.JugadorConcreto;

import propiedades.Aysa;
import propiedades.Compania;
import propiedades.Edesur;
import propiedades.Subte;
import propiedades.Trenes;

public class PropiedadesTest {

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
	public void test02CompaniaSinPropietarioAfectaJugadorDebeComprarla() {
		Jugador unJugador = new JugadorConcreto("Jugador de prueba");
		Compania unaCompania = new Aysa();
		
		Assert.assertFalse(unJugador == unaCompania.propietario());

		unaCompania.afectar(unJugador);
		
		Assert.assertEquals(unJugador, unaCompania.propietario());
		
	}

	@Test
	public void test03CompaniaConPropietarioAfectaJugadorDebePagarAlPropietario() {
		Jugador unPropietario = new JugadorConcreto("Propietario de prueba");
		Jugador unJugador = new JugadorConcreto("Jugador de prueba");
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


	@Test
	public void test04CompaniaComprarAysaCuesta30000() {
		Jugador unJugador = new JugadorConcreto("Jugador de prueba");
		int capitalInicial = unJugador.capital();

		Compania unaCompania = new Aysa();
		unaCompania.afectar(unJugador);

		Assert.assertEquals((capitalInicial - 30000), unJugador.capital());
	}

	@Test
	public void test05CompaniaComprarEdesurCuesta35000() {
		Jugador unJugador = new JugadorConcreto("Jugador de prueba");
		int capitalInicial = unJugador.capital();

		Compania unaCompania = new Edesur();
		unaCompania.afectar(unJugador);

		Assert.assertEquals((capitalInicial - 35000), unJugador.capital());
	}

	@Test
	public void test06CompaniaComprarSubteCuesta40000() {
		Jugador unJugador = new JugadorConcreto("Jugador de prueba");
		int capitalInicial = unJugador.capital();

		Compania unaCompania = new Subte();
		unaCompania.afectar(unJugador);

		Assert.assertEquals((capitalInicial - 40000), unJugador.capital());
	}

	@Test
	public void test07CompaniaComprarTrenesCuesta38000() {
		Jugador unJugador = new JugadorConcreto("Jugador de prueba");
		int capitalInicial = unJugador.capital();

		Compania unaCompania = new Trenes();
		unaCompania.afectar(unJugador);

		Assert.assertEquals((capitalInicial - 38000), unJugador.capital());
	}
}
