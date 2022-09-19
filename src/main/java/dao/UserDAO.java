package dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.Types;

import bean.User;
import database.Database;

public class UserDAO {

	private Database db;
	private Connection connection;
	private PreparedStatement ps;
	private CallableStatement cs;

	public boolean isAuthenticated(String email, String password) {

		String result = null;
		try {
			connection = db.getConnection();
			cs = connection.prepareCall("{call ? := CHECK_USER(?, ?)}");

			cs.registerOutParameter(1, Types.CHAR);
			cs.setString(2, email);
			cs.setString(3, password);

			cs.execute();
			result = cs.getString(1);
			System.out.println(result);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			Database.close(cs);
			Database.close(connection);
		}
		System.out.println("2 --> " + result.equalsIgnoreCase("true"));
		return result.equalsIgnoreCase("true");
	}

	public int insert(User user) {
		int row = 0;
		try {
			db = new Database();
			connection = db.getConnection();
			ps = connection.prepareStatement(
					"insert into user_tbl (user_id, first_name, last_name, sex, birthdate, country, email, pwd, sal, mobile) values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
			
			int counter = 1;
			
			ps.setInt(counter++, user.getId());
			ps.setString(counter++, user.getFirstName());
			ps.setString(counter++, user.getLastName());
			ps.setString(counter++, user.getSex());
			ps.setDate(counter++, new Date(user.getBirthDate().getTime()));
			ps.setString(counter++, user.getCountry());
			ps.setString(counter++, user.getEmail());
			ps.setString(counter++, user.getPassword());
			ps.setDouble(counter++, user.getExpectedSalary());
			ps.setString(counter++, user.getMobile());

			row = ps.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			Database.close(ps);
			Database.close(connection);
		}

		return row;
	}

}
