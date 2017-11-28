package vista;

import java.util.ArrayList;
import java.util.LinkedList;

import modelo.entidades.*;
import modelo.juego.Turno;
import vista.tablero.VistaTablero;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Aplicacion extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(final Stage stage) throws Exception {
    	Jugador j1 = new JugadorUno("YO");
    	Jugador j2 = new JugadorDos("TU");
    	Jugador j3 = new JugadorTres("EL");
    	
    	LinkedList<Jugador> jugadores = new LinkedList<Jugador>();
    	jugadores.add(j1);
    	jugadores.add(j2);
    	jugadores.add(j3);
    	
    	Turno.inicializarTurno(jugadores);

        stage.setTitle("Algopoy");

        BorderPane contenedorPrincipal = new BorderPane();
        
        contenedorPrincipal.setCenter(VistaTablero.getInstance());
        
        
        contenedorPrincipal.setPadding(new Insets(0));
        
        
        VBox panelLateral = new VBox();
        panelLateral.setPrefSize(200, 600);

        contenedorPrincipal.setRight(panelLateral);
        
        
//        contenedorPrincipal.setMenu(stage);

        Scene escenaJuego = new Scene(contenedorPrincipal, 800, 600);
/*
        AplicacionOnKeyPressEventHandler AplicacionOnKeyPressEventHandler = new AplicacionOnKeyPressEventHandler(stage, contenedorPrincipal.getBarraDeMenu());
        escenaJuego.setOnKeyPressed(AplicacionOnKeyPressEventHandler);

        ContenedorBienvenidos contenedorBienvenidos = new ContenedorBienvenidos(stage, escenaJuego);
*/
//		Scene escenaBienvenidos = new Scene(new VBox(), 640, 480);

        stage.setScene(escenaJuego);
        stage.setFullScreen(false);
        stage.setResizable(false);

        stage.show();

    }

}
