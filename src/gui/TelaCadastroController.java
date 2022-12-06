package gui;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class TelaCadastroController implements Initializable {

	@FXML
	private TextField txtNome;
	@FXML
	private TextField txtMatricula;
	@FXML
	private Button btSalvar;
	@FXML
	private Button btCancelar;

	@FXML
	public void onBtSalvarAction() {

	}

	@FXML
	public void onBtCancelarAction(ActionEvent event) {
TelaPrincipalController.getRighPane().getChildren().clear();
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {

	}


}
