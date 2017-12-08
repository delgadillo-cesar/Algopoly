package unitarios;

import java.util.List;

import org.junit.Assert;
import modelo.entidades.*;
import modelo.tablero.PosicionTablero;
import modelo.tablero.poseibles.barrios.Barrio;
import modelo.tablero.poseibles.barrios.BarrioBuenosAiresNorte;
import modelo.tablero.poseibles.barrios.BarrioBuenosAiresSur;
import modelo.tablero.poseibles.barrios.BarrioNeuquen;
import modelo.tablero.poseibles.barrios.BarrioTucuman;
import modelo.tablero.poseibles.compania.Aysa;
import modelo.tablero.poseibles.compania.Compania;
import modelo.tablero.poseibles.compania.Edesur;

import org.junit.Test;

public class JugadorTest {
	
	@Test
	public void testCrearJugadores(){
		Jugador jugadorUno = new JugadorUno("Jugador de Prueba 1");
		Jugador jugadorDos = new JugadorUno("Jugador de Prueba 2");
		Jugador jugadorTres = new JugadorUno("Jugador de Prueba 3");
		
		Assert.assertNotNull(jugadorUno);
		Assert.assertNotNull(jugadorDos);
		Assert.assertNotNull(jugadorTres);
	}

	@Test
	public void testJugadorBancoEsDeInstanciaUnica(){
		Jugador bancoUno = Banco.getInstance();
		Jugador bancoDos = Banco.getInstance();
		
		Assert.assertEquals(bancoUno, bancoDos);
	}
	
	@Test
	public void testJugadorObteberNombreDelJugador(){
		Jugador jugador = new JugadorUno("Jugador de Prueba 1");
		
		Assert.assertEquals("Jugador de Prueba 1", jugador.nombreJugador());
	}

	@Test
	public void testJugadorEmpiezaCon100000(){
		Jugador jugador = new JugadorUno("Jugador de Prueba 1");
		
		Assert.assertEquals(100000, jugador.capital());
	}
		
