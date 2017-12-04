package vista.tablero;

import java.util.HashMap;
import java.util.Map;

import modelo.entidades.Jugador;
import modelo.juego.Turno;
import modelo.tablero.Tablero;

import vista.Algopoly;
import vista.jugador.VistaJugador;
import vista.tablero.acciones.*;
import vista.tablero.comprables.*;
import javafx.geometry.Insets;
import javafx.scene.image.Image;
import javafx.scene.layout.*;

public class VistaTablero extends BorderPane {

	public static final int ANCHO_CASILLA = 100;
	public static final int ALTO_CASILLA = 100;
	private static VistaTablero laVistaTablero;
	private HashMap<Integer, VistaCasilla> casillas;

	
	public void dibujarTablero(){
		
		for(Map.Entry<Integer, VistaCasilla> casilla : this.casillas.entrySet()){
			try{
				casilla.getValue().habilitarParaJugador(Turno.getInstance().turnoActual());
				casilla.getValue().dibujarCasilla();
			}catch(NullPointerException e){}
		}
		
        HBox contenedorInferior = new HBox();
        contenedorInferior.getChildren().add(this.casillas.get(Tablero.CASILLA_CARCEL));
        contenedorInferior.getChildren().add(this.casillas.get(Tablero.CASILLA_BUENOS_AIRES_NORTE));
        contenedorInferior.getChildren().add(this.casillas.get(Tablero.CASILLA_EDESUR));
        contenedorInferior.getChildren().add(this.casillas.get(Tablero.CASILLA_BUENOS_AIRES_SUR));
        contenedorInferior.getChildren().add(this.casillas.get(Tablero.CASILLA_QUINI));
        contenedorInferior.getChildren().add(this.casillas.get(Tablero.CASILLA_SALIDA));
        contenedorInferior.setSpacing(0);
        contenedorInferior.setPadding(new Insets(0));
        this.setBottom(contenedorInferior);
        
        VBox contenedorIzquierdo = new VBox();
        contenedorIzquierdo.getChildren().add(this.casillas.get(Tablero.CASILLA_CORDOBA_NORTE));
        contenedorIzquierdo.getChildren().add(this.casillas.get(Tablero.CASILLA_SUBTE));
        contenedorIzquierdo.getChildren().add(this.casillas.get(Tablero.CASILLA_AVANCE_DINAMICO));
        contenedorIzquierdo.getChildren().add(this.casillas.get(Tablero.CASILLA_CORDOBA_SUR));
        contenedorIzquierdo.setSpacing(0);
        contenedorIzquierdo.setPadding(new Insets(0));
        this.setLeft(contenedorIzquierdo);

        HBox contenedorSuperior = new HBox();
        contenedorSuperior.getChildren().add(this.casillas.get(Tablero.CASILLA_IMPUESTO_DE_LUJO));
        contenedorSuperior.getChildren().add(this.casillas.get(Tablero.CASILLA_SANTA_FE));
        contenedorSuperior.getChildren().add(this.casillas.get(Tablero.CASILLA_AYSA));
        contenedorSuperior.getChildren().add(this.casillas.get(Tablero.CASILLA_SALTA_NORTE));
        contenedorSuperior.getChildren().add(this.casillas.get(Tablero.CASILLA_SALTA_SUR));
        contenedorSuperior.getChildren().add(this.casillas.get(Tablero.CASILLA_POLICIA));
        contenedorSuperior.setSpacing(0);
        contenedorSuperior.setPadding(new Insets(0));
        this.setTop(contenedorSuperior);

        VBox contenedorDerecho = new VBox();
        contenedorDerecho.getChildren().add(this.casillas.get(Tablero.CASILLA_TREN));
        contenedorDerecho.getChildren().add(this.casillas.get(Tablero.CASILLA_NEUQUEN));
        contenedorDerecho.getChildren().add(this.casillas.get(Tablero.CASILLA_RETROCESO_DINAMICO));
        contenedorDerecho.getChildren().add(this.casillas.get(Tablero.CASILLA_TUCUMAN));
        contenedorDerecho.setSpacing(0);
        contenedorDerecho.setPadding(new Insets(0));
        this.setRight(contenedorDerecho);
	}

