package modelo.tablero.casillas.acciones;

import java.util.HashMap;

import modelo.entidades.*;
import modelo.juego.Dados;
import modelo.tablero.Casilla;


public class RetrocesoDinamico implements Casilla {
	
	private HashMap<Integer,MovimientoDesplazamietoDinamico> tipoDeDesplazamiento;
	
	public	RetrocesoDinamico (){
		this.tipoDeDesplazamiento = new HashMap<Integer,MovimientoDesplazamietoDinamico>();
		this.tipoDeDesplazamiento.put(2, new MovimientoDesplazamietoDinamico3());
		this.tipoDeDesplazamiento.put(3, new MovimientoDesplazamietoDinamico3());
		this.tipoDeDesplazamiento.put(4, new MovimientoDesplazamietoDinamico3());
		this.tipoDeDesplazamiento.put(5, new MovimientoDesplazamietoDinamico3());
		this.tipoDeDesplazamiento.put(6, new MovimientoDesplazamietoDinamico3());
		this.tipoDeDesplazamiento.put(7, new MovimientoDesplazamietoDinamico2());
		this.tipoDeDesplazamiento.put(8, new MovimientoDesplazamietoDinamico2());
		this.tipoDeDesplazamiento.put(9, new MovimientoDesplazamietoDinamico2());
		this.tipoDeDesplazamiento.put(10, new MovimientoDesplazamietoDinamico2());
		this.tipoDeDesplazamiento.put(11, new MovimientoDesplazamietoDinamico1());
		this.tipoDeDesplazamiento.put(12, new MovimientoDesplazamietoDinamico1());
	}
	
	public void afectar(Jugador jugador) {
		int dados = Dados.getInstance().getValor();
		
		MovimientoDesplazamietoDinamico tipoMovimiento = this.tipoDeDesplazamiento.get(dados);
		tipoMovimiento.setDireccion(MovimientoDesplazamietoDinamico.direccionRetroceso);
		
		jugador.cambiarTipoDeMovimiento(tipoMovimiento);
		jugador.mover(dados);
	}
}
