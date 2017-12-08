package unitarios;

import org.junit.Assert;
import org.junit.Test;

import modelo.entidades.JugadorDos;
import modelo.entidades.JugadorUno;
import modelo.tablero.PosicionTablero;
import modelo.tablero.Tablero;
import modelo.tablero.comprables.SaltaNorteComprable;
import modelo.tablero.comprables.SaltaSurComprable;
import modelo.tablero.poseibles.barrios.Barrio;
import modelo.tablero.poseibles.barrios.BarrioSaltaNorte;
import modelo.tablero.poseibles.barrios.BarrioSaltaSur;
import modelo.tablero.poseibles.barrios.construcciones.NadaParaConstruirException;

public class BarrioSaltaSurTest {

	@Test
	public void testSeCreaBarrioSaltaSurYSuPropietarioEsJugador() {
		JugadorUno unJugador = new JugadorUno("jugador");
		Barrio barrioSaltaSur = new BarrioSaltaSur(unJugador);
		Assert.assertEquals(unJugador, barrioSaltaSur.propietario());
	}

	@Test(expected = NadaParaConstruirException.class)
	public void testSeCreaBarrioSaltaSurYCostoConstruccionLanzaExcepcion() {
		JugadorUno unJugador = new JugadorUno("jugador");
		Barrio barrioSaltaSur = new BarrioSaltaSur(unJugador);
		barrioSaltaSur.costoConstruccion();
	}

	@Test
	public void testSeCreaBarrioSaltaSurYSaltaNorteYCostoConstruccionEs4500() {
		JugadorUno unJugador = new JugadorUno("jugador");
		unJugador.comprarPropiedad(new SaltaSurComprable());
		unJugador.comprarPropiedad(new SaltaNorteComprable());
		Barrio barrioSaltaSur = new BarrioSaltaSur(unJugador);
		Barrio barrioSaltaNorte = new BarrioSaltaNorte(unJugador);
		Assert.assertTrue(barrioSaltaSur.costoConstruccion() == 4500);
	}

	@Test
	public void testSeCreaBarrioSaltaSurYSaltaNorteSeConstruyeUnaCasaYCostoConstruccionEs4500() {
		JugadorUno unJugador = new JugadorUno("jugador");
		unJugador.comprarPropiedad(new SaltaSurComprable());
		unJugador.comprarPropiedad(new SaltaNorteComprable());
		Barrio barrioSaltaSur = new BarrioSaltaSur(unJugador);
		Barrio barrioSaltaNorte = new BarrioSaltaNorte(unJugador);
		barrioSaltaSur.construir();
		Assert.assertTrue(barrioSaltaSur.costoConstruccion() == 4500);
	}

	@Test(expected = NadaParaConstruirException.class)
	public void testSeConstruyenDosCasasYCostoConstruccionLanzaExcepcion() {
		JugadorUno unJugador = new JugadorUno("jugador");
		unJugador.comprarPropiedad(new SaltaSurComprable());
		unJugador.comprarPropiedad(new SaltaNorteComprable());
		Barrio barrioSaltaSur = new BarrioSaltaSur(unJugador);
		Barrio barrioSaltaNorte = new BarrioSaltaNorte(unJugador);
		barrioSaltaSur.construir();
		barrioSaltaSur.construir();
		barrioSaltaSur.costoConstruccion();
	}

	@Test
	public void testSeConstruyenDosCasasEnAmbosBarriosYCostoConstruccionEs7500() {
		JugadorUno unJugador = new JugadorUno("jugador");
		unJugador.comprarPropiedad(new SaltaSurComprable());
		unJugador.comprarPropiedad(new SaltaNorteComprable());
		Barrio barrioSaltaSur = (Barrio)Tablero.getInstance().obtenerCasilla(new PosicionTablero(15));
		Barrio barrioSaltaNorte = (Barrio)Tablero.getInstance().obtenerCasilla(new PosicionTablero(14));
		barrioSaltaSur.construir();
		barrioSaltaSur.construir();
		barrioSaltaNorte.construir();
		barrioSaltaNorte.construir();
		Assert.assertTrue(barrioSaltaSur.costoConstruccion() == 7500);
	}

