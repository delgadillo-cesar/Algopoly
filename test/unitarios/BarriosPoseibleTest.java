package unitarios;

import org.junit.Assert;
import org.junit.Test;

import modelo.entidades.JugadorDos;
import modelo.entidades.JugadorUno;
import modelo.tablero.poseibles.barrios.Barrio;
import modelo.tablero.poseibles.barrios.BarrioNeuquen;
import modelo.tablero.poseibles.barrios.construcciones.NadaParaConstruirException;
import modelo.tablero.poseibles.barrios.construcciones.Terreno;
import modelo.tablero.poseibles.barrios.construcciones.UnaCasa;

public class BarriosPoseibleTest {

	@Test
	public void testSeCreaUnBarrioYPropietarioEsJugador() {
		JugadorUno unJugador = new JugadorUno("jugador");
		Barrio barrio = new BarrioNeuquen(unJugador);
		Assert.assertEquals(unJugador, barrio.propietario());
	}

	@Test
	public void testSeCreaUnBarrioYCantidadDePropiedadesEsCero() {
		JugadorUno unJugador = new JugadorUno("jugador");
		Barrio barrio = new BarrioNeuquen(unJugador);
		Assert.assertEquals(1, barrio.cantidadDePropiedades());
	}

	@Test
	public void testSeCreaUnBarrioSeVendeYAumentaCapital() {
		JugadorUno unJugador = new JugadorUno("jugador");
		Barrio barrio = new BarrioNeuquen(unJugador);
		int capitalInicial = unJugador.capital();
		barrio.vender();
		Assert.assertTrue(capitalInicial < unJugador.capital());
	}

	@Test
	public void testSeConstruyeConstruccionYCantidadDePropiedadesEsUno() {
		JugadorUno unJugador = new JugadorUno("jugador");
		Barrio barrio = new BarrioNeuquen(unJugador);
		barrio.construir();
		Assert.assertEquals(1, barrio.cantidadDePropiedades());
	}

	@Test
	public void testSeConstruyeConstruccionYDisminuyeCapital() {
		JugadorUno unJugador = new JugadorUno("jugador");
		Barrio barrio = new BarrioNeuquen(unJugador);
		int capitalInicial = unJugador.capital();
		barrio.construir();
		Assert.assertTrue(capitalInicial > unJugador.capital());
	}

	@Test(expected = NadaParaConstruirException.class)
	public void testSeIntentaContruirMuchasVecesYTiraException() {
		JugadorUno unJugador = new JugadorUno("jugador");
		Barrio barrio = new BarrioNeuquen(unJugador);
		while (true) {
			barrio.construir();
		}
	}

	@Test(expected = NadaParaConstruirException.class)
	public void testSeConstruyeMuchasVecesYSePreguntaCostoDeConstruccionSiguienteYTiraException() {
		JugadorUno unJugador = new JugadorUno("jugador");
		Barrio barrio = new BarrioNeuquen(unJugador);
		while (true) {
			barrio.construir();
			barrio.costoConstruccion();
		}
	}

	@Test
	public void testNoSeConstruyeYSePreguntaCostoDeConstruccionSiguiente() {
		JugadorUno unJugador = new JugadorUno("jugador");
		Barrio barrio = new BarrioNeuquen(unJugador);
		Assert.assertTrue(barrio.costoConstruccion() > 0);
	}

	@Test
	public void testSeCreaBarrioYConstruccionActualEsTerreno() {
		JugadorUno unJugador = new JugadorUno("jugador");
		Barrio barrio = new BarrioNeuquen(unJugador);
		Assert.assertEquals(Terreno.class, barrio.construccionActual().getClass());
	}

	@Test
	public void testSeConstruyeYConstruccionActualEsUnaCasa() {
		JugadorUno unJugador = new JugadorUno("jugador");
		Barrio barrio = new BarrioNeuquen(unJugador);
		barrio.construir();
		Assert.assertEquals(UnaCasa.class, barrio.construccionActual().getClass());
	}

	@Test
	public void testAfectaAlJugadorDosYPierdeCapital() {
		JugadorUno jugadorUno = new JugadorUno("jugadorUno");
		JugadorDos jugadorDos = new JugadorDos("jugadorDos");
		Barrio barrio = new BarrioNeuquen(jugadorUno);
		int capitalInicial = jugadorDos.capital();
		barrio.afectar(jugadorDos);
		Assert.assertTrue(capitalInicial > jugadorDos.capital());
	}

	@Test
	public void testAfectaAlJugadorDosYJugadorUnoGanaCapital() {
		JugadorUno jugadorUno = new JugadorUno("jugadorUno");
		JugadorDos jugadorDos = new JugadorDos("jugadorDos");
		Barrio barrio = new BarrioNeuquen(jugadorUno);
		int capitalInicial = jugadorUno.capital();
		barrio.afectar(jugadorDos);
		Assert.assertTrue(capitalInicial < jugadorUno.capital());
	}

	@Test
	public void testSeCreaBarrioYNoSePuedeVenderConstruccion() {
		JugadorUno unJugador = new JugadorUno("jugador");
		Barrio barrio = new BarrioNeuquen(unJugador);
		Assert.assertFalse(barrio.sePuedeVenderConstruccion());
	}

	@Test
	public void testSeCreaBarrioSeConstruyeYSePuedeVenderConstruccion() {
		JugadorUno unJugador = new JugadorUno("jugador");
		Barrio barrio = new BarrioNeuquen(unJugador);
		barrio.construir();
		Assert.assertTrue(barrio.sePuedeVenderConstruccion());
	}

	@Test
	public void testSeCreaBarrioSeConstruyeSeVendeConstruccionYAumentaCapital() {
		JugadorUno unJugador = new JugadorUno("jugador");
		Barrio barrio = new BarrioNeuquen(unJugador);
		barrio.construir();
		int capitalInicial = unJugador.capital();
		barrio.venderConstruccion();
		Assert.assertTrue(capitalInicial < unJugador.capital());
	}
}
