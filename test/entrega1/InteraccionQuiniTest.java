package entrega1;

import org.junit.Assert;
import org.junit.Test;

import acciones.Quini;
import entidades.JugadorConcreto;
import tablero.Casilla;


public class InteraccionQuiniTest {
	
	@Test
	public void testCaerPorPrimeraVezEnQuini6IncrementaCapitalEn50000() {
		
		JugadorConcreto jugador = new JugadorConcreto("Elias");
		Casilla quini = new Quini();
		int capitalInicial = jugador.capital();
		
		quini.afectar(jugador);
		
		Assert.assertEquals(capitalInicial + 50000, jugador.capital());
	}
	
	@Test
	public void testCaerPorSegundaVezEnQuini6IncrementaCapitalEn30000() {
		
		JugadorConcreto jugador = new JugadorConcreto("Pedro");
		Casilla quini = new Quini();
		int capitalInicial = jugador.capital();
		quini.afectar(jugador);
		
		quini.afectar(jugador);
		
		Assert.assertEquals(capitalInicial + 80000, jugador.capital());
	}
	
	@Test
	public void testCaerPorTerceraVezEnQuini6NoIncrementaElCapital() {
		
		JugadorConcreto jugador = new JugadorConcreto("Pedro");
		Casilla quini = new Quini();
		int capitalInicial = jugador.capital();
		quini.afectar(jugador);
		quini.afectar(jugador);
		
		quini.afectar(jugador);
		
		Assert.assertEquals(capitalInicial + 80000, jugador.capital());
	}
	
	@Test
	public void testCaerMilVecesEnQuini6NoIncrementaElCapital() {
		
		JugadorConcreto jugador = new JugadorConcreto("Pedro");
		Casilla quini = new Quini();
		int capitalInicial = jugador.capital();
		for (int i = 0; i < 999; i++) {
			quini.afectar(jugador);
		}
		
		quini.afectar(jugador);
		
		Assert.assertEquals(capitalInicial + 80000, jugador.capital());
	}
}

	


