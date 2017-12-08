package unitarios;

import org.junit.Assert;
import org.junit.Test;

import modelo.entidades.JugadorDos;
import modelo.entidades.JugadorUno;
import modelo.tablero.comprables.NeuquenComprable;
import modelo.tablero.poseibles.barrios.Barrio;
import modelo.tablero.poseibles.barrios.BarrioNeuquen;
import modelo.tablero.poseibles.barrios.construcciones.NadaParaConstruirException;

public class BarrioNeuquenTest {

	@Test
	public void testSeCreaBarrioNeuquenYSuPropietarioEsJugador() {
		JugadorUno unJugador = new JugadorUno("jugador");
		unJugador.comprarPropiedad(new NeuquenComprable());
		Barrio barrioNeuquen = new BarrioNeuquen(unJugador);
		Assert.assertEquals(unJugador, barrioNeuquen.propietario());
	}

	@Test
	public void testSeCreaBarrioNeuquenYCostoConstruccionEs4800() {
		JugadorUno unJugador = new JugadorUno("jugador");
		unJugador.comprarPropiedad(new NeuquenComprable());
		Barrio barrioNeuquen = new BarrioNeuquen(unJugador);
		Assert.assertTrue(barrioNeuquen.costoConstruccion() == 4800);
	}
	
	@Test(expected = NadaParaConstruirException.class)
	public void testSeConstruyeUnaCasaYCostoConstruccionLanzaExcepcion() {
		JugadorUno unJugador = new JugadorUno("jugador");
		unJugador.comprarPropiedad(new NeuquenComprable());
		Barrio barrioNeuquen = new BarrioNeuquen(unJugador);
		barrioNeuquen.construir();
		barrioNeuquen.costoConstruccion();
	}

	@Test
	public void testSeConstruyeUnaCasaYCapitalDisminuyeEn4800() {
		JugadorUno unJugador = new JugadorUno("jugador");
		unJugador.comprarPropiedad(new NeuquenComprable());
		Barrio barrioNeuquen = new BarrioNeuquen(unJugador);
		int capitalInicial = unJugador.capital();
		barrioNeuquen.construir();
		Assert.assertTrue((capitalInicial - 4800) == unJugador.capital());
	}

	@Test
	public void testSeConstruyeUnaCasaYCostoDeAlquilerEs3800() {
		//Construccion Actual Es UnaCasa
		JugadorUno unJugador = new JugadorUno("jugadorUno");
		unJugador.comprarPropiedad(new NeuquenComprable());
		JugadorDos otroJugador = new JugadorDos("jugadorDos");
		Barrio barrioNeuquen = new BarrioNeuquen(unJugador);
		barrioNeuquen.construir();
		int capitalInicial = otroJugador.capital();
		barrioNeuquen.afectar(otroJugador);
		Assert.assertTrue((capitalInicial - 3800) == otroJugador.capital());
	}
	
	@Test
	public void testSeCreaUnBarrioNeuquenYCostoDeAlquilerEs1800() {
		//Construccion Actual Es Terreno
		JugadorUno unJugador = new JugadorUno("jugadorUno");
		unJugador.comprarPropiedad(new NeuquenComprable());
		JugadorDos otroJugador = new JugadorDos("jugadorDos");
		Barrio barrioNeuquen = new BarrioNeuquen(unJugador);
		int capitalInicial = otroJugador.capital();
		barrioNeuquen.afectar(otroJugador);
		Assert.assertTrue((capitalInicial - 1800) == otroJugador.capital());
	}

	@Test
	public void testSeVendeUnaCasaYCapitalAumenta() {
		JugadorUno unJugador = new JugadorUno("jugador");
		unJugador.comprarPropiedad(new NeuquenComprable());
		Barrio barrioNeuquen = new BarrioNeuquen(unJugador);
		barrioNeuquen.construir();
		int capitalInicial = unJugador.capital();
		barrioNeuquen.venderConstruccion();
		Assert.assertTrue((capitalInicial + (4800 * 0.85)) == unJugador.capital());
	}

	@Test
	public void testBarrioNeuquenConUnaCasaSeVendeElBarrioYElCapitalAumenta() {
		JugadorUno unJugador = new JugadorUno("jugador");
		Barrio barrioNeuquen = new BarrioNeuquen(unJugador);
		barrioNeuquen.construir();
		int capitalInicial = unJugador.capital();
		barrioNeuquen.vender();
		Assert.assertTrue((capitalInicial + (4800 + 17000) * 0.85) == unJugador.capital());
	}

	@Test
	public void testSeVendeElBarrioNeuquenYElCapitalAumenta() {
		JugadorUno unJugador = new JugadorUno("jugador");
		unJugador.comprarPropiedad(new NeuquenComprable());
		Barrio barrioNeuquen = new BarrioNeuquen(unJugador);
		int capitalInicial = unJugador.capital();
		barrioNeuquen.vender();
		Assert.assertTrue((capitalInicial + (17000 * 0.85)) == unJugador.capital());
	}

}
