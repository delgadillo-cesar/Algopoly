package modelo.tablero.acciones;

import java.util.HashMap;

import modelo.entidades.*;
import modelo.juego.*;
import modelo.tablero.Casilla;

public class AvanceDinamico implements Casilla {

	private HashMap<Integer,MovimientoDesplazamietoDinamico> tipoDeDesplazamiento;

	public AvanceDinamico() {
		this.tipoDeDesplazamiento = new HashMap<Integer,MovimientoDesplazamietoDinamico>();
		this.tipoDeDesplazamiento.put(2, new MovimientoTiradaMenosDos());
		this.tipoDeDesplazamiento.put(3, new MovimientoTiradaMenosDos());
		this.tipoDeDesplazamiento.put(4, new MovimientoTiradaMenosDos());
		this.tipoDeDesplazamiento.put(5, new MovimientoTiradaMenosDos());
		this.tipoDeDesplazamiento.put(6, new MovimientoTiradaMenosDos());
		this.tipoDeDesplazamiento.put(7, new MovimientoCapitalModuloTirada());
		this.tipoDeDesplazamiento.put(8, new MovimientoCapitalModuloTirada());
		this.tipoDeDesplazamiento.put(9, new MovimientoCapitalModuloTirada());
		this.tipoDeDesplazamiento.put(10, new MovimientoCapitalModuloTirada());
		this.tipoDeDesplazamiento.put(11, new MovimientoTiradaMenosPropiedades());
		this.tipoDeDesplazamiento.put(12, new MovimientoTiradaMenosPropiedades());

	}

	public void afectar(Jugador jugador) {
		int dados = Dados.getInstance().getValor();
		
		MovimientoDesplazamietoDinamico tipoMovimiento = this.tipoDeDesplazamiento.get(dados);
		tipoMovimiento.setDireccion(MovimientoDesplazamietoDinamico.direccionAvance);
		
		jugador.cambiarTipoDeMovimiento(tipoMovimiento);
		jugador.mover(dados);
	}
}
