package gui;

import java.net.URL;
import java.util.ResourceBundle;

import application.Main;
import gui.util.Alerts;
import gui.util.Constraints;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.SplitPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import model.entities.Aluno;
import model.service.AlunoService;

public class TelaCadastroController implements Initializable {

	private Aluno entity;
	private AlunoService service;

	@FXML
	private TextField txtMatricula;
	@FXML
	private TextField txtNome;
	@FXML
	private TextField txtCPF;
	@FXML
	private TextField txtTelefone;
	@FXML
	private Button btSalvar;
	@FXML
	private Button btCancelar;

	@FXML
	private Label labelErroNome;
	@FXML
	private Label labelErroCPF;
	@FXML
	private Label labelErroTelefone;

	@FXML
	public void onBtSalvarAction() {

		if (entity == null) {
			throw new IllegalStateException("entity was null");
		}
		if (service == null) {
			throw new IllegalStateException("service was null");
		}

		try {
			entity = getData();
			service.saveOrUpdate(entity);
			
			Alerts.showAlert("Sucesso", null, entity.toString(), AlertType.INFORMATION);
		} catch (Exception e) {
			e.printStackTrace();
			Alerts.showAlert("Erro ao cadastrar", null, "Nenhum dado encontrado", AlertType.ERROR);
		}

	}

	@FXML
	public void onBtCancelarAction(ActionEvent event) {
		carregarPainel("/gui/PainelPrincipal.fxml");
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		Constraints.setTextFieldMaxLength(txtNome, 70);
		Constraints.setTextFieldMaxLength(txtCPF, 11);
		Constraints.setTextFieldMaxLength(txtTelefone, 9);

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

	public Aluno getData() {
		Aluno aluno = new Aluno();
		aluno.setMatricula(null);
		aluno.setNome(txtNome.getText());
		aluno.setCPF(txtCPF.getText());
		aluno.setTelefone(txtTelefone.getText());
		return aluno;
	}

	public AlunoService getService() {
		return service;
	}

	public void setService(AlunoService service) {
		this.service = service;
	}

	public Aluno getEntity() {
		return entity;
	}

	public void setEntity(Aluno entity) {
		this.entity = entity;
	}

}
