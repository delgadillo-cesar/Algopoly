package modelo.tablero.poseibles;

import modelo.entidades.Banco;
import modelo.entidades.Jugador;
import modelo.juego.Dados;
import modelo.tablero.Tablero;
import modelo.tablero.comprables.SubteComprable;

public class Subte implements Compania {

	private Jugador propietario;
	
	public Subte(Jugador propietario){
		this.propietario = propietario;
		this.propietario.agregarCompania(this);
	}

	protected int cobrar() {
		int dados = Dados.getInstance().getValor();
		int veces = 600;
		
		for(Compania compania : this.propietario.obtenerCompanias()){
			veces += this.cobrarCon(compania);
		}
		
		return (dados * veces);
	}

	public Jugador propietario() {
		return this.propietario;
	}

	public void afectar(Jugador jugador) {
		jugador.pagarA(this.propietario, this.cobrar());
	}

	public int cobrarCon(Compania otraCompania) {
		return otraCompania.cobrarConSubte();
	}

	public int cobrarConAysa() {
		return 0;
	}

	public int cobrarConEdesur() {
		return 0;
	}

	public int cobrarConTren() {
		return 350;
	}

	public int cobrarConSubte() {
		return 0;
	}
	
	@Override
	public void vender() {
		SubteComprable subte = new SubteComprable();
		this.propietario.quitarCompania(this);
		Banco.getInstance().pagarA(this.propietario, (int) (subte.precioDeCompra() * 0.85));
		Tablero.getInstance().cambiarCasillaPor(Tablero.CASILLA_SUBTE, subte);
	}

}
