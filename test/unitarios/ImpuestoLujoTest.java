package unitarios;

import org.junit.Assert;
import org.junit.Test;

import acciones.ImpuestoLujo;
import entidades.Jugador;


public class ImpuestoLujoTest {

/***********************************************/
	
	@Test
	public void testAfectarAJugadorConImpuestoDeLujoChequeamosDineroRestante() {
		
		Jugador jugador = new Jugador ("Raul");
		ImpuestoLujo impuesto = new ImpuestoLujo ();
		impuesto.afectar(jugador);
		Assert.assertEquals (90000,jugador.capital());
		
	}

/***********************************************/	

}