	@Test(expected = NadaParaConstruirException.class)
	public void testSeConstruyenDosCasasYAlIntentarConstruirLanzaExcepcion() {
		JugadorUno unJugador = new JugadorUno("jugador");
		unJugador.comprarPropiedad(new SaltaSurComprable());
		unJugador.comprarPropiedad(new SaltaNorteComprable());
		Barrio barrioSaltaSur = new BarrioSaltaSur(unJugador);
		Barrio barrioSaltaNorte = new BarrioSaltaNorte(unJugador);
		barrioSaltaSur.construir();
		barrioSaltaSur.construir();
		barrioSaltaSur.construir();
	}

	@Test(expected = NadaParaConstruirException.class)
	public void testSeConstruyeUnhotelYAlIntentarConstruirLanzaExcepcion() {
		JugadorUno unJugador = new JugadorUno("jugador");
		unJugador.comprarPropiedad(new SaltaSurComprable());
		unJugador.comprarPropiedad(new SaltaNorteComprable());
		Barrio barrioSaltaSur = new BarrioSaltaSur(unJugador);
		Barrio barrioSaltaNorte = new BarrioSaltaNorte(unJugador);
		barrioSaltaSur.construir();
		barrioSaltaSur.construir();
		barrioSaltaNorte.construir();
		barrioSaltaNorte.construir();
		barrioSaltaSur.construir();
		barrioSaltaSur.construir();
	}

	@Test
	public void testSeConstruyeUnaCasaYCapitalDisminuyeEn4500() {
		JugadorUno unJugador = new JugadorUno("jugador");
		unJugador.comprarPropiedad(new SaltaSurComprable());
		unJugador.comprarPropiedad(new SaltaNorteComprable());
		Barrio barrioSaltaSur = new BarrioSaltaSur(unJugador);
		Barrio barrioSaltaNorte = new BarrioSaltaNorte(unJugador);
		int capitalInicial = unJugador.capital();
		barrioSaltaSur.construir();
		Assert.assertTrue((capitalInicial - 4500) == unJugador.capital());
	}

	@Test
	public void testSeConstruyenDosCasasYCapitalDisminuyeEn4500DespuesDeLaSegunda() {
		JugadorUno unJugador = new JugadorUno("jugador");
		unJugador.comprarPropiedad(new SaltaSurComprable());
		unJugador.comprarPropiedad(new SaltaNorteComprable());
		Barrio barrioSaltaSur = new BarrioSaltaSur(unJugador);
		Barrio barrioSaltaNorte = new BarrioSaltaNorte(unJugador);
		barrioSaltaSur.construir();
		int capitalInicial = unJugador.capital();
		barrioSaltaSur.construir();
		Assert.assertTrue((capitalInicial - 4500) == unJugador.capital());
	}

	@Test
	public void testSeConstruyeUnHotelYCapitalDisminuyeEn7500DespuesDelHotel() {
		JugadorUno unJugador = new JugadorUno("jugador");
		unJugador.comprarPropiedad(new SaltaSurComprable());
		unJugador.comprarPropiedad(new SaltaNorteComprable());
		Barrio barrioSaltaSur = (Barrio)Tablero.getInstance().obtenerCasilla(new PosicionTablero(15));
		Barrio barrioSaltaNorte = (Barrio)Tablero.getInstance().obtenerCasilla(new PosicionTablero(14));
		barrioSaltaSur.construir();
		barrioSaltaSur.construir();
		barrioSaltaNorte.construir();
		barrioSaltaNorte.construir();
		int capitalInicial = unJugador.capital();
		barrioSaltaSur.construir();
		Assert.assertTrue((capitalInicial - 7500) == unJugador.capital());
	}

	@Test
	public void testSeCreaUnBarrioSaltaSurYCostoDeAlquilerEs2000() {
		// Construccion Actual Es Terreno
		JugadorUno unJugador = new JugadorUno("jugadorUno");
		JugadorDos otroJugador = new JugadorDos("jugadorDos");
		Barrio barrioSaltaSur = new BarrioSaltaSur(unJugador);
		int capitalInicial = otroJugador.capital();
		barrioSaltaSur.afectar(otroJugador);
		Assert.assertTrue((capitalInicial - 2000) == otroJugador.capital());
	}

