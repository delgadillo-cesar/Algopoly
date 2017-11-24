package barrios;

public class ComplementoCompleto extends CondicionConstruccion {

	@Override
	public boolean verificarCondicion(BarrioDoble unBarrio) {
		return (unBarrio.getBarrioComplementario().elEspacioEstaCompleto());
	}

}
