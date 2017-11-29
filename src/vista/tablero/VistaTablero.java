package vista.tablero;

import vista.tablero.acciones.*;
import vista.tablero.comprables.*;
import vista.tablero.poseibles.VistaBuenosAiresNortePoseible;
import vista.tablero.poseibles.VistaCordobaNortePoseible;
import vista.tablero.poseibles.VistaSantaFePoseible;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.*;

public class VistaTablero extends BorderPane {

	public static final int ANCHO_CASILLA_VERTICAL = 120;
	public static final int ALTO_CASILLA_VERTICAL = 90;
	public static final int ANCHO_CASILLA_HORIZONTAL = 90;
	public static final int ALTO_CASILLA_HORIZONTAL = 120;
	private static VistaTablero laVistaTablero;

	private Button botonSalida;
	private Button botonQuini;
	private Button botonBuenoAiresSur;
	private Button botonEdesur;
	private Button botonBuenoAiresNorte;
	private Button botonCarcel;
	private Button botonCordobaSur;
	private Button botonAvanceDinamico;
	private Button botonSubte;
	private Button botonCordobaNorte;
	private Button botonImpuestoLujo;
	private Button botonSantaFe;
	private Button botonAysa;
	private Button botonSaltaNorte;
	private Button botonSaltaSur;
	private Button botonPolicia;
	private Button botonTren;
	private Button botonNeuquen;
	private Button botonRetrocesoDinamico;
	private Button botonTucuman;

	private void dibujarTablero(){
        HBox contenedorInferior = new HBox(botonCarcel, botonBuenoAiresNorte, botonEdesur, botonBuenoAiresSur, botonQuini, botonSalida);
        contenedorInferior.setSpacing(0);
        contenedorInferior.setPadding(new Insets(0));
        this.setBottom(contenedorInferior);
        
        VBox contenedorIzquierdo = new VBox(botonCordobaSur, botonAvanceDinamico, botonSubte, botonCordobaNorte);
        contenedorIzquierdo.setSpacing(0);
        contenedorIzquierdo.setPadding(new Insets(0));
        this.setLeft(contenedorIzquierdo);

        HBox contenedorSuperior = new HBox(botonImpuestoLujo, botonSantaFe, botonAysa, botonSaltaNorte, botonSaltaSur, botonPolicia);
        contenedorSuperior.setSpacing(0);
        contenedorSuperior.setPadding(new Insets(0));
        this.setTop(contenedorSuperior);

        VBox contenedorDerecho = new VBox(botonTren, botonNeuquen, botonRetrocesoDinamico, botonTucuman);
        contenedorDerecho.setSpacing(0);
        contenedorDerecho.setPadding(new Insets(0));
        this.setRight(contenedorDerecho);
	}

	private VistaTablero(){
	    Image imagen = new Image("file:src/vista/imagenes/tablero.jpg");
	    BackgroundImage imagenDeFondo = new BackgroundImage(imagen, BackgroundRepeat.REPEAT, BackgroundRepeat.REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);
	    this.setBackground(new Background(imagenDeFondo));
	    
        botonSalida = new VistaSalida();
        botonQuini = new VistaQuini();
        botonBuenoAiresSur = new VistaBuenosAiresSurComprable();
        botonEdesur = new VistaEdesurComprable();
        botonBuenoAiresNorte = new VistaBuenosAiresNorteComprable();
        botonCarcel = new VistaCarcel();
        botonCordobaSur = new VistaCordobaSurComprable();
        botonAvanceDinamico = new VistaAvanceDinamico();
        botonSubte = new VistaSubteComprable();
        botonCordobaNorte = new VistaCordobaNorteComprable();
        botonImpuestoLujo = new VistaImpuestoLujo();
        botonSantaFe = new VistaSantaFeComprable();
        botonAysa= new VistaAysaComprable();
        botonSaltaNorte = new VistaSaltaNorteComprable();
        botonSaltaSur = new VistaSaltaSurComprable();
        botonPolicia = new VistaPolicia();
        botonTren = new VistaTrenComprable();
        botonNeuquen = new VistaNeuquenComprable();
        botonRetrocesoDinamico = new VistaRetrocesoDinamico();
        botonTucuman = new VistaTucumanComprable();

        this.dibujarTablero();
        this.setPadding(new Insets(0));
	}

	public static VistaTablero getInstance(){
		if(laVistaTablero == null){
			laVistaTablero = new VistaTablero();
		}
		return laVistaTablero;
	}
	
	
	public void setAysa(Button unBoton){
		this.botonAysa = unBoton;
		this.dibujarTablero();
	}

	public void setEdesur(Button unBoton) {
		this.botonEdesur = unBoton;
		this.dibujarTablero();
	}

	public void setTren(Button unBoton) {
		this.botonTren = unBoton;
		this.dibujarTablero();
	}

	public void setSubte(Button unBoton) {
		this.botonSubte = unBoton;
		this.dibujarTablero();
	}
	

	public void setBuenosAiresNorte(Button unBoton){
			this.botonBuenoAiresNorte = unBoton;
			this.dibujarTablero();
	}

	public void setBuenosAiresSur(Button unBoton){
		this.botonBuenoAiresSur = unBoton;
		this.dibujarTablero();
}

	public void setCordobaNorte(Button unBoton) {
		this.botonCordobaNorte = unBoton;
		this.dibujarTablero();
	}

	public void setCordobaSur(Button unBoton) {
		this.botonCordobaSur = unBoton;
		this.dibujarTablero();
	}

	public void setSantaFe(Button unBoton) {
		this.botonSantaFe = unBoton;
		this.dibujarTablero();
	}

	public void setNeuquen(Button unBoton) {
		this.botonNeuquen = unBoton;
		this.dibujarTablero();
	}

	public void setTucuman(Button unBoton) {
		this.botonTucuman = unBoton;
		this.dibujarTablero();
	}

	public void setSaltaNorte(Button unBoton) {
		this.botonSaltaNorte = unBoton;
		this.dibujarTablero();
	}

	public void setSaltaSur(Button unBoton) {
		this.botonSaltaSur = unBoton;
		this.dibujarTablero();
	}
}
