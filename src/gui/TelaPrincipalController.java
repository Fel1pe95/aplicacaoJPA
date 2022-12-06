package gui;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.function.Consumer;

import application.Main;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.SplitPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

public class TelaPrincipalController implements Initializable {

	@FXML
	private Button btCadastrar;
	@FXML
	private Button btConsultar;
	@FXML
	private Button btFechar;
	@FXML
	private ImageView imgView;

	@FXML
	public void onBtCadastrarAction() {
		carregarTela("/gui/TelaCadastro.fxml", x -> {
		});
		System.out.println("btcadastrar");
	}

	@FXML
	public void onBtConsultarAction() {
		System.out.println("btconcultar");
	}

	@FXML
	public void onBtFecharAction() {
		System.out.println("btfechar");
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		carregarImagem();

	}

	public void carregarImagem() {
		Image img = new Image("logo.jpg");
		imgView.setImage(img);
	}

	public synchronized <T> void carregarTela(String absoluteName, Consumer<T> initializingAction) {
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource(absoluteName));
			AnchorPane newPane = loader.load();
			SplitPane splitPane = Main.getSplitPane();
			AnchorPane rightPane = (AnchorPane) splitPane.getItems().get(1);
			rightPane.getChildren().clear();
			rightPane.getChildren().addAll(newPane.getChildren());

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
