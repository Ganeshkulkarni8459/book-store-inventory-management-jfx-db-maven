package update_book;

import java.sql.ResultSet;
import java.sql.SQLException;

import db_operations.DBUtils;
import inventory_management.InventoryManagementScreen;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class UpdateBookScreenController {

	@FXML 
	private TextField bookNameToUpdate;

	@FXML 
	private TextField newBookTitle;

	@FXML 
	private TextField newISBN;

	@FXML 
	private TextField newAuthorName;

	@FXML 
	private TextField newQuantity;

	@FXML 
	private TextField newBookPrice;

	@FXML 
	private Button close;

	@FXML 
	private Button update;

	public boolean update_book(String bookNameToUpdate) {
	    String query = "SELECT * FROM Inventory WHERE bookTitle = '" + bookNameToUpdate + "'";
	    ResultSet rs = DBUtils.executeQueryGetResult(query);

	    try {
	        if (rs.next()) {
	            String updateQuery = "UPDATE Inventory SET bookTitle = '" + newBookTitle.getText() + "', "
	                    + "bookISBN = '" + newISBN.getText() + "', "
	                    + "authorName = '" + newAuthorName.getText() + "', "
	                    + "quantity = '" + newQuantity.getText() + "', "
	                    + "price = '" + newBookPrice.getText() + "' "
	                    + "WHERE bookTitle = '" + bookNameToUpdate + "'";

	            DBUtils.executeQuery(updateQuery); // Corrected query execution

	            return true;
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return false;
	}



	public void showUpdate(ActionEvent event) {
		boolean status = update_book(bookNameToUpdate.getText());
		if(status) {
			System.out.println("Book Updated successfully.");
		}
		else {
			System.out.println("Book not found.");
		}	
	}

	public void backToInventoryManagementScreen(ActionEvent event) {
		new InventoryManagementScreen().show();
	}

}
