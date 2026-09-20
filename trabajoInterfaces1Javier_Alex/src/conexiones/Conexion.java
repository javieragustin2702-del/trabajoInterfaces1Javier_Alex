package conexiones;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {

	public static Connection getConnection() {
		try {

			String user = "root";
			String pwd = "";
			String url = "jdbc:mysql://localhost:3306/interfaces";
			Connection con = DriverManager.getConnection(url, user, pwd);
			return con;
		} catch (SQLException e) {

			System.out.println(e);

		}
		return null;
	}
}
