package modelo.tablero.casillas.acciones;

public class QuiniSegundaVez extends TipoPremioQuini {

	public QuiniSegundaVez(){
		this.premio = 30000;
		this.proximoPremio = new QuiniSinPremio();
	}
}
