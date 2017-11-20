package unitarios;

import org.junit.Assert;
import org.junit.Test;

import entidades.Jugador;
import juego.Dados;
import tablero.Tablero;

public class AvanceDinamico {

/***********************************************/
	
	@Test
	public void test01CaeEnAvanceDinamicoCon5EnLosDadosAvanza5Menos2() {
		
		Dados dados = Dados.getInstance();	
		Jugador jugador = new Jugador ("Jose");
		Tablero tablero = Tablero.getInstance();
		tablero.desplazar(jugador,"BS AS ZONA SUR");
		while (dados.getValor()!=5) 
			dados.lanzarDados();

		tablero.desplazar(jugador, dados.getValor());
		Assert.assertEquals(11, tablero.casillaDeJugador(jugador));
		
		/* esta en la casilla 3, sale 5 y llega ala casilla 8 "AvanceDinamico"
		 * la cualautomaticamente avalua con que valor llego ahi y 
		 * lo hace avanzar la cantidad de casilleros establecidos
		 */
	}
	
/***********************************************/
	
	@Test
	public void test02CaeEnAvanceDinamicoCon8EnLosDados() {
		
		Dados dados = Dados.getInstance();	
		Jugador jugador = new Jugador ("Jose");
		Tablero tablero = Tablero.getInstance();
		tablero.desplazar(jugador,"SALIDA");
		while (dados.getValor()!=8) 
			dados.lanzarDados();
		tablero.desplazar(jugador, dados.getValor());
		Assert.assertEquals (9,tablero.casillaDeJugador(jugador));
		
		// 100000 MOD 9 = 1
		// si saca 7,8,9,10 avanza (#dineroDelJugador % (7,8,9,10))
		
	}
	
/***********************************************/
	
	@Test
	public void test03CaeEnAvanceDinamicoCon11EnLosDados() {
		
		Dados dados = Dados.getInstance();	
		Jugador jugador = new Jugador ("Jose");
		Tablero tablero = Tablero.getInstance();
		tablero.desplazar(jugador,"TRENES");
		while(dados.getValor()!=11) 
			dados.lanzarDados();

		Assert.assertEquals(17, tablero.casillaDeJugador(jugador));
		
	
	}

/***********************************************/

}
