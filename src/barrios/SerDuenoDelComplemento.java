package barrios;

import comprables.SinPropietarioException;

public class SerDuenoDelComplemento extends CondicionConstruccion {

	@Override
	public boolean verificarCondicion(BarrioDoble unBarrio) {
		Boolean verificacion = false;
		
		try{
			verificacion = (unBarrio.propietario() == unBarrio.getBarrioComplementario().propietario());
		}catch(SinPropietarioException e){
		}
		
		return verificacion;
	}
}
