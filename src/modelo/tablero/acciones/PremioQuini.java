package modelo.tablero.acciones;

public class PremioQuini {
	
	private TipoPremioQuini premio;
	
	public PremioQuini(){
		premio = new QuiniPrimeraVez();
	}

	public int cobrarPremio(){
		int premioAPagar = premio.cobrarPremio();
		premio = premio.getProximoPremio();
		
		return premioAPagar;
	}
	
}
