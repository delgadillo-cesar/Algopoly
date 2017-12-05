package modelo.tablero.poseibles.barrios.construcciones;

import java.util.ArrayList;


public class NoConstruye extends ConstruccionPosible {
	
	public NoConstruye(){
		this.construcciones = new ArrayList<Construible>();
	}

	@Override
	public ConstruccionPosible actualizarCon(ConstruccionPosible otraConstruccionPosible) {
		return otraConstruccionPosible;
	}

	@Override
	public ConstruccionPosible actualizarConNoConstruye(ConstruccionPosible otraConstruccionPosible) {
		return otraConstruccionPosible;
	}

	@Override
	public ConstruccionPosible actualizarConSoloCasa(ConstruccionPosible otraConstruccionPosible) {
		return otraConstruccionPosible;
	}

	@Override
	public ConstruccionPosible actualizarConHastaDosCasas(ConstruccionPosible otraConstruccionPosible) {
		return otraConstruccionPosible;
	}

	@Override
	public ConstruccionPosible actualizarConHastaHotel(ConstruccionPosible otraConstruccionPosible) {
		return otraConstruccionPosible;
	}

	@Override
	public ConstruccionPosible actualizarConSoloEdificioHistorico(ConstruccionPosible otraConstruccionPosible) {
		return otraConstruccionPosible;
	}

}
