package gui;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class PainelPrincipalController implements Initializable{

	@FXML
	private ImageView imgView;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
	carregarImagem("logo.jpg");
		
	}
	
	public void carregarImagem(String path) {
		Image img = new Image(path);
		imgView.setImage(img);
	}
	
}
