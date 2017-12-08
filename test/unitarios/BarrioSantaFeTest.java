package unitarios;

import org.junit.Assert;
import org.junit.Test;

import modelo.entidades.JugadorDos;
import modelo.entidades.JugadorUno;
import modelo.tablero.poseibles.barrios.Barrio;
import modelo.tablero.poseibles.barrios.BarrioSantaFe;
import modelo.tablero.poseibles.barrios.construcciones.NadaParaConstruirException;

public class BarrioSantaFeTest {

	@Test
	public void testSeCreaBarrioSantaFeYSuPropietarioEsJugador() {
		JugadorUno unJugador = new JugadorUno("jugador");
		Barrio barrioSantaFe = new BarrioSantaFe(unJugador);
		Assert.assertEquals(unJugador, barrioSantaFe.propietario());
	}

	@Test
	public void testSeCreaBarrioSantaFeYCostoConstruccionEs4000() {
		JugadorUno unJugador = new JugadorUno("jugador");
		Barrio barrioSantaFe = new BarrioSantaFe(unJugador);
		Assert.assertTrue(barrioSantaFe.costoConstruccion() == 4000);
	}
	
	@Test(expected = NadaParaConstruirException.class)
	public void testSeConstruyeUnEdificioYCostoConstruccionLanzaExcepcion() {
		JugadorUno unJugador = new JugadorUno("jugador");
		Barrio barrioSantaFe = new BarrioSantaFe(unJugador);
		barrioSantaFe.construir();
		barrioSantaFe.costoConstruccion();
	}

	@Test
	public void testSeConstruyeUnEdificioYCapitalDisminuyeEn4000() {
		JugadorUno unJugador = new JugadorUno("jugador");
		Barrio barrioSantaFe = new BarrioSantaFe(unJugador);
		int capitalInicial = unJugador.capital();
		barrioSantaFe.construir();
		Assert.assertTrue((capitalInicial - 4000) == unJugador.capital());
	}

	@Test
	public void testSeConstruyeUnEdificioYCostoDeAlquilerEs3500() {
		//Construccion Actual Es Edificio
		JugadorUno unJugador = new JugadorUno("jugadorUno");
		JugadorDos otroJugador = new JugadorDos("jugadorDos");
		Barrio barrioSantaFe = new BarrioSantaFe(unJugador);
		barrioSantaFe.construir();
		int capitalInicial = otroJugador.capital();
		barrioSantaFe.afectar(otroJugador);
		Assert.assertTrue((capitalInicial - 3500) == otroJugador.capital());
	}
	
	@Test
	public void testSeCreaUnBarrioSantaFeYCostoDeAlquilerEs2500() {
		//Construccion Actual Es Terreno
		JugadorUno unJugador = new JugadorUno("jugadorUno");
		JugadorDos otroJugador = new JugadorDos("jugadorDos");
		Barrio barrioSantaFe = new BarrioSantaFe(unJugador);
		int capitalInicial = otroJugador.capital();
		barrioSantaFe.afectar(otroJugador);
		Assert.assertTrue((capitalInicial - 1500) == otroJugador.capital());
	}

	@Test
	public void testSeVendeUnEdificioYCapitalAumenta() {
		JugadorUno unJugador = new JugadorUno("jugador");
		Barrio barrioSantaFe = new BarrioSantaFe(unJugador);
		barrioSantaFe.construir();
		int capitalInicial = unJugador.capital();
		barrioSantaFe.venderConstruccion();
		Assert.assertTrue((capitalInicial + (4000 * 0.85)) == unJugador.capital());
	}

	@Test
	public void testBarrioSantaFeConUnaCasaSeVendeElBarrioYElCapitalAumenta() {
		JugadorUno unJugador = new JugadorUno("jugador");
		Barrio barrioSantaFe = new BarrioSantaFe(unJugador);
		barrioSantaFe.construir();
		int capitalInicial = unJugador.capital();
		barrioSantaFe.vender();
		Assert.assertTrue((capitalInicial + (4000 + 15000) * 0.85) == unJugador.capital());
	}

	@Test
	public void testSeVendeElBarrioSantaFeYElCapitalAumenta() {
		JugadorUno unJugador = new JugadorUno("jugador");
		Barrio barrioSantaFe = new BarrioSantaFe(unJugador);
		int capitalInicial = unJugador.capital();
		barrioSantaFe.vender();
		Assert.assertTrue((capitalInicial + (15000 * 0.85)) == unJugador.capital());
	}

}
