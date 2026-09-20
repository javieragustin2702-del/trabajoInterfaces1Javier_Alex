package clasesBases;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import conexiones.Conexion;
import modelo.Libro;

public class LibroSQL implements OperacionesBases<Libro> {

	@Override
	public boolean insertar(Libro objeto) {
		String sql = """
				insert libro (idlibro,titulo,autor,precio,stock)
				values(?,?,?,?,?)
				""";
		try (Connection con = Conexion.getConnection();PreparedStatement ps = con.prepareStatement(sql)){
			ps.setInt(1, objeto.getId());
			ps.setString(2, objeto.getTitulo());
			ps.setString(3, objeto.getAutor());
			ps.setDouble(4, objeto.getPrecio());
			ps.setInt(5, objeto.getStock());
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
