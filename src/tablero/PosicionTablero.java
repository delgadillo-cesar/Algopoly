package tablero;

public class PosicionTablero {

	protected int nroCasilla;
	
	public PosicionTablero(){
		this.nroCasilla = 0;
	}
	
	public int getPosicion(){
		return this.nroCasilla;
	}
	
	public void setPosicion(int unNroCasilla){
		this.nroCasilla = unNroCasilla;
	}
}
