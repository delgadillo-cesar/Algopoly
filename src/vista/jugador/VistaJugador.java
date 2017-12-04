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
	private static final Background focusBackground = new Background( new BackgroundFill( Color.web( "#FFFFFF" ), CornerRadii.EMPTY, Insets.EMPTY ) );
	private  final Background unfocusBackground = new Background( new BackgroundFill( Color.web( "#FF3333" ), CornerRadii.EMPTY, Insets.EMPTY ) );
	
	private Image ficha;
	private Jugador elJugador;
	
	

	
	private static void crearFichas(){
		fichas = new ArrayList<Image>();

	    fichas.add(new Image("file:src/vista/imagenes/rojo.png", 20, 30, true, false));
	    fichas.add(new Image("file:src/vista/imagenes/amarillo.png", 20, 30, true, false));
	    fichas.add(new Image("file:src/vista/imagenes/fucsia.png", 20, 30, true, false));
	}
	

	public VistaJugador(Jugador unJugador){
		this.setSpacing(10);
		this.elJugador = unJugador;
		
		if (fichas == null) crearFichas();
		if (fichas.size() > 0){
			this.ficha = fichas.get(0);
			fichas.remove(0);
		}
	}

	public Image getFicha() {
		return this.ficha;
	}

	public void actualizar() {
		this.getChildren().clear();

		if (Turno.getInstance().turnoActual() == this.elJugador)
			this.setBackground( unfocusBackground );
		else
			this.setBackground( focusBackground );
		
		Text nombreJugador = new Text();
		nombreJugador.setFont(new Font(18));
		nombreJugador.setWrappingWidth(200);
		nombreJugador.setTextAlignment(TextAlignment.JUSTIFY);
		nombreJugador.setText("Jugador: " + this.elJugador.nombreJugador());

		
		Text saldoJugador = new Text();
		saldoJugador.setFont(new Font(16));
		saldoJugador.setWrappingWidth(200);
		saldoJugador.setTextAlignment(TextAlignment.JUSTIFY);
		saldoJugador.setText("Saldo: " + this.elJugador.capital());


		this.getChildren().add(nombreJugador);
		this.getChildren().add(saldoJugador);
	}

	public Jugador getJugador(){
		return this.elJugador;
	}
}
