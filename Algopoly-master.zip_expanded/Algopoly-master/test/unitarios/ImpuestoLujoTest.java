package unitarios;

import org.junit.Assert;
import org.junit.Test;

import acciones.ImpuestoLujo;
import entidades.Jugador;
import entidades.JugadorConcreto;


public class ImpuestoLujoTest {

/***********************************************/
	
	@Test
	public void testAfectarAJugadorConImpuestoDeLujoChequeamosDineroRestante() {
		
		Jugador jugador = new JugadorConcreto ("Raul");
		ImpuestoLujo impuesto = new ImpuestoLujo ();
		impuesto.afectar(jugador);
		Assert.assertEquals (90000,jugador.capital());
		
	}

/***********************************************/	

}
