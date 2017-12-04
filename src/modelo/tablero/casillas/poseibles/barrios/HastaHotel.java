package modelo.tablero.casillas.poseibles.barrios;

import java.util.ArrayList;
import java.util.List;

public class HastaHotel extends ConstruccionPosible {

	public HastaHotel(){
		this.construcciones = new ArrayList<Construible>();
		this.construcciones.add(new UnaCasa());
		this.construcciones.add(new DosCasas());
		this.construcciones.add(new Hotel());
	}

	@Override
	public ConstruccionPosible actualizarCon(ConstruccionPosible otraConstruccionPosible) {
		return otraConstruccionPosible.actualizarConHastaHotel(this);
	}

	@Override
	public ConstruccionPosible actualizarConNoConstruye(ConstruccionPosible otraConstruccionPosible) {
		return this;
	}

	@Override
	public ConstruccionPosible actualizarConSoloCasa(ConstruccionPosible otraConstruccionPosible) {
		List<Construible> construccionesAux = new ArrayList<Construible>();

		construccionesAux.addAll(otraConstruccionPosible.construcciones);
		construccionesAux.add(this.construcciones.get(this.construcciones.size() - 2));
		construccionesAux.add(this.construcciones.get(this.construcciones.size() - 1));
		
		this.construcciones = construccionesAux;
		
		return this;
	}

	@Override
	public ConstruccionPosible actualizarConHastaDosCasas(ConstruccionPosible otraConstruccionPosible) {
		List<Construible> construccionesAux = new ArrayList<Construible>();

		construccionesAux.addAll(otraConstruccionPosible.construcciones);
		construccionesAux.add(this.construcciones.get(this.construcciones.size() - 1));
		
		this.construcciones = construccionesAux;
		
		return this;
	}

	@Override
	public ConstruccionPosible actualizarConHastaHotel(ConstruccionPosible otraConstruccionPosible) {
		return otraConstruccionPosible;
	}

	@Override
	public ConstruccionPosible actualizarConSoloEdificioHistorico(ConstruccionPosible otraConstruccionPosible) {
		return this;
	}
}
