package unitarios;

import org.junit.Assert;
import org.junit.Test;
import entidades.JugadorConcreto;
import entidades.Jugador;
import acciones.Quini;



public class QuiniTest {
	
/***********************************************/	

	@Test
	public void test01CaenEnQuiniYCapitalSeIncrementaEn50000() {
		
		Jugador jugador = new JugadorConcreto ("Jose PEPE Argento");
		Quini quini6 = new Quini ();
		quini6.afectar(jugador);
		Assert.assertEquals(150000,jugador.capital());
		
	}

/***********************************************/
	
	@Test
	public void test02CaenEnQuiniPorSegundaVezYCapitalSeIncrementaEn30000() {
		
		Jugador jugador = new JugadorConcreto ("Jose PEPE Argento");
		Quini quini6 = new Quini ();
		quini6.afectar(jugador);
		quini6.afectar(jugador);
		Assert.assertEquals(180000,jugador.capital());
		
	}
	
/***********************************************/
	
	@Test
	public void test03CaenEnQuiniPorTerceraVezYCapitalNoSeIncrementa() {
		
		Jugador jugador = new JugadorConcreto ("Jose PEPE Argento");
		Quini quini6 = new Quini ();
		quini6.afectar(jugador);
		quini6.afectar(jugador);
		quini6.afectar(jugador);
		Assert.assertEquals(180000,jugador.capital());
		
	}
	
/***********************************************/
	
}
