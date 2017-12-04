package vista;

import vista.tablero.VistaTablero;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Aplicacion extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(final Stage stage) throws Exception {
        stage.setTitle("Algopoy");
        Scene escenaJuego = new Scene(Algopoly.getInstance(), 200+(VistaTablero.ANCHO_CASILLA * 6), VistaTablero.ALTO_CASILLA * 6);
        stage.setScene(escenaJuego);
        stage.setFullScreen(false);
        stage.setResizable(false);

        stage.show();

    }

}
