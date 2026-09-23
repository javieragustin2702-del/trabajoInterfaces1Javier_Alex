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
		Scanner sc = new Scanner(System.in).useLocale(Locale.US);
		System.out.println("Escribe la ruta de la base de datos");
		String ruta = sc.nextLine();
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
			BufferedWriter bw = new BufferedWriter(new FileWriter(ruta,true));
			bw.write(objeto.getId() + "," + objeto.getTitulo() + "," + objeto.getAutor() + "," + objeto.getPrecio() + "," + objeto.getStock());
			bw.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
		sc.close();
		return false;
	}

	@Override
	public List<Libro> obtenerTodos() {
		Scanner sc = new Scanner(System.in).useLocale(Locale.US);
		System.out.println("Escribe la ruta de la base de datos");
		String ruta = sc.nextLine();
		try {
			BufferedReader br = new BufferedReader(new FileReader(ruta));
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
		}
		sc.close();
		return null;
	}

	@Override
	public Libro obtenerPorId(int id) {
		Scanner sc = new Scanner(System.in).useLocale(Locale.US);
		System.out.println("Escribe la ruta de la base de datos");
		String ruta = sc.nextLine();
		try {
			BufferedReader br = new BufferedReader(new FileReader(ruta));
			String linea = "";
			String titulo = "";
			String autor = "";
			double precio = 0;
			int stock = 0;
			while ((linea = br.readLine()) != null) {
				String[] partes = linea.split(",");
				if (Integer.parseInt(partes[0]) == id) {
					titulo = partes[1];
					autor = partes[2];
					precio = Double.parseDouble(partes[3]);
					stock = Integer.parseInt(partes[4]);
					return new Libro(id,titulo,autor,precio,stock);
				}
			}
			br.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		sc.close();
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
