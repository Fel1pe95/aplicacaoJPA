package gui;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.function.Consumer;

import application.Main;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.SplitPane;
import javafx.scene.layout.Pane;

public class TelaPrincipalController implements Initializable {

	@FXML
	private Button btCadastrar;
	@FXML
	private Button btConsultar;
	@FXML
	private Button btFechar;

	@FXML
	public void onBtCadastrarAction() {
		carregarTela("/gui/TelaCadastro.fxml", x -> {
		});
	}

	@FXML
	public void onBtConsultarAction() {
		System.out.println("btconsultar");
	}

	@FXML
	public void onBtFecharAction() {
		System.out.println("btfechar");
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {

	}

	public synchronized <T> void carregarTela(String absoluteName, Consumer<T> initializingAction) {
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource(absoluteName));
			Pane newPane = loader.load();
			SplitPane splitPane = Main.getSplitPane();
			Node rightPane = splitPane.getItems().get(1);
			splitPane.getItems().remove(rightPane);
			splitPane.getItems().add(newPane);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
