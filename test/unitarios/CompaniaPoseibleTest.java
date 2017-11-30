package unitarios;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import modelo.entidades.Banco;
import modelo.entidades.Jugador;
import modelo.entidades.JugadorDos;
import modelo.entidades.JugadorUno;
import modelo.juego.Dados;
import modelo.tablero.Casilla;
import modelo.tablero.casillas.poseibles.Aysa;
import modelo.tablero.casillas.poseibles.Compania;
import modelo.tablero.casillas.poseibles.Edesur;
import modelo.tablero.casillas.poseibles.Subte;
import modelo.tablero.casillas.poseibles.Tren;

public class CompaniaPoseibleTest {

	Jugador propietario;
	
	@Before
	public void setUp() throws Exception {
		propietario = new JugadorUno("Jugador de prueba");
	}
	
	@Test
	public void test01CrearCompanias() {
		Compania unaCompania = new Aysa(propietario);
		Assert.assertNotNull(unaCompania);
		
		unaCompania = new Edesur(propietario);
		Assert.assertNotNull(unaCompania);
		
		unaCompania = new Subte(propietario);
		Assert.assertNotNull(unaCompania);
		
		unaCompania = new Tren(propietario);
		Assert.assertNotNull(unaCompania);
	}
/*	
	@Test
	public void test03CompaniaPrecioDeCompra() {
		Compania unaCompania = new Aysa(propietario);
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
*/
	@Test
	public void test05CompaniaObtenerPropietario() {
		Compania unaCompania = new Aysa(propietario);
				
		Assert.assertEquals(propietario, unaCompania.propietario());
	}	
	
	@Test
	public void test06CompaniaConPropietarioAfectaJugadorDebePagarAlPropietario() {
		Jugador unPropietario = new JugadorUno("Propietario de prueba");
		Jugador unJugador = new JugadorDos("Jugador de prueba");
		int capitalPropietario, capitalJugador, variacionPropietario, variacionJugador;

		Casilla unaCompania = new Aysa(unPropietario);
		
		capitalPropietario = unPropietario.capital();
		capitalJugador = unJugador.capital();
		
		unaCompania.afectar(unJugador); /*Le paga al propietario*/
		variacionPropietario = unPropietario.capital() - capitalPropietario;
		variacionJugador = capitalJugador - unJugador.capital();
		
		Assert.assertEquals(variacionPropietario, variacionJugador);
	}

	@Test
	public void test07CompaniaPropietarioCaeEnSuPropiaCompaniaAfectaJugadorNoLeCobra() {
		Jugador unPropietario = new JugadorUno("Propietario de prueba");
		Casilla unaCompania = new Aysa(propietario);
		int capitalInicial = unPropietario.capital();

		unaCompania.afectar(unPropietario);
		Assert.assertEquals(capitalInicial, unPropietario.capital());
		
		/*Sin capital*/
		unPropietario.pagarA(Banco.getInstance(), unPropietario.capital());
		Assert.assertEquals(0, unPropietario.capital());

		unaCompania.afectar(unPropietario);
		Assert.assertEquals(0, unPropietario.capital());
	}

/*
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

		Compania unaCompania = new Tren();
		unaCompania.afectar(unJugador);

		Assert.assertEquals((capitalInicial - 38000), unJugador.capital());
	}
*/
	@Test
	public void test12CompaniaAysaCobra300VecesLosDados() {
		Jugador unJugador = new JugadorDos("Jugador de prueba");
		Dados losDados = Dados.getInstance();
		int capitalInicial = unJugador.capital();
		int valorACobrar;

		Compania unaCompania = new Aysa(propietario);
		
		losDados.lanzarDados();
		valorACobrar = 300 * losDados.getValor();
		unaCompania.afectar(unJugador); /*Le paga al propietario*/
		
		Assert.assertEquals(capitalInicial - valorACobrar, unJugador.capital());
	}

