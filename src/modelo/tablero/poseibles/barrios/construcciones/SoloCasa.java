package modelo.tablero.poseibles.barrios.construcciones;

import java.util.ArrayList;

public class SoloCasa extends ConstruccionPosible {

	public SoloCasa(){
		this.construcciones = new ArrayList<Construible>();
		this.construcciones.add(new UnaCasaConstruible());
	}

	@Override
	public ConstruccionPosible actualizarCon(ConstruccionPosible otraConstruccionPosible) {
		return otraConstruccionPosible.actualizarConSoloCasa(this);
	}

	@Override
	public ConstruccionPosible actualizarConNoConstruye(ConstruccionPosible otraConstruccionPosible) {
		return this;
	}

	@Override
	public ConstruccionPosible actualizarConSoloCasa(ConstruccionPosible otraConstruccionPosible) {
		return otraConstruccionPosible;
	}

	@Override
	public ConstruccionPosible actualizarConHastaDosCasas(ConstruccionPosible otraConstruccionPosible) {
/*
		List<Construible> construccionesAux = new ArrayList<Construible>();

		construccionesAux.addAll(this.construcciones);
		construccionesAux.add(otraConstruccionPosible.construcciones.get(otraConstruccionPosible.construcciones.size() - 1));
		
		otraConstruccionPosible.construcciones = construccionesAux;
*/		
		return otraConstruccionPosible;
	}

	@Override
	public ConstruccionPosible actualizarConHastaHotel(ConstruccionPosible otraConstruccionPosible) {
/*
		List<Construible> construccionesAux = new ArrayList<Construible>();

		construccionesAux.addAll(this.construcciones);
		construccionesAux.add(otraConstruccionPosible.construcciones.get(otraConstruccionPosible.construcciones.size() - 2));
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
