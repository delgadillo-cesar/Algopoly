package acciones;

import java.util.HashMap;
import entidades.Jugador;
import juego.Dados;
import entidades.*;

public class AvanceDinamico extends Accion {

	private static String tag = "AVANCE_DINAMICO";
	private HashMap<Integer,MovimientoDesplazamietoDinamico> tipoDeDesplazamiento;

	/***********************************************/

	public AvanceDinamico() {
		this.descripcion = "AVANCE DINAMICO";
		this.tipoDeDesplazamiento = new HashMap<Integer,MovimientoDesplazamietoDinamico>();
		this.tipoDeDesplazamiento.put(2, new MovimientoDesplazamietoDinamico1());
		this.tipoDeDesplazamiento.put(3, new MovimientoDesplazamietoDinamico1());
		this.tipoDeDesplazamiento.put(4, new MovimientoDesplazamietoDinamico1());
		this.tipoDeDesplazamiento.put(5, new MovimientoDesplazamietoDinamico1());
		this.tipoDeDesplazamiento.put(6, new MovimientoDesplazamietoDinamico1());
		this.tipoDeDesplazamiento.put(7, new MovimientoDesplazamietoDinamico2());
		this.tipoDeDesplazamiento.put(8, new MovimientoDesplazamietoDinamico2());
		this.tipoDeDesplazamiento.put(9, new MovimientoDesplazamietoDinamico2());
		this.tipoDeDesplazamiento.put(10, new MovimientoDesplazamietoDinamico2());
		this.tipoDeDesplazamiento.put(11, new MovimientoDesplazamietoDinamico3());
		this.tipoDeDesplazamiento.put(12, new MovimientoDesplazamietoDinamico3());

	}

	/***********************************************/

	@Override
	public void afectar(Jugador jugador) {
		
		int dados = Dados.getInstance().getValor();
		
		MovimientoDesplazamietoDinamico tipoMovimiento = this.tipoDeDesplazamiento.get(dados);
		tipoMovimiento.setDireccion(MovimientoDesplazamietoDinamico.direccionAvance);
		
		jugador.cambiarTipoDeMovimiento(tipoMovimiento);
		jugador.mover(dados);
	}

	/***********************************************/
	
	public static String getTag(){
		return tag;
	}

}