	@Test
	public void testSeConstruyeUnaCasaYCostoDeAlquilerEs3250() {
		// Construccion Actual Es UnaCasa
		JugadorUno unJugador = new JugadorUno("jugadorUno");
		JugadorDos otroJugador = new JugadorDos("jugadorDos");
		unJugador.comprarPropiedad(new SaltaSurComprable());
		unJugador.comprarPropiedad(new SaltaNorteComprable());
		Barrio barrioSaltaSur = new BarrioSaltaSur(unJugador);
		Barrio barrioSaltaNorte = new BarrioSaltaNorte(unJugador);
		barrioSaltaSur.construir();
		int capitalInicial = otroJugador.capital();
		barrioSaltaSur.afectar(otroJugador);
		Assert.assertTrue((capitalInicial - 3250) == otroJugador.capital());
	}

	@Test
	public void testSeConstruyenDosCasasYCostoDeAlquilerEs3850() {
		// Construccion Actual Es DosCasas
		JugadorUno unJugador = new JugadorUno("jugadorUno");
		JugadorDos otroJugador = new JugadorDos("jugadorDos");
		unJugador.comprarPropiedad(new SaltaSurComprable());
		unJugador.comprarPropiedad(new SaltaNorteComprable());
		Barrio barrioSaltaSur = new BarrioSaltaSur(unJugador);
		Barrio barrioSaltaNorte = new BarrioSaltaNorte(unJugador);
		barrioSaltaSur.construir();
		barrioSaltaSur.construir();
		int capitalInicial = otroJugador.capital();
		barrioSaltaSur.afectar(otroJugador);
		Assert.assertTrue((capitalInicial - 3850) == otroJugador.capital());
	}

	@Test
	public void testSeConstruyeUnHotelYCostoDeAlquilerEs5500() {
		// Construccion Actual Es DosCasas
		JugadorUno unJugador = new JugadorUno("jugadorUno");
		JugadorDos otroJugador = new JugadorDos("jugadorDos");
		unJugador.comprarPropiedad(new SaltaSurComprable());
		unJugador.comprarPropiedad(new SaltaNorteComprable());
		Barrio barrioSaltaSur = (Barrio)Tablero.getInstance().obtenerCasilla(new PosicionTablero(15));
		Barrio barrioSaltaNorte = (Barrio)Tablero.getInstance().obtenerCasilla(new PosicionTablero(14));
		barrioSaltaNorte.construir();
		barrioSaltaNorte.construir();
		barrioSaltaSur.construir();
		barrioSaltaSur.construir();
		barrioSaltaSur.construir();
		int capitalInicial = otroJugador.capital();
		barrioSaltaSur.afectar(otroJugador);
		Assert.assertTrue((capitalInicial - 5500) == otroJugador.capital());
	}

	@Test
	public void testSeVendeUnaCasaYCapitalAumenta() {
		JugadorUno unJugador = new JugadorUno("jugador");
		unJugador.comprarPropiedad(new SaltaSurComprable());
		unJugador.comprarPropiedad(new SaltaNorteComprable());
		Barrio barrioSaltaSur = new BarrioSaltaSur(unJugador);
		Barrio barrioSaltaNorte = new BarrioSaltaNorte(unJugador);
		barrioSaltaSur.construir();
		int capitalInicial = unJugador.capital();
		barrioSaltaSur.venderConstruccion();
		Assert.assertTrue((capitalInicial + (4500 * 0.85)) == unJugador.capital());
	}

	@Test
	public void testSeVendeSegundaCasaYCapitalAumenta() {
		JugadorUno unJugador = new JugadorUno("jugador");
		unJugador.comprarPropiedad(new SaltaSurComprable());
		unJugador.comprarPropiedad(new SaltaNorteComprable());
		Barrio barrioSaltaSur = new BarrioSaltaSur(unJugador);
		Barrio barrioSaltaNorte = new BarrioSaltaNorte(unJugador);
		barrioSaltaSur.construir();
		barrioSaltaSur.construir();
		int capitalInicial = unJugador.capital();
		barrioSaltaSur.venderConstruccion();
		Assert.assertTrue((capitalInicial + (4500 * 0.85)) == unJugador.capital());
	}

