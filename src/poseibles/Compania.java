package poseibles;

import tablero.Poseible;

public interface Compania extends Poseible{

	public int cobrarCon(Compania otraCompania);
	public int cobrarConAysa();
	public int cobrarConEdesur();
	public int cobrarConTren();
	public int cobrarConSubte();
}
