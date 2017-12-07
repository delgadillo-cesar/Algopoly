package unitarios;

import java.util.LinkedList;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import modelo.entidades.Jugador;
import modelo.entidades.JugadorUno;
import modelo.juego.Dados;
import modelo.juego.Turno;

public class TurnoTest {

	@Before
	public void setUp(){
		/*Dados Impares por defecto*/
		do {
			Dados.getInstance().lanzarDados();
		} while (Dados.getInstance().salieronPares());
	}
	
	@Test
	public void testCrearTurnoyNoDevuelveNull() {
		Jugador primerJugador = new JugadorUno("Rich Uncle");
		Jugador segundoJugador = new JugadorUno("Milburn Pennybags");
		LinkedList<Jugador> jugadores = new LinkedList<Jugador>();
		jugadores.add(primerJugador);
		jugadores.add(segundoJugador);
		Turno turno = Turno.inicializarTurno(jugadores);
		Assert.assertNotNull(turno);
	}

	@Test
	public void testCambiarTurnoyJugadorActualEsSegundoJugador() {
		Jugador primerJugador = new JugadorUno("Rich Uncle");
		Jugador segundoJugador = new JugadorUno("Milburn Pennybags");
		LinkedList<Jugador> jugadores = new LinkedList<Jugador>();
		jugadores.add(primerJugador);
		jugadores.add(segundoJugador);
		Turno turno = Turno.inicializarTurno(jugadores);
		do {
			Dados.getInstance().lanzarDados();
		} while (Dados.getInstance().salieronPares());
		Assert.assertEquals(segundoJugador, turno.cambiarTurno());
	}

	@Test
	public void testCambiarTurnoDosVecesyJugadorActualEsPrimerJugador() {
		Jugador primerJugador = new JugadorUno("Rich Uncle");
		Jugador segundoJugador = new JugadorUno("Milburn Pennybags");
		LinkedList<Jugador> jugadores = new LinkedList<Jugador>();
		jugadores.add(primerJugador);
		jugadores.add(segundoJugador);
		Turno turno = Turno.inicializarTurno(jugadores);
		do {
			Dados.getInstance().lanzarDados();
		} while (Dados.getInstance().salieronPares());
		turno.cambiarTurno();
		Assert.assertEquals(primerJugador, turno.cambiarTurno());
	}

	@Test
	public void testCambiarTurnoConDadosIgualesyJugadorActualEsPrimerJugador() {
		Jugador primerJugador = new JugadorUno("Rich Uncle");
		Jugador segundoJugador = new JugadorUno("Milburn Pennybags");
		LinkedList<Jugador> jugadores = new LinkedList<Jugador>();
		jugadores.add(primerJugador);
		jugadores.add(segundoJugador);
		Turno turno = Turno.inicializarTurno(jugadores);
		do {
			Dados.getInstance().lanzarDados();
		} while (!Dados.getInstance().salieronPares());
		Assert.assertEquals(primerJugador, turno.cambiarTurno());
	}

	@Test
	public void testCambiarTurnoConDadosIgualesDosVecesyJugadorActualEsSegundoJugador() {
		Jugador primerJugador = new JugadorUno("Rich Uncle");
		Jugador segundoJugador = new JugadorUno("Milburn Pennybags");
		LinkedList<Jugador> jugadores = new LinkedList<Jugador>();
		jugadores.add(primerJugador);
		jugadores.add(segundoJugador);
		Turno turno = Turno.inicializarTurno(jugadores);
		do {
			Dados.getInstance().lanzarDados();
		} while (!Dados.getInstance().salieronPares());
		turno.cambiarTurno();
		Assert.assertEquals(segundoJugador, turno.cambiarTurno());
	}

	@Test
	public void testTurnoConListaDe3JugadoresNingunoSacaParesCadaUnoTieneUnTurno() {
		Jugador primerJugador = new JugadorUno("Jugador de Prueba 1");
		Jugador segundoJugador = new JugadorUno("Jugador de Prueba 2");
		Jugador tercerJugador = new JugadorUno("Jugador de Prueba 3");

		LinkedList<Jugador> jugadores = new LinkedList<Jugador>();
		jugadores.add(primerJugador);
		jugadores.add(segundoJugador);
		jugadores.add(tercerJugador);
		Turno turno = Turno.inicializarTurno(jugadores);

		do {
			Dados.getInstance().lanzarDados();
		} while (Dados.getInstance().salieronPares());
		

		Assert.assertEquals(primerJugador, (turno.turnoActual()));

		Assert.assertEquals(segundoJugador, turno.cambiarTurno());
		
		Assert.assertEquals(tercerJugador, turno.cambiarTurno());
	}

