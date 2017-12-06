package vista.jugador;

import javafx.scene.control.Alert;

public class AlertaSaldoInsuficiente extends Alert {

	public AlertaSaldoInsuficiente() {
		super(AlertType.INFORMATION);
		this.setTitle("Saldo insuficiente");
		this.setHeaderText(null);
		this.setContentText("No tenes sufiente dinero");

		this.showAndWait();	
	}

}
