package unitarios;

import org.junit.Assert;
import org.junit.Test;

import modelo.entidades.JugadorUno;
import modelo.tablero.casillas.acciones.Quini;

public class QuiniTest {

	/***********************************************/

	@Test
	public void test01CaenEnQuiniYCapitalSeIncrementaEn50000() {

		JugadorUno jugador = new JugadorUno("Jose PEPE Argento");
		Quini quini6 = new Quini();
		quini6.afectar(jugador);
		Assert.assertEquals(150000, jugador.capital());

	}

	/***********************************************/

	@Test
	public void test02CaenEnQuiniPorSegundaVezYCapitalSeIncrementaEn30000() {

		JugadorUno jugador = new JugadorUno("Jose PEPE Argento");
		Quini quini6 = new Quini();
		quini6.afectar(jugador);
		quini6.afectar(jugador);
		Assert.assertEquals(180000, jugador.capital());

	}

	/***********************************************/

	@Test
	public void test03CaenEnQuiniPorTerceraVezYCapitalNoSeIncrementa() {

		JugadorUno jugador = new JugadorUno("Jose PEPE Argento");
		Quini quini6 = new Quini();
		quini6.afectar(jugador);
		quini6.afectar(jugador);
		quini6.afectar(jugador);
		Assert.assertEquals(180000, jugador.capital());

	}

	/***********************************************/

}
