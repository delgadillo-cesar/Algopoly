package modelo.tablero.casillas.acciones;

public abstract class TipoPremioQuini {

	protected TipoPremioQuini proximoPremio;
	protected int premio;
	
	
	public TipoPremioQuini getProximoPremio(){
		return this.proximoPremio;
	}
	
	public int cobrarPremio(){
		return this.premio;
	}
}
