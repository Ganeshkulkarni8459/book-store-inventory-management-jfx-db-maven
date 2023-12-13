package book_store_inventory_management;

import common.StageFactory;
import javafx.application.Application;
import javafx.stage.Stage;
import login.LoginScreen;

public class ApplicationMain extends Application {
	
	public static void main(String args[]) {
		launch(args);
	}
	@Override
	public void start(Stage stage) {

		StageFactory.stage = stage;
		new LoginScreen().show();
	}
}