	@Test
	public void testTurnoConListaDeJugadoresNingunoSacaParesCuandoSeAcabaLalistaVuelveDesdeElPrimero() {
		Jugador primerJugador = new JugadorUno("Jugador de Prueba 1");
		Jugador segundoJugador = new JugadorUno("Jugador de Prueba 2");
		Jugador tercerJugador = new JugadorUno("Jugador de Prueba 3");

		LinkedList<Jugador> jugadores = new LinkedList<Jugador>();
		jugadores.add(primerJugador);
		jugadores.add(segundoJugador);
		jugadores.add(tercerJugador);
		Turno turno = Turno.inicializarTurno(jugadores);

		do {
			Dados.getInstance().lanzarDados();
		} while (Dados.getInstance().salieronPares());
		

		Assert.assertEquals(primerJugador, (turno.turnoActual()));
		Assert.assertEquals(segundoJugador, turno.cambiarTurno());
		Assert.assertEquals(tercerJugador, turno.cambiarTurno());

		Assert.assertEquals(primerJugador, (turno.cambiarTurno()));
		Assert.assertEquals(segundoJugador, turno.cambiarTurno());
		Assert.assertEquals(tercerJugador, turno.cambiarTurno());
	}

	@Test
	public void testTurnoConListaDeJugadoresCualquieraPuedeSacaParesYTenerUnTurnoExtra() {
		Jugador primerJugador = new JugadorUno("Jugador de Prueba 1");
		Jugador segundoJugador = new JugadorUno("Jugador de Prueba 2");
		Jugador tercerJugador = new JugadorUno("Jugador de Prueba 3");

		LinkedList<Jugador> jugadores = new LinkedList<Jugador>();
		jugadores.add(primerJugador);
		jugadores.add(segundoJugador);
		jugadores.add(tercerJugador);
		Turno turno = Turno.inicializarTurno(jugadores);

		do {
			Dados.getInstance().lanzarDados();
		} while (!Dados.getInstance().salieronPares());
		

		Assert.assertEquals(primerJugador, (turno.turnoActual()));
		Assert.assertEquals(primerJugador, (turno.cambiarTurno()));

		Assert.assertEquals(segundoJugador, turno.cambiarTurno());
		Assert.assertEquals(segundoJugador, turno.cambiarTurno());
		
		Assert.assertEquals(tercerJugador, turno.cambiarTurno());
		Assert.assertEquals(tercerJugador, turno.cambiarTurno());

		Assert.assertEquals(primerJugador, (turno.cambiarTurno()));
		Assert.assertEquals(primerJugador, (turno.cambiarTurno()));

		Assert.assertEquals(segundoJugador, turno.cambiarTurno());
		Assert.assertEquals(segundoJugador, turno.cambiarTurno());
		
		Assert.assertEquals(tercerJugador, turno.cambiarTurno());
		Assert.assertEquals(tercerJugador, turno.cambiarTurno());
	}

	@Test
	public void testTurnoConListaDe3JugadoresSequitaAlPrimeroLeTocaAlSegundo() {
		Jugador primerJugador = new JugadorUno("Jugador de Prueba 1");
		Jugador segundoJugador = new JugadorUno("Jugador de Prueba 2");
		Jugador tercerJugador = new JugadorUno("Jugador de Prueba 3");

		LinkedList<Jugador> jugadores = new LinkedList<Jugador>();
		jugadores.add(primerJugador);
		jugadores.add(segundoJugador);
		jugadores.add(tercerJugador);
		Turno turno = Turno.inicializarTurno(jugadores);
		
		Assert.assertEquals(primerJugador, turno.turnoActual());
		turno.quitarJugadorActual();
		Assert.assertEquals(segundoJugador, turno.turnoActual());
	}

