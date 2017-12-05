package modelo.tablero.poseibles.barrios.construcciones;

import java.util.ArrayList;
import java.util.List;

public class HastaDosCasas extends ConstruccionPosible {

	public HastaDosCasas(){
		this.construcciones = new ArrayList<Construible>();
		this.construcciones.add(new UnaCasaConstruible());
		this.construcciones.add(new DosCasasConstruible());
	}

	@Override
	public ConstruccionPosible actualizarCon(ConstruccionPosible otraConstruccionPosible) {
		return otraConstruccionPosible.actualizarConHastaDosCasas(this);
	}

	@Override
	public ConstruccionPosible actualizarConNoConstruye(ConstruccionPosible otraConstruccionPosible) {
		return this;
	}

	@Override
	public ConstruccionPosible actualizarConSoloCasa(ConstruccionPosible otraConstruccionPosible) {
		List<Construible> construccionesAux = new ArrayList<Construible>();

		construccionesAux.addAll(otraConstruccionPosible.construcciones);
		construccionesAux.add(this.construcciones.get(this.construcciones.size() - 1));
		
		this.construcciones = construccionesAux;
		
		return this;
	}

	@Override
	public ConstruccionPosible actualizarConHastaDosCasas(ConstruccionPosible otraConstruccionPosible) {
		return otraConstruccionPosible;
	}

	@Override
	public ConstruccionPosible actualizarConHastaHotel(ConstruccionPosible otraConstruccionPosible) {
/*
		List<Construible> construccionesAux = new ArrayList<Construible>();

		construccionesAux.addAll(this.construcciones);
		construccionesAux.add(otraConstruccionPosible.construcciones.get(otraConstruccionPosible.construcciones.size() - 1));
		
		otraConstruccionPosible.construcciones = construccionesAux;
*/
		return otraConstruccionPosible;
	}

	@Override
	public ConstruccionPosible actualizarConSoloEdificioHistorico(ConstruccionPosible otraConstruccionPosible) {
		return this;
	}
}
