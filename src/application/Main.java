package application;
	
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.SplitPane;
import javafx.stage.Stage;


public class Main extends Application {
	
	private static Scene mainScene;
	private static SplitPane splitPane;
	private static Node rightPane;
	@Override
	public void start(Stage primaryStage) throws Exception {
		
		try {
		
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/gui/TelaPrincipal.fxml"));
		splitPane = loader.load();
		
		mainScene = new Scene(splitPane);
		primaryStage.setScene(mainScene);
		primaryStage.setTitle("Aplicação - JPA");
		primaryStage.show();
		
		}catch(Exception e) {
			e.printStackTrace();
		}
				
	}
	
	public static void main(String[] args) {
		launch(args);
	}
	
	public static Scene getMainScene() {
		return mainScene;
	}
	
	public static SplitPane getSplitPane() {
		return splitPane;
	}

	public static Node getRightPane() {
		return rightPane;
	}

	
}
