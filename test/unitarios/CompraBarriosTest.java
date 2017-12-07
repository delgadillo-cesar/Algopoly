package unitarios;

import org.junit.Assert;
import org.junit.Test;

import modelo.entidades.JugadorDos;
import modelo.entidades.JugadorUno;
import modelo.tablero.Comprable;
import modelo.tablero.comprables.CordobaNorteComprable;
import modelo.tablero.poseibles.BarrioYaHabiaSidoCompradoException;

public class CompraBarriosTest {

	@Test
	public void testVerificaCapitalDeJugadorTrasComprarBarrio() {
		JugadorUno unJugador = new JugadorUno ("Jugador de Prueba");
		int capitalInicial = unJugador.capital();
		Comprable comprable = new CordobaNorteComprable();
		int precioDeCompra = comprable.precioDeCompra();
		comprable.comprar(unJugador);
		int capitalFinal = unJugador.capital();
		Assert.assertEquals(capitalFinal, capitalInicial - precioDeCompra);
	}


	@Test
	public void testVerificaCantidadDePropiedadesTrasComprarBarrio() {
		JugadorUno unJugador = new JugadorUno ("Jugador de Prueba");
		Comprable comprable = new CordobaNorteComprable();
		comprable.comprar(unJugador);
		Assert.assertTrue(unJugador.obtenerBarrios().size() == 1);
	}


	@Test (expected = BarrioYaHabiaSidoCompradoException.class)
	public void testVerificaQueOtroJugadorNoPuedeComprarElMismoBarrio() {
		JugadorUno unJugador = new JugadorUno("Jugador uno");
		JugadorDos otroJugador = new JugadorDos("Jugador dos");
		Comprable comprable = new CordobaNorteComprable();
		comprable.comprar(unJugador);
		comprable.comprar(otroJugador);
	}
}
