package add_user;

import db_operations.DBUtils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import user_management.UserManagementScreen;

public class AddUserScreenController {
	
	@FXML
	private TextField userName;
	
	@FXML
	private TextField email;
	
	@FXML
	private TextField passwordField;
	
	@FXML
	private TextField confirmPassword;
	
	@FXML
	private TextField role;
	
	
	public void saveDetails(ActionEvent event) {
		String query = "INSERT INTO Users(Username,Email,Password,ConfirmPassword,UserRole)VALUES('"+userName.getText()+"','"+email.getText()+"','"+passwordField.getText()+"','"+confirmPassword.getText()+"','"+role.getText()+"')";
		
		DBUtils.executeQuery(query);	
	}
	
	public void backToUsermanagementScreen(ActionEvent event) {
		new UserManagementScreen().show();
	}
}
