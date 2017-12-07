package unitarios;

import org.junit.Assert;
import org.junit.Test;

import modelo.entidades.JugadorUno;
import modelo.tablero.Comprable;
import modelo.tablero.comprables.CordobaNorteComprable;

public class CompraBarriosTest {

	@Test
	public void testVerificaCapitalDeJugadorTrasComprarBarrio() {
		JugadorUno unJugador = new JugadorUno("Jugador de Prueba");
		int capitalInicial = unJugador.capital();
		Comprable comprable = new CordobaNorteComprable();
		int precioDeCompra = comprable.precioDeCompra();
		comprable.comprar(unJugador);
		int capitalFinal = unJugador.capital();
		Assert.assertEquals(capitalFinal, capitalInicial - precioDeCompra);
	}

	@Test
	public void testVerificaCantidadDePropiedadesTrasComprarBarrio() {
		JugadorUno unJugador = new JugadorUno("Jugador de Prueba");
		Comprable comprable = new CordobaNorteComprable();
		comprable.comprar(unJugador);
		Assert.assertTrue(unJugador.obtenerBarrios().size() == 1);
	}
}
