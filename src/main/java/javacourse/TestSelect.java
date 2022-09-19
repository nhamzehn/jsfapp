package javacourse;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TestSelect {

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
			Connection conn = DriverManager.getConnection(
					"jdbc:oracle:thin:@localhost:1521:xe", "scott", "tiger");
			System.out.println("Connected to Oracle");

			PreparedStatement ps = conn.prepareStatement(
					"select empno, ename, sal, job from emp where deptno = 10 order by empno");

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				System.out.println(rs.getInt("empno") + " "
						+ rs.getString("ename") + " " + rs.getDouble("sal"));
			}

			rs.close();
			ps.close();
			conn.close();

		} catch (SQLException e) {
			System.out.println("Error: connected to Oracle");
			e.printStackTrace();
		}

	}

}
