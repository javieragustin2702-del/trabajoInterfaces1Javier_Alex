//Tarea 1 del trabajo 1 Javier Agustin Garcia Bolea y Alex Daniel Musca
package clasesBases;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import conexiones.Conexion;
import modelo.Libro;
/**
 * Clase que realiza todas las operaciones referentes a la gestión
 * de la base de datos de MySQL. No cuenta con parámetros solo cuenta
 * con métodos
 * 
 * @author Javier Agustin Garcia Bolea
 * @author Usuario Alex Daniel Musca
 * @version 1.0
 */
public class LibroSQL implements OperacionesBases<Libro> {
	/**
	 * Método que inserta un libro con todos sus datos excepto su id. Para
	 * ello realiza una inserción a la tabla libro insertando
	 * los valores de titulo,autor,precio y stock del {@code Libro} que
	 * se le ha pasado al método
	 * 
	 * @return True o false según se haya podido insertar el libro o no
	 * @exception e en caso de faltar datos del libro o de fallar la conexión o inserción de MySQL
	 */
	@Override
	public boolean insertar(Libro objeto) {
		String sql = """
				insert libro (titulo,autor,precio,stock)
				values(?,?,?,?)
				""";
		try (Connection con = Conexion.getConnection();PreparedStatement ps = con.prepareStatement(sql)){
			ps.setString(1, objeto.getTitulo());
			ps.setString(2, objeto.getAutor());
			ps.setDouble(3, objeto.getPrecio());
			ps.setInt(4, objeto.getStock());
			int filas = ps.executeUpdate();
			if (filas > 0) {
				return true;
			}
		}
		catch (Exception e) {
			System.out.println(e);
		}
		return false;
	}
	/**
	 * Método que devuelve una lista de libros realizando una consulta a
	 * la tabla libro obteniendo todos los datos de cada libro de la base de datos
	 * 
	 * @return Lista de libros si no falla o devuelve null si falla
	 * @exception {@code Exception} e en caso de fallar la conexión con MySQL
	 */
	@Override
	public List<Libro> obtenerTodos() {
		List<Libro> lista = new ArrayList<Libro>();
		String sql = """
				select * from libro
				""";
		try (Connection con = Conexion.getConnection();PreparedStatement ps = con.prepareStatement(sql)){
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				lista.add(mapeo(rs));
			}
			return lista;
		}catch (Exception e) {
			System.out.println(e);
		}
		return null;
	}
	/**
	 * Método que devuelve un libro obtenido por una consuta buscándolo por su id
	 * pasado al método un id llamado "id" como {@code int} 
	 * Actualmente no se usa en ninguna parte del programa
	 * 
	 * @return Libro obtenido por una búsqueda por su id si se encuentra un libro con ese id, en otro caso devuelve null
	 * @exception {@code Exception} e en caso de fallar la conexión con MySQL
	 */
	@Override
	public Libro obtenerPorId(int id) {
		String sql = """
				select * from libro where idlibro = ?
				""";
		try (Connection con = Conexion.getConnection();PreparedStatement ps = con.prepareStatement(sql)){
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				return mapeo(rs);
			}
		}catch (Exception e) {
			System.out.println(e);
		}
		return null;
	}
	/**
	 * Método que actualiza un libro buscando el libro a actualizar por su id. Para ello
	 * se le pasa al método un {@code Libro} con todos los parámetros y actualizara en la tabla
	 * libro.
	 * Actualmente en el programa no se usa
	 * 
	 * @return True o False en caso de haberse actualizado el libro o no
	 * @exception {@code Exception} e en caso de faltar datos del libro o de fallar la conexión o inserción de MySQL
	 */
	@Override
	public boolean actualizar(Libro objeto) {
		String sql = """
				update libro set titulo = ?,autor = ?,precio = ?,stock = ? where idlibro = ?
				""";
		try (Connection con = Conexion.getConnection();PreparedStatement ps = con.prepareStatement(sql)){
			ps.setString(1, objeto.getTitulo());
			ps.setString(2, objeto.getAutor());
			ps.setDouble(3, objeto.getPrecio());
			ps.setInt(4, objeto.getStock());
			ps.setInt(5, objeto.getId());
			int filas = ps.executeUpdate();
			if (filas > 0) {
				return true;
			}
		}
		catch (Exception e) {
			System.out.println(e);
		}
		return false;
	}
	/**
	 * Método que elimina un libro de la tabla libro por su id siendo ese id el pasado
	 * al método como {@code int} 
	 * 
	 * @return true en caso de ser eliminado o false en caso de no ser eliminado o encontrado
	 * @exception {@code Exception} e de fallar la conexión
	 */
	@Override
	public boolean eliminar(int id) {
		String sql = """
				delete from libro where idlibro = ?
				""";
		try (Connection con = Conexion.getConnection();PreparedStatement ps = con.prepareStatement(sql)){
			ps.setInt(1, id);
			int filas = ps.executeUpdate();
			if (filas > 0) {
				return true;
			}
		}
		catch (Exception e) {
			System.out.println(e);
		}
		return false;
	}
	/**
	 * Método usado por otros métodos de la clase que sirve para transformar los
	 * datos obtenidos del {@code rs} en objetos de la clase Libro
	 * @param rs que es un {@link ResulSet} de los otros métodos de la clase 
	 * @return Libro formado por los datos del {@code rs}
	 * @throws SQLException
	 */
	public Libro mapeo(ResultSet rs) throws SQLException{
		Libro l = new Libro();
		l.setId(rs.getInt("idlibro"));
		l.setTitulo(rs.getString("titulo"));
		l.setAutor(rs.getString("autor"));
		l.setPrecio(rs.getDouble("precio"));
		l.setStock(rs.getInt("stock"));
		return l;
	}
}
