package user_management;

import java.util.Scanner;



import add_user.AddUserScreen;
import db_operations.DBUtils;
import home_screen.HomeScreen;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import search_user.SearchUserScreen;
import update_user.UpdateUserScreen;

public class UserManagementScreenController {

	@FXML
	private Button updateUser;

	@FXML
	private Button searchUser;

	@FXML
	private Button deleteUser;

	@FXML
	private Button quit;
	
    
	public void addUserButton(ActionEvent event) {
		new AddUserScreen().show();
	}
	public void updateUserButton(ActionEvent event) {
		new UpdateUserScreen().show(); //update user
	}
	public void searchUserButton(ActionEvent event) {
		new SearchUserScreen().show();
	}
	public void deleteUserButton(ActionEvent event) {
		new SearchUserScreen().show();
	}
	public void quit(ActionEvent event) {
		new HomeScreen().show();
	}
}