	@Test
	public void testSeVendeHotelaYCapitalAumenta() {
		JugadorUno unJugador = new JugadorUno("jugador");
		unJugador.comprarPropiedad(new SaltaSurComprable());
		unJugador.comprarPropiedad(new SaltaNorteComprable());
		Barrio barrioSaltaSur = (Barrio)Tablero.getInstance().obtenerCasilla(new PosicionTablero(15));
		Barrio barrioSaltaNorte = (Barrio)Tablero.getInstance().obtenerCasilla(new PosicionTablero(14));
		barrioSaltaNorte.construir();
		barrioSaltaNorte.construir();
		barrioSaltaSur.construir();
		barrioSaltaSur.construir();
		barrioSaltaSur.construir();
		int capitalInicial = unJugador.capital();
		barrioSaltaSur.venderConstruccion();
		Assert.assertTrue((capitalInicial + (7500 * 0.85)) == unJugador.capital());
	}

	@Test
	public void testBarrioSaltaSurConUnaCasaSeVendeElBarrioYElCapitalAumenta() {
		JugadorUno unJugador = new JugadorUno("jugador");
		unJugador.comprarPropiedad(new SaltaSurComprable());
		unJugador.comprarPropiedad(new SaltaNorteComprable());
		Barrio barrioSaltaSur = new BarrioSaltaSur(unJugador);
		Barrio barrioSaltaNorte = new BarrioSaltaNorte(unJugador);
		barrioSaltaSur.construir();
		int capitalInicial = unJugador.capital();
		barrioSaltaSur.vender();
		Assert.assertTrue((capitalInicial + (4500 + 23000) * 0.85) == unJugador.capital());
	}

	@Test
	public void testBarrioSaltaSurConHotelSeVendeElBarrioYElCapitalAumenta() {
		JugadorUno unJugador = new JugadorUno("jugador");
		unJugador.comprarPropiedad(new SaltaSurComprable());
		unJugador.comprarPropiedad(new SaltaNorteComprable());
		Barrio barrioSaltaSur = (Barrio)Tablero.getInstance().obtenerCasilla(new PosicionTablero(15));
		Barrio barrioSaltaNorte = (Barrio)Tablero.getInstance().obtenerCasilla(new PosicionTablero(14));
		barrioSaltaNorte.construir();
		barrioSaltaNorte.construir();
		barrioSaltaSur.construir();
		barrioSaltaSur.construir();
		barrioSaltaSur.construir();
		int capitalInicial = unJugador.capital();
		barrioSaltaSur.vender();
		Assert.assertTrue((capitalInicial + (7500 + 23000) * 0.85) == unJugador.capital());
	}

	@Test
	public void testBarrioSaltaSurConDosCasasSeVendeElBarrioYElCapitalAumenta() {
		JugadorUno unJugador = new JugadorUno("jugador");
		unJugador.comprarPropiedad(new SaltaSurComprable());
		unJugador.comprarPropiedad(new SaltaNorteComprable());
		Barrio barrioSaltaSur = new BarrioSaltaSur(unJugador);
		Barrio barrioSaltaNorte = new BarrioSaltaNorte(unJugador);
		barrioSaltaSur.construir();
		barrioSaltaSur.construir();
		int capitalInicial = unJugador.capital();
		barrioSaltaSur.vender();
		Assert.assertTrue((capitalInicial + (4500 + 4500 + 23000) * 0.85) == unJugador.capital());
	}

	@Test
	public void testSeVendeElBarrioSaltaSurYElCapitalAumenta() {
		JugadorUno unJugador = new JugadorUno("jugador");
		Barrio barrioSaltaSur = new BarrioSaltaSur(unJugador);
		int capitalInicial = unJugador.capital();
		barrioSaltaSur.vender();
		Assert.assertTrue((capitalInicial + (23000 * 0.85)) == unJugador.capital());
	}

}
