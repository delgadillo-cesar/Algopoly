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
		
		Jugador jugador = new Jugador ("Jose PEPE Argento");
		Casilla policia = new Policia ();
		Tablero tablero = Tablero.getInstance();
		tablero.desplazar(jugador,"POLICIA");
		policia.afectar(jugador);	
		Assert.assertEquals(6,tablero.casillaDeJugador(jugador));
		
	}

/***********************************************/	
	
}
