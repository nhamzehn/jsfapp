package javacourse;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class TestInsert {

	public static void main(String[] args) {

		try {
			Connection conn = DriverManager.getConnection(
					"jdbc:oracle:thin:@localhost:1521:xe", "scott", "tiger");
			conn.setAutoCommit(false);
			PreparedStatement ps = conn.prepareStatement(
					"insert into emp (empno, ename, sal) values(?, ?, ?)");
			
			ps.setInt(1, 1);
			ps.setString(2, "Hamzeh");
			ps.setDouble(3, 1000.0);
			
			int rows = ps.executeUpdate();
			System.out.println(rows + " inserted");
			conn.commit();
			
			ps.close();
			conn.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
