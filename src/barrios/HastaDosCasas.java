package barrios;

import java.util.ArrayList;

public class HastaDosCasas extends ConstruccionPosible {

	public HastaDosCasas(){
		this.construcciones = new ArrayList<Construible>();
		this.construcciones.add(new UnaCasa());
		this.construcciones.add(new DosCasas());
	}

}