	@Test
	public void testTurnoConListaDe3JugadoresSequitaAlPrimeroSoloQuedanLosOtros() {
		Jugador primerJugador = new JugadorUno("Jugador de Prueba 1");
		Jugador segundoJugador = new JugadorUno("Jugador de Prueba 2");
		Jugador tercerJugador = new JugadorUno("Jugador de Prueba 3");

		LinkedList<Jugador> jugadores = new LinkedList<Jugador>();
		jugadores.add(primerJugador);
		jugadores.add(segundoJugador);
		jugadores.add(tercerJugador);
		Turno turno = Turno.inicializarTurno(jugadores);
		
		Assert.assertEquals(primerJugador, turno.turnoActual());
		turno.quitarJugadorActual();
		Assert.assertEquals(segundoJugador, turno.turnoActual());
		
		for(int i=0; i<100; i++){
			turno.cambiarTurno();
			Assert.assertTrue((segundoJugador == turno.turnoActual()) || (tercerJugador == turno.turnoActual()));
		}
	}

	@Test
	public void testTurnoConListaDe3JugadoresSequitaAlSegundoLeTocaAlTercero() {
		Jugador primerJugador = new JugadorUno("Jugador de Prueba 1");
		Jugador segundoJugador = new JugadorUno("Jugador de Prueba 2");
		Jugador tercerJugador = new JugadorUno("Jugador de Prueba 3");

		LinkedList<Jugador> jugadores = new LinkedList<Jugador>();
		jugadores.add(primerJugador);
		jugadores.add(segundoJugador);
		jugadores.add(tercerJugador);
		Turno turno = Turno.inicializarTurno(jugadores);
		
		turno.cambiarTurno();
		Assert.assertEquals(segundoJugador, turno.turnoActual());
		turno.quitarJugadorActual();
		Assert.assertEquals(tercerJugador, turno.turnoActual());
	}

	@Test
	public void testTurnoConListaDe3JugadoresSequitaAlTerceroLeTocaAlPrimero() {
		Jugador primerJugador = new JugadorUno("Jugador de Prueba 1");
		Jugador segundoJugador = new JugadorUno("Jugador de Prueba 2");
		Jugador tercerJugador = new JugadorUno("Jugador de Prueba 3");

		LinkedList<Jugador> jugadores = new LinkedList<Jugador>();
		jugadores.add(primerJugador);
		jugadores.add(segundoJugador);
		jugadores.add(tercerJugador);
		Turno turno = Turno.inicializarTurno(jugadores);
		
		turno.cambiarTurno();
		Assert.assertEquals(segundoJugador, turno.turnoActual());
		turno.quitarJugadorActual();
		Assert.assertEquals(tercerJugador, turno.turnoActual());
		
		for(int i=0; i<100; i++){
			turno.cambiarTurno();
			Assert.assertTrue((tercerJugador == turno.turnoActual()) || (primerJugador == turno.turnoActual()));
		}
	}

	
	@Test
	public void testTurnoConListaDe3JugadoresPrimerJugadorSacaParesEnElPrimerTunoYLoQuitanLeTocaAlSegundo() {
		Jugador primerJugador = new JugadorUno("Jugador de Prueba 1");
		Jugador segundoJugador = new JugadorUno("Jugador de Prueba 2");
		Jugador tercerJugador = new JugadorUno("Jugador de Prueba 3");

		LinkedList<Jugador> jugadores = new LinkedList<Jugador>();
		jugadores.add(primerJugador);
		jugadores.add(segundoJugador);
		jugadores.add(tercerJugador);
		Turno turno = Turno.inicializarTurno(jugadores);

		do {
			Dados.getInstance().lanzarDados();
		} while (!Dados.getInstance().salieronPares());

		Assert.assertEquals(primerJugador, turno.turnoActual());
		turno.quitarJugadorActual();
		Assert.assertEquals(segundoJugador, turno.turnoActual());
	}