	@Test
	public void test13CompaniaAysaPropietarioTieneEdesurCobra500VecesLosDados() {
		Jugador unJugador = new JugadorDos("Jugador de prueba");
		Dados losDados = Dados.getInstance();
		int capitalInicial = unJugador.capital();
		int valorACobrar;

		Compania unaCompania = new Edesur(propietario);
		unaCompania = new Aysa(propietario);
		
		losDados.lanzarDados();
		valorACobrar = 500 * losDados.getValor();
		unaCompania.afectar(unJugador); /*Le paga al propietario*/
		
		Assert.assertEquals(capitalInicial - valorACobrar, unJugador.capital());
	}

	@Test
	public void test14CompaniaEdesurCobra500VecesLosDados() {
		Jugador unJugador = new JugadorDos("Jugador de prueba");
		Dados losDados = Dados.getInstance();
		int capitalInicial = unJugador.capital();
		int valorACobrar;

		Compania unaCompania = new Edesur(propietario);
		
		losDados.lanzarDados();
		valorACobrar = 500 * losDados.getValor();
		unaCompania.afectar(unJugador); /*Le paga al propietario*/
		
		Assert.assertEquals(capitalInicial - valorACobrar, unJugador.capital());
	}

	@Test
	public void test15CompaniaEdesurPropietarioTieneAysaCobra1000VecesLosDados() {
		Jugador unPropietario = new JugadorUno("Propietario de prueba");
		Jugador unJugador = new JugadorDos("Jugador de prueba");
		Dados losDados = Dados.getInstance();
		int capitalInicial = unJugador.capital();
		int valorACobrar;

		Compania unaCompania = new Aysa(unPropietario);
		unaCompania = new Edesur(unPropietario);
		
		losDados.lanzarDados();
		valorACobrar = 1000 * losDados.getValor();
		unaCompania.afectar(unJugador); /*Le paga al propietario*/
		
		Assert.assertEquals(capitalInicial - valorACobrar, unJugador.capital());
	}

	@Test
	public void test16CompaniaSubteCobra600VecesLosDados() {
		Jugador unJugador = new JugadorDos("Jugador de prueba");
		Dados losDados = Dados.getInstance();
		int capitalInicial = unJugador.capital();
		int valorACobrar;

		Compania unaCompania = new Subte(propietario);
		
		losDados.lanzarDados();
		valorACobrar = 600 * losDados.getValor();
		unaCompania.afectar(unJugador); /*Le paga al propietario*/
		
		Assert.assertEquals(capitalInicial - valorACobrar, unJugador.capital());
	}

	@Test
	public void test17CompaniaSubtePropietarioTieneTrenesCobra1100VecesLosDados() {
		Jugador unJugador = new JugadorDos("Jugador de prueba");
		Dados losDados = Dados.getInstance();
		int capitalInicial = unJugador.capital();
		int valorACobrar;

		Compania unaCompania = new Tren(propietario);
		unaCompania = new Subte(propietario);
		
		losDados.lanzarDados();
		valorACobrar = 1100 * losDados.getValor();
		unaCompania.afectar(unJugador); /*Le paga al propietario*/
		
		Assert.assertEquals(capitalInicial - valorACobrar, unJugador.capital());
	}

	@Test
	public void test18CompaniaTrenesCobra450VecesLosDados() {
		Jugador unJugador = new JugadorDos("Jugador de prueba");
		Dados losDados = Dados.getInstance();
		int capitalInicial = unJugador.capital();
		int valorACobrar;

		Compania unaCompania = new Tren(propietario);
		
		losDados.lanzarDados();
		valorACobrar = 450 * losDados.getValor();
		unaCompania.afectar(unJugador); /*Le paga al propietario*/
		
		Assert.assertEquals(capitalInicial - valorACobrar, unJugador.capital());
	}

	@Test
	public void test19CompaniaTrenesPropietarioTieneSubteCobra800VecesLosDados() {
		Jugador unJugador = new JugadorDos("Jugador de prueba");
		Dados losDados = Dados.getInstance();
		int capitalInicial = unJugador.capital();
		int valorACobrar;

		Compania unaCompania = new Subte(propietario);
		unaCompania = new Tren(propietario);
		
		losDados.lanzarDados();
		valorACobrar = 800 * losDados.getValor();
		unaCompania.afectar(unJugador); /*Le paga al propietario*/
		
		Assert.assertEquals(capitalInicial - valorACobrar, unJugador.capital());
	}
}
