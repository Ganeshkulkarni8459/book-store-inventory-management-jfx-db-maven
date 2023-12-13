package search_book;

import java.sql.ResultSet;
import java.sql.SQLException;

import db_operations.DBUtils;
import inventory_management.InventoryManagementScreen;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import search_user.SearchUserScreenController;

public class SearchBookScreenController {
	
	@FXML 
	private TextField nameToSearch;
	
	@FXML 
	private TextField bookName;
	
	@FXML 
	private TextField bookISBN;
	
	@FXML 
	private TextField authorName;
	
	@FXML 
	private TextField quantity;
	
	@FXML 
	private TextField price;
	
	@FXML 
	private Button search;
	
	@FXML 
	private Button close;
	
	@FXML 
	private Button delete;
	
	@FXML 
	private Button edit;
	
	public void showSearch() {
		boolean status = Search_Book(nameToSearch.getText());
		
		if(!status) {
			System.out.println("!!!!BOOK NOT FOUND!!!!!");
		}
	}
	
	public boolean Search_Book(String nameToSearch) {
		
		String query = "SELECT * from Inventory where  bookTitle ='"+nameToSearch+"'";
		
		ResultSet rs = DBUtils.executeQueryGetResult(query);
		try {
			if(rs.next()) {
				bookName.setText(rs.getString("bookTitle"));
				bookISBN.setText(rs.getString("bookISBN"));
				authorName.setText(rs.getString("authorName"));
				quantity.setText(rs.getString("quantity"));
				price.setText(rs.getString("price"));
				return true;
			}
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	public boolean Edit_Book(String nameToSearch) {
		String query = "select * from Inventory where bookTitle = '"+nameToSearch+"'";
		
		ResultSet rs = DBUtils.executeQueryGetResult(query);
		
		try {
			if(rs.next()) {
				String Query = "UPDATE Inventory SET bookTitle = '"+bookName.getText()+"', "
						+ "bookISBN = '" +bookISBN.getText()  + "', " 
						+ "authorName = '"+authorName.getText()+"', "
						+ "quantity = '"+quantity.getText()+"',"
						+ "price = '"+price.getText()+"'"
						+ "WHERE bookTitle = '"+nameToSearch+"'";

				DBUtils.executeQuery(Query);

				System.out.println("Book Edited successfully.");

				return true;
			}
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	public void showEdit(ActionEvent Event) {
		boolean status = Edit_Book(nameToSearch.getText());
		if(status) {
			System.out.println("Book Edited successfully.");
		}
		else {
			System.out.println("Book not found.");
		}
	}
	public boolean Delete_Book(String nameToSearch) {
		String query = "DELETE FROM Inventory WHERE bookTitle = '"+nameToSearch+"'";

		DBUtils.executeQuery(query);

		int rowsDeleted = DBUtils.getRowsDeleted();

		if(rowsDeleted > 0) {
			return true;
		}
		return false;
	}
	public void showDelete(ActionEvent Event) {
		boolean status = Delete_Book(nameToSearch.getText());

		if(status) {
			System.out.println("BOOK DELETED SUCCESSFULLY");
		}
		else {
			System.out.println("!!!!BOOK NOT FOUND!!!!!");
		}
		
	}
	public void showClose(ActionEvent Event) {
		new InventoryManagementScreen().show();
	}
	
	
	
}
