package login;

import java.sql.ResultSet;
import java.sql.SQLException;

import db_operations.DBUtils;
import home_screen.HomeScreen;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class LoginScreenController {
	
	@FXML
	private TextField email;
	
	@FXML
	private TextField password;
	
	@FXML
	private Button loginButton;
	
	public void login(ActionEvent event) throws SQLException {
		
		boolean loginStatus = LoginScreenController.ValidateUserAndPassword(email.getText(), password.getText());
		
		if(loginStatus == true) {
			new HomeScreen().show();
		}
		else {
			System.out.println("Login Unsuccessful");
		}
	}
	public static boolean ValidateUserAndPassword(String email,String password) throws SQLException {
		String query = " Select * from Users where Email='"+email+"' and password = '"+password+"' ";
		
		ResultSet rs = DBUtils.executeQueryGetResult(query);
		
		try {
			if(rs.next()) {
				return true;
			}
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
}
