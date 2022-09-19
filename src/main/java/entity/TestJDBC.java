package entity;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class TestJDBC {

	public static void main(String[] args) {

		// Check Driver
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("Oracle Driver Found");
		} catch (ClassNotFoundException e) {
			System.out.println("Oracle Driver not Found");
			e.printStackTrace();
		}

		// Connect to Oracle
		try {
			Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "scott", "tiger");
			System.out.println("Connected to Oracle");
			conn.close();
		} catch (SQLException e) {
			System.out.println("Error: connected to Oracle");
			e.printStackTrace();
		}

	}

}
