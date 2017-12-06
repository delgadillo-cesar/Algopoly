package modelo.tablero;

public class PosicionTablero {

	private int nroCasilla;
	
	public PosicionTablero(){
		this.nroCasilla = 1;
	}
	
	public PosicionTablero(int nroCasilla){
		this.nroCasilla = nroCasilla;
	}
	
	public int getPosicion(){
		return this.nroCasilla;
	}
	
	public void setPosicion(int unNroCasilla){
		this.nroCasilla = unNroCasilla;
	}

	public void sumarUnaPosicion() {
		this.nroCasilla += 1;
	}
}
