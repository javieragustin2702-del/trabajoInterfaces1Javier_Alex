//Tarea 1 del trabajo 1 Javier Agustin Garcia Bolea y Alex Daniel Musca
package clasesBases;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import modelo.Libro;

public class LibroTXT implements OperacionesBases<Libro> {

	@Override
	public boolean insertar(Libro objeto) {
		try {
			FileReader leer = new FileReader("bases.txt");
			Scanner sc = new Scanner(leer);
			PrintWriter escribir = new PrintWriter(new FileWriter("bases.txt",true));
			if (sc.hasNext() == false) {
				escribir.print(objeto.getId() + "," + objeto.getTitulo() + "," + objeto.getAutor() + "," + objeto.getPrecio() + "," + objeto.getStock());
			} else {
				escribir.print("\n" + objeto.getId() + "," + objeto.getTitulo() + "," + objeto.getAutor() + "," + objeto.getPrecio() + "," + objeto.getStock());
			}
			escribir.close();
			sc.close();
			leer.close();
			return true;
		} catch (Exception e) {
			System.out.println(e);
		}
		return false;
	}

	@Override
	public List<Libro> obtenerTodos() {
		List<Libro> lista = new ArrayList<Libro>();
		try {
			FileReader leer = new FileReader("bases.txt");
			Scanner sc = new Scanner(leer);
			while (sc.hasNext()) {
				String[] cadena = sc.nextLine().split(",");
				int id = Integer.parseInt(cadena[0]);
				String titulo = cadena[1];
				String autor = cadena[2];
				double precio = Double.parseDouble(cadena[3]);
				int stock = Integer.parseInt(cadena[4]);
				lista.add(new Libro(id, titulo, autor, precio, stock));
			}
			sc.close();
			leer.close();
			return lista;
		} catch (Exception e) {
			System.out.println(e);
		}
		return null;
	}

	@Override
	public Libro obtenerPorId(int id) {
		return null;
	}

	@Override
	public boolean actualizar(Libro objeto) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean eliminar(int id) {
		List<String> lista = new ArrayList<String>();
		try {
			FileReader leer = new FileReader("bases.txt");
			Scanner sc = new Scanner(leer);
			while(sc.hasNext()) {
				String linea = sc.nextLine();
				String[] cadena = linea.split(",");
				if (Integer.parseInt(cadena[0]) != id) {
					lista.add(linea);
				}
			}
			sc.close();
			leer.close();
			PrintWriter escribir = new PrintWriter(new FileWriter("bases.txt"));
			lista.stream().forEach(linea -> escribir.println(linea));
			escribir.close();
			return true;
		} catch (Exception e) {
			System.out.println(e);
		}
		return false;
	}
}