	@Test
	public void testJugadorPagaAOtroJugador(){
		Jugador jugadorUno = new JugadorUno("Jugador de Prueba 1");
		Jugador jugadorDos = new JugadorDos("Jugador de Prueba 2");
		Jugador jugadorTres = new JugadorTres("Jugador de Prueba 3");
		
		int capitalPagador = jugadorUno.capital();
		int capitalCobrador = jugadorDos.capital();
		jugadorUno.pagarA(jugadorDos, 100);
		Assert.assertEquals(capitalPagador - 100, jugadorUno.capital());
		Assert.assertEquals(capitalCobrador + 100, jugadorDos.capital());

		capitalPagador = jugadorUno.capital();
		capitalCobrador = jugadorTres.capital();
		jugadorUno.pagarA(jugadorTres, 100);
		Assert.assertEquals(capitalPagador - 100, jugadorUno.capital());
		Assert.assertEquals(capitalCobrador + 100, jugadorTres.capital());
		
		capitalPagador = jugadorUno.capital();
		capitalCobrador = Banco.getInstance().capital();
		jugadorUno.pagarA(Banco.getInstance(), 100);
		Assert.assertEquals(capitalPagador - 100, jugadorUno.capital());
		Assert.assertEquals(capitalCobrador + 100, Banco.getInstance().capital());

		
		
		capitalPagador = jugadorDos.capital();
		capitalCobrador = jugadorUno.capital();
		jugadorDos.pagarA(jugadorUno, 100);
		Assert.assertEquals(capitalPagador - 100, jugadorDos.capital());
		Assert.assertEquals(capitalCobrador + 100, jugadorUno.capital());
		
		capitalPagador = jugadorDos.capital();
		capitalCobrador = jugadorTres.capital();
		jugadorDos.pagarA(jugadorTres, 100);
		Assert.assertEquals(capitalPagador - 100, jugadorDos.capital());
		Assert.assertEquals(capitalCobrador + 100, jugadorTres.capital());
		
		capitalPagador = jugadorDos.capital();
		capitalCobrador = Banco.getInstance().capital();
		jugadorDos.pagarA(Banco.getInstance(), 100);
		Assert.assertEquals(capitalPagador - 100, jugadorDos.capital());
		Assert.assertEquals(capitalCobrador + 100, Banco.getInstance().capital());


		
		capitalPagador = jugadorTres.capital();
		capitalCobrador = jugadorUno.capital();
		jugadorTres.pagarA(jugadorUno, 100);
		Assert.assertEquals(capitalPagador - 100, jugadorTres.capital());
		Assert.assertEquals(capitalCobrador + 100, jugadorUno.capital());
		
		capitalPagador = jugadorTres.capital();
		capitalCobrador = jugadorDos.capital();
		jugadorTres.pagarA(jugadorDos, 100);
		Assert.assertEquals(capitalPagador - 100, jugadorTres.capital());
		Assert.assertEquals(capitalCobrador + 100, jugadorDos.capital());
		
		capitalPagador = jugadorTres.capital();
		capitalCobrador = Banco.getInstance().capital();
		jugadorTres.pagarA(Banco.getInstance(), 100);
		Assert.assertEquals(capitalPagador - 100, jugadorTres.capital());
		Assert.assertEquals(capitalCobrador + 100, Banco.getInstance().capital());

	
		
		capitalPagador = Banco.getInstance().capital();
		capitalCobrador = jugadorUno.capital();
		Banco.getInstance().pagarA(jugadorUno, 100);
		Assert.assertEquals(capitalPagador - 100, Banco.getInstance().capital());
		Assert.assertEquals(capitalCobrador + 100, jugadorUno.capital());
		
		capitalPagador = Banco.getInstance().capital();
		capitalCobrador = jugadorDos.capital();
		Banco.getInstance().pagarA(jugadorDos, 100);
		Assert.assertEquals(capitalPagador - 100, Banco.getInstance().capital());
		Assert.assertEquals(capitalCobrador + 100, jugadorDos.capital());
		
		capitalPagador = Banco.getInstance().capital();
		capitalCobrador = jugadorTres.capital();
		Banco.getInstance().pagarA(jugadorTres, 100);
		Assert.assertEquals(capitalPagador - 100, Banco.getInstance().capital());
		Assert.assertEquals(capitalCobrador + 100, jugadorTres.capital());
	}

	@Test (expected = JugadorSinSaldoException.class)
	public void testJugadorSinSaldoSuficienteQuierePagarLanzaExcepcion(){
		Jugador jugadorUno = new JugadorUno("Jugador de Prueba 1");
		Jugador jugadorDos = new JugadorDos("Jugador de Prueba 2");

		jugadorUno.pagarA(Banco.getInstance(), 99999);
		Assert.assertEquals(1, jugadorUno.capital());
		
		jugadorUno.pagarA(jugadorDos, 100);
	}

	@Test
	public void testJugadorNoSeCobraASiMismo(){
		Jugador jugadorUno = new JugadorUno("Jugador de Prueba 1");
		Jugador jugadorDos = new JugadorDos("Jugador de Prueba 2");
		Jugador jugadorTres = new JugadorTres("Jugador de Prueba 3");

		jugadorUno.pagarA(Banco.getInstance(), 99999);
		Assert.assertEquals(1, jugadorUno.capital());
		
		jugadorDos.pagarA(Banco.getInstance(), 99999);
		Assert.assertEquals(1, jugadorDos.capital());
		
		jugadorTres.pagarA(Banco.getInstance(), 99999);
		Assert.assertEquals(1, jugadorTres.capital());

		
		int capitalInicial = jugadorUno.capital();
		jugadorUno.pagarA(jugadorUno, 100);
		Assert.assertEquals(capitalInicial, jugadorUno.capital());

		capitalInicial = jugadorDos.capital();
		jugadorDos.pagarA(jugadorDos, 100);
		Assert.assertEquals(capitalInicial, jugadorDos.capital());

		capitalInicial = jugadorTres.capital();
		jugadorTres.pagarA(jugadorTres, 100);
		Assert.assertEquals(capitalInicial, jugadorTres.capital());

		capitalInicial = Banco.getInstance().capital();
		Banco.getInstance().pagarA(Banco.getInstance(), 100);
		Assert.assertEquals(capitalInicial, Banco.getInstance().capital());
}

