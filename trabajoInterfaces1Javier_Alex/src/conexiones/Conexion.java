package conexiones;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {

	public static Connection getConnection() {
		try {

			String url = System.getenv("DB_URL");
			String user = System.getenv("DB_USER");
			String pass = System.getenv("DB_PASS");
			Connection con = DriverManager.getConnection(url, user, pass);
			return con;
		} catch (SQLException e) {

			System.out.println(e);

		}
		return null;
	}
}
