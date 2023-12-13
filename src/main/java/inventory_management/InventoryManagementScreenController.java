package inventory_management;

import add_book.AddBookScreen;
import home_screen.HomeScreen;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import search_book.SearchBookScreen;
import update_book.UpdateBookScreen;
import update_book.UpdateBookScreenController;

public class InventoryManagementScreenController {
	
	@FXML
	private Button addBook;
	
	@FXML
	private Button updateBook;
	
	@FXML
	private Button searchBook;
	
	@FXML
	private Button deleteBook;
	
	@FXML
	private Button quit;
	
	public void showAddBook(ActionEvent event) {
		new AddBookScreen().show();
	}
	public void showupdateBook(ActionEvent event) {
		new UpdateBookScreen().show();
	}
	public void showSearchBook(ActionEvent event) {
		new SearchBookScreen().show();
	}
	public void showDeleteBook(ActionEvent event) {
		new SearchBookScreen().show();
	}
	public void quit(ActionEvent event) {
		new HomeScreen().show();
	}
	
	
}