	private VistaTablero(){
		Image imagen = new Image("file:src/vista/imagenes/tablero.jpg");
	    BackgroundImage imagenDeFondo = new BackgroundImage(imagen, BackgroundRepeat.REPEAT, BackgroundRepeat.REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);
	    this.setBackground(new Background(imagenDeFondo));

	    this.casillas = new HashMap<Integer, VistaCasilla>();
	    this.casillas.put(Tablero.CASILLA_SALIDA, new VistaSalida());
	    this.casillas.put(Tablero.CASILLA_QUINI, new VistaQuini());
	    this.casillas.put(Tablero.CASILLA_BUENOS_AIRES_SUR, new VistaBuenosAiresSurComprable());
	    this.casillas.put(Tablero.CASILLA_EDESUR, new VistaEdesurComprable());
	    this.casillas.put(Tablero.CASILLA_BUENOS_AIRES_NORTE, new VistaBuenosAiresNorteComprable());
	    this.casillas.put(Tablero.CASILLA_CARCEL, new VistaCarcel());
	    this.casillas.put(Tablero.CASILLA_CORDOBA_SUR, new VistaCordobaSurComprable());
	    this.casillas.put(Tablero.CASILLA_AVANCE_DINAMICO, new VistaAvanceDinamico());
	    this.casillas.put(Tablero.CASILLA_SUBTE, new VistaSubteComprable());
	    this.casillas.put(Tablero.CASILLA_CORDOBA_NORTE, new VistaCordobaNorteComprable());
	    this.casillas.put(Tablero.CASILLA_IMPUESTO_DE_LUJO, new VistaImpuestoLujo());
	    this.casillas.put(Tablero.CASILLA_SANTA_FE, new VistaSantaFeComprable());
	    this.casillas.put(Tablero.CASILLA_AYSA, new VistaAysaComprable());
	    this.casillas.put(Tablero.CASILLA_SALTA_NORTE, new VistaSaltaNorteComprable());
	    this.casillas.put(Tablero.CASILLA_SALTA_SUR, new VistaSaltaSurComprable());
	    this.casillas.put(Tablero.CASILLA_POLICIA, new VistaPolicia());
	    this.casillas.put(Tablero.CASILLA_TREN, new VistaTrenComprable());
	    this.casillas.put(Tablero.CASILLA_NEUQUEN, new VistaNeuquenComprable());
	    this.casillas.put(Tablero.CASILLA_RETROCESO_DINAMICO, new VistaRetrocesoDinamico());
	    this.casillas.put(Tablero.CASILLA_TUCUMAN, new VistaTucumanComprable());

        this.dibujarTablero();
        this.setPadding(new Insets(0));
	}

	public static VistaTablero getInstance(){
		if(laVistaTablero == null){
			laVistaTablero = new VistaTablero();
		}
		return laVistaTablero;
	}
	
	
	public void setAysa(VistaCasilla unaCasilla){
	    this.casillas.put(Tablero.CASILLA_AYSA, unaCasilla);
		this.dibujarTablero();
	}

	public void setEdesur(VistaCasilla unaCasilla) {
	    this.casillas.put(Tablero.CASILLA_EDESUR, unaCasilla);
		this.dibujarTablero();
	}

	public void setTren(VistaCasilla unaCasilla) {
	    this.casillas.put(Tablero.CASILLA_TREN, unaCasilla);
		this.dibujarTablero();
	}

	public void setSubte(VistaCasilla unaCasilla) {
	    this.casillas.put(Tablero.CASILLA_SUBTE, unaCasilla);
		this.dibujarTablero();
	}
	
	public void setBuenosAiresNorte(VistaCasilla unaCasilla){
	    this.casillas.put(Tablero.CASILLA_BUENOS_AIRES_NORTE, unaCasilla);
			this.dibujarTablero();
	}

	public void setBuenosAiresSur(VistaCasilla unaCasilla){
	    this.casillas.put(Tablero.CASILLA_BUENOS_AIRES_SUR, unaCasilla);
		this.dibujarTablero();
}

	public void setCordobaNorte(VistaCasilla unaCasilla) {
	    this.casillas.put(Tablero.CASILLA_CORDOBA_NORTE, unaCasilla);
		this.dibujarTablero();
	}

	public void setCordobaSur(VistaCasilla unaCasilla) {
	    this.casillas.put(Tablero.CASILLA_CORDOBA_SUR, unaCasilla);
		this.dibujarTablero();
	}

	public void setSantaFe(VistaCasilla unaCasilla) {
	    this.casillas.put(Tablero.CASILLA_SANTA_FE, unaCasilla);
		this.dibujarTablero();
	}

	public void setNeuquen(VistaCasilla unaCasilla) {
	    this.casillas.put(Tablero.CASILLA_NEUQUEN, unaCasilla);
		this.dibujarTablero();
	}

	public void setTucuman(VistaCasilla unaCasilla) {
	    this.casillas.put(Tablero.CASILLA_TUCUMAN, unaCasilla);
		this.dibujarTablero();
	}

	public void setSaltaNorte(VistaCasilla unaCasilla) {
	    this.casillas.put(Tablero.CASILLA_SALTA_NORTE, unaCasilla);
		this.dibujarTablero();
	}

	public void setSaltaSur(VistaCasilla unaCasilla) {
	    this.casillas.put(Tablero.CASILLA_SALTA_SUR, unaCasilla);
		this.dibujarTablero();
	}

	public void dibujarFichaJugador(VistaJugador unJugador) {
		int posJugador = Tablero.getInstance().casillaDeJugador(unJugador.getJugador());
		VistaCasilla casilla = this.casillas.get(posJugador);
		casilla.jugadorCaeEnCasilla(unJugador);
		this.dibujarTablero();
	}

	public void moverJugadrDeTurno(int cantidadAMover) {
		Jugador unJugador = Turno.getInstance().turnoActual();
		int casillaAnterior = Tablero.getInstance().casillaDeJugador(unJugador);
		unJugador.mover(cantidadAMover);
		int casillaPosterior = Tablero.getInstance().casillaDeJugador(unJugador);
		
		
		VistaCasilla casilla = this.casillas.get(casillaAnterior);
		casilla.jugadorSaleDeCasilla(Algopoly.getInstance().obtenerVistaJugador(unJugador));

		casilla = this.casillas.get(casillaPosterior);
		casilla.jugadorCaeEnCasilla(Algopoly.getInstance().obtenerVistaJugador(unJugador));

		this.dibujarTablero();
	}
}