	@Test
	public void testTurnoConListaDe3JugadoresPrimerJugadorSacaParesEnElPrimerTunoYLoQuitanLeTocaAlSegundoPeroNoRepiteTurno() {
		Jugador primerJugador = new JugadorUno("Jugador de Prueba 1");
		Jugador segundoJugador = new JugadorUno("Jugador de Prueba 2");
		Jugador tercerJugador = new JugadorUno("Jugador de Prueba 3");

		LinkedList<Jugador> jugadores = new LinkedList<Jugador>();
		jugadores.add(primerJugador);
		jugadores.add(segundoJugador);
		jugadores.add(tercerJugador);
		Turno turno = Turno.inicializarTurno(jugadores);

		do {
			Dados.getInstance().lanzarDados();
		} while (!Dados.getInstance().salieronPares());

		Assert.assertEquals(primerJugador, turno.turnoActual());
		turno.quitarJugadorActual();
		Assert.assertEquals(segundoJugador, turno.turnoActual());

		do {
			Dados.getInstance().lanzarDados();
		} while (Dados.getInstance().salieronPares());

		turno.cambiarTurno();
		Assert.assertEquals(tercerJugador, turno.turnoActual());
	}

	@Test
	public void testTurnoConListaDe3JugadoresPrimerJugadorSacaParesEnElSegundoTunoYLoQuitanLeTocaAlSegundo() {
		Jugador primerJugador = new JugadorUno("Jugador de Prueba 1");
		Jugador segundoJugador = new JugadorUno("Jugador de Prueba 2");
		Jugador tercerJugador = new JugadorUno("Jugador de Prueba 3");

		LinkedList<Jugador> jugadores = new LinkedList<Jugador>();
		jugadores.add(primerJugador);
		jugadores.add(segundoJugador);
		jugadores.add(tercerJugador);
		Turno turno = Turno.inicializarTurno(jugadores);

		do {
			Dados.getInstance().lanzarDados();
		} while (!Dados.getInstance().salieronPares());

		Assert.assertEquals(primerJugador, turno.turnoActual());
		turno.cambiarTurno();
		Assert.assertEquals(primerJugador, turno.turnoActual());

		turno.quitarJugadorActual();
		Assert.assertEquals(segundoJugador, turno.turnoActual());
	}

	@Test
	public void testTurnoConListaDe3JugadoresPrimerJugadorSacaParesEnElSegundoTunoYLoQuitanLeTocaAlSegundoPeroNoRepiteTurno() {
		Jugador primerJugador = new JugadorUno("Jugador de Prueba 1");
		Jugador segundoJugador = new JugadorUno("Jugador de Prueba 2");
		Jugador tercerJugador = new JugadorUno("Jugador de Prueba 3");

		LinkedList<Jugador> jugadores = new LinkedList<Jugador>();
		jugadores.add(primerJugador);
		jugadores.add(segundoJugador);
		jugadores.add(tercerJugador);
		Turno turno = Turno.inicializarTurno(jugadores);

		do {
			Dados.getInstance().lanzarDados();
		} while (!Dados.getInstance().salieronPares());

		Assert.assertEquals(primerJugador, turno.turnoActual());
		turno.cambiarTurno();
		Assert.assertEquals(primerJugador, turno.turnoActual());

		turno.quitarJugadorActual();
		Assert.assertEquals(segundoJugador, turno.turnoActual());

		do {
			Dados.getInstance().lanzarDados();
		} while (Dados.getInstance().salieronPares());

		turno.cambiarTurno();
		Assert.assertEquals(tercerJugador, turno.turnoActual());
	}

	
	@Test
	public void testTurnoConListaDe3JugadoresSegundoJugadorSacaParesEnElPrimerTunoYLoQuitanLeTocaAlTercero() {
		Jugador primerJugador = new JugadorUno("Jugador de Prueba 1");
		Jugador segundoJugador = new JugadorUno("Jugador de Prueba 2");
		Jugador tercerJugador = new JugadorUno("Jugador de Prueba 3");

		LinkedList<Jugador> jugadores = new LinkedList<Jugador>();
		jugadores.add(primerJugador);
		jugadores.add(segundoJugador);
		jugadores.add(tercerJugador);
		Turno turno = Turno.inicializarTurno(jugadores);
		turno.cambiarTurno();

		do {
			Dados.getInstance().lanzarDados();
		} while (!Dados.getInstance().salieronPares());

		Assert.assertEquals(segundoJugador, turno.turnoActual());
		turno.quitarJugadorActual();
		Assert.assertEquals(tercerJugador, turno.turnoActual());
	}

