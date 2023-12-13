package update_user;

import java.sql.ResultSet;
import java.sql.SQLException;

import db_operations.DBUtils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import user_management.UserManagementScreen;

public class UpdateUserScreenController {
	@FXML
	private TextField userNameToUpdate;
	
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
	
	@FXML
	private Button update;
	
	@FXML
	private Button close;
	
	public void updateButton(ActionEvent event) {
		boolean status = Update_User(userNameToUpdate.getText());
		if(status) {
			System.out.println("User updated successfully.");
		}
		else {
			System.out.println("User not found.");
		}
	}
	public boolean Update_User(String userNameToUpdate) {
		String Query = "select * from Users where Username = '"+userNameToUpdate+"'";

		ResultSet rs = DBUtils.executeQueryGetResult(Query);
		try {
			if(rs.next()) {
				String query = "UPDATE Users SET Username = '"+userName.getText()+"', "
						+ "Email = '" +email.getText()  + "', " 
						+ "Password = '"+passwordField.getText()+"', "
						+ "ConfirmPassword = '"+confirmPassword.getText()+"',"
						+ "UserRole = '"+role.getText()+"'"
						+ "WHERE Username = '"+userNameToUpdate+"'";

				DBUtils.executeQuery(query);

				System.out.println("User updated successfully.");

				return true;
			}
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	
	public void backToUsermanagementScreen(ActionEvent event) {
		new UserManagementScreen().show();
	}

}
