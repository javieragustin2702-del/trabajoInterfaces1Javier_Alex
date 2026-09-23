package clasesBases;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import modelo.Libro;

public class LibroTXT implements OperacionesBases<Libro> {

	@Override
	public boolean insertar(Libro objeto) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Libro> obtenerTodos() {
		try {
			BufferedReader br = new BufferedReader(new FileReader("D:\\Cosas de clase\\DAM\\Programación\\ejercicios\\pruebas\\src\\bases.txt"));
			List<Libro> lista = new ArrayList<Libro>();
			String linea = "";
			int id = 0;
			String titulo = "";
			String autor = "";
			double precio = 0;
			int stock = 0;
			while ((linea = br.readLine()) != null) {
				String[] partes = linea.split(",");
				for (int i = 0; i < partes.length; i++) {
					if (i == 0) {
						id = Integer.parseInt(partes[i]);
					} else if (i == 1) {
						titulo = partes [i];
					} else if (i == 2) {
						autor = partes[i];
					} else if (i == 3) {
						precio = Double.parseDouble(partes[i]);
					} else {
						stock = Integer.parseInt(partes[i]);
					}
				}
				lista.add(new Libro(id,titulo,autor,precio,stock));
			}
			br.close();
			return lista;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		return null;
	}

	@Override
	public Libro obtenerPorId(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean actualizar(Libro objeto) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean eliminar(int id) {
		// TODO Auto-generated method stub
		return false;
	}

}