	@Test
	public void testJugadorAgregarCompania(){
		Jugador unJugador = new JugadorUno("Jugador de Prueba");

		Compania aysa = new Aysa(unJugador);
		unJugador.agregarCompania(aysa);
		List<Compania> companias = unJugador.obtenerCompanias();
		Assert.assertTrue(companias.contains(aysa));
		
		Compania edesur = new Edesur(unJugador);
		unJugador.agregarCompania(edesur);
		companias = unJugador.obtenerCompanias();
		Assert.assertTrue(companias.contains(aysa));
		Assert.assertTrue(companias.contains(edesur));
	}

	@Test
	public void testtestJugadorQuitarCompania(){
		Jugador unJugador = new JugadorUno("Jugador de Prueba");

		Compania aysa = new Aysa(unJugador);
		unJugador.agregarCompania(aysa);

		Compania edesur = new Edesur(unJugador);
		unJugador.agregarCompania(edesur);

		unJugador.quitarCompania(aysa);
		List<Compania> companias = unJugador.obtenerCompanias();
		Assert.assertFalse(companias.contains(aysa));
		Assert.assertTrue(companias.contains(edesur));
	}

	@Test
	public void testJugadorAgregarBarrio(){
		Jugador unJugador = new JugadorUno("Jugador de Prueba");

		Barrio tucuman = new BarrioTucuman(unJugador);
		unJugador.agregarBarrio(tucuman);
		List<Barrio> companias = unJugador.obtenerBarrios();
		Assert.assertTrue(companias.contains(tucuman));
		
		Barrio neuquen = new BarrioNeuquen(unJugador);
		unJugador.agregarBarrio(neuquen);
		companias = unJugador.obtenerBarrios();
		Assert.assertTrue(companias.contains(tucuman));
		Assert.assertTrue(companias.contains(neuquen));
	}

	@Test
	public void testJugadorQuitarBarrio(){
		Jugador unJugador = new JugadorUno("Jugador de Prueba");

		Barrio tucuman = new BarrioTucuman(unJugador);
		unJugador.agregarBarrio(tucuman);
		
		Barrio neuquen = new BarrioNeuquen(unJugador);
		unJugador.agregarBarrio(neuquen);

		unJugador.quitarBarrio(tucuman);
		List<Barrio> companias = unJugador.obtenerBarrios();
		Assert.assertFalse(companias.contains(tucuman));
		Assert.assertTrue(companias.contains(neuquen));
	}

	@Test
	public void testJugadorObtenerCantidadDePosicionesSumatoriaDeBarriosYCompanias(){
		Jugador unJugador = new JugadorUno("Jugador de Prueba");
		Assert.assertEquals(0, unJugador.cantidadPosesiones());
		
		unJugador.agregarBarrio(new BarrioTucuman(unJugador));
		unJugador.agregarBarrio(new BarrioNeuquen(unJugador));
		Assert.assertEquals(2, unJugador.cantidadPosesiones());

		unJugador.agregarCompania(new Aysa(unJugador));
		unJugador.agregarCompania(new Edesur(unJugador));
		Assert.assertEquals(4, unJugador.cantidadPosesiones());
	}

