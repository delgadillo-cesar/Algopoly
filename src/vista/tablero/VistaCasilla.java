package vista.tablero;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

import vista.jugador.VistaJugador;
import modelo.entidades.Jugador;
import javafx.scene.canvas.Canvas;
import javafx.scene.image.Image;
import javafx.scene.layout.VBox;

public abstract class VistaCasilla extends VBox {

	protected EstadoVista estadoVista;
	protected String stringImagen;	
	
	protected Image imagen;
	protected Canvas canvas;
	protected HashSet<VistaJugador> jugadores;
	private HashMap<Integer, List<Integer>> distribucionFichas;
	
	
	public VistaCasilla(){
		this.canvas = new Canvas(VistaTablero.ANCHO_CASILLA, VistaTablero.ALTO_CASILLA);
	    this.setPrefSize(VistaTablero.ANCHO_CASILLA, VistaTablero.ALTO_CASILLA);
	    this.getChildren().add(canvas);

	    this.jugadores = new HashSet<VistaJugador>();
	    
	    this.distribucionFichas = new HashMap<Integer, List<Integer>>();

	    List<Integer> posFichas = new ArrayList<Integer>();
	    posFichas.add(0);
	    this.distribucionFichas.put(1, posFichas);
	    
	    posFichas = new ArrayList<Integer>();
	    posFichas.add(-7);
	    posFichas.add(7);
	    this.distribucionFichas.put(2, posFichas);

	    posFichas = new ArrayList<Integer>();
	    posFichas.add(-12);
	    posFichas.add(0);
	    posFichas.add(12);
	    this.distribucionFichas.put(3, posFichas);
	}
	
	public void dibujarCasilla(){
	    this.imagen = new Image(stringImagen, VistaTablero.ANCHO_CASILLA, VistaTablero.ALTO_CASILLA, true, false);
		this.canvas.getGraphicsContext2D().drawImage(this.imagen, 0, 0);
		
		Iterator<VistaJugador> i = this.jugadores.iterator();
		VistaJugador jugador;

		if(this.jugadores.size() > 0){
			List<Integer> posFichas = this.distribucionFichas.get(this.jugadores.size());
			int posicionH, index = 0;
			
			while(i.hasNext()){
				jugador = i.next();
				posicionH = (VistaTablero.ANCHO_CASILLA/2) + (posFichas.get(index));
				this.canvas.getGraphicsContext2D().drawImage(jugador.getFicha(), posicionH,  VistaTablero.ALTO_CASILLA/2);
				index ++;
			}
		}
	}

	public void jugadorCaeEnCasilla(VistaJugador unJugador){
		this.jugadores.add(unJugador);
		this.estadoVista.jugadorCayoEnCasilla(unJugador);
	}

	public void jugadorSaleDeCasilla(VistaJugador unJugador){
		this.jugadores.remove(unJugador);
	}
	
	public void habilitarParaJugador(Jugador unJugador){
		this.setDisable(!this.estadoVista.habilitarParaJugador(unJugador));
	}
	
	public void cambiarEstado(EstadoVista estado){
		this.estadoVista = estado;
		this.setOnMouseClicked(this.estadoVista.obtenerHandler(this.imagen));
	}
}