	@Test
	public void testTurnoConListaDe3JugadoresSegundoJugadorSacaParesEnElPrimerTunoYLoQuitanLeTocaAlTerceroPeroNoRepiteTurno() {
		Jugador primerJugador = new JugadorUno("Jugador de Prueba 1");
		Jugador segundoJugador = new JugadorUno("Jugador de Prueba 2");
		Jugador tercerJugador = new JugadorUno("Jugador de Prueba 3");

		LinkedList<Jugador> jugadores = new LinkedList<Jugador>();
		jugadores.add(primerJugador);
		jugadores.add(segundoJugador);
		jugadores.add(tercerJugador);
		Turno turno = Turno.inicializarTurno(jugadores);
		turno.cambiarTurno();

		do {
			Dados.getInstance().lanzarDados();
		} while (!Dados.getInstance().salieronPares());

		Assert.assertEquals(segundoJugador, turno.turnoActual());
		turno.quitarJugadorActual();
		Assert.assertEquals(tercerJugador, turno.turnoActual());

		do {
			Dados.getInstance().lanzarDados();
		} while (Dados.getInstance().salieronPares());

		turno.cambiarTurno();
		Assert.assertEquals(primerJugador, turno.turnoActual());
	}

	@Test
	public void testTurnoConListaDe3JugadoresSegundoJugadorSacaParesEnElSegundoTunoYLoQuitanLeTocaAlTecero() {
		Jugador primerJugador = new JugadorUno("Jugador de Prueba 1");
		Jugador segundoJugador = new JugadorUno("Jugador de Prueba 2");
		Jugador tercerJugador = new JugadorUno("Jugador de Prueba 3");

		LinkedList<Jugador> jugadores = new LinkedList<Jugador>();
		jugadores.add(primerJugador);
		jugadores.add(segundoJugador);
		jugadores.add(tercerJugador);
		Turno turno = Turno.inicializarTurno(jugadores);
		turno.cambiarTurno();
		
		do {
			Dados.getInstance().lanzarDados();
		} while (!Dados.getInstance().salieronPares());

		Assert.assertEquals(segundoJugador, turno.turnoActual());
		turno.cambiarTurno();
		Assert.assertEquals(segundoJugador, turno.turnoActual());

		turno.quitarJugadorActual();
		Assert.assertEquals(tercerJugador, turno.turnoActual());
	}

	@Test
	public void testTurnoConListaDe3JugadoresSegundoJugadorSacaParesEnElSegundoTunoYLoQuitanLeTocaAlTeceroPeroNoRepiteTurno() {
		Jugador primerJugador = new JugadorUno("Jugador de Prueba 1");
		Jugador segundoJugador = new JugadorUno("Jugador de Prueba 2");
		Jugador tercerJugador = new JugadorUno("Jugador de Prueba 3");

		LinkedList<Jugador> jugadores = new LinkedList<Jugador>();
		jugadores.add(primerJugador);
		jugadores.add(segundoJugador);
		jugadores.add(tercerJugador);
		Turno turno = Turno.inicializarTurno(jugadores);
		turno.cambiarTurno();

		do {
			Dados.getInstance().lanzarDados();
		} while (!Dados.getInstance().salieronPares());

		Assert.assertEquals(segundoJugador, turno.turnoActual());
		turno.cambiarTurno();
		Assert.assertEquals(segundoJugador, turno.turnoActual());

		turno.quitarJugadorActual();
		Assert.assertEquals(tercerJugador, turno.turnoActual());

		do {
			Dados.getInstance().lanzarDados();
		} while (Dados.getInstance().salieronPares());

		turno.cambiarTurno();
		Assert.assertEquals(primerJugador, turno.turnoActual());
	}






	@Test
	public void testTurnoConListaDe3JugadoresTercerJugadorSacaParesEnElPrimerTunoYLoQuitanLeTocaAlPrimero() {
		Jugador primerJugador = new JugadorUno("Jugador de Prueba 1");
		Jugador segundoJugador = new JugadorUno("Jugador de Prueba 2");
		Jugador tercerJugador = new JugadorUno("Jugador de Prueba 3");

		LinkedList<Jugador> jugadores = new LinkedList<Jugador>();
		jugadores.add(primerJugador);
		jugadores.add(segundoJugador);
		jugadores.add(tercerJugador);
		Turno turno = Turno.inicializarTurno(jugadores);
		turno.cambiarTurno();
		turno.cambiarTurno();

		do {
			Dados.getInstance().lanzarDados();
		} while (!Dados.getInstance().salieronPares());

		Assert.assertEquals(tercerJugador, turno.turnoActual());
		turno.quitarJugadorActual();
		Assert.assertEquals(primerJugador, turno.turnoActual());
	}

