package entrega1;

import org.junit.Assert;
import org.junit.Test;

import entidades.JugadorConcreto;
import propiedades.Terreno;
import tablero.Casilla;

public class CompraPropiedadTest {
	
	@Test
	public void testJugadorAdquierePropiedadEntoncesEsElDuenioDeEsaPropiedad() {
		
		Casilla terreno = new Terreno();
		JugadorConcreto jugador = new JugadorConcreto("Lucas");
		
		terreno.afectar(jugador);
		
		Assert.assertTrue(terreno.propietario() == jugador);		
		
	}
}
