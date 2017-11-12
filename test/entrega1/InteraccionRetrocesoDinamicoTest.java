package entrega1;

import org.junit.Assert;
import org.junit.Test;

import entidades.JugadorConcreto;
import tablero.Casilla;
import acciones.AvanceDinamico;
import acciones.RetrocesoDinamico;
import propiedades.Terreno;

public class InteraccionRetrocesoDinamicoTest {
	
/***********************************************/
	
	@Test
	public void test01CaeEnRetrocesoDinamicoCon3EnLosDadosYTiene6Propiedades() {
		
		JugadorConcreto jugador = new JugadorConcreto ("Jose");
		Casilla retrocesoDinamico = new RetrocesoDinamico ();
		int numeroConElQueCayoEnEstaCasilla = 3;
		int nuevoValor;
		Terreno BsAsSur = new Terreno ();
		Terreno BsAsNorte = new Terreno ();
		Terreno SantaFeSur = new Terreno ();
		Terreno SantaFeNorte= new Terreno ();
		Terreno CordobaSur = new Terreno ();
		Terreno CordobaNorte= new Terreno ();
		jugador.comprar(BsAsSur);
		jugador.comprar(BsAsNorte);
		jugador.comprar(SantaFeSur);
		jugador.comprar(SantaFeNorte);
		jugador.comprar(CordobaSur);
		jugador.comprar(CordobaNorte);
		nuevoValor = retrocesoDinamico.numeroDeCasillerosARetroceder (jugador,numeroConElQueCayoEnEstaCasilla);
		Assert.assertEquals(3, nuevoValor);
	}
	
/***********************************************/	
	
	@Test
	public void test02CaeEnRetrocesoDinamicoCon6EnLosDadosYTiene3Propiedades() {
		
		JugadorConcreto jugador = new JugadorConcreto ("Jose");
		Casilla retrocesoDinamico = new RetrocesoDinamico ();
		int numeroConElQueCayoEnEstaCasilla = 3;
		int nuevoValor;
		Terreno BsAsSur = new Terreno ();
		Terreno BsAsNorte = new Terreno ();
		Terreno SantaFeSur = new Terreno ();
		Terreno SantaFeNorte= new Terreno ();
		Terreno CordobaSur = new Terreno ();
		Terreno CordobaNorte= new Terreno ();
		jugador.comprar(BsAsSur);
		jugador.comprar(BsAsNorte);
		jugador.comprar(SantaFeSur);
		jugador.comprar(SantaFeNorte);
		jugador.comprar(CordobaSur);
		jugador.comprar(CordobaNorte);
		nuevoValor = retrocesoDinamico.numeroDeCasillerosARetroceder (jugador,numeroConElQueCayoEnEstaCasilla);
		Assert.assertEquals(3, nuevoValor);
	}
	
/***********************************************/	
	
	@Test
	public void test03CaeEnRetrocesoDinamicoCon9EnLosDados() {
		
		JugadorConcreto jugador = new JugadorConcreto ("Jose");
		Casilla retrocesoDinamico = new RetrocesoDinamico ();
		int nuevoValor=0;
		int numeroConElQueCayoEnEstaCasilla = 9;
		nuevoValor = retrocesoDinamico.numeroDeCasillerosARetroceder (jugador,numeroConElQueCayoEnEstaCasilla);
		Assert.assertEquals (1,nuevoValor);
		
		// 100000 MOD 9 = 1
		// si saca 7,8,9,10 avanza (#dineroDelJugador % (7,8,9,10))
	}
	
/***********************************************/	
	
	@Test
	public void test04CaeEnRetrocesoDinamicoCon12EnLosDadosAvanza12Menos2() {
		
		JugadorConcreto jugador = new JugadorConcreto ("Jose");
		Casilla retrocesoDinamico = new RetrocesoDinamico ();
		int nuevoValor=0;
		int numeroConElQueCayoEnEstaCasilla = 12;
		nuevoValor = retrocesoDinamico.numeroDeCasillerosARetroceder (jugador,numeroConElQueCayoEnEstaCasilla);
		Assert.assertEquals (10,nuevoValor);

	}	
	
}