	@Test
	public void testTurnoConListaDe3JugadoresTercerJugadorSacaParesEnElPrimerTunoYLoQuitanLeTocaAlPrimeroPeroNoRepiteTurno() {
		Jugador primerJugador = new JugadorUno("Jugador de Prueba 1");
		Jugador segundoJugador = new JugadorUno("Jugador de Prueba 2");
		Jugador tercerJugador = new JugadorUno("Jugador de Prueba 3");

		LinkedList<Jugador> jugadores = new LinkedList<Jugador>();
		jugadores.add(primerJugador);
		jugadores.add(segundoJugador);
		jugadores.add(tercerJugador);
		Turno turno = Turno.inicializarTurno(jugadores);
		turno.cambiarTurno();
		turno.cambiarTurno();

		do {
			Dados.getInstance().lanzarDados();
		} while (!Dados.getInstance().salieronPares());

		Assert.assertEquals(tercerJugador, turno.turnoActual());
		turno.quitarJugadorActual();
		Assert.assertEquals(primerJugador, turno.turnoActual());

		do {
			Dados.getInstance().lanzarDados();
		} while (Dados.getInstance().salieronPares());

		turno.cambiarTurno();
		Assert.assertEquals(segundoJugador, turno.turnoActual());
	}

	@Test
	public void testTurnoConListaDe3JugadoresTercerJugadorSacaParesEnElSegundoTunoYLoQuitanLeTocaAlPrimero() {
		Jugador primerJugador = new JugadorUno("Jugador de Prueba 1");
		Jugador segundoJugador = new JugadorUno("Jugador de Prueba 2");
		Jugador tercerJugador = new JugadorUno("Jugador de Prueba 3");

		LinkedList<Jugador> jugadores = new LinkedList<Jugador>();
		jugadores.add(primerJugador);
		jugadores.add(segundoJugador);
		jugadores.add(tercerJugador);
		Turno turno = Turno.inicializarTurno(jugadores);
		turno.cambiarTurno();
		turno.cambiarTurno();
		
		do {
			Dados.getInstance().lanzarDados();
		} while (!Dados.getInstance().salieronPares());

		Assert.assertEquals(tercerJugador, turno.turnoActual());
		turno.cambiarTurno();
		Assert.assertEquals(tercerJugador, turno.turnoActual());

		turno.quitarJugadorActual();
		Assert.assertEquals(primerJugador, turno.turnoActual());
	}

	@Test
	public void testTurnoConListaDe3JugadoresTercerJugadorSacaParesEnElSegundoTunoYLoQuitanLeTocaAlPrimeroPeroNoRepiteTurno() {
		Jugador primerJugador = new JugadorUno("Jugador de Prueba 1");
		Jugador segundoJugador = new JugadorUno("Jugador de Prueba 2");
		Jugador tercerJugador = new JugadorUno("Jugador de Prueba 3");

		LinkedList<Jugador> jugadores = new LinkedList<Jugador>();
		jugadores.add(primerJugador);
		jugadores.add(segundoJugador);
		jugadores.add(tercerJugador);
		Turno turno = Turno.inicializarTurno(jugadores);
		turno.cambiarTurno();
		turno.cambiarTurno();

		do {
			Dados.getInstance().lanzarDados();
		} while (!Dados.getInstance().salieronPares());

		Assert.assertEquals(tercerJugador, turno.turnoActual());
		turno.cambiarTurno();
		Assert.assertEquals(tercerJugador, turno.turnoActual());

		turno.quitarJugadorActual();
		Assert.assertEquals(primerJugador, turno.turnoActual());

		do {
			Dados.getInstance().lanzarDados();
		} while (Dados.getInstance().salieronPares());

		turno.cambiarTurno();
		Assert.assertEquals(segundoJugador, turno.turnoActual());
	}
}
