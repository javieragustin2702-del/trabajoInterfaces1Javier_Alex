//Tarea 1 del trabajo 1 Javier Agustin Garcia Bolea y Alex Daniel Musca
package conexiones;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import io.github.cdimascio.dotenv.Dotenv;

/**
 * Clase que permite la conexión entre Java y MySQL. Solo
 * Tiene un método que es el de conexión y los datos para
 * poder entrar en la base de datos están en un .env que
 * está dentro del proyecto
 * 
 * @author Javier Agustin Garcia Bolea
 * @author Alex Daniel Musca
 * @version 1.0
 */
public class Conexion {
	/**
	 * Método que permite la conexión entre Java y MySQL.
	 * 
	 * Los datos necesarios son obtenidos de un .env que
	 * está en el proyecto. Los nombres para cada variable
	 * dentro del .env son
	 * 
	 * <ul>
	 * <li>DB_URL para ubicacion y puerto de la base de datos</li>
	 * <li>DB_USER para el nombre de usurio de la base de datos</li>
	 * <li>DB_PASS para la contraseña del usuario de la base de datos</li>
	 * </ul>
	 * @return {@code DriverManager.getConnection}
	 * @throws SQLException 
	 */
	public static Connection getConnection() throws SQLException {
		Dotenv env = Dotenv.load();
		String url = env.get("DB_URL");
		String user = env.get("DB_USER");
		String pass = env.get("DB_PASS");
		return DriverManager.getConnection(url, user, pass);
	}
}
