package home_screen;

import inventory_management.InventoryManagementScreen;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import login.LoginScreen;
import user_management.UserManagementScreen;

public class HomeScreenController {

	@FXML
	private Button userManagement;

	@FXML
	private Button inventoryManagementScreen;

	@FXML
	private Button backToHome;


	public void showUserManagementScreen(ActionEvent event) {
		new UserManagementScreen().show();
	}
	public void showInventoryManagementScreen(ActionEvent event) {
		new InventoryManagementScreen().show();
	}
	public void backToHomeScreen(ActionEvent event) {
		new LoginScreen().show();
	}
}
