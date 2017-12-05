package modelo.tablero.poseibles.barrios.construcciones;

import java.util.ArrayList;

public class SoloEdificioHistorico extends ConstruccionPosible {

	public SoloEdificioHistorico(){
		this.construcciones = new ArrayList<Construible>();
		this.construcciones.add(new EdificioHistoricoConstruible());
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
		return this;
	}

	@Override
	public ConstruccionPosible actualizarConHastaDosCasas(ConstruccionPosible otraConstruccionPosible) {
		return this;
	}

	@Override
	public ConstruccionPosible actualizarConHastaHotel(ConstruccionPosible otraConstruccionPosible) {
		return this;
	}

	@Override
	public ConstruccionPosible actualizarConSoloEdificioHistorico(ConstruccionPosible otraConstruccionPosible) {
		return this;
	}
}
