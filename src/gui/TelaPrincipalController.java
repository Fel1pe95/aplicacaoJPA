package gui;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class TelaPrincipalController implements Initializable{

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
		System.out.println("btcadastrar");
	}
	@FXML
	public void onBtConsultarAction(){
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
	
	
}
