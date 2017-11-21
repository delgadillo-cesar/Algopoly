package unitarios;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import entidades.Jugador;
import juego.Dados;
import tablero.Tablero;
import propiedades.Construccion;
import propiedades.Barrio;
import propiedades.Trenes;

public class RetrocesoDinamico {

	private List<Construccion> construcciones;
	@Before
	public void setUp() throws Exception {
		construcciones = new ArrayList<Construccion>();
		
		construcciones.add(Construccion.construirUnTerreno(2500));
		construcciones.add(Construccion.construirUnaCasa(5500, 3500));
		construcciones.add(Construccion.construirDosCasa(5500, 4000));
		construcciones.add(Construccion.construirUnHotel(9000, 6000));
	}
	

/***********************************************/
	
	@Test
	public void test01CaeEnRetrocesoDinamicoCon2EnLosDadosYTiene1Propiedades() {
		
		Dados dados = Dados.getInstance();
		Jugador jugador = new Jugador ("Jose");
		Tablero tablero = Tablero.getInstance();
		Trenes trenes = new Trenes ();
		jugador.comprarPropiedad(trenes);
		tablero.desplazar(jugador,"TRENES");
		Assert.assertEquals(17,tablero.casillaDeJugador(jugador));
		while(dados.getValor()!=2) 
			dados.lanzarDados();
		tablero.desplazar(jugador, dados.getValor());
		Assert.assertEquals(18,tablero.casillaDeJugador(jugador));
	}
	
/***********************************************/	
	
	@Test
	public void test02CaeEnRetrocesoDinamicoCon7EnLosDadosYTiene1Propiedades() {
		
		Dados dados = Dados.getInstance();	
		Jugador jugador = new Jugador ("Jose");
		Tablero tablero = Tablero.getInstance();
		Barrio unTerreno = new Barrio("SANTA FE",15000, construcciones);
		jugador.comprarPropiedad(unTerreno);
		tablero.desplazar(jugador,"SANTA FE");
		Assert.assertEquals(12, tablero.casillaDeJugador(jugador));
		while(dados.getValor()!=7) 
			dados.lanzarDados();
		tablero.desplazar(jugador, dados.getValor()); /*Cae en retoceso dinamico*/
		Assert.assertEquals(15, tablero.casillaDeJugador(jugador));
	}
	
/***********************************************/	
	
	@Test
	public void test03CaeEnRetrocesoDinamicoCon12EnLosDadosAvanza12Menos2() {
		
		Dados dados = Dados.getInstance();	
		Jugador jugador = new Jugador ("Jose");
		Tablero tablero = Tablero.getInstance();
		tablero.desplazar(jugador,"CORDOBA SUR");
		while(dados.getValor()!=12) 
			dados.lanzarDados();
		tablero.desplazar(jugador, dados.getValor());
		Assert.assertEquals (9,tablero.casillaDeJugador(jugador));

	}	
	
}
