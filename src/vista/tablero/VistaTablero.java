package vista.tablero;

import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.ToggleButton;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class VistaTablero extends BorderPane {

	protected static final int ANCHO_CASILLA_VERTICAL = 120;
	protected static final int ALTO_CASILLA_VERTICAL = 90;
	protected static final int ANCHO_CASILLA_HORIZONTAL = 90;
	protected static final int ALTO_CASILLA_HORIZONTAL = 120;
	protected static VistaTablero laVistaTablero;

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
	    
        botonSalida = new Button();
        botonSalida.setStyle("-fx-background-image: url('/vista/imagenes/CasillaSalida.png')");
        botonSalida.setMinSize(ANCHO_CASILLA_VERTICAL, ALTO_CASILLA_HORIZONTAL);

        botonQuini = new Button();
        botonQuini.setStyle("-fx-background-image: url('/vista/imagenes/CasillaQuini.png')");
        botonQuini.setMinSize(ANCHO_CASILLA_HORIZONTAL, ALTO_CASILLA_HORIZONTAL);
        
        botonBuenoAiresSur = new Button();
        botonBuenoAiresSur.setStyle("-fx-background-image: url('/vista/imagenes/CasillaBuenosAiresSur.png')");
        botonBuenoAiresSur.setMinSize(ANCHO_CASILLA_HORIZONTAL, ALTO_CASILLA_HORIZONTAL);
        
        botonEdesur = new Button();
        botonEdesur.setStyle("-fx-background-image: url('/vista/imagenes/CasillaEdesur.png')");
        botonEdesur.setMinSize(ANCHO_CASILLA_HORIZONTAL, ALTO_CASILLA_HORIZONTAL);
        
        botonBuenoAiresNorte = new Button();
        botonBuenoAiresNorte.setStyle("-fx-background-image: url('/vista/imagenes/CasillaBuenosAiresNorte.png')");
        botonBuenoAiresNorte.setMinSize(ANCHO_CASILLA_HORIZONTAL, ALTO_CASILLA_HORIZONTAL);
	    
        botonCarcel = new Button();
        botonCarcel.setStyle("-fx-background-image: url('/vista/imagenes/CasillaCarcel.png')");
        botonCarcel.setMinSize(ANCHO_CASILLA_VERTICAL, ALTO_CASILLA_HORIZONTAL);
        
        botonCordobaSur = new Button();
        botonCordobaSur.setStyle("-fx-background-image: url('/vista/imagenes/CasillaCordobaSur.png')");
        botonCordobaSur.setMinSize(ANCHO_CASILLA_VERTICAL, ALTO_CASILLA_VERTICAL);

        botonAvanceDinamico = new Button();
        botonAvanceDinamico.setStyle("-fx-background-image: url('/vista/imagenes/CasillaAvanceDinamico.png')");
        botonAvanceDinamico.setMinSize(ANCHO_CASILLA_VERTICAL, ALTO_CASILLA_VERTICAL);
        
        botonSubte = new Button();
        botonSubte.setStyle("-fx-background-image: url('/vista/imagenes/CasillaSubte.png')");
        botonSubte.setMinSize(ANCHO_CASILLA_VERTICAL, ALTO_CASILLA_VERTICAL);
        
        botonCordobaNorte = new Button();
        botonCordobaNorte.setStyle("-fx-background-image: url('/vista/imagenes/CasillaCordobaNorte.png')");
        botonCordobaNorte.setMinSize(ANCHO_CASILLA_VERTICAL, ALTO_CASILLA_VERTICAL);

        botonImpuestoLujo = new Button();
        botonImpuestoLujo.setStyle("-fx-background-image: url('/vista/imagenes/CasillaImpuestoLujo.png')");
        botonImpuestoLujo.setMinSize(ANCHO_CASILLA_VERTICAL, ALTO_CASILLA_HORIZONTAL);

        botonSantaFe = new Button();
        botonSantaFe.setStyle("-fx-background-image: url('/vista/imagenes/CasillaSantaFe.png')");
        botonSantaFe.setMinSize(ANCHO_CASILLA_HORIZONTAL, ALTO_CASILLA_HORIZONTAL);
        
        botonAysa= new VistaAysaComprable();
        
        botonSaltaNorte = new Button();
        botonSaltaNorte.setStyle("-fx-background-image: url('/vista/imagenes/CasillaSaltaNorte.png')");
        botonSaltaNorte.setMinSize(ANCHO_CASILLA_HORIZONTAL, ALTO_CASILLA_HORIZONTAL);
        
        botonSaltaSur = new Button();
        botonSaltaSur.setStyle("-fx-background-image: url('/vista/imagenes/CasillaSaltaSur.png')");
        botonSaltaSur.setMinSize(ANCHO_CASILLA_HORIZONTAL, ALTO_CASILLA_HORIZONTAL);
	    
        botonPolicia = new Button();
        botonPolicia.setStyle("-fx-background-image: url('/vista/imagenes/CasillaPolicia.png')");
        botonPolicia.setMinSize(ANCHO_CASILLA_VERTICAL, ALTO_CASILLA_HORIZONTAL);
        
        botonTren = new Button();
        botonTren.setStyle("-fx-background-image: url('/vista/imagenes/CasillaTren.png')");
        botonTren.setMinSize(ANCHO_CASILLA_VERTICAL, ALTO_CASILLA_VERTICAL);

        botonNeuquen = new Button();
        botonNeuquen.setStyle("-fx-background-image: url('/vista/imagenes/CasillaNeuquen.png')");
        botonNeuquen.setMinSize(ANCHO_CASILLA_VERTICAL, ALTO_CASILLA_VERTICAL);
        
        botonRetrocesoDinamico = new Button();
        botonRetrocesoDinamico.setStyle("-fx-background-image: url('/vista/imagenes/CasillaRetrocesoDinamico.png')");
        botonRetrocesoDinamico.setMinSize(ANCHO_CASILLA_VERTICAL, ALTO_CASILLA_VERTICAL);
        
        botonTucuman = new Button();
        botonTucuman.setStyle("-fx-background-image: url('/vista/imagenes/CasillaTucuman.png')");
        botonTucuman.setMinSize(ANCHO_CASILLA_VERTICAL, ALTO_CASILLA_VERTICAL);

        this.dibujarTablero();
        this.setPadding(new Insets(0));
	}

	public static VistaTablero getInstance(){
		if(laVistaTablero == null){
			laVistaTablero = new VistaTablero();
		}
		return laVistaTablero;
	}
	
	
	public void setBotonAysa(Button unBoton){
		this.botonAysa = unBoton;
		this.dibujarTablero();
	}
}
