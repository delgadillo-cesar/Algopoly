package unitarios;

import org.junit.Assert;
import org.junit.Test;

import modelo.entidades.Jugador;
import modelo.entidades.JugadorDos;
import modelo.entidades.JugadorUno;
import modelo.tablero.Casilla;
import modelo.tablero.Tablero;
import modelo.tablero.casillas.acciones.Policia;

public class PoliciaTest {

/***********************************************/	
	
	@Test
	public void test01JugadorCaeEnPoliciaYTerminaEnLaCarcel() {
		
		Jugador jugadorPrueba = new JugadorUno ("Jugador de prueba");
		Jugador jugadorReferencia = new JugadorDos ("Jugador de referencia");
		Casilla policia = new Policia ();
		Tablero tablero = Tablero.getInstance();

		tablero.desplazar(jugadorReferencia,"CARCEL");
		
		tablero.desplazar(jugadorPrueba,"POLICIA");
		policia.afectar(jugadorPrueba);	
		Assert.assertEquals(jugadorReferencia.obtenerPosicion().getPosicion(), jugadorPrueba.obtenerPosicion().getPosicion());
		
	}

/***********************************************/	
	
}
