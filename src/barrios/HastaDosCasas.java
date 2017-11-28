package barrios;

import java.util.ArrayList;
import java.util.List;

public class HastaDosCasas extends ConstruccionPosible {

	public HastaDosCasas(){
		this.construcciones = new ArrayList<Construible>();
		this.construcciones.add(new UnaCasa());
		this.construcciones.add(new DosCasas());
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
		List<Construible> construccionesAux = new ArrayList<Construible>();

		construccionesAux.addAll(this.construcciones);
		construccionesAux.add(otraConstruccionPosible.construcciones.get(otraConstruccionPosible.construcciones.size() - 1));
		
		otraConstruccionPosible.construcciones = construccionesAux;
		
		return otraConstruccionPosible;
	}

	@Override
	public ConstruccionPosible actualizarConSoloEdificioHistorico(ConstruccionPosible otraConstruccionPosible) {
		return this;
	}
}
