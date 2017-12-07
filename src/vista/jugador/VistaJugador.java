package vista.jugador;

import java.util.ArrayList;
import java.util.List;
import modelo.entidades.Jugador;
import modelo.juego.Turno;
import javafx.geometry.Insets;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;

public class VistaJugador extends VBox {

	private static List<Image> fichas;
	private static List<Color> colores;

	private static final Background unfocusBackground = new Background( new BackgroundFill( Color.web( "#FFFFFF" ), CornerRadii.EMPTY, Insets.EMPTY ) );
	
	private Image ficha;
	private Color color;
	private Jugador elJugador;
	private Text nombreJugador;
	private Text saldoJugador;
	private Text gameOver;
	

	
	private static void crearFichas(){
		fichas = new ArrayList<Image>();

	    fichas.add(new Image("file:src/vista/imagenes/rojo.png", 20, 30, true, false));
	    fichas.add(new Image("file:src/vista/imagenes/amarillo.png", 20, 30, true, false));
	    fichas.add(new Image("file:src/vista/imagenes/fucsia.png", 20, 30, true, false));
	}
	
	private static void crearColores(){
		colores = new ArrayList<Color>();

//		colores.add(new Background(new BackgroundFill( Color.web( "#FF3333" ), CornerRadii.EMPTY, Insets.EMPTY )));
		colores.add(Color.web( "#FF3333" ));
		colores.add(Color.web( "#FFFF33" ));
		colores.add(Color.web( "#FF00FF" ));
	}
	

	public VistaJugador(Jugador unJugador){
		this.setSpacing(10);
		this.elJugador = unJugador;

		this.nombreJugador = new Text();
		this.saldoJugador = new Text();
		this.gameOver = new Text();
		this.gameOver.setVisible(false);
		
		if (fichas == null) crearFichas();
		if (fichas.size() > 0){
			this.ficha = fichas.get(0);
			fichas.remove(0);
		}

		if (colores == null) crearColores();
		if (colores.size() > 0){
			this.color = colores.get(0);
			colores.remove(0);
		}
	}

	public Image getFicha() {
		return this.ficha;
	}

	public Color getColor() {
		return this.color;
	}

	public void actualizar() {
		this.getChildren().clear();

		if (Turno.getInstance().turnoActual() == this.elJugador)
			this.setBackground(new Background(new BackgroundFill( this.color, CornerRadii.EMPTY, Insets.EMPTY )));
		else
			this.setBackground( unfocusBackground );
		
		nombreJugador.setFont(new Font(18));
		nombreJugador.setWrappingWidth(200);
		nombreJugador.setTextAlignment(TextAlignment.JUSTIFY);
		nombreJugador.setText("Jugador: " + this.elJugador.nombreJugador());

		
		saldoJugador.setFont(new Font(16));
		saldoJugador.setWrappingWidth(200);
		saldoJugador.setTextAlignment(TextAlignment.JUSTIFY);
		saldoJugador.setText("Saldo: " + this.elJugador.capital());

		gameOver.setFont(new Font(16));
		gameOver.setWrappingWidth(200);
		gameOver.setTextAlignment(TextAlignment.JUSTIFY);
		gameOver.setText("GAME OVER");


		this.getChildren().add(nombreJugador);
		this.getChildren().add(saldoJugador);
		this.getChildren().add(gameOver);
	}

	public Jugador getJugador(){
		return this.elJugador;
	}

	public void gameOver() {
		this.saldoJugador.setVisible(false);
		this.gameOver.setVisible(true);
	}
}
