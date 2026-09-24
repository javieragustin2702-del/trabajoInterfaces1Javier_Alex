package clasesBases;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import modelo.Libro;

public class LibroTXT implements OperacionesBases<Libro> {

	@Override
	public boolean insertar(Libro objeto) {
		String ruta = obteneRuta();
		try {
			BufferedReader br = new BufferedReader(new FileReader(ruta));
			String linea = "";
			while ((linea = br.readLine()) != null) {
				String[] partes = linea.split(",");
				if (Integer.parseInt(partes[0]) == objeto.getId()) {
					System.out.println("id del libro pasado ya existe,cambie el id del libro");
					return false;
				}
			}
			br.close();
			BufferedWriter bw = new BufferedWriter(new FileWriter(ruta, true));
			bw.newLine();
			bw.write(objeto.getId() + "," + objeto.getTitulo() + "," + objeto.getAutor() + "," + objeto.getPrecio()
					+ "," + objeto.getStock());
			bw.close();
			return true;
		} catch (Exception e) {
			// TODO: handle exception
		}
		return false;
	}

	@Override
	public List<Libro> obtenerTodos() {
		String ruta = obteneRuta();
		try {
			BufferedReader br = new BufferedReader(new FileReader(ruta));
			List<Libro> lista = new ArrayList<Libro>();
			String linea = "";

			while ((linea = br.readLine()) != null) {
				String[] partes = linea.split(",");
				int id = Integer.parseInt(partes[0]);
				String titulo = partes[1];
				String autor = partes[2];
				double precio = Double.parseDouble(partes[3]);
				int stock = Integer.parseInt(partes[4]);
				lista.add(new Libro(id, titulo, autor, precio, stock));
			}
			br.close();
			return lista;
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Libro obtenerPorId(int id) {
		String ruta = obteneRuta();
		try {
			BufferedReader br = new BufferedReader(new FileReader(ruta));
			String linea = "";

			while ((linea = br.readLine()) != null) {
				String[] partes = linea.split(",");
				if (Integer.parseInt(partes[0]) == id) {
					String titulo = partes[1];
					String autor = partes[2];
					double precio = Double.parseDouble(partes[3]);
					int stock = Integer.parseInt(partes[4]);
					return new Libro(id, titulo, autor, precio, stock);
				}
			}
			br.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public boolean actualizar(Libro objeto) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean eliminar(int id) {
		String ruta = obteneRuta();
		List<String> lista = new ArrayList<String>();
		try {
			BufferedReader br = new BufferedReader(new FileReader(ruta));
			String linea = "";

			while ((linea = br.readLine()) != null) {
				String[] partes = linea.split(",");
				if (Integer.parseInt(partes[0]) == id) {
					continue;
				} else {
					lista.add(linea);
				}
			}
			br.close();
			BufferedWriter bw = new BufferedWriter(new FileWriter(ruta));
			bw.write("");
			bw.close();
			BufferedWriter bw2 = new BufferedWriter(new FileWriter(ruta,true));
			for (String string : lista) {
				bw2.write(string);
				bw2.newLine();
			}
			bw2.close();
			return true;
		} catch (Exception e) {
			System.out.println(e);
		}
		return false;
	}

	public String obteneRuta() {
		Scanner sc = new Scanner(System.in).useLocale(Locale.US);
		System.out.println("Escribe la ruta del archivo");
		String ruta = sc.nextLine();
		return ruta;
	}

}
