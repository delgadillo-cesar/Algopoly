package unitarios;

import org.junit.Assert;
import org.junit.Test;

import modelo.entidades.Jugador;
import modelo.entidades.JugadorUno;
import modelo.tablero.acciones.ImpuestoLujo;

public class ImpuestoLujoTest {

	/***********************************************/

	@Test
	public void testAfectarAJugadorConImpuestoDeLujoChequeamosDineroRestante() {

		Jugador jugador = new JugadorUno("Raul");
		ImpuestoLujo impuesto = new ImpuestoLujo();
		impuesto.afectar(jugador);
		Assert.assertEquals(90000, jugador.capital());

	}

	/***********************************************/

}
