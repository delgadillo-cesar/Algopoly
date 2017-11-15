package unitarios;

import org.junit.Assert;
import org.junit.Test;

import entidades.Jugador;
import entidades.JugadorConcreto;
import tablero.Tablero;

public class TableroTest {

	@Test
	public void testObtenerTableroNoDevuelveNull() {
		
		Tablero tablero = Tablero.getInstance();
		
		Assert.assertNotNull(tablero);
	}
	
	@Test
	public void testDesplazarJugadorUnaCasillaHaciaAdelanteLoDesplazaCorrectamente() {
		
		Tablero tablero = Tablero.getInstance();
		Jugador jugador = new JugadorConcreto("Pepe");
		tablero.desplazar(jugador, "SALIDA");
		
		tablero.desplazar(jugador, 1);
		
		int casillaActual = tablero.casillaDeJugador(jugador);
		Assert.assertEquals(casillaActual, 2);
		
	}
	
	@Test
	public void testDesplazarJugadorveintiunCasillasHaciaAdelanteLoDesplazaCorrectamente() {
		
		Tablero tablero = Tablero.getInstance();
		Jugador jugador = new JugadorConcreto("Pepe");
		tablero.desplazar(jugador, "SALIDA");
		
		tablero.desplazar(jugador, 21);
		
		int casillaActual = tablero.casillaDeJugador(jugador);
		Assert.assertEquals(casillaActual, 2);
		
	}
	
	@Test
	public void testDesplazarJugadorUnaCasillaHaciaAtrasLoDesplazaCorrectamente() {
		
		Tablero tablero = Tablero.getInstance();
		Jugador jugador = new JugadorConcreto("Pepe");
		tablero.desplazar(jugador, "SALIDA");
		
		tablero.desplazar(jugador, -1);
		
		int casillaActual = tablero.casillaDeJugador(jugador);
		Assert.assertEquals(casillaActual, 20);
		
	}
	
	@Test
	public void testDesplazarJugadorVeintiunCasillaHaciaAtrasLoDesplazaCorrectamente() {
		
		Tablero tablero = Tablero.getInstance();
		Jugador jugador = new JugadorConcreto("Pepe");
		tablero.desplazar(jugador, "SALIDA");
		
		tablero.desplazar(jugador, -21);
		
		int casillaActual = tablero.casillaDeJugador(jugador);
		Assert.assertEquals(casillaActual, 20);
		
	}
	
	@Test
	public void testDesplazarJugadorUnaPosicionHaciaAdelanteRemueveAlJugadorDeLaCasillaAnterior() {
		
		Tablero tablero = Tablero.getInstance();
		Jugador jugador = new JugadorConcreto("Pepe");
		tablero.desplazar(jugador, "SALIDA");
		
		tablero.desplazar(jugador, 1);
		
		Assert.assertTrue(tablero.casillaEstaVacia(1));
		
	}
	
	@Test
	public void testDesplazarJugadorUnaPosicionHaciAtrasRemueveAlJugadorDeLaCasillaAnterior() {
		
		Tablero tablero = Tablero.getInstance();
		Jugador jugador = new JugadorConcreto("Pepe");
		tablero.desplazar(jugador, "SALIDA");
		
		tablero.desplazar(jugador, -1);
		
		Assert.assertTrue(tablero.casillaEstaVacia(1));
		
	}
	
	@Test
	public void testDarUnaVueltaCompletaDesplazaCorrectamenteAUnJugadorPorElTablero() {
		
		Tablero tablero = Tablero.getInstance();
		Jugador jugador = new JugadorConcreto("Pepe");
		tablero.desplazar(jugador, "SALIDA");
		
		for (int i = 1; i <= 21; i++) {
			
			tablero.desplazar(jugador, 1);
			Assert.assertTrue(tablero.casillaEstaVacia(i));
			Assert.assertFalse(tablero.casillaEstaVacia(i+1));
		}
	}
}
