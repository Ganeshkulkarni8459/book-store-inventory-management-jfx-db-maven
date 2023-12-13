package search_user;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import db_operations.DBUtils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import user_management.UserManagementScreen;

public class SearchUserScreenController {

	@FXML 
	private TextField nameToSearch;

	@FXML 
	private TextField userName;

	@FXML 
	private TextField email;

	@FXML 
	private TextField password;

	@FXML 
	private TextField confirmPassword;

	@FXML 
	private TextField role;

	@FXML 
	private Button search;

	@FXML 
	private Button edit;

	@FXML 
	private Button delete;

	@FXML 
	private Button close;


	public void searchButton(ActionEvent event) throws SQLException {
		boolean status = Search_User(nameToSearch.getText());

		if(!status) {
			System.out.println("!!!!USER NOT FOUND!!!!!");
		}
	}
	public boolean Search_User(String nameToSearch) throws SQLException {
		String query = "SELECT * FROM Users WHERE Username = '"+nameToSearch+"'";

		ResultSet rs = DBUtils.executeQueryGetResult(query);

		try {
			if(rs.next()) {
				userName.setText(rs.getString("Username"));
				email.setText(rs.getString("Email"));
				password.setText(rs.getString("Password"));
				confirmPassword.setText(rs.getString("ConfirmPassword"));
				role.setText(rs.getString("UserRole"));
				return true;
			}
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	
	public void editButton(ActionEvent event) {
		boolean status = Edit_User(nameToSearch.getText());
		
		if(status) {
			System.out.println("User Edited successfully.");
		}
		else {
			System.out.println("User not found.");
		}
	}
	public boolean Edit_User(String nameToSearch) {
		String Query = "select * from Users where Username = '"+nameToSearch+"'";

		ResultSet rs = DBUtils.executeQueryGetResult(Query);
		try {
			if(rs.next()) {
				String query = "UPDATE Users SET Username = '"+userName.getText()+"', "
						+ "Email = '" +email.getText()  + "', " 
						+ "Password = '"+password.getText()+"', "
						+ "ConfirmPassword = '"+confirmPassword.getText()+"',"
						+ "UserRole = '"+role.getText()+"'"
						+ "WHERE Username = '"+nameToSearch+"'";

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
	
	
	public void deleteButton(ActionEvent event) {
		boolean status =  SearchUserScreenController.Delete_User(nameToSearch.getText());

		if(status) {
			System.out.println("USER DELETED SUCCESSFULLY");
		}
		else {
			System.out.println("!!!!USER NOT FOUND!!!!!");
		}
	}
	public static boolean Delete_User(String nameToSearch) {

		String query = "DELETE FROM Users WHERE Username = '"+nameToSearch+"'";

		DBUtils.executeQuery(query);

		int rowsDeleted = DBUtils.getRowsDeleted();

		if(rowsDeleted > 0) {
			return true;
		}
		return false;
	}
	public void closeButton(ActionEvent event) {
		new UserManagementScreen().show();
	}
}
