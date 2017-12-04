package vista.tablero;

import java.util.HashMap;
import java.util.Map;

import modelo.entidades.Jugador;
import modelo.juego.Turno;
import modelo.tablero.Tablero;

import vista.Algopoly;
import vista.jugador.VistaJugador;
import vista.tablero.acciones.*;
import vista.tablero.casilla.VistaCasillaAysa;
import vista.tablero.casilla.VistaCasillaBuenosAiresNorte;
import vista.tablero.casilla.VistaCasillaBuenosAiresSur;
import vista.tablero.casilla.VistaCasillaCordobaNorte;
import vista.tablero.casilla.VistaCasillaCordobaSur;
import vista.tablero.casilla.VistaCasillaEdesur;
import vista.tablero.casilla.VistaCasillaNeuquen;
import vista.tablero.casilla.VistaCasillaSaltaNorte;
import vista.tablero.casilla.VistaCasillaSaltaSur;
import vista.tablero.casilla.VistaCasillaSantaFe;
import vista.tablero.casilla.VistaCasillaSubte;
import vista.tablero.casilla.VistaCasillaTren;
import vista.tablero.casilla.VistaCasillaTucuman;
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

	    this.casillas.put(Tablero.CASILLA_SALIDA, new VistaCasillaSalida());
	    this.casillas.put(Tablero.CASILLA_QUINI, new VistaCasillaQuini());
	    this.casillas.put(Tablero.CASILLA_BUENOS_AIRES_SUR, new VistaCasillaBuenosAiresSur());
	    this.casillas.put(Tablero.CASILLA_EDESUR, new VistaCasillaEdesur());
	    this.casillas.put(Tablero.CASILLA_BUENOS_AIRES_NORTE, new VistaCasillaBuenosAiresNorte());
	    this.casillas.put(Tablero.CASILLA_CARCEL, new VistaCasillaCarcel());
	    this.casillas.put(Tablero.CASILLA_CORDOBA_SUR, new VistaCasillaCordobaSur());
	    this.casillas.put(Tablero.CASILLA_AVANCE_DINAMICO, new VistaCasillaAvanceDinamico());
	    this.casillas.put(Tablero.CASILLA_SUBTE, new VistaCasillaSubte());
	    this.casillas.put(Tablero.CASILLA_CORDOBA_NORTE, new VistaCasillaCordobaNorte());
	    this.casillas.put(Tablero.CASILLA_IMPUESTO_DE_LUJO, new VistaCasillaImpuestoLujo());
	    this.casillas.put(Tablero.CASILLA_SANTA_FE, new VistaCasillaSantaFe());
	    this.casillas.put(Tablero.CASILLA_AYSA, new VistaCasillaAysa());
	    this.casillas.put(Tablero.CASILLA_SALTA_NORTE, new VistaCasillaSaltaNorte());
	    this.casillas.put(Tablero.CASILLA_SALTA_SUR, new VistaCasillaSaltaSur());
	    this.casillas.put(Tablero.CASILLA_POLICIA, new VistaCasillaPolicia());
	    this.casillas.put(Tablero.CASILLA_TREN, new VistaCasillaTren());
	    this.casillas.put(Tablero.CASILLA_NEUQUEN, new VistaCasillaNeuquen());
	    this.casillas.put(Tablero.CASILLA_RETROCESO_DINAMICO, new VistaCasillaRetrocesoDinamico());
	    this.casillas.put(Tablero.CASILLA_TUCUMAN, new VistaCasillaTucuman());

	    
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

	public VistaCasilla obtenerCasilla(Integer casilla) {
		return this.casillas.get(casilla);
	}
}
