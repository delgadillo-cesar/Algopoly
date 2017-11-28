package modelo.tablero.casillas.acciones;

public class QuiniPrimeraVez extends TipoPremioQuini {

	public QuiniPrimeraVez(){
		this.premio = 50000;
		this.proximoPremio = new QuiniSegundaVez();
	}
}
