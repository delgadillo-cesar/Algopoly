package entrega1;

import org.junit.Assert;
import org.junit.Test;

import entidades.Jugador;
import entidades.JugadorConcreto;
import tablero.Casilla;

public class InteraccionCarcelTest {
	
	@Test
	public void testLuegoDeCaerEnLaCarcelElJugadorNoPuedeDesplazarse() {
		
		Jugador juan = new JugadorConcreto("Juan");
		Jugador pepe = new JugadorConcreto("Pepe");
		Jugador luis = new JugadorConcreto("Luis");
		Turno turno = new Turno(juan, pepe, luis);		
		Casilla carcel = new Carcel();
		
		carcel.afectar(pepe);
		
		Jugador jugadorSiguiente = turno.cambiarTurno();
		Assert.assertEquals(jugadorSiguiente, luis);		
		
		
	}
	
	@Test
	public void testJugadorEncarceladoPuedePagarFianzaYAlPagarlaPuedeMoverse() {
		
		Jugador juan = new JugadorConcreto("Juan");
		Jugador pepe = new JugadorConcreto("Pepe");
		Jugador luis = new JugadorConcreto("Luis");
		Turno turno = new Turno(juan, pepe, luis);		
		Casilla carcel = new Carcel();
		
		carcel.afectar(pepe);
		carcel.pagarFianza(pepe);
		
		Jugador jugadorSiguiente = turno.cambiarTurno();
		Assert.assertEquals(jugadorSiguiente, pepe);
		
	}
	
	@Test
	public void testJugadorEncarceladoNoPuedePagarFianzaPorFaltaDeCapitalEntoncesNoPuedeMoverse() {
		
		Jugador juan = new JugadorConcreto("Juan");
		Jugador pepe = new JugadorConcreto("Pepe");
		Jugador luis = new JugadorConcreto("Luis");
		Turno turno = new Turno(juan, pepe, luis);		
		Casilla carcel = new Carcel();
		
		carcel.afectar(pepe);
		carcel.pagarFianza(pepe);
		
		Jugador jugadorSiguiente = turno.cambiarTurno();
		Assert.assertEquals(jugadorSiguiente, luis);
		
	}
	
}
