package barrios;

import java.util.ArrayList;

public class SoloEdificioHistorico extends ConstruccionPosible {

	public SoloEdificioHistorico(){
		this.construcciones = new ArrayList<Construible>();
		this.construcciones.add(new EdificioHistorico());
	}

}
