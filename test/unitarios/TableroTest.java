package unitarios;

import org.junit.Assert;
import org.junit.Test;

import entidades.Jugador;
import entidades.JugadorConcreto;
import tablero.Tablero;

public class TableroTest {

	@Test
	public void testObtenerTableroNoDevuelveNull() {
		
		Tablero.resetear();
		Tablero tablero = Tablero.getInstance();
		
		Assert.assertNotNull(tablero);
	}
	
	@Test
	public void testDesplazarJugadorUnaCasillaHaciaAdelanteLoDesplazaCorrectamente() {
		
		Tablero.resetear();
		Tablero tablero = Tablero.getInstance();
		Jugador jugador = new JugadorConcreto("Pepe");
		tablero.desplazar(jugador, "SALIDA");
		
		tablero.desplazar(jugador, 1);
		
		int casillaActual = tablero.casillaDeJugador(jugador);
		Assert.assertEquals(casillaActual, 2);
		
	}
	
	@Test
	public void testDesplazarJugadorveintiunCasillasHaciaAdelanteLoDesplazaCorrectamente() {
		
		Tablero.resetear();
		Tablero tablero = Tablero.getInstance();
		Jugador jugador = new JugadorConcreto("Pepe");
		tablero.desplazar(jugador, "SALIDA");
		
		tablero.desplazar(jugador, 21);
		
		int casillaActual = tablero.casillaDeJugador(jugador);
		Assert.assertEquals(casillaActual, 2);
		
	}
	
	@Test
	public void testDesplazarJugadorUnaCasillaHaciaAtrasLoDesplazaCorrectamente() {
		
		Tablero.resetear();
		Tablero tablero = Tablero.getInstance();
		Jugador jugador = new JugadorConcreto("Pepe");
		tablero.desplazar(jugador, "SALIDA");
		
		tablero.desplazar(jugador, -1);
		
		int casillaActual = tablero.casillaDeJugador(jugador);
		Assert.assertEquals(casillaActual, 20);
		
	}
	
	@Test
	public void testDesplazarJugadorVeintiunCasillaHaciaAtrasLoDesplazaCorrectamente() {
		
		Tablero.resetear();
		Tablero tablero = Tablero.getInstance();
		Jugador jugador = new JugadorConcreto("Pepe");
		tablero.desplazar(jugador, "SALIDA");
		
		tablero.desplazar(jugador, -21);
		
		int casillaActual = tablero.casillaDeJugador(jugador);
		Assert.assertEquals(casillaActual, 20);
		
	}
	
	@Test
	public void testDesplazarJugadorUnaPosicionHaciaAdelanteRemueveAlJugadorDeLaCasillaAnterior() {
		
		Tablero.resetear();
		Tablero tablero = Tablero.getInstance();
		Jugador jugador = new JugadorConcreto("Pepe");
		tablero.desplazar(jugador, "SALIDA");
		
		tablero.desplazar(jugador, 1);
		
		Assert.assertTrue(tablero.casillaEstaVacia(1));
		
	}
	
	@Test
	public void testDesplazarJugadorUnaPosicionHaciAtrasRemueveAlJugadorDeLaCasillaAnterior() {
		
		Tablero.resetear();
		Tablero tablero = Tablero.getInstance();
		Jugador jugador = new JugadorConcreto("Pepe");
		tablero.desplazar(jugador, "SALIDA");
		
		tablero.desplazar(jugador, -1);
		
		Assert.assertTrue(tablero.casillaEstaVacia(1));
		
	}
	
	@Test
	public void testMovimientoDesdeSalidaHastaBsAsZonaNorteDesplazaCorrectamenteAUnJugadorPorElTablero() {
		
		Tablero.resetear();
		Tablero tablero = Tablero.getInstance();
		Jugador jugador = new JugadorConcreto("Pepe");
		tablero.desplazar(jugador, "SALIDA");
		
		for (int i = 1; i <= 4; i++) {			
			tablero.desplazar(jugador, 1);
		}
		
		for (int i = 1; i <= 4; i++) {			
			Assert.assertTrue(tablero.casillaEstaVacia(i));
		}		
		
	}
	
	@Test
	public void testMovimientoDesdeSubteHastaSaltaSurDesplazaCorrectamenteAUnJugadorPorElTablero() {
		
		Tablero.resetear();
		Tablero tablero = Tablero.getInstance();
		Jugador jugador = new JugadorConcreto("Pepe");
		tablero.desplazar(jugador, "SUBTE");
		
		for (int i = 1; i <= 6; i++) {			
			tablero.desplazar(jugador, 1);
		}
		
		for (int i = 9; i <= 14; i++) {			
			Assert.assertTrue(tablero.casillaEstaVacia(i));
		}		
		
	}
}
