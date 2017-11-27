package barrios;

import java.util.ArrayList;

public class SoloCasa extends ConstruccionPosible {

	public SoloCasa(){
		this.construcciones = new ArrayList<Construible>();
		this.construcciones.add(new UnaCasa());
	}
}
