package modelo.tablero.acciones;

import java.util.HashMap;

import modelo.entidades.*;
import modelo.juego.Dados;
import modelo.tablero.Casilla;


public class RetrocesoDinamico implements Casilla {
	
	private HashMap<Integer,MovimientoDesplazamietoDinamico> tipoDeDesplazamiento;
	
	public	RetrocesoDinamico (){
		this.tipoDeDesplazamiento = new HashMap<Integer,MovimientoDesplazamietoDinamico>();
		this.tipoDeDesplazamiento.put(2, new MovimientoTiradaMenosPropiedades());
		this.tipoDeDesplazamiento.put(3, new MovimientoTiradaMenosPropiedades());
		this.tipoDeDesplazamiento.put(4, new MovimientoTiradaMenosPropiedades());
		this.tipoDeDesplazamiento.put(5, new MovimientoTiradaMenosPropiedades());
		this.tipoDeDesplazamiento.put(6, new MovimientoTiradaMenosPropiedades());
		this.tipoDeDesplazamiento.put(7, new MovimientoCapitalModuloTirada());
		this.tipoDeDesplazamiento.put(8, new MovimientoCapitalModuloTirada());
		this.tipoDeDesplazamiento.put(9, new MovimientoCapitalModuloTirada());
		this.tipoDeDesplazamiento.put(10, new MovimientoCapitalModuloTirada());
		this.tipoDeDesplazamiento.put(11, new MovimientoTiradaMenosDos());
		this.tipoDeDesplazamiento.put(12, new MovimientoTiradaMenosDos());
	}
	
	public void afectar(Jugador jugador) {
		int dados = Dados.getInstance().getValor();
		
		MovimientoDesplazamietoDinamico tipoMovimiento = this.tipoDeDesplazamiento.get(dados);
		tipoMovimiento.setDireccion(MovimientoDesplazamietoDinamico.direccionRetroceso);
		
		jugador.cambiarTipoDeMovimiento(tipoMovimiento);
		jugador.mover(dados);
	}
}
