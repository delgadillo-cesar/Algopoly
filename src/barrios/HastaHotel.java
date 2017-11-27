package barrios;

import java.util.ArrayList;

public class HastaHotel extends ConstruccionPosible {

	public HastaHotel(){
		this.construcciones = new ArrayList<Construible>();
		this.construcciones.add(new UnaCasa());
		this.construcciones.add(new DosCasas());
		this.construcciones.add(new Hotel());
	}

}