	@Test
	public void testJugadorObtenerCantidadDePropiedadesLosTerrenosCasasYHoteles(){
		Jugador unJugador = new JugadorUno("Jugador de Prueba");

		Barrio tucuman = new BarrioTucuman(unJugador);
		unJugador.agregarBarrio(tucuman);
		Barrio neuquen = new BarrioNeuquen(unJugador);
		unJugador.agregarBarrio(neuquen);

		Assert.assertEquals(2, unJugador.cantidadPropiedades());
		tucuman.construir();
		neuquen.construir();
		Assert.assertEquals(2, unJugador.cantidadPropiedades());
		
		
		Banco.getInstance().pagarA(unJugador, 100000); /*Se agrega capital para poder comprar y construir*/
		
		Barrio bsAsSur = new BarrioBuenosAiresSur(unJugador);
		unJugador.agregarBarrio(bsAsSur);
		Barrio bsAsNorte = new BarrioBuenosAiresNorte(unJugador);
		unJugador.agregarBarrio(bsAsNorte);
		Assert.assertEquals(4, unJugador.cantidadPropiedades());
		
		bsAsSur.construir();
		bsAsSur.construir();
		bsAsNorte.construir();
		bsAsNorte.construir();
		
		Assert.assertEquals(6, unJugador.cantidadPropiedades());
	}

	@Test
	public void testJugadorObtenerPosicion(){
		Jugador unJugador = new JugadorUno("Jugador de Prueba");
		PosicionTablero posicion = unJugador.obtenerPosicion();
		
		Assert.assertNotNull(posicion);
	}

	@Test
	public void testJugadorCambiarPosicion(){
		Jugador unJugador = new JugadorUno("Jugador de Prueba");
		Assert.assertEquals(1, unJugador.obtenerPosicion().getPosicion());

		PosicionTablero posicion = new PosicionTablero (15);
		unJugador.cambiarPosicion(posicion);
		Assert.assertEquals(15, unJugador.obtenerPosicion().getPosicion());		
	}

	@Test
	public void testJugadorSeMueveUnaCantidadDePosiciones(){
		Jugador unJugador = new JugadorUno("Jugador de Prueba");
		
		PosicionTablero posicionInicial = unJugador.obtenerPosicion();
		unJugador.mover(10);
		PosicionTablero posicionFinal = unJugador.obtenerPosicion();
		
		Assert.assertEquals(posicionInicial.getPosicion() + 10, posicionFinal.getPosicion());
	}

	@Test
	public void testJugadorCambiarTipoDeMovimiento(){
		Jugador unJugador = new JugadorUno("Jugador de Prueba");
		PosicionTablero posicionInicial = new PosicionTablero(1);

		unJugador.cambiarPosicion(posicionInicial);
		unJugador.mover(10);
		Assert.assertEquals(posicionInicial.getPosicion() + 10, unJugador.obtenerPosicion().getPosicion());

		TipoMovimiento tipoMov = new MovimientoEncarcelado();
		unJugador.cambiarPosicion(posicionInicial);
		unJugador.cambiarTipoDeMovimiento(tipoMov);
		unJugador.mover(10);
		Assert.assertFalse(posicionInicial.getPosicion() + 10 == unJugador.obtenerPosicion().getPosicion());
		Assert.assertEquals(posicionInicial.getPosicion(), unJugador.obtenerPosicion().getPosicion());
		
		tipoMov = new MovimientoTiradaMenosDos();
		((MovimientoTiradaMenosDos) tipoMov).setDireccion(MovimientoDesplazamietoDinamico.direccionAvance);
		unJugador.cambiarPosicion(posicionInicial);
		unJugador.cambiarTipoDeMovimiento(tipoMov);
		unJugador.mover(10);
		Assert.assertFalse(posicionInicial.getPosicion() + 10 == unJugador.obtenerPosicion().getPosicion());
		Assert.assertEquals(posicionInicial.getPosicion() + (10 - 2), unJugador.obtenerPosicion().getPosicion());
	}

}
