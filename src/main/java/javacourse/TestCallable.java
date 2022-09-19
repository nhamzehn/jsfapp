package javacourse;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Types;

public class TestCallable {

	public static void main(String[] args) {
		
		try {
			Connection connection = DriverManager.getConnection(
					"jdbc:oracle:thin:@localhost:1521:xe", "scott", "tiger");
			CallableStatement cs = connection.prepareCall("{call ? := get_annual_salary(?)}");
			
			cs.registerOutParameter(1, Types.DOUBLE);
			cs.setInt(2, 7788);
			
			cs.execute();
			System.out.println("Annual salary = " + cs.getDouble(1));
			
			cs.close();
			connection.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
