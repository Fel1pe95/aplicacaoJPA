package gui;

import java.net.URL;
import java.util.ResourceBundle;

import application.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.SplitPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;

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
    carregarPainel("/gui/PainelPrincipal.fxml");
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {

	}
	
	public synchronized void carregarPainel(String absoluteName) {
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource(absoluteName));
			Pane newPane = loader.load();
			SplitPane split = Main.getSplitPane();
			Node rightPane = split.getItems().get(1); 
			split.getItems().remove(rightPane);
			split.getItems().add(newPane);	
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	


}
