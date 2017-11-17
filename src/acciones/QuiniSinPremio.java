package acciones;

public class QuiniSinPremio extends TipoPremioQuini {

	public QuiniSinPremio(){
		this.premio = 0;
		this.proximoPremio = this;
	}
}
