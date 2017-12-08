package unitarios;

import org.junit.Assert;
import org.junit.Test;

import modelo.entidades.JugadorDos;
import modelo.entidades.JugadorUno;
import modelo.tablero.poseibles.barrios.Barrio;
import modelo.tablero.poseibles.barrios.BarrioTucuman;
import modelo.tablero.poseibles.barrios.construcciones.NadaParaConstruirException;

public class BarrioTucumanTest {

	@Test
	public void testSeCreaBarrioTucumanYSuPropietarioEsJugador() {
		JugadorUno unJugador = new JugadorUno("jugador");
		Barrio barrioTucuman = new BarrioTucuman(unJugador);
		Assert.assertEquals(unJugador, barrioTucuman.propietario());
	}

	@Test
	public void testSeCreaBarrioTucumanYCostoConstruccionEs7000() {
		JugadorUno unJugador = new JugadorUno("jugador");
		Barrio barrioTucuman = new BarrioTucuman(unJugador);
		Assert.assertTrue(barrioTucuman.costoConstruccion() == 7000);
	}
	
	@Test(expected = NadaParaConstruirException.class)
	public void testSeConstruyeUnEdificioYCostoConstruccionLanzaExcepcion() {
		JugadorUno unJugador = new JugadorUno("jugador");
		Barrio barrioTucuman = new BarrioTucuman(unJugador);
		barrioTucuman.construir();
		barrioTucuman.costoConstruccion();
	}

	@Test
	public void testSeConstruyeUnEdificioYCapitalDisminuyeEn7000() {
		JugadorUno unJugador = new JugadorUno("jugador");
		Barrio barrioTucuman = new BarrioTucuman(unJugador);
		int capitalInicial = unJugador.capital();
		barrioTucuman.construir();
		Assert.assertTrue((capitalInicial - 7000) == unJugador.capital());
	}

	@Test
	public void testSeConstruyeUnEdificioYCostoDeAlquilerEs4500() {
		//Construccion Actual Es Edificio
		JugadorUno unJugador = new JugadorUno("jugadorUno");
		JugadorDos otroJugador = new JugadorDos("jugadorDos");
		Barrio barrioTucuman = new BarrioTucuman(unJugador);
		barrioTucuman.construir();
		int capitalInicial = otroJugador.capital();
		barrioTucuman.afectar(otroJugador);
		Assert.assertTrue((capitalInicial - 4500) == otroJugador.capital());
	}
	
	@Test
	public void testSeCreaUnBarrioTucumanYCostoDeAlquilerEs2500() {
		//Construccion Actual Es Terreno
		JugadorUno unJugador = new JugadorUno("jugadorUno");
		JugadorDos otroJugador = new JugadorDos("jugadorDos");
		Barrio barrioTucuman = new BarrioTucuman(unJugador);
		int capitalInicial = otroJugador.capital();
		barrioTucuman.afectar(otroJugador);
		Assert.assertTrue((capitalInicial - 2500) == otroJugador.capital());
	}

	@Test
	public void testSeVendeUnEdificioYCapitalAumenta() {
		JugadorUno unJugador = new JugadorUno("jugador");
		Barrio barrioTucuman = new BarrioTucuman(unJugador);
		barrioTucuman.construir();
		int capitalInicial = unJugador.capital();
		barrioTucuman.venderConstruccion();
		Assert.assertTrue((capitalInicial + (7000 * 0.85)) == unJugador.capital());
	}

	@Test
	public void testBarrioTucumanConUnaCasaSeVendeElBarrioYElCapitalAumenta() {
		JugadorUno unJugador = new JugadorUno("jugador");
		Barrio barrioTucuman = new BarrioTucuman(unJugador);
		barrioTucuman.construir();
		int capitalInicial = unJugador.capital();
		barrioTucuman.vender();
		Assert.assertTrue((capitalInicial + (7000 + 25000) * 0.85) == unJugador.capital());
	}

	@Test
	public void testSeVendeElBarrioTucumanYElCapitalAumenta() {
		JugadorUno unJugador = new JugadorUno("jugador");
		Barrio barrioTucuman = new BarrioTucuman(unJugador);
		int capitalInicial = unJugador.capital();
		barrioTucuman.vender();
		Assert.assertTrue((capitalInicial + (25000 * 0.85)) == unJugador.capital());
	}

}
