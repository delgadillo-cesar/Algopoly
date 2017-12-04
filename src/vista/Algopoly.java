package vista;

import java.util.HashMap;
import java.util.LinkedList;

import controlador.*;

import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import modelo.entidades.*;
import modelo.juego.Dados;
import modelo.juego.Turno;
import modelo.tablero.Tablero;
import vista.jugador.VistaJugador;
import vista.tablero.VistaTablero;

public class Algopoly extends BorderPane {

	private VistaJugador vj1;
	private VistaJugador vj2;
	private VistaJugador vj3;

	Button botonTerminarTurno;
	Button botonTirarDados;
	Text valorDados;

	private static Algopoly algopoly;
	private HashMap<Jugador, VistaJugador> vistaJugadores;

	private void dibujarPanel() {
		VBox panelLateral;
		vj1.actualizar();
		vj2.actualizar();
		vj3.actualizar();

		panelLateral = new VBox();
		panelLateral.getChildren().add(vj1);
		panelLateral.getChildren().add(vj2);
		panelLateral.getChildren().add(vj3);
		panelLateral.getChildren().add(botonTerminarTurno);
		panelLateral.getChildren().add(botonTirarDados);

		Integer valorTiradaDados = Dados.getInstance().getValor();
		valorDados.setText(valorTiradaDados.toString());
		panelLateral.getChildren().add(valorDados);

		panelLateral.setPrefSize(100, 600);
		panelLateral.setSpacing(10);
		this.setRight(panelLateral);
	}

	private void crearElementos() {
		botonTerminarTurno = new Button("Terminar Turno");
		botonTerminarTurno.setOnAction(new CambiarTurnoHandler());
		botonTerminarTurno.setMaxWidth(Double.MAX_VALUE);
		botonTerminarTurno.setDisable(true);

		botonTirarDados = new Button("Tirar dados");
		botonTirarDados.setOnAction(new TirarDadosHandler());
		botonTirarDados.setMaxWidth(Double.MAX_VALUE);

		valorDados = new Text();
		valorDados.setFont(new Font(20));
		valorDados.setWrappingWidth(200);
		valorDados.setTextAlignment(TextAlignment.CENTER);

		this.setCenter(VistaTablero.getInstance());
		this.setPadding(new Insets(0));
	}

	private void iniciarJuego() {
		Jugador j1 = new JugadorUno("JUGADOR 1");
		Jugador j2 = new JugadorDos("JUGADOR 2");
		Jugador j3 = new JugadorTres("JUGADOR 3");

		vj1 = new VistaJugador(j1);
		vj2 = new VistaJugador(j2);
		vj3 = new VistaJugador(j3);

		this.vistaJugadores.put(j1, vj1);
		this.vistaJugadores.put(j2, vj2);
		this.vistaJugadores.put(j3, vj3);

		LinkedList<Jugador> jugadores = new LinkedList<Jugador>();
		jugadores.add(j1);
		jugadores.add(j2);
		jugadores.add(j3);
		Turno.inicializarTurno(jugadores);

		Tablero.getInstance().desplazar(j1, Tablero.CASILLA_SALIDA);
		Tablero.getInstance().desplazar(j2, Tablero.CASILLA_SALIDA);
		Tablero.getInstance().desplazar(j3, Tablero.CASILLA_SALIDA);
		VistaTablero.getInstance().dibujarFichaJugador(vj1);
		VistaTablero.getInstance().dibujarFichaJugador(vj2);
		VistaTablero.getInstance().dibujarFichaJugador(vj3);
	}

	public Algopoly() {
		this.vistaJugadores = new HashMap<Jugador, VistaJugador>();
		this.crearElementos();
		this.iniciarJuego();
		this.dibujarPanel();
	}

	public static Algopoly getInstance() {
		if (algopoly == null) {
			algopoly = new Algopoly();
		}
		return algopoly;
	}

	public void redibujar() {
		this.dibujarPanel();
		VistaTablero.getInstance().dibujarTablero();
	}

	public void tirarDadosSetDisable(boolean estado) {
		this.botonTirarDados.setDisable(estado);
	}

	public void terminarTurnoSetDisable(boolean estado) {
		this.botonTerminarTurno.setDisable(estado);
	}

	public VistaJugador obtenerVistaJugador(Jugador unJugador) {
		return this.vistaJugadores.get(unJugador);
	}
}
