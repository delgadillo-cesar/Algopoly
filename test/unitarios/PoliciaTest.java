package unitarios;

import org.junit.Assert;
import org.junit.Test;
import entidades.Jugador;
import tablero.Casilla;
import tablero.Tablero;
import acciones.Policia;

public class PoliciaTest {

/***********************************************/	
	
	@Test
	public void test01JugadorCaeEnPoliciaYTerminaEnLaCarcel() {
		
		Jugador jugadorPrueba = new Jugador ("Jugador de prueba");
		Jugador jugadorReferencia = new Jugador ("Jugador de referencia");
		Casilla policia = new Policia ();
		Tablero tablero = Tablero.getInstance();

		tablero.desplazar(jugadorReferencia,"CARCEL");
		
		tablero.desplazar(jugadorPrueba,"POLICIA");
		policia.afectar(jugadorPrueba);	
		Assert.assertEquals(jugadorReferencia.obtenerPosicion().getPosicion(), jugadorPrueba.obtenerPosicion().getPosicion());
		
	}

/***********************************************/	
	
}
