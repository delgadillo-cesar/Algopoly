package entrega1;

import org.junit.Assert;
import org.junit.Test;

import entidades.JugadorConcreto;
import tablero.Casilla;
import acciones.AvanceDinamico;
import propiedades.Terreno;


public class InteraccionAvanceDinamicoTest {

/***********************************************/
	
	@Test
	public void test01CaeEnAvanceDinamicoCon4EnLosDadosAvanza4Menos2() {
		
		JugadorConcreto jugador = new JugadorConcreto ("Jose");
		Casilla avanceDinamico = new AvanceDinamico ();
		int nuevoValor=0;
		int numeroConElQueCayoEnEstaCasilla = 4;
		nuevoValor = avanceDinamico.numeroDeCasillerosAAvanzar (jugador,numeroConElQueCayoEnEstaCasilla);
		Assert.assertEquals (2,nuevoValor);

	}
	
/***********************************************/
	
	@Test
	public void test02CaeEnAvanceDinamicoCon9EnLosDados() {
		
		JugadorConcreto jugador = new JugadorConcreto ("Jose");
		Casilla avanceDinamico = new AvanceDinamico ();
		int nuevoValor=0;
		int numeroConElQueCayoEnEstaCasilla = 9;
		nuevoValor = avanceDinamico.numeroDeCasillerosAAvanzar (jugador,numeroConElQueCayoEnEstaCasilla);
		Assert.assertEquals (1,nuevoValor);
		
		// 100000 MOD 9 = 1
		// si saca 7,8,9,10 avanza (#dineroDelJugador % (7,8,9,10))
		
	}
	
/***********************************************/
	
	@Test
	public void test03CaeEnAvanceDinamicoCon12EnLosDados() {
		
		JugadorConcreto jugador = new JugadorConcreto ("Jose");
		Casilla avanceDinamico = new AvanceDinamico ();
		int numeroConElQueCayoEnEstaCasilla = 12;
		int nuevoValor;
		Terreno BsAsSur = new Terreno ();
		Terreno BsAsNorte = new Terreno ();
		Terreno santaFe = new Terreno ();
		jugador.comprar(BsAsSur);
		jugador.comprar(BsAsNorte);
		jugador.comprar(santaFe);
		nuevoValor = avanceDinamico.numeroDeCasillerosAAvanzar (jugador,numeroConElQueCayoEnEstaCasilla);
		Assert.assertEquals(9, nuevoValor);
		
	
	}

/***********************************************/

}
