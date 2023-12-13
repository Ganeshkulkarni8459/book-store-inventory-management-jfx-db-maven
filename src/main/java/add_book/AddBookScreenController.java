package add_book;

import db_operations.DBUtils;
import inventory_management.InventoryManagementScreen;
import inventory_management.InventoryManagementScreenController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class AddBookScreenController {
	
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
	private Button close;
	
	@FXML
	private Button save;
	
	public void saveDetails(ActionEvent event) {
		String query = "INSERT INTO Inventory(bookTitle,bookISBN,authorName,quantity,price)VALUES('"+bookName.getText()+"','"+bookISBN.getText()+"','"+authorName.getText()+"','"+quantity.getText()+"','"+price.getText()+"')";
		
		DBUtils.executeQuery(query);	
	}
	public void backToInventoryManagementScreen(ActionEvent event) {
		new InventoryManagementScreen().show();
	}
}
