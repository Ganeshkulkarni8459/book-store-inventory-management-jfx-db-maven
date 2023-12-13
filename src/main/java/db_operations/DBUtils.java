package db_operations;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.cj.xdevapi.Statement;

public class DBUtils {
	static Connection con;
	static java.sql.Statement stmt;
	
	static {
		try {
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/book_store_inventory_management","root","Pranita@Ganesh");
			stmt = con.createStatement();
		}catch(Exception e) {
			System.out.println(e);		
		}
	}
	public static void executeQuery(String query) {
		try {
			stmt.execute(query);
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
	public static ResultSet executeQueryGetResult(String query) {
		ResultSet resultset = null;
		try {
			resultset = stmt.executeQuery(query);
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return resultset;
	}
	public static int getRowsDeleted() {
		int rowsDeleted = 0;
		try {
			if (stmt != null) {
				rowsDeleted = stmt.getUpdateCount();
			}
		} 
		catch (SQLException e) {
			e.printStackTrace();
		}
		return rowsDeleted;
	}

	
}
